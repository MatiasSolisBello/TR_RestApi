package com.turismo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.model.Checkin;
import com.turismo.model.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Long>{
	List<Checkout> findByReservaId(Long reservaId); 
}
