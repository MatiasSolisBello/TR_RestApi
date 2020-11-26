package com.turismo.model;


import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Reserva")

public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @NotNull
	@Column
	private int precio;
	
    @NotNull
    @Column
	private String descripcion;
	
    @NotNull
    @Column
	private LocalDate llegada;
	
    @NotNull
    @Column
	private LocalDate salida;
	
    @NotNull
    @Column
	private String pago;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "servicio_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Servicio servicio;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "departamento_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Depart depart;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "usuario_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;
    
    //---------------------------------------
    //            GETTER AND SETTER
    //--------------------------------------- 
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public LocalDate getLlegada() {
        return llegada;
    }
    public void setLlegada(LocalDate llegada) {
        this.llegada = llegada;
    }
    public LocalDate getSalida() {
        return salida;
    }
    public void setSalida(LocalDate salida) {
        this.salida = salida;
    }
    public String getPago() {
        return pago;
    }
    public void setPago(String pago) {
        this.pago = pago;
    }
    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
	public Depart getDepart() {
		return depart;
	}
	public void setDepart(Depart depart) {
		this.depart = depart;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
}
