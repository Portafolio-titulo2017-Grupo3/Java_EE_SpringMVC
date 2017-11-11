package com.orion.portafolio2017.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orion.portafolio2017.entity.Estado;

@Repository("estadoRepository")
public interface EstadoRepository extends JpaRepository<Estado, Serializable> {
	
	public abstract Estado findByIdEstado(int id);

}
