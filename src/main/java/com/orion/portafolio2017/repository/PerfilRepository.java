package com.orion.portafolio2017.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orion.portafolio2017.entity.Perfil;


@Repository("perfilRepository")
public interface PerfilRepository extends JpaRepository<Perfil, Serializable>  {

}
