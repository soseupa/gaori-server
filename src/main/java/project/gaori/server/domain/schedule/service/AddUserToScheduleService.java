package project.gaori.server.domain.schedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.notice.service.MakeInviteScheduleNoticeService;
import project.gaori.server.domain.schedule.entity.Schedule;
import project.gaori.server.domain.schedule.facade.ScheduleFacade;
import project.gaori.server.domain.schedule.user.entity.ScheduleUser;
import project.gaori.server.domain.schedule.user.entity.repository.ScheduleUserRepository;
import project.gaori.server.domain.schedule.user.exception.ScheduleUserAlreadyExistsException;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.facade.UserFacade;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AddUserToScheduleService {

    private final ScheduleFacade scheduleFacade;
    private final UserFacade userFacade;
    private final ScheduleUserRepository scheduleUserRepository;
    private final MakeInviteScheduleNoticeService makeInviteScheduleNoticeService;

    @Transactional
    public void execute(Long scheduleId, String email) throws IOException {
        User me = userFacade.getCurrentUser();
        User user = userFacade.findUserByEmail(email);
        Schedule schedule = scheduleFacade.findScheduleById(scheduleId);
        this.scheduleUserRepository.findByUserAndSchedule(user, schedule).ifPresent(s -> {
            throw ScheduleUserAlreadyExistsException.EXCEPTION;
        });
        scheduleUserRepository.save(ScheduleUser.builder().schedule(schedule).user(user).build());
        makeInviteScheduleNoticeService.execute(me, user, schedule);
    }
}
