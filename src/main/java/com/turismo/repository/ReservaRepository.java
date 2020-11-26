package com.turismo.repository;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.model.Depart;
import com.turismo.model.Reserva;
import com.turismo.model.User;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	Page<Reserva> findByServicioId(Long servicioId, Pageable pageable);
    Optional<Reserva> findByIdAndServicioId(Long id, Long servicioId);
    
	Page<Reserva> findByUserId(Long userId, Pageable pageable);
    Optional<Reserva> findByIdAndUserId(Long id, Long userId);
    
	Page<Reserva> findByDepartId(Long departId, Pageable pageable);
    Optional<Reserva> findByIdAndDepartId(Long id, Long departId);
}