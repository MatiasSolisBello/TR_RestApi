package com.turismo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.model.Checkin;
import com.turismo.repository.CheckinRepository;

@RestController
@CrossOrigin
public class CheckinController {
	@Autowired
	private CheckinRepository checkinRepository;
	
	@GetMapping("/checkin")
	public List<Checkin> listarCheckin(){
		return checkinRepository.findAll();
	}
}
