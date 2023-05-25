package project.gaori.server.domain.schedule.user.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import project.gaori.server.global.error.exception.ErrorProperty;

@Getter
@RequiredArgsConstructor
public enum ScheduleUserErrorProperty implements ErrorProperty {

    SCHEDULE_USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "이미 존재하는 사용자입니다.");;
    private final HttpStatus status;
    private final String message;
}
