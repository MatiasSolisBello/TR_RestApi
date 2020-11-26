package com.turismo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.turismo.model.Checkin;

public interface CheckinRepository extends JpaRepository<Checkin, Long>{
	List<Checkin> findByReservaId(Long reservaId);  
}
