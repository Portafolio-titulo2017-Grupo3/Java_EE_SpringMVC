package com.orion.portafolio2017.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "perfil", uniqueConstraints = @UniqueConstraint(columnNames = { "nombre_perfil", "id_perfil" }))
public class Perfil {

	@Id
	@GeneratedValue
	@Column(name = "id_perfil", unique = true, nullable = false)
	private int userRoleId;


	@OneToMany(fetch = FetchType.EAGER, mappedBy = "perfil")
	private Set<Usuario> usuario = new HashSet<Usuario>();

	@Column(name = "nombre_perfil", nullable = false, length = 45)
	private String role;

	@Column(name = "descripcion_perfil", nullable = false, length = 45)
	private String descripcion;

	public Perfil() {
		super();
	}

	public Perfil(int userRoleId, Set<Usuario> usuario, String role, String descripcion) {
		super();
		this.userRoleId = userRoleId;
		this.usuario = usuario;
		this.role = role;
		this.descripcion = descripcion;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Set<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

	
}
