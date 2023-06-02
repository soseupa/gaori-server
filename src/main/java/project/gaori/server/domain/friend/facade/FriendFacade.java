package project.gaori.server.domain.friend.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.friend.entity.repository.FriendshipRepository;

@Component
@RequiredArgsConstructor
public class FriendFacade {
    private final FriendshipRepository friendshipRepository;
    @Transactional
    public boolean isFriend(Long userId, Long friendId) {
        return friendshipRepository.findByUserIdAndFriendId(userId, friendId).isPresent();
    }

}
