package project.gaori.server.domain.user.exception;

import project.gaori.server.domain.user.exception.error.UserErrorProperty;
import project.gaori.server.global.error.exception.GaoriException;

public class UserNotFoundException extends GaoriException {
    public final static UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(UserErrorProperty.USER_NOT_FOUND);
    }
}
