package com.gestion.softax.contacto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.softax.contacto.model.TrabajarJuntos;

@Repository
public interface TrabajarJuntosRepositorio extends JpaRepository<TrabajarJuntos, Long>{

}
