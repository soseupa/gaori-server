package project.gaori.server.domain.schedule.detail.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.gaori.server.domain.schedule.entity.Schedule;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_schedule_detail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ScheduleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "schedule_id")
    private Schedule schedule_detail;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int orderIndex;
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Builder
    public ScheduleDetail(Schedule schedule_detail, String location, int orderIndex, double latitude, double longitude,String title) {
        this.schedule_detail = schedule_detail;
        this.location = location;
        this.orderIndex = orderIndex;
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
    }
}
