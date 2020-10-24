package com.turismo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.model.Cliente;


public interface ClienteDAO extends JpaRepository<Cliente, Integer> {

}
