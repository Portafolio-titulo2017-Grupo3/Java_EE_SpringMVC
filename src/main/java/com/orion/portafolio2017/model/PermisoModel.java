package com.orion.portafolio2017.model;

import java.util.Date;

public class PermisoModel {

	private int idPermiso;
	private String resolucionPermiso;
	private Date fechaSolicitud;
	private Date fechaInicio;
	private Date fechaTermino;
	
	private int estado;
	private String nombreEstado;
	
	private String rutFuncionario;
	
	private int motivo;
	private String descripcionMotivo;

	private int tipo;
	private String nombreTipo;
	private String descripcionTipo;
	
	private String nombreDepartamento;
	private String diaI,mesI,anioI;
	private String diaF,mesF,anioF;

	public PermisoModel() {
	}

	public PermisoModel(int idPermiso, String resolucionPermiso, Date fechaSolicitud, Date fechaInicio,
			Date fechaTermino, int estado, String nombreEstado, String rutFuncionario, int motivo,
			String descripcionMotivo, int tipo, String nombreTipo, String descripcionTipo, String nombreDepartamento,
			String diaI, String mesI, String anioI, String diaF, String mesF, String anioF) {
		super();
		this.idPermiso = idPermiso;
		this.resolucionPermiso = resolucionPermiso;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
		this.estado = estado;
		this.nombreEstado = nombreEstado;
		this.rutFuncionario = rutFuncionario;
		this.motivo = motivo;
		this.descripcionMotivo = descripcionMotivo;
		this.tipo = tipo;
		this.nombreTipo = nombreTipo;
		this.descripcionTipo = descripcionTipo;
		this.nombreDepartamento = nombreDepartamento;
		this.diaI = diaI;
		this.mesI = mesI;
		this.anioI = anioI;
		this.diaF = diaF;
		this.mesF = mesF;
		this.anioF = anioF;
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getResolucionPermiso() {
		return resolucionPermiso;
	}

	public void setResolucionPermiso(String resolucionPermiso) {
		this.resolucionPermiso = resolucionPermiso;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public String getRutFuncionario() {
		return rutFuncionario;
	}

	public void setRutFuncionario(String rutFuncionario) {
		this.rutFuncionario = rutFuncionario;
	}

	public int getMotivo() {
		return motivo;
	}

	public void setMotivo(int motivo) {
		this.motivo = motivo;
	}

	public String getDescripcionMotivo() {
		return descripcionMotivo;
	}

	public void setDescripcionMotivo(String descripcionMotivo) {
		this.descripcionMotivo = descripcionMotivo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	public String getDescripcionTipo() {
		return descripcionTipo;
	}

	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public String getDiaI() {
		return diaI;
	}

	public void setDiaI(String diaI) {
		this.diaI = diaI;
	}

	public String getMesI() {
		return mesI;
	}

	public void setMesI(String mesI) {
		this.mesI = mesI;
	}

	public String getAnioI() {
		return anioI;
	}

	public void setAnioI(String anioI) {
		this.anioI = anioI;
	}

	public String getDiaF() {
		return diaF;
	}

	public void setDiaF(String diaF) {
		this.diaF = diaF;
	}

	public String getMesF() {
		return mesF;
	}

	public void setMesF(String mesF) {
		this.mesF = mesF;
	}

	public String getAnioF() {
		return anioF;
	}

	public void setAnioF(String anioF) {
		this.anioF = anioF;
	}

	@Override
	public String toString() {
		return "PermisoModel [idPermiso=" + idPermiso + ", resolucionPermiso=" + resolucionPermiso + ", fechaSolicitud="
				+ fechaSolicitud + ", fechaInicio=" + fechaInicio + ", fechaTermino=" + fechaTermino + ", estado="
				+ estado + ", nombreEstado=" + nombreEstado + ", rutFuncionario=" + rutFuncionario + ", motivo="
				+ motivo + ", descripcionMotivo=" + descripcionMotivo + ", tipo=" + tipo + ", nombreTipo=" + nombreTipo
				+ ", descripcionTipo=" + descripcionTipo + ", nombreDepartamento=" + nombreDepartamento + ", diaI="
				+ diaI + ", mesI=" + mesI + ", anioI=" + anioI + ", diaF=" + diaF + ", mesF=" + mesF + ", anioF="
				+ anioF + "]";
	}

	

	


	

	

	

}
