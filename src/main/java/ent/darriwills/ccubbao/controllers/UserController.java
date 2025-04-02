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

import ent.darriwills.ccubbao.data.repository.UserRepository;
import ent.darriwills.ccubbao.middleware.UserModelAssembler;
import ent.darriwills.ccubbao.models.User;

@RestController
public class UserController {
    private final UserRepository repository;
    private final UserModelAssembler assembler;

    UserController(UserRepository repository
                       UserModelAssembler assembler
    ) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @PostMapping("/users")
    ResponseEntity<?> newUser(@RequestBody User newUser) {
        EntityModel<User> model = assembler.toModel(
            repository.save(newUser));
        
        return ResponseEntity
                .created(model.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(model);
    }

    @PutMapping("/users/{id}")
    ResponseEntity<?> updateUser(@RequestBody User newUser,
        @PathVariable Long id
    ) {
        User updatedUser = repository.findById(id)
            .map(user -> {
                return repository.save(user);
            })
            .orElseGet(() -> {
                return repository.save(newUser);
            });

        EntityModel<User> model = assembler.toModel(updatedUser);

        return ResponseEntity
            .created(model.getRequiredLink(IanaLinkRelations.SELF).toUri())
            .body(model);
    }

    @GetMapping("/users")
    public Collection<EntityModel<User>> findAll() {
        List<EntityModel<User>> users = repository.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(users,
            linkTo(methodOn(UserController.class).findAll()).withSelfRel());
    }

    @GetMapping("/users/{id}")
    EntityModel<User> findById(@PathVariable Long id) {
        var user = repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));

        return assembler.toModel(user);
    }

    @DeleteMapping("/users/{id}")
    ResponseEntity<?> deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}