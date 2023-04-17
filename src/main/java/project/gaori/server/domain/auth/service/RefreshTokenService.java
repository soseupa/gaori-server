package project.gaori.server.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gaori.server.domain.auth.domain.RefreshToken;
import project.gaori.server.domain.auth.domain.repository.RefreshTokenRepository;
import project.gaori.server.domain.auth.presentation.dto.response.AccessTokenResponse;
import project.gaori.server.global.security.jwt.JwtTokenProvider;
import project.gaori.server.global.security.jwt.exception.ExpiredTokenException;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public AccessTokenResponse execute(String token) {
        RefreshToken refreshToken = getRefreshToken(token);
        return AccessTokenResponse.builder()
                .accessToken(jwtTokenProvider
                        .generateAccessToken(refreshToken.getEmail()))
                .build();
    }

    private RefreshToken getRefreshToken(String token) {
        return refreshTokenRepository.findById(token)
                .orElseThrow(() -> ExpiredTokenException.EXCEPTION);
    }
}

