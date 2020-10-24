package com.turismo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.model.Depart;

public interface DepartDAO extends JpaRepository<Depart, Integer> {

}