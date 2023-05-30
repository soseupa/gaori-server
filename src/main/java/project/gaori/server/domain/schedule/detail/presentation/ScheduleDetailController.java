package project.gaori.server.domain.schedule.detail.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.schedule.detail.presentation.dto.request.CreateScheduleDetailRequest;
import project.gaori.server.domain.schedule.detail.presentation.dto.response.ScheduleDetailListResponse;
import project.gaori.server.domain.schedule.detail.service.CreateScheduleDetailService;
import project.gaori.server.domain.schedule.detail.service.FindScheduleDetailByScheduleIdService;

@RestController
@RequestMapping("/schedule/detail")
@RequiredArgsConstructor
public class ScheduleDetailController {
    private final CreateScheduleDetailService createScheduleDetailService;
    private final FindScheduleDetailByScheduleIdService findScheduleDetailByScheduleIdService;

    @PostMapping("")
    public void createScheduleDetail(@RequestBody CreateScheduleDetailRequest request) {
        createScheduleDetailService.execute(request);
    }

    @GetMapping("/{id}")
    public ScheduleDetailListResponse getScheduleDetail(@PathVariable Long id) {
        return findScheduleDetailByScheduleIdService.execute(id);
    }
}
