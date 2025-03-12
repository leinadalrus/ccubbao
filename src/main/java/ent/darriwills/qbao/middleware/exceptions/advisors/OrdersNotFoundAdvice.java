package ent.darriwills.qbao.middleware.exceptions.advisors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ent.darriwills.qbao.middleware.exceptions.OrdersNotFoundException;

@RestControllerAdvice
class OrdersNotFoundAdvice {
    @ExceptionHandler(OrdersNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ordersNotFoundHandler(OrdersNotFoundException exception) {
        return exception.getMessage();
    }
}