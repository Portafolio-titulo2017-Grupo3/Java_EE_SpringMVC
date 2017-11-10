package modelBackup;

import java.util.Date;

public class PermisoModel {

	private int idPermiso;
	private EstadoModel estadoModel;
	private FuncionarioModel funcionarioModel;
	private MotivoModel motivoModel;
	private TipoModel tipoModel;
	private String resolucionPermiso;
	private Date fechaSolicitud;
	private Date fechaInicio;
	private Date fechaTermino;

	public PermisoModel() {
	}

	public PermisoModel(int idPermiso, EstadoModel estadoModel, FuncionarioModel funcionarioModel,
			MotivoModel motivoModel, TipoModel tipoModel, String resolucionPermiso, Date fechaSolicitud,
			Date fechaInicio, Date fechaTermino) {
		this.idPermiso = idPermiso;
		this.estadoModel = estadoModel;
		this.funcionarioModel = funcionarioModel;
		this.motivoModel = motivoModel;
		this.tipoModel = tipoModel;
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

	public EstadoModel getEstado() {
		return this.estadoModel;
	}

	public void setEstado(EstadoModel estadoModel) {
		this.estadoModel = estadoModel;
	}

	public FuncionarioModel getFuncionario() {
		return this.funcionarioModel;
	}

	public void setFuncionario(FuncionarioModel funcionarioModel) {
		this.funcionarioModel = funcionarioModel;
	}

	public MotivoModel getMotivo() {
		return this.motivoModel;
	}

	public void setMotivo(MotivoModel motivoModel) {
		this.motivoModel = motivoModel;
	}

	public TipoModel getTipo() {
		return this.tipoModel;
	}

	public void setTipo(TipoModel tipoModel) {
		this.tipoModel = tipoModel;
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
