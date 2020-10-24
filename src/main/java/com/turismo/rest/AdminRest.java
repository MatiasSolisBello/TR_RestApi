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

import com.turismo.dao.AdminDAO;
import com.turismo.model.Admin;

@RestController
@RequestMapping("/admin")
public class AdminRest {
	@Autowired
	private AdminDAO adminDao;
	
	@PostMapping("/guardar")
	public void guardarAdmin(@RequestBody Admin admin) {
		adminDao.save(admin);
	}
	
	@GetMapping("/listar")
	public List<Admin> listarAdmin(){
		return adminDao.findAll();
	}
	
	@DeleteMapping("/eliminar/{rut}")
	public void eliminarAdmin(@PathVariable("rut") Integer rut) {
		adminDao.deleteById(rut);
	}
	
	@PutMapping("/actualizar")
	public void actualizarAdmin(@RequestBody Admin admin) {
		adminDao.save(admin);
	}
}
