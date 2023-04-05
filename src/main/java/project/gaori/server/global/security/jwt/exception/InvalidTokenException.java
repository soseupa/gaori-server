package project.gaori.server.global.security.jwt.exception;

import project.gaori.server.global.error.exception.GaoriException;
import project.gaori.server.global.security.jwt.exception.error.JwtErrorProperty;

public class InvalidTokenException extends GaoriException {

    public final static InvalidTokenException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(JwtErrorProperty.INVALID_TOKEN);
    }
}