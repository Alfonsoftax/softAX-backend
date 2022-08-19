package com.gestion.softax.contacto.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.softax.contacto.excepciones.ResourceNotFoundException;
import com.gestion.softax.contacto.model.TrabajarJuntos;
import com.gestion.softax.contacto.repositorio.TrabajarJuntosRepositorio;

@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200/")
@CrossOrigin(origins = "http://softax.es/")
public class TrabajarJuntosControlador {

	@Autowired
	private TrabajarJuntosRepositorio repositorio;

	//este método lista todos los trabajoJuntos a medida
	@GetMapping("/trabajar-juntos")
	public List<TrabajarJuntos> listarTodosLosTrabajosJuntos() {
		return repositorio.findAll();
	}
	
	//Este método sirve para guardar un contacto
	@PostMapping("/trabajar-juntos")
	public TrabajarJuntos guardarTrabajarJuntos(@RequestBody TrabajarJuntos trabajoJunto) {
		return repositorio.save(trabajoJunto);
	}
	
	//Busca un contacto por ID
	@GetMapping("/trabajar-juntos/{id}")
	public ResponseEntity<TrabajarJuntos> obtenerTrabajarJuntosPorId(@PathVariable Long id) {
		TrabajarJuntos trabajoJunto = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el trabajoJunto a medida con el id: " + id));
		return ResponseEntity.ok(trabajoJunto);
	}
	
	//Busca un contacto por ID
	@PutMapping("/trabajar-juntos/{id}")
	public ResponseEntity<TrabajarJuntos> actualizarTrabajarJuntos(@PathVariable Long id, @RequestBody TrabajarJuntos detallesTrabajarJuntos) {
		TrabajarJuntos trabajoJunto = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el contacto con el id: " + id));
		trabajoJunto.setNombre(detallesTrabajarJuntos.getNombre());
		trabajoJunto.setMensaje(detallesTrabajarJuntos.getMensaje());
		trabajoJunto.setEmail(detallesTrabajarJuntos.getEmail());
		trabajoJunto.setPresupuesto(detallesTrabajarJuntos.getPresupuesto());
		trabajoJunto.setTipoProyecto(detallesTrabajarJuntos.getTipoProyecto());
		TrabajarJuntos trabajoJuntoActualizado = repositorio.save(trabajoJunto);
		return ResponseEntity.ok(trabajoJuntoActualizado);
	}
	
	
	//este metodo sirve para eliminar un trabajoJunto a medida
	@DeleteMapping("/trabajar-juntos/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarTrabajarJuntos(@PathVariable Long id){
		TrabajarJuntos trabajoJunto = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el trabajoJunto a medida con el ID : " + id));		
		repositorio.delete(trabajoJunto);
		Map<String, Boolean> respuesta = new HashMap();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
	
}
