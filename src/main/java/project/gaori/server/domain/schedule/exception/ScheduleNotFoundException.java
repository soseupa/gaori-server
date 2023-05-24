package project.gaori.server.domain.schedule.exception;

import project.gaori.server.domain.schedule.exception.error.ScheduleErrorProperty;
import project.gaori.server.global.error.exception.GaoriException;

public class ScheduleNotFoundException extends GaoriException {
    public final static ScheduleNotFoundException EXCEPTION = new ScheduleNotFoundException();

    public ScheduleNotFoundException() {super(ScheduleErrorProperty.SCHEDULE_NOT_FOUND);
    }
}
