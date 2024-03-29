package project.gaori.server.domain.user.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import project.gaori.server.global.error.exception.ErrorProperty;

@Getter
@RequiredArgsConstructor
public enum UserErrorProperty implements ErrorProperty {

    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "사용자가 이미 존재합니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자가 없습니다."),
    PASSWORD_MISMATCH(HttpStatus.UNAUTHORIZED, "비밀번호가 틀렸습니다."),
    AUTHORITY_MISMATCH(HttpStatus.FORBIDDEN, "권한이 없습니다."),
    ;

    private final HttpStatus status;
    private final String message;
}
