package project.gaori.server.domain.schedule.detail.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "친구 서버")
public class ScheduleDetailController {
    private final CreateScheduleDetailService createScheduleDetailService;
    private final FindScheduleDetailByScheduleIdService findScheduleDetailByScheduleIdService;

    @Operation(summary = "세부 일정 추가")
    @PostMapping("")
    public void createScheduleDetail(@RequestBody CreateScheduleDetailRequest request) {
        createScheduleDetailService.execute(request);
    }

    @Operation(summary = "세부 일정 조회")
    @GetMapping("/{id}")
    public ScheduleDetailListResponse getScheduleDetail(@PathVariable Long id) {
        return findScheduleDetailByScheduleIdService.execute(id);
    }
}
