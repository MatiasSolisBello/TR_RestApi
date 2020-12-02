package com.turismo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.model.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Long>{
	Page<Checkout> findByReservaId(Long reservaId, Pageable pageable); 	
    Optional<Checkout> findByIdAndReservaId(Long id, Long reservaId);
}
