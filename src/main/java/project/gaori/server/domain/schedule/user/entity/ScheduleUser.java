package project.gaori.server.domain.schedule.user.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import project.gaori.server.domain.schedule.entity.Schedule;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_schedule_user")
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule_users;

}
