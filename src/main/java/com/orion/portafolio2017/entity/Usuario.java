package com.orion.portafolio2017.entity;
// Generated 29-10-2017 16:52:28 by Hibernate Tools 5.0.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * UsuarioModel generated by hbm2java
 */
@Entity
@Table(name = "usuario")
public class Usuario implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id_usuario", unique = true, nullable = false, precision = 8, scale = 0)
	private int idUsuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "funcionario_rut_funcionario", nullable = false)
	private Funcionario funcionario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "perfil_id_perfil", nullable = false)
	private Perfil perfil;

	@Column(name = "nombre_usuario", nullable = false, length = 30)
	private String username;

	@Column(name = "clave_usuario", nullable = false)
	private String password;

	public Usuario() {
	}

	public Usuario(int idUsuario, Funcionario funcionario, Perfil perfil, String nombreUsuario, String claveUsuario) {
		this.idUsuario = idUsuario;
		this.funcionario = funcionario;
		this.perfil = perfil;
		this.username = nombreUsuario;
		this.password = claveUsuario;
	}

	public Usuario(String username2, String password2, SimpleGrantedAuthority authorities) {
		// TODO Auto-generated constructor stub
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String nombreUsuario) {
		this.username = nombreUsuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String claveUsuario) {
		this.password = claveUsuario;
	}

}
