package project.gaori.server.domain.schedule.detail.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.schedule.detail.presentation.dto.request.CreateScheduleDetailRequest;
import project.gaori.server.domain.schedule.detail.service.CreateScheduleDetailService;

@RestController
@RequestMapping("/schedule/detail")
@RequiredArgsConstructor
public class ScheduleDetailController {
    private final CreateScheduleDetailService createScheduleDetailService;
    @PostMapping("")
    public void createScheduleDetail(@RequestBody CreateScheduleDetailRequest request) {
        createScheduleDetailService.execute(request);
    }
}
