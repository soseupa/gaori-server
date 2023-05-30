package project.gaori.server.domain.friend.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.friend.presentation.response.FriendListResponse;
import project.gaori.server.domain.friend.service.FindFriendsService;

@RestController
@RequestMapping("/friend")
@RequiredArgsConstructor
public class FriendController {
    private final FindFriendsService findFriendsService;

    @GetMapping("/list")
    public FriendListResponse getFriendList() {
        return findFriendsService.execute();
    }
}
