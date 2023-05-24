package project.gaori.server.domain.schedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.schedule.entity.Schedule;
import project.gaori.server.domain.schedule.entity.repository.ScheduleRepository;
import project.gaori.server.domain.schedule.presentation.dto.request.CreateScheduleRequest;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class CreateScheduleService {
    private final UserFacade userFacade;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public void execute(CreateScheduleRequest request) {
        User user = userFacade.getCurrentUser();
        Schedule schedule = request.toEntity();
        schedule.addUser(user);
        scheduleRepository.save(schedule);

    }
}
