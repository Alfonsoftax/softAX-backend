package com.gestion.softax.contacto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACTO")
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre",length = 60, nullable = false)
	private String nombre;
	
	@Column(name = "mensaje",length = 500, nullable = false)
	private String mensaje;
	
	@Column(name = "email",length = 60, nullable = false, unique = false)
	private String email;
	
	public Contacto() {
		
	}
	

	public Contacto(Long id, String nombre, String mensaje, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.mensaje = mensaje;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
