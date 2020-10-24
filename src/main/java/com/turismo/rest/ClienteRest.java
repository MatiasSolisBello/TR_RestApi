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

import com.turismo.dao.ClienteDAO;
import com.turismo.model.Cliente;


@RestController
@RequestMapping("/cliente")
@CrossOrigin

public class ClienteRest {
	@Autowired
	private ClienteDAO clienteDao;

	@PostMapping("/guardar")
	public void guardarCliente(@RequestBody Cliente cli) {
		clienteDao.save(cli);
	}
	

	@GetMapping("/listar")
	public List<Cliente> listarCliente(){
		return clienteDao.findAll();
	}
	
	@GetMapping("/listar/{rut}")
	public Optional<Cliente> listarByRut(@PathVariable("rut") Integer rut){
		return clienteDao.findById(rut);
	}
	
	
	@DeleteMapping("/eliminar/{rut}")
	public void eliminarCliente(@PathVariable("rut") Integer rut) {
		clienteDao.deleteById(rut);
	}
	
	@PutMapping("/actualizar")
	public void actualizarCliente(@RequestBody Cliente cli) {
		clienteDao.save(cli);
	}
}
