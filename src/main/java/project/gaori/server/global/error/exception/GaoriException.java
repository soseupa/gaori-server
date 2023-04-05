package project.gaori.server.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GaoriException extends RuntimeException {

    private final ErrorProperty errorProperty;

}
