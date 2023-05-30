package project.gaori.server.domain.friend.request.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.gaori.server.domain.friend.request.entity.FriendRequest;
import project.gaori.server.domain.user.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {
    boolean existsFriendRequestBySenderAndReceiver(User sender, User receiver);

    List<FriendRequest> findAllByReceiver(User receiver);

    Optional<FriendRequest> findBySender(User sender);
}
