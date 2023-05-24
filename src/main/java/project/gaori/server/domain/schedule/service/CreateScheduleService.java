package project.gaori.server.domain.schedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.schedule.entity.Schedule;
import project.gaori.server.domain.schedule.entity.repository.ScheduleRepository;
import project.gaori.server.domain.schedule.presentation.dto.request.CreateScheduleRequest;
import project.gaori.server.domain.schedule.user.entity.ScheduleUser;
import project.gaori.server.domain.schedule.user.entity.repository.ScheduleUserRepository;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class CreateScheduleService {
    private final UserFacade userFacade;
    private final ScheduleRepository scheduleRepository;
    private final ScheduleUserRepository scheduleUserRepository;

    @Transactional
    public void execute(CreateScheduleRequest request) {
        User user = userFacade.getCurrentUser();
        Schedule schedule = request.toEntity();
        scheduleRepository.save(schedule);
        ScheduleUser scheduleUser = ScheduleUser.builder()
                .schedule(schedule)
                .user(user)
                .build();
        scheduleUserRepository.save(scheduleUser);
    }
}
