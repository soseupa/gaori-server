package project.gaori.server.domain.user.exception;

import project.gaori.server.domain.user.exception.error.UserErrorProperty;
import project.gaori.server.global.error.exception.GaoriException;

public class UserAlreadyExistsException extends GaoriException {
    public final static UserAlreadyExistsException EXCEPTION = new UserAlreadyExistsException();
    private UserAlreadyExistsException() {
        super(UserErrorProperty.USER_ALREADY_EXISTS);
    }
}
