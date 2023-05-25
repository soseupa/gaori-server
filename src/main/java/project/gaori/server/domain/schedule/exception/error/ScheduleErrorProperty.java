package project.gaori.server.domain.schedule.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import project.gaori.server.global.error.exception.ErrorProperty;

@Getter
@RequiredArgsConstructor
public enum ScheduleErrorProperty implements ErrorProperty {

    SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "일정이 없습니다."),
    ;
    private final HttpStatus status;
    private final String message;

}
