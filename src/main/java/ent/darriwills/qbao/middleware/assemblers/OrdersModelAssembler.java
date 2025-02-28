package ent.darriwills.qbao.middleware.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ent.darriwills.models.Orders;

@Component
class OrdersModelAssembler implements RepresentationModelAssembler<Orders, EntityModel<Orders>> {

  @Override
  public EntityModel<Orders> toModel(Orderss orders) {
    EntityModel<Orders> model = EntityModel.of(orders,
        linkTo(methodOn(OrdersController.class).one(orders.getId())).withSelfRel(),
        linkTo(methodOn(OrdersController.class).all()).withRel("orders"));

    return model;
  }
}