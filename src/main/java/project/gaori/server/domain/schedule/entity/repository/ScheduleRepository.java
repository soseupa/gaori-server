package project.gaori.server.domain.schedule.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.gaori.server.domain.schedule.entity.Schedule;
import project.gaori.server.domain.user.entity.User;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("select s from Schedule s join fetch s.scheduleUsers su where su.user = :user and s.time between :startDay and :endDay")
    List<Schedule> findAllByScheduleUsersAndTime(User user, LocalDateTime startDay, LocalDateTime endDay);
}
