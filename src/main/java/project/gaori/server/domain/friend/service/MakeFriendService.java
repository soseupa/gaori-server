package project.gaori.server.domain.friend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.friend.entity.Friendship;
import project.gaori.server.domain.friend.entity.repository.FriendshipRepository;
import project.gaori.server.domain.user.entity.User;

@Service
@RequiredArgsConstructor
public class MakeFriendService {
    private final FriendshipRepository friendshipRepository;

    @Transactional
    public void execute(User sender, User receiver) {
        friendshipRepository.save(
                Friendship.builder()
                        .user(receiver)
                        .friend(sender)
                        .build()
        );
        friendshipRepository.save(
                Friendship.builder()
                        .user(sender)
                        .friend(receiver)
                        .build()
        );
    }
}
