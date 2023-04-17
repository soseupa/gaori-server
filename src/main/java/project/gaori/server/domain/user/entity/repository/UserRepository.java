package project.gaori.server.domain.user.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gaori.server.domain.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsUserByNickname(String nickname);
    boolean existsUserByEmail(String email);
    Optional<User> findUserByEmail(String email);
}
