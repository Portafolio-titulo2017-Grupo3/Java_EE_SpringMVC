package com.orion.portafolio2017.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orion.portafolio2017.entity.Usuario;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<Usuario, Serializable> {

	public abstract Usuario findByUsername(String username);
	
	
}
