package com.turismo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.model.Servicio;

public  interface ServicioDAO extends JpaRepository<Servicio, Integer> {


}
