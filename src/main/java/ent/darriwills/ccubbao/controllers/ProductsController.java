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

import ent.darriwills.ccubbao.data.repository.ProductsRepository;
import ent.darriwills.ccubbao.middleware.ProductsModelAssembler;
import ent.darriwills.ccubbao.models.Products;

@RestController
public class ProductsController {
    private final ProductsRepository repository;
    private final ProductsModelAssembler assembler;

    ProductsController(ProductsRepository repository
                       ProductsModelAssembler assembler
    ) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @PostMapping("/products")
    ResponseEntity<?> newProduct(@RequestBody Products newProduct) {
        EntityModel<Products> model = assembler.toModel(
            repository.save(newProduct));
        
        return ResponseEntity
                .created(model.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(model);
    }

    @PutMapping("/products/{id}")
    ResponseEntity<?> updateProduct(@RequestBody Products newProduct,
        @PathVariable Long id
    ) {
        Products updatedProduct = repository.findById(id)
            .map(product -> {
                product.setName(newProduct.getName());
                product.setDescription(newProduct.getDescription());
                product.setHeroImage(newProduct.getHeroImage());
                product.setDateStamp(newProduct.getDateStamp());

                return repository.save(product);
            })
            .orElseGet(() -> {
                return repository.save(newProduct);
            });

        EntityModel<Products> model = assembler.toModel(updatedProduct);

        return ResponseEntity
            .created(model.getRequiredLink(IanaLinkRelations.SELF).toUri())
            .body(model);
    }

    @GetMapping("/products")
    public Collection<EntityModel<Products>> findAll() {
        List<EntityModel<Products>> products = repository.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(products,
            linkTo(methodOn(ProductsController.class).findAll()).withSelfRel());
    }

    @GetMapping("/products/{id}")
    EntityModel<Products> findById(@PathVariable Long id) {
        var product = repository.findById(id)
            .orElseThrow(() -> new ProductsNotFoundException(id));

        return assembler.toModel(product);
    }

    @DeleteMapping("/products/{id}")
    ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}