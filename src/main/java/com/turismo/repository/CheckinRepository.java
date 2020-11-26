package com.turismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.turismo.model.Checkin;

public interface CheckinRepository extends JpaRepository<Checkin, Long>{
	
}
