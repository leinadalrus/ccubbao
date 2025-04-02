package ent.darriwills.ccubbao.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ent.darriwills.ccubbao.models.Orders;

interface OrderssRepository extends JpaRepository<Orders, Long> {}