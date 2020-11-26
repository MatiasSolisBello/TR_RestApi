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

import com.turismo.model.Checkin;
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
	public List<Checkin> listarCheckin(){
		return checkinRepository.findAll();
	}
	
	@GetMapping("/reserva/{reservaId}/checkin")
    public Checkin getCheckinByreservaId(@PathVariable Long reservaId) {
        if(!reservaRepository.existsById(reservaId)) {
            throw new NotFoundException("Reserva not found!");
        }
      
      List<Checkin> checkin = checkinRepository.findByReservaId(reservaId);
      if(checkin.size() > 0) {
        return checkin.get(0);
      }else {
        throw new NotFoundException("Checkin not found!");
      }
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
    
    @PutMapping("/checkin/{checkinId}")
    public Checkin updateCheckin(@PathVariable Long CheckinId,
    @Valid @RequestBody Checkin CheckinUpdated) {
        return checkinRepository.findById(CheckinId)
        .map(Checkin -> {
            Checkin.setCondiciones(CheckinUpdated.getCondiciones());
            return checkinRepository.save(Checkin);
        }).orElseThrow(() -> new NotFoundException("Checkin not found!"));
    }
    
    @DeleteMapping("/checkins/{checkinId}")
    public String deleteCheckin(@PathVariable Long CheckinId) {
    return checkinRepository.findById(CheckinId)
        .map(Checkin -> {
            checkinRepository.delete(Checkin);
            return "Deleted Successfully!";
        }).orElseThrow(() -> new NotFoundException("Checkin not found!"));
    }
}
