package com.orion.portafolio2017.model;

import java.util.Date;

public class PermisoModel {

	private int idPermiso;
	private String resolucionPermiso;
	private Date fechaSolicitud;
	private Date fechaInicio;
	private Date fechaTermino;
	
	private int idEstado;
	private String nombreEstado;
	
	private String rutFuncionario;
	
	private int idMotivo;
	private String descripcionMotivo;

	private int idTipo;
	private String nombreTipo;
	private String descripcionTipo;

	public PermisoModel() {
	}

	public PermisoModel(int idPermiso, String resolucionPermiso, Date fechaSolicitud, Date fechaInicio,
			Date fechaTermino, int idEstado, String nombreEstado, String rutFuncionario, int idMotivo,
			String descripcionMotivo, int idTipo, String nombreTipo, String descripcionTipo) {
		super();
		this.idPermiso = idPermiso;
		this.resolucionPermiso = resolucionPermiso;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
		this.idEstado = idEstado;
		this.nombreEstado = nombreEstado;
		this.rutFuncionario = rutFuncionario;
		this.idMotivo = idMotivo;
		this.descripcionMotivo = descripcionMotivo;
		this.idTipo = idTipo;
		this.nombreTipo = nombreTipo;
		this.descripcionTipo = descripcionTipo;
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

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
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

	public int getIdMotivo() {
		return idMotivo;
	}

	public void setIdMotivo(int idMotivo) {
		this.idMotivo = idMotivo;
	}

	public String getDescripcionMotivo() {
		return descripcionMotivo;
	}

	public void setDescripcionMotivo(String descripcionMotivo) {
		this.descripcionMotivo = descripcionMotivo;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
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

	@Override
	public String toString() {
		return "PermisoModel [idPermiso=" + idPermiso + ", resolucionPermiso=" + resolucionPermiso + ", fechaSolicitud="
				+ fechaSolicitud + ", fechaInicio=" + fechaInicio + ", fechaTermino=" + fechaTermino + ", idEstado="
				+ idEstado + ", nombreEstado=" + nombreEstado + ", rutFuncionario=" + rutFuncionario + ", idMotivo="
				+ idMotivo + ", descripcionMotivo=" + descripcionMotivo + ", idTipo=" + idTipo + ", nombreTipo="
				+ nombreTipo + ", descripcionTipo=" + descripcionTipo + "]";
	}

}
