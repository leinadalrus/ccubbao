package ent.darriwills.ccubbao.middleware.exceptions.advisors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ent.darriwills.ccubbao.middleware.exceptions.ProductsNotFoundException;

@RestControllerAdvice
class ProductsNotFoundAdvice {
    @ExceptionHandler(ProductsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productsNotFoundHandler(ProductsNotFoundException exception) {
        return exception.getMessage();
    }
}