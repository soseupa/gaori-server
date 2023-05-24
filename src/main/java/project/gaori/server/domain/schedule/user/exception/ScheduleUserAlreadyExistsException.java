package project.gaori.server.domain.schedule.user.exception;

import project.gaori.server.domain.schedule.user.exception.error.ScheduleUserErrorProperty;
import project.gaori.server.global.error.exception.GaoriException;

public class ScheduleUserAlreadyExistsException extends GaoriException {
    public final static ScheduleUserAlreadyExistsException EXCEPTION = new ScheduleUserAlreadyExistsException();

    public ScheduleUserAlreadyExistsException() {
        super(ScheduleUserErrorProperty.SCHEDULE_USER_ALREADY_EXISTS);
    }
}
