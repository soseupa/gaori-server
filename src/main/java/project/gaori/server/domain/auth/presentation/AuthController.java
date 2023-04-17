package project.gaori.server.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.auth.presentation.dto.response.AccessTokenResponse;
import project.gaori.server.domain.auth.service.RefreshTokenService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final RefreshTokenService refreshTokenService;

    @PutMapping
    public AccessTokenResponse refreshToken(@RequestHeader(value = "Refresh-Token") String refreshToken) {
        return refreshTokenService.execute(refreshToken);
    }
}
