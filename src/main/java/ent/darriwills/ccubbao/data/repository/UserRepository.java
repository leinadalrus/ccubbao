package ent.darriwills.ccubbao.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ent.darriwills.ccubbao.models.User;

interface UserRepository extends JpaRepository<User, Long> {}