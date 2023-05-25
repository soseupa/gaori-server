package project.gaori.server.domain.schedule.detail.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.schedule.detail.entity.ScheduleDetail;
import project.gaori.server.domain.schedule.detail.presentation.dto.response.ScheduleDetailListResponse;
import project.gaori.server.domain.schedule.detail.presentation.dto.response.ScheduleDetailResponse;
import project.gaori.server.domain.schedule.entity.Schedule;
import project.gaori.server.domain.schedule.facade.ScheduleFacade;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindScheduleDetailByScheduleIdService {
    private final ScheduleFacade scheduleFacade;

    @Transactional
    public ScheduleDetailListResponse execute(Long id) {
        Schedule schedule = scheduleFacade.findScheduleById(id);
        List<ScheduleDetail> details = schedule.getDetails();
        return ScheduleDetailListResponse.builder()
                .scheduleDetails(details.stream().map(ScheduleDetailResponse::of).collect(Collectors.toList()))
                .build();
    }
}
