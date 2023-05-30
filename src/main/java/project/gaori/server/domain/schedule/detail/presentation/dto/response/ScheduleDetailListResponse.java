package project.gaori.server.domain.schedule.detail.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ScheduleDetailListResponse {
    private List<ScheduleDetailResponse> scheduleDetails;
}
