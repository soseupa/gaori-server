package project.gaori.server.domain.friend_requst.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.friend_requst.presentation.dto.request.CreateFriendRequest;
import project.gaori.server.domain.friend_requst.service.CreateRequestService;

@RestController
@RequestMapping("/friend")
@RequiredArgsConstructor
public class FriendController {
    private final CreateRequestService createRequestService;
    @PostMapping("/request")
    public void requestFriend(@RequestBody CreateFriendRequest request) {
        createRequestService.execute(request);
    }
}
