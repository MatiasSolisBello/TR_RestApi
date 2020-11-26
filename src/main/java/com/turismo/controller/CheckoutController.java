package com.turismo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Checkout> listarCheckout(){
		return checkoutRepository.findAll();
	}
	
	@GetMapping("/reserva/{reservaId}/checkout")
    public Checkout getCheckoutByReservaId(@PathVariable Long reservaId) {
        if(!reservaRepository.existsById(reservaId)) {
            throw new NotFoundException("Reserva not found!");
        }
      
      List<Checkout> checkout = checkoutRepository.findByReservaId(reservaId);
      if(checkout.size() > 0) {
        return checkout.get(0);
      }else {
        throw new NotFoundException("checkout not found!");
      }
    }
	
	@PostMapping("/reserva/{reservaId}/checkout")
    public Checkout addCheckout(@PathVariable Long reservaId,
    @Valid @RequestBody Checkout Checkout) {
        return reservaRepository.findById(reservaId)
        .map(reserva -> {
            Checkout.setReserva(reserva);
            return checkoutRepository.save(Checkout);
        }).orElseThrow(() -> new NotFoundException("reserva not found!"));
    }
    
    @PutMapping("/checkout/{checkoutId}")
    public Checkout updateCheckout(@PathVariable Long CheckoutId,
    @Valid @RequestBody Checkout CheckoutUpdated) {
        return checkoutRepository.findById(CheckoutId)
        .map(Checkout -> {
            Checkout.setEstado(CheckoutUpdated.getEstado());
            Checkout.setMulta(CheckoutUpdated.getMulta());
            Checkout.setProblemas(CheckoutUpdated.getProblemas());
            return checkoutRepository.save(Checkout);
        }).orElseThrow(() -> new NotFoundException("Checkout not found!"));
    }
    
    @DeleteMapping("/checkout/{checkoutId}")
    public String deleteCheckout(@PathVariable Long CheckoutId) {
    return checkoutRepository.findById(CheckoutId)
        .map(Checkout -> {
            checkoutRepository.delete(Checkout);
            return "Deleted Successfully!";
        }).orElseThrow(() -> new NotFoundException("checkout not found!"));
    }
}
