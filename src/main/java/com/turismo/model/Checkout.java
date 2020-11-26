package com.turismo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Checkout")
public class Checkout {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
    @Size(max = 100)
    @Column
	private String estado;
	
	@NotNull
    @Column
	private int multa;
	
	@NotNull
    @Size(max = 100)
    @Column
	private String problemas;
	
	//FALTA RESERVA ONE TO ONE
	
}
