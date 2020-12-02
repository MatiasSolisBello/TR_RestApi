package com.turismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    Long countById(Long id);
}
