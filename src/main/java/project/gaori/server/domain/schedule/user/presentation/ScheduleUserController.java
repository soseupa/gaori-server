package project.gaori.server.domain.schedule.user.entity.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.schedule.service.AddUserToScheduleService;

@RestController
@RequestMapping("/schedule/user")
@RequiredArgsConstructor
@Tag(name = "일정 친구 서버")
public class ScheduleUserController {
    private final AddUserToScheduleService addUserToScheduleService;

    @Operation(summary = "일정에 친구 추가")
    @GetMapping("/add")
    public void AddMember(@RequestParam Long id, @RequestParam String email) {
        addUserToScheduleService.execute(id, email);
    }
}
