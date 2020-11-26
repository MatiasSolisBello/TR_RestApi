package com.turismo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Usuario")
public class User {
	@Id
	private Long id;
	
    @NotNull
    @Size(max = 100)
    @Column
	private String username;
	
    @NotNull
    @Size(max = 100)
    @Column
	private String email;
	
    @NotNull
    @Column
	private int telefono;
	
    @NotNull
    @Size(max = 100)
    @Column
	private String password;
    
    //---------------------------------------
    //            GETTER AND SETTER
    //---------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
