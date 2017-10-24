package com.orion.portafolio2017.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = { "id_usuario", "perfil_id_perfil" }))
public class Usuario {

	@Id
	@Column(name="id_usuario", unique = true, nullable = false, length = 8)
	private int usuarioId;
	
	@Column(name = "nombre_usuario", nullable = false, length = 30)
	private String username;

	@Column(name = "clave_usuario", nullable = false, length = 255)
	private String password;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "perfil_id_perfil", nullable = false)
	private Perfil perfil;


	public Usuario() {
		
	}



	public Usuario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	

	public Usuario(int usuarioId, String username, String password, Perfil perfil) {
		super();
		this.usuarioId = usuarioId;
		this.username = username;
		this.password = password;
		this.perfil = perfil;
	}

	public Usuario(String username2, String password2, SimpleGrantedAuthority authorities) {
		// TODO Auto-generated constructor stub
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	
	
}
