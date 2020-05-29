package lab4.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Component
public class ParsingExceptionHandler {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String handleParsingException(Exception e) {
        System.err.println("Exception occurred:");
        e.printStackTrace(System.err);
        return "Wrong syntax.";
    }
}
