package com.turismo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.model.Checkout;
import com.turismo.repository.CheckoutRepository;
import com.turismo.repository.ReservaRepository;

@RestController
@CrossOrigin
public class CheckoutController {
	@Autowired
	private CheckoutRepository checkoutRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
    @GetMapping("/checkout")
    public List<Checkout> listarReserva(){
        return checkoutRepository.findAll();
    }
    
    @GetMapping("/checkout/{id}")
	public Optional<Checkout> listarById
	(@PathVariable("id") Long id) {
		return checkoutRepository.findById(id);
	}
    //------------------------------------------------
    //            CRUD RESERVA - SERVICIO
    //------------------------------------------------
    @GetMapping("/reserva/{reservaId}/checkout")
    public Page<Checkout> getAllCheckoutByReservaId
    (@PathVariable (value = "reservaId") 
    Long reservaId, Pageable pageable) {
        return checkoutRepository.findByReservaId
        (reservaId, pageable);
    }
    
	@PostMapping("/reserva/{reservaId}/checkout")
    public Checkout addCheckout(@PathVariable Long reservaId,
    @Valid @RequestBody Checkout checkout) {
        return reservaRepository.findById(reservaId)
        .map(reserva -> {
            checkout.setReserva(reserva);
            return checkoutRepository.save(checkout);
        }).orElseThrow(() -> new NotFoundException("reserva not found!"));
    }
    
}
