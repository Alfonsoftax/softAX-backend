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
import com.gestion.softax.contacto.model.Contacto;
import com.gestion.softax.contacto.repositorio.ContactoRepositorio;

@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200/")
@CrossOrigin(origins = "http://softax.es/")
public class ContactoControlador {

	@Autowired
	private ContactoRepositorio repositorio;

	//este método lista todos los contactos
	@GetMapping("/contacto")
	public List<Contacto> listarTodosLosContactos() {
		return repositorio.findAll();
	}
	
	//Este método sirve para guardaar un contacto
	@PostMapping("/contacto")
	public Contacto guardarContacto(@RequestBody Contacto contacto) {
		return repositorio.save(contacto);
	}
	
	//Busca un contacto por ID
	@GetMapping("/contacto/{id}")
	public ResponseEntity<Contacto> obtenerEmpleadoPorId(@PathVariable Long id) {
		Contacto contacto = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el contacto con el id: " + id));
		return ResponseEntity.ok(contacto);
	}
	
	//Busca un contacto por ID
	@PutMapping("/contacto/{id}")
	public ResponseEntity<Contacto> actualizarContacto(@PathVariable Long id, @RequestBody Contacto detallesContacto) {
		Contacto contacto = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el contacto con el id: " + id));
		contacto.setNombre(detallesContacto.getNombre());
		contacto.setMensaje(detallesContacto.getMensaje());
		contacto.setEmail(detallesContacto.getEmail());
		Contacto contactoActualizado = repositorio.save(contacto);
		return ResponseEntity.ok(contactoActualizado);
	}
	
	//este metodo sirve para eliminar un contacto
	@DeleteMapping("/contacto/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarContacto(@PathVariable Long id){
		Contacto contacto = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el contacto con el ID : " + id));
		
		repositorio.delete(contacto);
		Map<String, Boolean> respuesta = new HashMap();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
	
}
