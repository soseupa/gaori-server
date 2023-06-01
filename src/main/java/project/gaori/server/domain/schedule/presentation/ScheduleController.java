package project.gaori.server.domain.schedule.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.schedule.presentation.dto.request.CreateScheduleRequest;
import project.gaori.server.domain.schedule.presentation.dto.response.ScheduleListResponse;
import project.gaori.server.domain.schedule.service.CreateScheduleService;
import project.gaori.server.domain.schedule.service.FindSchedulesByDateService;

import java.text.ParseException;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
@Tag(name = "일정 서버")
public class ScheduleController {
    private final CreateScheduleService createScheduleService;
    private final FindSchedulesByDateService findSchedulesByDateService;

    @Operation(summary = "일정 생성")
    @PostMapping("")
    public void CreateSchedule(@RequestBody CreateScheduleRequest request) {
        createScheduleService.execute(request);
    }

    @Operation(summary = "해당 날짜 일정 조회")
    @GetMapping("")
    public ScheduleListResponse GetSchedule(@RequestParam String date) throws ParseException {
        return findSchedulesByDateService.execute(date);
    }


}
