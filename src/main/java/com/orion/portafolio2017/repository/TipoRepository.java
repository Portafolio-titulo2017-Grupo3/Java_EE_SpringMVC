package com.orion.portafolio2017.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orion.portafolio2017.entity.Tipo;

@Repository("tipoRepository")
public interface TipoRepository extends JpaRepository<Tipo, Serializable> {
	
	public abstract Tipo findByIdTipo(int id);

}
