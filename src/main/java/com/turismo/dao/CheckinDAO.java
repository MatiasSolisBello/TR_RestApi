package com.turismo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.model.Checkin;

public interface CheckinDAO extends JpaRepository<Checkin, Integer>{
	//List<Checkin> findByIdReserva(Integer Idreserva);  
}
