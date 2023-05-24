package project.gaori.server.domain.schedule.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import project.gaori.server.domain.schedule.entity.Schedule;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateScheduleRequest {

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime time;

    public  Schedule toEntity() {
        return Schedule.builder()
                .title(this.title)
                .time(this.time)
                .build();
    }
}
