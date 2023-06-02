package project.gaori.server.domain.friend.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.gaori.server.domain.friend.entity.Friendship;

import java.util.Optional;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    Optional<Friendship> findByUserIdAndFriendId(Long userId, Long friendId);
}
