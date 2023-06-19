package project.gaori.server.domain.notice.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.gaori.server.domain.notice.entity.TargetToken;
import project.gaori.server.domain.user.entity.User;

import java.util.Optional;

@Repository
public interface TargetTokenRepository extends JpaRepository<TargetToken, Long> {
    Optional<TargetToken> findByUser(User user);
}
