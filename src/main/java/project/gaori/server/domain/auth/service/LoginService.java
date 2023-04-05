package project.gaori.server.domain.auth.service;

import project.gaori.server.domain.auth.presentation.dto.request.LoginRequest;
import project.gaori.server.domain.auth.presentation.dto.response.TokenResponse;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.facade.UserFacade;
import project.gaori.server.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse execute(LoginRequest request) {
        User user = userFacade.findUserByEmail(request.getEmail());

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(user.getEmail()))
                .refreshToken(jwtTokenProvider.generateRefreshToken(user.getEmail()))
                .isLogin(!(user.getNickname() == null || user.getNickname().equals("")))
                .build();
    }

}
