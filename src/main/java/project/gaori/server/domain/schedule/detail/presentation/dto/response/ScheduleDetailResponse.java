package project.gaori.server.domain.schedule.detail.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.gaori.server.domain.schedule.detail.entity.ScheduleDetail;

@Getter
@Builder
@AllArgsConstructor
public class ScheduleDetailResponse {
    private Long id;
    private String location;
    private double latitude;
    private double longitude;
    private int orderIndex;

    public static ScheduleDetailResponse of(ScheduleDetail scheduleDetail) {
        return ScheduleDetailResponse.builder()
                .id(scheduleDetail.getId())
                .location(scheduleDetail.getLocation())
                .latitude(scheduleDetail.getLatitude())
                .longitude(scheduleDetail.getLongitude())
                .orderIndex(scheduleDetail.getOrderIndex())
                .build();
    }
}
