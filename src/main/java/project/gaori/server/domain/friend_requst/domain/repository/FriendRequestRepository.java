package project.gaori.server.domain.friend_requst.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gaori.server.domain.friend_requst.domain.FriendRequest;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {
}
