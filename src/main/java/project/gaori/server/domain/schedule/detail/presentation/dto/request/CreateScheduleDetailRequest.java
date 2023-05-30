package project.gaori.server.domain.schedule.detail.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.gaori.server.domain.schedule.detail.entity.ScheduleDetail;
import project.gaori.server.domain.schedule.entity.Schedule;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateScheduleDetailRequest {
    private Long id;
    private String location;
    private double latitude;
    private double longitude;

    public ScheduleDetail toEntity(Schedule schedule, int order){
        return ScheduleDetail.builder()
                .schedule_detail(schedule)
                .location(this.location)
                .orderIndex(order)
                .latitude(this.latitude)
                .longitude(this.longitude)
                .build();
    }
}
