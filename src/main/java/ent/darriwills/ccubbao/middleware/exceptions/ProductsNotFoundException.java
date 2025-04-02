package ent.darriwills.ccubbao.middleware.exceptions;

public class ProductsNotFoundException extends RuntimeException {
    ProductsNotFoundException(Long id) {
        super("Cannot find the inputted product with:\t" + id);
    }
}