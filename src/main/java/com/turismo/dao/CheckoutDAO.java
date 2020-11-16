package com.turismo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.model.Checkout;

public interface CheckoutDAO extends JpaRepository<Checkout, Integer>{
	//List<Checkout> findByIdReserva(Integer Idreserva); 

}
