package com.turismo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.model.Checkin;
import com.turismo.model.Depart;
import com.turismo.model.Reserva;
import com.turismo.repository.CheckinRepository;
import com.turismo.repository.ReservaRepository;

@RestController
@CrossOrigin
public class CheckinController {
	@Autowired
	private CheckinRepository checkinRepository;
	@Autowired
	private ReservaRepository reservaRepository;
	
    @GetMapping("/checkin")
    public List<Checkin> listarReserva(){
        return checkinRepository.findAll();
    }
    
    @GetMapping("/checkin/{id}")
	public Optional<Checkin> listarById
	(@PathVariable("id") Long id) {
		return checkinRepository.findById(id);
	}
    
    //------------------------------------------------
    //            CRUD RESERVA - CHECKIN
    //------------------------------------------------
    @GetMapping("/reserva/{reservaId}/checkin")
    public Page<Checkin> getAllCheckinByReservaId
    (@PathVariable (value = "reservaId") 
    Long reservaId, Pageable pageable) {
        return checkinRepository.findByReservaId
        (reservaId, pageable);
    }
    
	
	@PostMapping("/reserva/{reservaId}/checkin")
    public Checkin addCheckin(@PathVariable Long reservaId,
    @Valid @RequestBody Checkin Checkin) {
        return reservaRepository.findById(reservaId)
        .map(reserva -> {
            Checkin.setReserva(reserva);
            return checkinRepository.save(Checkin);
        }).orElseThrow(() -> new NotFoundException("reserva not found!"));
    }
	
	
    
}
