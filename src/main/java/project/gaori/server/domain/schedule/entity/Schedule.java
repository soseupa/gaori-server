package project.gaori.server.domain.schedule.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import project.gaori.server.domain.schedule.detail.entity.ScheduleDetail;
import project.gaori.server.domain.schedule.user.entity.ScheduleUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_schedule")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToMany(mappedBy = "schedule_detail")
    private List<ScheduleDetail> details = new ArrayList<>();

    @OneToMany(mappedBy = "schedule_users")
    private List<ScheduleUser> users = new ArrayList<>();

}
