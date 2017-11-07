package com.orion.portafolio2017.entity;
// Generated 29-10-2017 16:52:28 by Hibernate Tools 5.0.6.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PermisoModel generated by hbm2java
 */
@Entity
@Table(name = "permiso")
public class Permiso implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id_permiso", unique = true, nullable = false, precision = 8, scale = 0)
	private int idPermiso;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estado_id_estado", nullable = false)
	private Estado estado;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "funcionario_rut_funcionario", nullable = false)
	private Funcionario funcionario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "motivo_id_motivo", nullable = false)
	private Motivo motivo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_id_tipo", nullable = false)
	private Tipo tipo;

	@Column(name = "resolucion_permiso", nullable = false)
	private String resolucionPermiso;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_solicitud", nullable = false, length = 7)
	private Date fechaSolicitud;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio", nullable = false, length = 7)
	private Date fechaInicio;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_termino", nullable = false, length = 7)
	private Date fechaTermino;

	public Permiso() {
	}

	public Permiso(int idPermiso, Estado estado, Funcionario funcionario, Motivo motivo, Tipo tipo,
			String resolucionPermiso, Date fechaSolicitud, Date fechaInicio, Date fechaTermino) {
		this.idPermiso = idPermiso;
		this.estado = estado;
		this.funcionario = funcionario;
		this.motivo = motivo;
		this.tipo = tipo;
		this.resolucionPermiso = resolucionPermiso;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
	}

	public int getIdPermiso() {
		return this.idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Motivo getMotivo() {
		return this.motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getResolucionPermiso() {
		return this.resolucionPermiso;
	}

	public void setResolucionPermiso(String resolucionPermiso) {
		this.resolucionPermiso = resolucionPermiso;
	}

	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTermino() {
		return this.fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

}
