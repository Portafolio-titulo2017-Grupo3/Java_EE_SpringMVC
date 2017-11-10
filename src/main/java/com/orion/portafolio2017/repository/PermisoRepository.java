package com.orion.portafolio2017.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.orion.portafolio2017.entity.Permiso;

@Repository("permisoRepository")
public interface PermisoRepository extends JpaRepository<Permiso, Serializable> {

	//public abstract Permiso findByFuncionario(String rut);
	
	public abstract Permiso findByIdPermiso(int id);
	
	//public abstract List<Permiso> findAllById(String rut);
	
	
}
