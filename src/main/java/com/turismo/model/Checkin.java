package com.turismo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Checkin")
public class Checkin  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
    @Size(max = 100)
    @Column
	private String condiciones;
	
	//FALTA RESERVA ONE TO ONE
}
