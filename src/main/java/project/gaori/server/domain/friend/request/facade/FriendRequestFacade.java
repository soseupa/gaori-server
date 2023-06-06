package project.gaori.server.domain.friend.request.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.friend.request.entity.FriendRequest;
import project.gaori.server.domain.friend.request.entity.repository.FriendRequestRepository;
import project.gaori.server.domain.friend.request.exception.FriendRequestNotFoundException;
import project.gaori.server.domain.user.entity.User;

@Component
@RequiredArgsConstructor
public class FriendRequestFacade {
    private final FriendRequestRepository friendRequestRepository;

    @Transactional
    public FriendRequest findFriendRequestBySenderAndReceiver(User sender, User receiver) {
        return friendRequestRepository.findBySenderAndReceiver(sender, receiver).orElseThrow(() -> FriendRequestNotFoundException.EXCEPTION);
    }
}
