package project.gaori.server.domain.schedule.detail.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
@Table(name = "tbl_schedule_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ScheduleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "schedule_id")
    private Schedule schedule_detail;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int order;

}
