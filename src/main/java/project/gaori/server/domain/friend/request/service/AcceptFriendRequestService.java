package project.gaori.server.domain.friend.request.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.friend.request.entity.FriendRequest;
import project.gaori.server.domain.friend.request.entity.repository.FriendRequestRepository;
import project.gaori.server.domain.friend.request.exception.FriendRequestNotFoundException;
import project.gaori.server.domain.friend.request.facade.FriendRequestFacade;
import project.gaori.server.domain.friend.service.MakeFriendService;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class AcceptFriendRequestService {
    private final UserFacade userFacade;
    private final FriendRequestRepository friendRequestRepository;
    private final FriendRequestFacade friendRequestFacade;
    private final MakeFriendService makeFriendService;

    @Transactional
    public void execute(Long senderId) {
        User receiver = userFacade.getCurrentUser();
        User sender = userFacade.findUserById(senderId);
        FriendRequest request = friendRequestFacade.findFriendRequestBySender(sender);
        if (!friendRequestRepository.existsFriendRequestBySenderAndReceiver(sender, receiver))
            throw FriendRequestNotFoundException.EXCEPTION;
        makeFriendService.execute(sender, receiver);
        friendRequestRepository.deleteById(request.getId());
    }
}
