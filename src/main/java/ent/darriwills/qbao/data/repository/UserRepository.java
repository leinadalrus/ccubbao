package ent.darriwills.qbao.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ent.darriwills.qbao.models.User;

interface UserRepository extends JpaRepository<User, Long> {}