package com.orion.portafolio2017.model;

public class FuncionarioInfoModel {


	private String rutFuncionario;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private long telefonoFunionario;
	private String sexoFunionario;
	private String correoFuncionario;
	
	private int idCargo;
	private String nombreCargo;
	private long salario;
	
	private int idDepto;
	private String nombreDepto;
	
	public FuncionarioInfoModel() {
		super();
	}

	public FuncionarioInfoModel(String rutFuncionario, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, long telefonoFunionario, String sexoFunionario, String correoFuncionario,
			int idCargo, String nombreCargo, long salario, int idDepto, String nombreDepto) {
		super();
		this.rutFuncionario = rutFuncionario;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.telefonoFunionario = telefonoFunionario;
		this.sexoFunionario = sexoFunionario;
		this.correoFuncionario = correoFuncionario;
		this.idCargo = idCargo;
		this.nombreCargo = nombreCargo;
		this.salario = salario;
		this.idDepto = idDepto;
		this.nombreDepto = nombreDepto;
	}

	public String getRutFuncionario() {
		return rutFuncionario;
	}

	public void setRutFuncionario(String rutFuncionario) {
		this.rutFuncionario = rutFuncionario;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public long getTelefonoFunionario() {
		return telefonoFunionario;
	}

	public void setTelefonoFunionario(long telefonoFunionario) {
		this.telefonoFunionario = telefonoFunionario;
	}

	public String getSexoFunionario() {
		return sexoFunionario;
	}

	public void setSexoFunionario(String sexoFunionario) {
		this.sexoFunionario = sexoFunionario;
	}

	public String getCorreoFuncionario() {
		return correoFuncionario;
	}

	public void setCorreoFuncionario(String correoFuncionario) {
		this.correoFuncionario = correoFuncionario;
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getNombreCargo() {
		return nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}

	public long getSalario() {
		return salario;
	}

	public void setSalario(long salario) {
		this.salario = salario;
	}

	public int getIdDepto() {
		return idDepto;
	}

	public void setIdDepto(int idDepto) {
		this.idDepto = idDepto;
	}

	public String getNombreDepto() {
		return nombreDepto;
	}

	public void setNombreDepto(String nombreDepto) {
		this.nombreDepto = nombreDepto;
	}
	
	@Override
	public String toString() {
		return "FuncionarioInfoModel [rutFuncionario=" + rutFuncionario + ", primerNombre=" + primerNombre
				+ ", segundoNombre=" + segundoNombre + ", primerApellido=" + primerApellido + ", segundoApellido="
				+ segundoApellido + ", telefonoFunionario=" + telefonoFunionario + ", sexoFunionario=" + sexoFunionario
				+ ", correoFuncionario=" + correoFuncionario + ", idCargo=" + idCargo + ", nombreCargo=" + nombreCargo
				+ ", salario=" + salario + ", idDepto=" + idDepto + ", nombreDepto=" + nombreDepto + "]";
	}
	
}
