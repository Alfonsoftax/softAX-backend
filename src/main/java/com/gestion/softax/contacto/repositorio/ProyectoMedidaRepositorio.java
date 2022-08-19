package com.gestion.softax.contacto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.softax.contacto.model.ProyectoMedida;

@Repository
public interface ProyectoMedidaRepositorio extends JpaRepository<ProyectoMedida, Long>{

}
