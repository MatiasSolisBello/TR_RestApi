package com.turismo.rest;

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

import com.turismo.dao.ServicioDAO;
import com.turismo.model.Servicio;

@RestController
@CrossOrigin
@RequestMapping("/servicio")
public class ServicioRest {
	@Autowired
	private ServicioDAO servicioDao;

	@PostMapping("/guardar")
	public void guardarServicio(@RequestBody Servicio ser) {
		servicioDao.save(ser);
	}
	
	@GetMapping("/listar")
	public List<Servicio> listarServicio(){
		return servicioDao.findAll();
	}
	
	@GetMapping("/listar/{id_servicio}")
	public Optional<Servicio> listarById(@PathVariable("id_servicio") Integer id_servicio) {
		return servicioDao.findById(id_servicio);
	}
	
	@DeleteMapping("/eliminar/{id_servicio}")
	public void eliminarServicio(@PathVariable("id_servicio") Integer id_servicio) {
		servicioDao.deleteById(id_servicio);
	}
	
	@PutMapping("/actualizar")
	public void actualizarServicio(@RequestBody Servicio ser) {
		servicioDao.save(ser);
	}

}
