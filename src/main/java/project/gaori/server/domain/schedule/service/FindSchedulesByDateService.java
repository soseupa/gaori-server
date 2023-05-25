package project.gaori.server.domain.schedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gaori.server.domain.schedule.entity.Schedule;
import project.gaori.server.domain.schedule.entity.repository.ScheduleRepository;
import project.gaori.server.domain.schedule.presentation.dto.response.ScheduleListResponse;
import project.gaori.server.domain.schedule.presentation.dto.response.ScheduleResponse;
import project.gaori.server.domain.schedule.user.entity.ScheduleUser;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.facade.UserFacade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindSchedulesByDateService {
    private final ScheduleRepository scheduleRepository;
    private final UserFacade userFacade;

    public ScheduleListResponse execute(String dateAsString) throws ParseException {
        User user = userFacade.getCurrentUser();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateAsString);
        LocalDateTime startDay = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime endDay = startDay.plusHours(23).plusMinutes(59).plusSeconds(59).plusSeconds(59);
        List<Schedule> lists = scheduleRepository.findAllByScheduleUsersAndTime(user, startDay, endDay);
        return ScheduleListResponse.builder()
                .schedules(lists.stream().map(schedule -> {
                    List<User> scheduleUsers = schedule.getScheduleUsers().stream().map(ScheduleUser::getUser).collect(Collectors.toList());
                    return ScheduleResponse.of(schedule, scheduleUsers);
                }).collect(Collectors.toList()))
                .build();
    }
}
