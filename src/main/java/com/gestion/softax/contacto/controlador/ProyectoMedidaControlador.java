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
import com.gestion.softax.contacto.model.ProyectoMedida;
import com.gestion.softax.contacto.repositorio.ProyectoMedidaRepositorio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProyectoMedidaControlador {

	@Autowired
	private ProyectoMedidaRepositorio repositorio;

	//este método lista todos los proyectos a medida
	@GetMapping("/proyecto-medida")
	public List<ProyectoMedida> listarTodosLosProyectosMedida() {
		return repositorio.findAll();
	}
	
	//Este método sirve para guardar un contacto
	@PostMapping("/proyecto-medida")
	public ProyectoMedida guardarProyectoMedida(@RequestBody ProyectoMedida proyectoMedida) {
		return repositorio.save(proyectoMedida);
	}
	
	//Busca un contacto por ID
	@GetMapping("/proyecto-medida/{id}")
	public ResponseEntity<ProyectoMedida> obtenerProyectoMedidaPorId(@PathVariable Long id) {
		ProyectoMedida proyectoMedida = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el proyecto a medida con el id: " + id));
		return ResponseEntity.ok(proyectoMedida);
	}
	
	//Busca un contacto por ID
	@PutMapping("/proyecto-medida/{id}")
	public ResponseEntity<ProyectoMedida> actualizarProyectoMedida(@PathVariable Long id, @RequestBody ProyectoMedida detallesProyectoMedida) {
		ProyectoMedida proyectoMedida = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el contacto con el id: " + id));
		proyectoMedida.setNombre(detallesProyectoMedida.getNombre());
		proyectoMedida.setMensaje(detallesProyectoMedida.getMensaje());
		proyectoMedida.setEmail(detallesProyectoMedida.getEmail());
		proyectoMedida.setPlataformaProyecto(detallesProyectoMedida.getPlataformaProyecto());
		proyectoMedida.setTipoProyecto(detallesProyectoMedida.getTipoProyecto());
		ProyectoMedida proyectoMedidaActualizado = repositorio.save(proyectoMedida);
		return ResponseEntity.ok(proyectoMedidaActualizado);
	}
	
	//este metodo sirve para eliminar un proyecto a medida
	@DeleteMapping("/proyecto-medida/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarProyectoMedida(@PathVariable Long id){
		ProyectoMedida proyectoMedida = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el proyecto a medida con el ID : " + id));		
		repositorio.delete(proyectoMedida);
		Map<String, Boolean> respuesta = new HashMap();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
	
}
