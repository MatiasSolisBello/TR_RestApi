package com.turismo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.model.Servicio;

public  interface ServicioDAO extends JpaRepository<Servicio, Integer> {

}
