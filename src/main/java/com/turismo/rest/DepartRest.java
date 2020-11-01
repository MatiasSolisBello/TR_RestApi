package com.turismo.rest;

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

import com.turismo.dao.DepartDAO;
import com.turismo.model.Depart;

@RestController
@RequestMapping("/depart")
public class DepartRest {
	@Autowired
	private DepartDAO departDao;

	@PostMapping("/guardar")
	public void guardarDepart(@RequestBody Depart dep) {
		departDao.save(dep);
	}
	
	@GetMapping("/listar")
	public List<Depart> listarDepart(){
		return departDao.findAll();
	}
	
	
	@GetMapping("listar/{id_depart}")
	public Optional<Depart> listarById(@PathVariable("id_depart") Integer id_depart) {
		return departDao.findById(id_depart);
	}
	
	@DeleteMapping("/eliminar/{id_depart}")
	public void eliminarDepart(@PathVariable("id_depart") Integer id_depart) {
		departDao.deleteById(id_depart);
	}
	
	@PutMapping("/actualizar")
	public void actualizarDepart(@RequestBody Depart dep) {
		departDao.save(dep);
	}
}
