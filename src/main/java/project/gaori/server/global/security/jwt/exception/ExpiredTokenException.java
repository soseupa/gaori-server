package project.gaori.server.global.security.jwt.exception;


import project.gaori.server.global.error.exception.GaoriException;
import project.gaori.server.global.security.jwt.exception.error.JwtErrorProperty;

public class ExpiredTokenException extends GaoriException {

    public final static ExpiredTokenException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(JwtErrorProperty.EXPIRED_TOKEN);
    }
}