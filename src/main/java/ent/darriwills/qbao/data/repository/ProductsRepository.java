package ent.darriwills.qbao.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ent.darriwills.qbao.models.Products;

interface ProductsRepository extends JpaRepository<Products, Long> {}