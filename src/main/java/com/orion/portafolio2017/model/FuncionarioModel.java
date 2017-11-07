package com.orion.portafolio2017.model;

import java.util.HashSet;
import java.util.Set;

public class FuncionarioModel {

	private String rutFuncionario;
	private DepartamentoModel departamentoModel;
	private CargoModel cargoModel;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private long telefonoFunionario;
	private String sexoFunionario;
	private String correoFuncionario;
	private Set<PermisoModel> permisoModels = new HashSet<PermisoModel>();
	private Set<UsuarioModel> usuarioModels = new HashSet<UsuarioModel>();

	public FuncionarioModel() {
	}

	public FuncionarioModel(String rutFuncionario, DepartamentoModel departamentoModel, CargoModel cargoModel,
			String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			long telefonoFunionario, String sexoFunionario, String correoFuncionario) {
		this.rutFuncionario = rutFuncionario;
		this.departamentoModel = departamentoModel;
		this.cargoModel = cargoModel;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.telefonoFunionario = telefonoFunionario;
		this.sexoFunionario = sexoFunionario;
		this.correoFuncionario = correoFuncionario;
	}

	public FuncionarioModel(String rutFuncionario, DepartamentoModel departamentoModel, CargoModel cargoModel,
			String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			long telefonoFunionario, String sexoFunionario, String correoFuncionario, Set<PermisoModel> permisoModels,
			Set<UsuarioModel> usuarioModels) {
		super();
		this.rutFuncionario = rutFuncionario;
		this.departamentoModel = departamentoModel;
		this.cargoModel = cargoModel;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.telefonoFunionario = telefonoFunionario;
		this.sexoFunionario = sexoFunionario;
		this.correoFuncionario = correoFuncionario;
		this.permisoModels = permisoModels;
		this.usuarioModels = usuarioModels;
	}

	public String getRutFuncionario() {
		return this.rutFuncionario;
	}

	public void setRutFuncionario(String rutFuncionario) {
		this.rutFuncionario = rutFuncionario;
	}

	public DepartamentoModel getDepartamento() {
		return this.departamentoModel;
	}

	public void setDepartamento(DepartamentoModel departamentoModel) {
		this.departamentoModel = departamentoModel;
	}

	public CargoModel getCargo() {
		return this.cargoModel;
	}

	public void setCargo(CargoModel cargoModel) {
		this.cargoModel = cargoModel;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public long getTelefonoFunionario() {
		return this.telefonoFunionario;
	}

	public void setTelefonoFunionario(long telefonoFunionario) {
		this.telefonoFunionario = telefonoFunionario;
	}

	public String getSexoFunionario() {
		return this.sexoFunionario;
	}

	public void setSexoFunionario(String sexoFunionario) {
		this.sexoFunionario = sexoFunionario;
	}

	public String getCorreoFuncionario() {
		return this.correoFuncionario;
	}

	public void setCorreoFuncionario(String correoFuncionario) {
		this.correoFuncionario = correoFuncionario;
	}

	public Set<PermisoModel> getPermisos() {
		return permisoModels;
	}

	public void setPermisos(Set<PermisoModel> permisoModels) {
		this.permisoModels = permisoModels;
	}

	public Set<UsuarioModel> getUsuarios() {
		return usuarioModels;
	}

	public void setUsuarios(Set<UsuarioModel> usuarioModels) {
		this.usuarioModels = usuarioModels;
	}

}
