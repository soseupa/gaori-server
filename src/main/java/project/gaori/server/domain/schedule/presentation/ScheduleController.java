package project.gaori.server.domain.schedule.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.schedule.presentation.dto.request.CreateScheduleRequest;
import project.gaori.server.domain.schedule.service.CreateScheduleService;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final CreateScheduleService createScheduleService;

    @PostMapping("")
    public void CreateSchedule(@RequestBody CreateScheduleRequest request) {
        createScheduleService.execute(request);
    }

}
