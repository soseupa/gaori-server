package project.gaori.server.domain.friend.request.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import project.gaori.server.domain.friend.request.service.RefuseFriendRequestService;

@RestController
@RequestMapping("/friend/request")
@RequiredArgsConstructor
@Tag(name = "친구 요청 서버")
public class FriendRequestController {
    private final CreateRequestService createRequestService;
    private final FindFriendRequestService findFriendRequestService;
    private final AcceptFriendRequestService acceptFriendRequestService;
    private final RefuseFriendRequestService refuseFriendRequestService;

    @Operation(summary = "친구 요청 보내기")
    @PostMapping("")
    public void requestFriend(@RequestBody CreateFriendRequest request) {
        createRequestService.execute(request);
    }
    @Operation(summary = "친구 요청 확인하기")
    @GetMapping("")
    public FindFriendRequestListResponse findFriendRequest() {
        return findFriendRequestService.execute();
    }
    @Operation(summary = "친구 요청 수락")
    @GetMapping("/accept")
    public void acceptFriendRequest(@RequestParam Long senderId) {
        acceptFriendRequestService.execute(senderId);
    }
    @Operation(summary = "친구 요청 거절")
    @GetMapping("/refuse")
    public void refuseFriendRequest(@RequestParam Long senderId) { refuseFriendRequestService.execute(senderId); }
}
