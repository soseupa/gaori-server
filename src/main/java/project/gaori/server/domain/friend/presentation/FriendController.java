package project.gaori.server.domain.friend.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.friend.presentation.response.FriendListResponse;
import project.gaori.server.domain.friend.service.FindFriendsService;

@RestController
@RequestMapping("/friend")
@RequiredArgsConstructor
@Tag(name = "친구 서버")
public class FriendController {
    private final FindFriendsService findFriendsService;

    @Operation(summary = "친구 목록")
    @GetMapping("/list")
    public FriendListResponse getFriendList() {
        return findFriendsService.execute();
    }
}
