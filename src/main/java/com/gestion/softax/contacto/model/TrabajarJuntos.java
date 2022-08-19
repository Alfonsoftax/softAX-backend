package com.gestion.softax.contacto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRABAJAR_JUNTOS")
public class TrabajarJuntos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NOMBRE",length = 60, nullable = false)
	private String nombre;
	
	@Column(name = "MENSAJE",length = 500, nullable = false)
	private String mensaje;
	
	@Column(name = "EMAIL",length = 60, nullable = false, unique = false)
	private String email;
	
	@Column(name = "TIPO_PROYECTO",length = 60, nullable = false, unique = false)
	private String tipoProyecto;
	
	@Column(name = "PRESUPUESTO",length = 20, nullable = false, unique = false)
	private String presupuesto;
	
	
	public String getPresupuesto() {
		return presupuesto;
	}


	public void setPresupuesto(String presupuesto) {
		this.presupuesto = presupuesto;
	}


	public String getTipoProyecto() {
		return tipoProyecto;
	}


	public void setTipoProyecto(String tipoProyecto) {
		this.tipoProyecto = tipoProyecto;
	}


	public TrabajarJuntos() {
		
	}
	

	public TrabajarJuntos(Long id, String nombre, String mensaje, String email) {
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
