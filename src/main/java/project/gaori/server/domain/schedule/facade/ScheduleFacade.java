package project.gaori.server.domain.schedule.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.schedule.entity.Schedule;
import project.gaori.server.domain.schedule.entity.repository.ScheduleRepository;
import project.gaori.server.domain.schedule.exception.ScheduleNotFoundException;

@Component
@RequiredArgsConstructor
public class ScheduleFacade {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public Schedule findScheduleById(Long scheduleId) {
        return scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> ScheduleNotFoundException.EXCEPTION);
    }
}
