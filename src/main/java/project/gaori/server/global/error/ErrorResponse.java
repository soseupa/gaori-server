package project.gaori.server.global.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import project.gaori.server.global.error.exception.ErrorProperty;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private HttpStatus status;
    private String message;

    public ErrorResponse(ErrorProperty errorProperty) {
        this.status = errorProperty.getStatus();
        this.message = errorProperty.getMessage();
    }
}
