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

import com.turismo.model.User;
import com.turismo.repository.UserRepository;

@RestController
@CrossOrigin

public class UserController {
	@Autowired
	private UserRepository userRepository;
	
   @RequestMapping("/count/users")
   private Long getNumberOfUsers(){
	   return userRepository.count();
   }

	@PostMapping("/user")
	public void guardarUser(@RequestBody User user) {
		userRepository.save(user);
	}
	

	@GetMapping("/user")
	public List<User> listarUser(){
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> listarByid(@PathVariable("id") Long id){
		return userRepository.findById(id);
	}
	
	
	@DeleteMapping("/user/{id}")
	public void eliminarUser(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
	}
	
	@PutMapping("/user")
	public void actualizarUser(@RequestBody User user) {
		userRepository.save(user);
	}
}
