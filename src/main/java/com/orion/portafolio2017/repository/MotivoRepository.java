package com.orion.portafolio2017.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orion.portafolio2017.entity.Motivo;

@Repository("motivoRepository")
public interface MotivoRepository extends JpaRepository<Motivo, Serializable> {

	public abstract Motivo findByIdMotivo(int id);
}
