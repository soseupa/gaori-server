package project.gaori.server.domain.schedule.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ScheduleListResponse {
    private int length;
    private List<ScheduleResponse> schedules;
}
