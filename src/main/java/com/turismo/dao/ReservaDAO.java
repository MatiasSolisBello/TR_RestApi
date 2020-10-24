package com.turismo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.model.Reserva;

public interface ReservaDAO extends JpaRepository<Reserva, Integer> {

}
