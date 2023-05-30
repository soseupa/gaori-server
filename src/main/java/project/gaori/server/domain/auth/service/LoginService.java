package project.gaori.server.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.gaori.server.domain.auth.presentation.dto.request.LoginRequest;
import project.gaori.server.domain.auth.presentation.dto.response.TokenResponse;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.exception.PasswordMismatchException;
import project.gaori.server.domain.user.facade.UserFacade;
import project.gaori.server.global.security.jwt.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse execute(LoginRequest request) {
        User user = userFacade.findUserByEmail(request.getEmail());
        checkPassword(request.getPassword(), user.getPassword());

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(user.getEmail()))
                .refreshToken(jwtTokenProvider.generateRefreshToken(user.getEmail()))
                .email(user.getEmail())
                .name(user.getNickname())
                .build();

    }

    private void checkPassword(String actual, String expected) {
        if (!passwordEncoder.matches(actual, expected)) {
            throw PasswordMismatchException.EXCEPTION;
        }
    }

}
