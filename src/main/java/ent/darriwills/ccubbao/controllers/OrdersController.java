package ent.darriwills.ccubbao.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import ent.darriwills.ccubbao.data.repository.OrdersRepository;
import ent.darriwills.ccubbao.middleware.OrdersModelAssembler;
import ent.darriwills.ccubbao.models.Orders;

@RestController
public class OrdersController {
    private final OrdersRepository repository;
    private final OrdersModelAssembler assembler;

    public OrdersController(OrdersRepository repository,
        OrdersModelAssembler assembler
    ) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public OrdersController() {}

    @GetMapping("/orders")
    CollectionModel<EntityModel<Orders>> findAll() {
        List<EntityModel<Orders>> orders = repository.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(orders,
            linkTo(methodOn(OrdersController.class).all()).withSelfRel());
    }

    @GetMapping("/orders/{id}")
    EntityModel<Orders> findOne(@PathVariable Long id) {
        Orders order = repository.findById(id)
            .orElseThrow(() -> new OrdersNotFoundException(id));
        
        return assembler.toModel(order);
    }

    @PostMapping("/orders")
    ResponseEntity<EntityModel<Orders>> newOrders(@RequestBody Orders orders) {

        Orders createdOrder = repository.save(orders);

        return ResponseEntity
            .created(linkTo(methodOn(OrdersController.class)
                .findOne(createdOrder.getId())).toUri())
            .body(assembler.toModel(newOrders));
    }

    @DeleteMapping("/orders/{id}")
    ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}