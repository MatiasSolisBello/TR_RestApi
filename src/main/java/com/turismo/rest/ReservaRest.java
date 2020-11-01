package com.turismo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.dao.ClienteDAO;
import com.turismo.dao.DepartDAO;
import com.turismo.dao.ReservaDAO;
import com.turismo.dao.ServicioDAO;
import com.turismo.model.Cliente;
import com.turismo.model.Reserva;

@RestController
@RequestMapping("/reserva")
public class ReservaRest {
	
	@Autowired
	private ReservaDAO reservaDao;
	
	/*
	@Autowired
	private ServicioDAO servicioDao;
	@Autowired
	private DepartDAO departDao;
	@Autowired
	private ClienteDAO clienteDao;
	*/
	
	// POST - GUARDAR RESERVA
	@PostMapping("/guardar")
	public void guardarReserva(@RequestBody Reserva res) {
		reservaDao.save(res);
	}
	
	//GET - LISTA DE RESERVA + FOREINGS KEYS 
	@GetMapping("/listar")
	public List<Reserva> listarReserva(){
		return reservaDao.findAll();
	}
	
	
	//GET - LISTA DE RESERVAS X ID
	@GetMapping("/listar/{id_reserva}")
	public Optional<Reserva> listarById(@PathVariable("id_reserva") Integer id_reserva){
		return reservaDao.findById(id_reserva);
	}
	
	
	
	//GET - OBTENER RESERVA X ID DE SERVICIO
	/*
	@GetMapping("/servicio/{id_servicio}/")
	public List<Reserva>listarServicioByReserva(@PathVariable Integer servicio_id_servicio){
		return reservaDao.findByServicioServicioIdServicio(servicio_id_servicio);
	}
	*/
	
	@DeleteMapping("/eliminar/{id_reserva}")
	public void eliminarReserva(@PathVariable("id_reserva") Integer id_reserva) {
		reservaDao.deleteById(id_reserva);
	}
	
	@PutMapping("actualizar")
	public void actualizarReserva(@RequestBody Reserva res) {
		reservaDao.save(res);
	}
}
