package ent.darriwills.qbao.middleware.exceptions.advisors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ent.darriwills.qbao.middleware.exceptions.UserNotFoundException;

@RestControllerAdvice
class UserNotFoundAdvice {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(UserNotFoundException exception) {
        return exception.getMessage();
    }
}