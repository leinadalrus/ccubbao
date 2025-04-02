package ent.darriwills.ccubbao.middleware.exceptions;

interface OrdersNotFoundException extends RuntimeException {
    public OrdersNotFoundException(Long id) {
        super("Orders Not Found with ID:\t" + id);
    }
}