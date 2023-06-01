package project.gaori.server.domain.auth.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "인증 서버")
public class AuthController {
    private final RefreshTokenService refreshTokenService;

    @Operation(summary = "토큰 재발급")
    @PutMapping
    public AccessTokenResponse refreshToken(@RequestHeader(value = "Refresh-Token") String refreshToken) {
        return refreshTokenService.execute(refreshToken);
    }
}
