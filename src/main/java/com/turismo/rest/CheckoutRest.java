package com.turismo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.dao.CheckoutDAO;
import com.turismo.dao.ReservaDAO;
import com.turismo.model.Checkout;

@RestController
@RequestMapping("/checkout")
@CrossOrigin
public class CheckoutRest {
	@Autowired
	private CheckoutDAO checkoutDao;
	
	/*
	@Autowired
	private ReservaDAO reservaDao;
	
	@GetMapping("/reserva/{Idreserva}/checkout")
    public List<Checkout> getCheckoutByIdReserva
    (@PathVariable Integer Idreserva) {
      
        if(!reservaDao.existsById(Idreserva)) {
            throw new NotFoundException("Reserva not found!");
        }
      
      return checkoutDao.findByIdReserva(Idreserva);
    }
    */
	
	@GetMapping("/listar")
	public List<Checkout> listarCheckout(){
		return checkoutDao.findAll();
	}
}
