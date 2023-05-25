package project.gaori.server.domain.friend_requst.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.friend_requst.domain.FriendRequest;
import project.gaori.server.domain.friend_requst.domain.repository.FriendRequestRepository;
import project.gaori.server.domain.friend_requst.exception.FriendRequestNotFoundException;
import project.gaori.server.domain.user.entity.User;

@Component
@RequiredArgsConstructor
public class FriendRequestFacade {
    private final FriendRequestRepository friendRequestRepository;

    @Transactional
    public FriendRequest findFriendRequestBySender(User sender) {
        return friendRequestRepository.findBySender(sender).orElseThrow(() -> FriendRequestNotFoundException.EXCEPTION);
    }
}
