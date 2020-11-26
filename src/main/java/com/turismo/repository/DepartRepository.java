package com.turismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.model.Depart;

public interface DepartRepository extends JpaRepository<Depart, Long> {

}