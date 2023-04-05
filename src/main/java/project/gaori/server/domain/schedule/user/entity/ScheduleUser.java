package project.gaori.server.domain.schedule.user.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import project.gaori.server.domain.schedule.entity.Schedule;

import javax.persistence.*;


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
    @JoinColumn(name = "schedule_id", nullable = false) //외래키 이름 지정
    private Schedule schedule_users;

}
