package com.turismo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.exception.ResourceNotFoundException;
import com.turismo.model.Depart;
import com.turismo.model.Reserva;
import com.turismo.model.User;
import com.turismo.repository.DepartRepository;
import com.turismo.repository.ReservaRepository;
import com.turismo.repository.ServicioRepository;
import com.turismo.repository.UserRepository;

@RestController
public class ReservaController {
	private Reserva reserva;
	
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private ServicioRepository servicioRepository;
    @Autowired
    private DepartRepository departRepository;
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/reserva")
    public List<Reserva> listarReserva(){
        return reservaRepository.findAll();
    }
    
    @GetMapping("/reserva/{id}")
	public Optional<Reserva> listarById
	(@PathVariable("id") Long id) {
		return reservaRepository.findById(id);
	}
    
    @DeleteMapping("/reserva/{id}")
	public void eliminarReserva(@PathVariable("id") Long id) {
    	reservaRepository.deleteById(id);
	}
    
    @RequestMapping("/count/reserva")
    private Long getNumberOfReserva(){
        return reservaRepository.count();
    }
    
	@PutMapping("/reserva")
	public void reservaUser(@RequestBody Reserva re) {
		reservaRepository.save(re);
	}
    
    //------------------------------------------------
    //            CRUD RESERVA - SERVICIO
    //------------------------------------------------
    @GetMapping("/servicio/{servicioId}/reserva")
    public Page<Reserva> getAllReservaByservicioId
    (@PathVariable (value = "servicioId") 
    Long servicioId, Pageable pageable) {
        return reservaRepository.findByServicioId
        (servicioId, pageable);
    }
    
    @PostMapping("servicio/{servicioId}/depart/{departId}/user/{userId}/reserva")
    public Reserva createReserva
    (@PathVariable (value = "servicioId") Long servicioId,
    @PathVariable (value = "departId") Long departId,
    @PathVariable (value = "userId") Long userId,
    @Valid @RequestBody Reserva reserva) {
        this.reserva = reserva;
        
        servicioRepository.findById(servicioId).map(servicio -> {
            this.reserva.setServicio(servicio);
            return this.reserva;
        }).orElseThrow(() -> new ResourceNotFoundException("servicio "+"id"+servicioId));
        
        departRepository.findById(departId).map(depart -> {
            this.reserva.setDepart(depart);
            return this.reserva;
        }).orElseThrow(() -> new ResourceNotFoundException("depart "+"id"+departId));
       
		userRepository.findById(userId).map(user -> {
            this.reserva.setUser(user);
            return this.reserva;
        }).orElseThrow(() -> new ResourceNotFoundException("uSUARIO "+"id"+userId));
        
        return reservaRepository.save(reserva);
    }
    
    
    /*
    @PutMapping("/servicio/{servicioId}/depart/{departId}/reserva/{id}")
    public Reserva updateReserva(@PathVariable (value = "servicioId") Long servicioId,
                                 @PathVariable (value = "id") Long id,
                                 @PathVariable (value = "departId") Long departId,
                                 @Valid @RequestBody Reserva ReservaRequest) {
        if(!servicioRepository.existsById(servicioId)) {
            throw new ResourceNotFoundException("servicioId " + servicioId + " not found");
        }
        if(!departRepository.existsById(departId)) {
            throw new ResourceNotFoundException("departId " + departId + " not found");
        }
        return reservaRepository.findById(id).map(Reserva -> {
            Reserva.setPrecio(ReservaRequest.getPrecio());
            Reserva.setDescripcion(ReservaRequest.getDescripcion());
            Reserva.setLlegada(ReservaRequest.getLlegada());
            Reserva.setSalida(ReservaRequest.getSalida());
            Reserva.setPago(ReservaRequest.getPago());
            //Reserva.setDepart(ReservaRequest.getDepart());
            return reservaRepository.save(Reserva);
        }).orElseThrow(() -> new ResourceNotFoundException("ReservaId " + id + "not found"));
    }
    
    
    
    @DeleteMapping("/servicio/{servicioId}/reserva/{reservaId}") //ELIMINA REERVA
    public ResponseEntity<?> deleteReservaxServicio(
    @PathVariable (value = "servicioId") Long servicioId,
    @PathVariable (value = "reservaId") Long reservaId) {
        return reservaRepository.findByIdAndServicioId
        (reservaId, servicioId).map(reserva -> {
            reservaRepository.delete(reserva);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> 
        new ResourceNotFoundException
        ("Reserva not found with id " + reservaId + " and servicioId " + servicioId));
    }*/
    
    //------------------------------------------------
    //            CRUD RESERVA - DEPARTAMENTO
    //------------------------------------------------
    
    @GetMapping("/depart/{departId}/reserva")
    public Page<Reserva> getAllReservaBydepartId
    (@PathVariable (value = "departId") 
    Long departId, Pageable pageable) {
        return reservaRepository.findByDepartId
        (departId, pageable);
    }
    
    /*
    @PostMapping("/depart/{departId}/reserva")
    public Reserva createReservaxDeart(@PathVariable 
    (value = "departId") Long departId,
    @Valid @RequestBody Reserva Reserva) {
        return departRepository.findById
                (departId).map(depart -> {Reserva.setDepart(depart);
            return reservaRepository.save(Reserva);
        }).orElseThrow(() 
        -> new ResourceNotFoundException
        ("departId " + departId + " not found"));
    }
    
    
    @PutMapping("/depart/{departId}/reserva/{reservaId}")
    public Reserva updateReservaxDepart
    (@PathVariable (value = "departId") Long departId,
    @PathVariable (value = "reservaId") Long ReservaId,
    @Valid @RequestBody Reserva ReservaRequest) {
        if(!reservaRepository.existsById(departId)) {
            throw new ResourceNotFoundException
            ("departId " + departId + " not found");
        }
        return reservaRepository.findById(ReservaId).map(Reserva -> {
            Reserva.setPrecio(ReservaRequest.getPrecio());
            Reserva.setDescripcion(ReservaRequest.getDescripcion());
            Reserva.setLlegada(ReservaRequest.getLlegada());
            Reserva.setSalida(ReservaRequest.getSalida());
            Reserva.setPago(ReservaRequest.getPago());
            return reservaRepository.save(Reserva);
        }).orElseThrow(() -> new ResourceNotFoundException
        ("ReservaId " + ReservaId + "not found"));
    }
    
    @DeleteMapping("/depart/{departId}/reserva/{reservaId}")
    public ResponseEntity<?> deleteReservaxDepart(@PathVariable (value = "departId") Long departId,
    @PathVariable (value = "reservaId") Long reservaId) {
        return reservaRepository.findByIdAndDepartId(reservaId, departId).map(reserva -> {
        	reservaRepository.delete(reserva);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Reserva not found with id " + reservaId + " and departId " + departId));
    }*/
}