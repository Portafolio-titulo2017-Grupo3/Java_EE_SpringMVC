package com.orion.portafolio2017.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orion.portafolio2017.entity.Departamento;

@Repository("departamentoRepository")
public interface DepartamentoRepository extends JpaRepository<Departamento, Serializable> {

	public abstract Departamento findByIdDepto(int IdDepto);

}
