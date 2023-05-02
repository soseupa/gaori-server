package project.gaori.server.global.security.jwt.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import project.gaori.server.global.error.exception.ErrorProperty;

@Getter
@RequiredArgsConstructor
public enum JwtErrorProperty implements ErrorProperty {

    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 토큰입니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다."),
    ;

    private final HttpStatus status;
    private final String message;
}