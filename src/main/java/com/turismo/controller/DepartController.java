package com.turismo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.model.Depart;
import com.turismo.repository.DepartRepository;

@RestController
public class DepartController {
	@Autowired
	private DepartRepository departRepository;

	@PostMapping("/depart")
	public void guardarDepart(@RequestBody Depart dep) {
		departRepository.save(dep);
	}
	
	@GetMapping("/depart")
	public List<Depart> listarDepart(){
		return departRepository.findAll();
	}
		
	@GetMapping("depart/{id}")
	public Optional<Depart> listarById(@PathVariable("id") Long id) {
		return departRepository.findById(id);
	}
	
	@DeleteMapping("/depart/{id}")
	public void eliminarDepart(@PathVariable("id") Long id) {
		departRepository.deleteById(id);
	}
	
	@PutMapping("/depart")
	public void actualizarDepart(@RequestBody Depart dep) {
		departRepository.save(dep);
	}
}
