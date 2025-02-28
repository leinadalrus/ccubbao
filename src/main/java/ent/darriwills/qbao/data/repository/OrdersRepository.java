package ent.darriwills.qbao.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ent.darriwills.qbao.models.Orders;

interface OrderssRepository extends JpaRepository<Orders, Long> {}