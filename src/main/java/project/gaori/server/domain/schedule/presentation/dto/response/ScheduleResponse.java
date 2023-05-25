package project.gaori.server.domain.schedule.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.gaori.server.domain.schedule.entity.Schedule;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.presentation.dto.response.ScheduleUserResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
public class ScheduleResponse {

    private Long scheduleId;
    private String title;
    private LocalDateTime time;
    private List<ScheduleUserResponse> scheduleResponseList;

    public static ScheduleResponse of(Schedule schedule, List<User> scheduleUsers) {
        return ScheduleResponse.builder()
                .scheduleId(schedule.getId())
                .title(schedule.getTitle())
                .time(schedule.getTime())
                .scheduleResponseList(scheduleUsers.stream().map(ScheduleUserResponse::of).collect(Collectors.toList()))
                .build();
    }
}
