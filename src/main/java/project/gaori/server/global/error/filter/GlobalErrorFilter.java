package project.gaori.server.global.error.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;
import project.gaori.server.global.error.ErrorResponse;
import project.gaori.server.global.error.exception.ErrorCode;
import project.gaori.server.global.error.exception.ErrorProperty;
import project.gaori.server.global.error.exception.GaoriException;
import project.gaori.server.global.security.jwt.exception.ExpiredTokenException;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class GlobalErrorFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredTokenException e) {
            setErrorResponse(e.getErrorProperty(), response);
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        } catch (GaoriException e) {
            setErrorResponse(e.getErrorProperty(), response);
        } catch (Exception e) {
            if (e.getCause() instanceof GaoriException) {
                setErrorResponse(((GaoriException) e.getCause()).getErrorProperty(), response);
            } else {
                e.printStackTrace();
                setErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, response);
            }
        }
    }

    private void setErrorResponse(ErrorProperty errorProperty, HttpServletResponse response) throws IOException {
        response.setStatus(errorProperty.getStatus().value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.getWriter().write(
                objectMapper.writeValueAsString(
                        new ErrorResponse(errorProperty)
                )
        );
    }
}
