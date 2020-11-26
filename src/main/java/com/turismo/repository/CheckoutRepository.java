package com.turismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.turismo.model.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Long>{

}
