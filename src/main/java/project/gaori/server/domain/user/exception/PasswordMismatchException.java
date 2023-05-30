package project.gaori.server.domain.user.exception;

import project.gaori.server.domain.user.exception.error.UserErrorProperty;
import project.gaori.server.global.error.exception.GaoriException;

public class PasswordMismatchException extends GaoriException {
    public final static PasswordMismatchException EXCEPTION = new PasswordMismatchException();

    private PasswordMismatchException() {
        super(UserErrorProperty.PASSWORD_MISMATCH);
    }
}
