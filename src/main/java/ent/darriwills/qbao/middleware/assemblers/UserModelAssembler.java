package ent.darriwills.qbao.middleware.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {
    @Override
    public EntityModel<User> toModel(User product) {
        return EntityModel.of(product,
            linkTo(methodOn(UserController.class).findOne(product.getId())).withSelfRel(),
            linkTo(methodOn(UserController.class).findAll(product.getId())).withRel("products"));
    }
}