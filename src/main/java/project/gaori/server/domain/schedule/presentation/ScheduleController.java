package project.gaori.server.domain.schedule.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.schedule.presentation.dto.request.CreateScheduleRequest;
import project.gaori.server.domain.schedule.service.AddUserToScheduleService;
import project.gaori.server.domain.schedule.service.CreateScheduleService;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final CreateScheduleService createScheduleService;
    private final AddUserToScheduleService addUserToScheduleService;

    @PostMapping("")
    public void CreateSchedule(@RequestBody CreateScheduleRequest request) {
        createScheduleService.execute(request);
    }

    @GetMapping("add")
    public void AddMember(@RequestParam Long id, @RequestParam String email) {
        addUserToScheduleService.execute(id, email);
    }

}
