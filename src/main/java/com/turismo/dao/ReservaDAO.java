package com.turismo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.model.Reserva;

public interface ReservaDAO extends JpaRepository<Reserva, Integer> {

	/*
	List<Reserva> findByServicioServicioIdServicio(Integer servicio_id_servicio);
	List<Reserva> findByDepartIdDepart(Integer depart_id_depart);
	List<Reserva> findByClienteRut(Integer cliente_rut);
	*/
}
