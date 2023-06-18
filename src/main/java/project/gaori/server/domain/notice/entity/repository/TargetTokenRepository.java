package project.gaori.server.domain.notice.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.gaori.server.domain.notice.entity.TargetToken;

@Repository
public interface TargetTokenRepository extends JpaRepository<TargetToken, Long> {
}
