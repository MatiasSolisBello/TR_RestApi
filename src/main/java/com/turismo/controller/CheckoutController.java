package com.turismo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.model.Checkout;
import com.turismo.repository.CheckoutRepository;

@RestController
@CrossOrigin
public class CheckoutController {
	@Autowired
	private CheckoutRepository checkoutRepository;
	
	@GetMapping("/checkout")
	public List<Checkout> listarCheckout(){
		return checkoutRepository.findAll();
	}
}
