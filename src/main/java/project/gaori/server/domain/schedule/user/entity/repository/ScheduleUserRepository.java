package project.gaori.server.domain.schedule.user.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.gaori.server.domain.schedule.entity.Schedule;
import project.gaori.server.domain.schedule.user.entity.ScheduleUser;
import project.gaori.server.domain.user.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleUserRepository extends JpaRepository<ScheduleUser, Long> {
    Optional<ScheduleUser> findByUserAndSchedule(User user, Schedule schedule);
    List<ScheduleUser> findAllBySchedule(Schedule schedule);
}
