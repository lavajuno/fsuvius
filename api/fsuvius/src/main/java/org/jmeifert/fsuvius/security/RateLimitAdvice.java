package org.jmeifert.fsuvius.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * RateLimitAdvice provides responses to throttled requests.
 */
@ControllerAdvice
public class RateLimitAdvice {
    @ResponseBody
    @ExceptionHandler(RateLimitException.class)
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    String rateLimitHandler(RateLimitException e) {
        return e.getMessage();
    }
}
