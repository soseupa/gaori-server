package project.gaori.server.domain.schedule.detail.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.schedule.detail.entity.ScheduleDetail;
import project.gaori.server.domain.schedule.detail.entity.repository.ScheduleDetailRepository;
import project.gaori.server.domain.schedule.detail.presentation.dto.request.CreateScheduleDetailRequest;
import project.gaori.server.domain.schedule.entity.Schedule;
import project.gaori.server.domain.schedule.facade.ScheduleFacade;

@Service
@RequiredArgsConstructor
public class CreateScheduleDetailService {
    private final ScheduleDetailRepository scheduleDetailRepository;
    private final ScheduleFacade scheduleFacade;

    @Transactional
    public void execute(CreateScheduleDetailRequest request) {
        Schedule schedule = scheduleFacade.findScheduleById(request.getId());
        int order = schedule.getDetails().size() + 1;
        ScheduleDetail scheduleDetail = request.toEntity(schedule,order);
        scheduleDetailRepository.save(scheduleDetail);
    }
}
