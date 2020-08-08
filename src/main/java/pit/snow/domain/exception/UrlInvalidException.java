package pit.snow.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "URL invalid.")
public class UrlInvalidException extends RuntimeException {
}
