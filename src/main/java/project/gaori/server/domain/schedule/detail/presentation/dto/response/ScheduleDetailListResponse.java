package project.gaori.server.domain.schedule.detail.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.gaori.server.domain.user.presentation.dto.response.ScheduleUserResponse;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ScheduleDetailListResponse {
    private List<ScheduleDetailResponse> scheduleDetails;
    private List<ScheduleUserResponse> scheduleUsers;
}
