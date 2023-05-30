package project.gaori.server.domain.friend.request.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.friend.request.entity.repository.FriendRequestRepository;
import project.gaori.server.domain.friend.request.presentation.dto.response.FindFriendRequestListResponse;
import project.gaori.server.domain.friend.request.presentation.dto.response.FindFriendRequestResponse;
import project.gaori.server.domain.friend.request.entity.FriendRequest;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.facade.UserFacade;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindFriendRequestService {
    private final FriendRequestRepository friendRequestRepository;
    private final UserFacade userFacade;

    @Transactional
    public FindFriendRequestListResponse execute() {
        User user = userFacade.getCurrentUser();
        List<FriendRequest> requests = friendRequestRepository.findAllByReceiver(user);
        return FindFriendRequestListResponse.builder().findFriendRequestResponseList(requests.stream().map(friendRequest -> FindFriendRequestResponse.of(friendRequest.getSender())).collect(Collectors.toList())).build();
    }
}
