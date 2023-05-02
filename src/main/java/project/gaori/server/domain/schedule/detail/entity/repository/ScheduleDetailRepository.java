package project.gaori.server.domain.schedule.detail.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.gaori.server.domain.schedule.detail.entity.ScheduleDetail;

@Repository
public interface ScheduleDetailRepository extends JpaRepository<ScheduleDetail, Long> {
}
