package project.gaori.server.domain.friend.request.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.friend.request.presentation.dto.request.CreateFriendRequest;
import project.gaori.server.domain.friend.request.presentation.dto.response.FindFriendRequestListResponse;
import project.gaori.server.domain.friend.request.service.AcceptFriendRequestService;
import project.gaori.server.domain.friend.request.service.CreateRequestService;
import project.gaori.server.domain.friend.request.service.FindFriendRequestService;

@RestController
@RequestMapping("/friend")
@RequiredArgsConstructor
public class FriendController {
    private final CreateRequestService createRequestService;
    private final FindFriendRequestService findFriendRequestService;
    private final AcceptFriendRequestService acceptFriendRequestService;

    @PostMapping("/request")
    public void requestFriend(@RequestBody CreateFriendRequest request) {
        createRequestService.execute(request);
    }

    @GetMapping("/request")
    public FindFriendRequestListResponse findFriendRequest() {
        return findFriendRequestService.execute();
    }

    @GetMapping("/request/accept")
    public void acceptFriendRequest(@RequestParam Long senderId) {
        acceptFriendRequestService.execute(senderId);
    }
}
