package com.orion.portafolio2017.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orion.portafolio2017.entity.Funcionario;

@Repository("funcionarioRepository")
public interface FuncionarioRepository extends JpaRepository<Funcionario, Serializable> {

	public abstract Funcionario findByRutFuncionario(String rut);
}
