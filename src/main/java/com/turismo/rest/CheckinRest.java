package com.turismo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.dao.CheckinDAO;
import com.turismo.dao.ReservaDAO;
import com.turismo.model.Checkin;


@RestController
@RequestMapping("/checkin")
@CrossOrigin
public class CheckinRest {
	@Autowired
	private CheckinDAO checkinDao;
	
	/*
	@Autowired
	private ReservaDAO reservaDao;
	
	@GetMapping("/reserva/{Idreserva}/checkin")
    public List<Checkin> getCheckinByIdReserva
    (@PathVariable Integer Idreserva) {
      
        if(!reservaDao.existsById(Idreserva)) {
            throw new NotFoundException("Reserva not found!");
        }
      
      return checkinDao.findByIdReserva(Idreserva);
    }
	*/
	
	@GetMapping("/listar")
	public List<Checkin> listarCheckin(){
		return checkinDao.findAll();
	}
}
