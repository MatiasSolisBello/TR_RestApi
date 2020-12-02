package com.turismo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turismo.model.Checkin;

public interface CheckinRepository extends JpaRepository<Checkin, Long>{
	Page<Checkin> findByReservaId(Long reservaId, Pageable pageable);
    Optional<Checkin> findByIdAndReservaId(Long id, Long reservaId);
}
