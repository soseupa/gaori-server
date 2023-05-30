package project.gaori.server.domain.user.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.gaori.server.domain.user.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByNickname(String nickname);

    boolean existsUserByEmail(String email);

    Optional<User> findUserByEmail(String email);

    @Query("select u from User u join fetch u.friendList f where f.user=:user")
    List<User> findAllByFriendships(User user);

}
