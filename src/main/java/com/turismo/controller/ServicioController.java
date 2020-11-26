package com.turismo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.model.Servicio;
import com.turismo.repository.ServicioRepository;

@RestController
@CrossOrigin
public class ServicioController {
	@Autowired
	private ServicioRepository servicioRepository;

	@PostMapping("/servicio")
	public void guardarServicio(@RequestBody Servicio ser) {
		servicioRepository.save(ser);
	}
	
	@GetMapping("/servicio")
	public List<Servicio> listarServicio(){
		return servicioRepository.findAll();
	}
	
	@GetMapping("/servicio/{id}")
	public Optional<Servicio> listarById(@PathVariable("id") Long id) {
		return servicioRepository.findById(id);
	}
	
	@DeleteMapping("/servicio/{id}")
	public void eliminarServicio(@PathVariable("id") Long id) {
		servicioRepository.deleteById(id);
	}
	
	@PutMapping("/servicio")
	public void actualizarServicio(@RequestBody Servicio ser) {
		servicioRepository.save(ser);
	}

}
