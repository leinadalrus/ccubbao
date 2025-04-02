package ent.darriwills.ccubbao.middleware.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

public class ProductsModelAssembler implements RepresentationModelAssembler<Products, EntityModel<Products>> {
    @Override
    public EntityModel<Products> toModel(Products product) {
        return EntityModel.of(product,
            linkTo(methodOn(ProductsController.class).findOne(product.getId())).withSelfRel(),
            linkTo(methodOn(ProductsController.class).findAll(product.getId())).withRel("products"));
    }
}