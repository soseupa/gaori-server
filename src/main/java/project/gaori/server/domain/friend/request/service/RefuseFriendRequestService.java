package project.gaori.server.domain.friend.request.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.friend.request.entity.FriendRequest;
import project.gaori.server.domain.friend.request.entity.repository.FriendRequestRepository;
import project.gaori.server.domain.friend.request.facade.FriendRequestFacade;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class RefuseFriendRequestService {
    private final UserFacade userFacade;
    private final FriendRequestRepository friendRequestRepository;
    private final FriendRequestFacade friendRequestFacade;

    @Transactional
    public void execute(Long senderId) {
        User receiver = userFacade.getCurrentUser();
        User sender = userFacade.findUserById(senderId);
        FriendRequest request = friendRequestFacade.findFriendRequestBySenderAndReceiver(sender, receiver);
        friendRequestRepository.deleteById(request.getId());
    }
}
