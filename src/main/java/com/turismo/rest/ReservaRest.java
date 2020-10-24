package com.turismo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.dao.ReservaDAO;
import com.turismo.model.Reserva;

@RestController
@RequestMapping("/reserva")
public class ReservaRest {
	@Autowired
	private ReservaDAO reservaDao;

	@PostMapping("/guardar")
	public void guardarReserva(@RequestBody Reserva res) {
		reservaDao.save(res);
	}
	
	@GetMapping("/listar")
	public List<Reserva> listarReserva(){
		return reservaDao.findAll();
	}
	
	@DeleteMapping("/eliminar/{id_reserva}")
	public void eliminarReserva(@PathVariable("id_reserva") Integer id_reserva) {
		reservaDao.deleteById(id_reserva);
	}
	
	@PutMapping("actualizar")
	public void actualizarReserva(@RequestBody Reserva res) {
		reservaDao.save(res);
	}
}
