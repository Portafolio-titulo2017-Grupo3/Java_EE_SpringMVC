package com.orion.portafolio2017.controller;


import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.DocumentException;
import com.orion.portafolio2017.component.Fechas;
import com.orion.portafolio2017.component.GenerarPDF;
import com.orion.portafolio2017.component.HttpJsonRequestLibreria;
import com.orion.portafolio2017.constant.ViewConstant;
import com.orion.portafolio2017.model.FuncionarioInfoModel;
import com.orion.portafolio2017.model.PermisoModel;
import com.orion.portafolio2017.service.DepartamentoService;
import com.orion.portafolio2017.service.EstadoService;
import com.orion.portafolio2017.service.FuncionarioService;
import com.orion.portafolio2017.service.MotivoService;
import com.orion.portafolio2017.service.PermisoService;
import com.orion.portafolio2017.service.TipoService;
import com.orion.portafolio2017.service.impl.UserService;



@Controller
@RequestMapping("/permisos")
public class PermisoController {
	
	private static final Log LOG = LogFactory.getLog(PermisoController.class);
	
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("estadoService")
	private EstadoService estadoService;
	
	@Autowired
	@Qualifier("motivoService")
	private MotivoService motivoService;
	
	@Autowired
	@Qualifier("tipoService")
	private TipoService tipoService;
	
	@Autowired
	@Qualifier("permisoService")
	private PermisoService permisoService;
	
	@Autowired
	@Qualifier("funcionarioService")
	private FuncionarioService funcionarioService;
	
	@Autowired
	@Qualifier("departamentoService")
	private DepartamentoService departamentoService;
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/menu/micuenta";
	}
	
	Fechas fecha = new Fechas();
	
	
	//Se agrega este metodo que trabaja sin Model (NO DEBERIA IR)
	@PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ALCALDE', 'JEFE INTERNO', 'JEFE SUPERIOR', 'FUNCIONARIO')")
	@GetMapping("/permisoform")
	public String redirectPermisoForm(@RequestParam(name="diass", required=false) String diass,
									  @RequestParam(name="error", required=false) String error,
									  @RequestParam(name="idPermiso", required=false) String idPermiso,
									  Model model) {
		PermisoModel permiso = new PermisoModel();
		String constante=null;
		
		LOG.info("METHOD: redirectPermisoForm() -- PARAMS IN: " + permiso.toString());
		
		if(Integer.parseInt(idPermiso) != 0) {
			permiso = permisoService.findPermisoModelById(Integer.parseInt(idPermiso));
		}
		LOG.info("METHOD: redirectPermisoForm() -- PARAMS OUT: " + permiso.toString());
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String perfil = userService.obtenerPerfilByUsuario(user.getUsername());
		FuncionarioInfoModel funcionarioModel = userService.obtenerFuncionarioByUsuario(user.getUsername());
		
		
		switch (perfil) {
        case "SUPER_ADMIN":  constante = ViewConstant.CREAR_PERMISO_SU;
                 break;
        case "ALCALDE":  constante = ViewConstant.CREAR_PERMISO_A;
                 break;
        case "JEFE INTERNO":  constante = ViewConstant.CREAR_PERMISO_JI;
                 break;
        case "JEFE SUPERIOR":  constante = ViewConstant.CREAR_PERMISO_JS;
                 break;
        case "FUNCIONARIO":  constante = ViewConstant.CREAR_PERMISO_F;
                 break;
        default: perfil = "PERFIL INVALIDO";
                 break;
		}
		
		
		model.addAttribute("hora", fecha.horaActual());
		model.addAttribute("fecha", fecha.fechaActual());
		
		model.addAttribute("perfil",perfil);
		model.addAttribute("username",user.getUsername());
		model.addAttribute("rutFuncionario", funcionarioModel.getRutFuncionario());
		model.addAttribute("nombres", funcionarioModel.getPrimerNombre()+" "+funcionarioModel.getSegundoNombre());
		model.addAttribute("apellidos", funcionarioModel.getPrimerApellido()+" "+funcionarioModel.getSegundoApellido());
		model.addAttribute("departamento", funcionarioModel.getNombreDepto());
		model.addAttribute("email", funcionarioModel.getCorreoFuncionario());
		model.addAttribute("telefono", funcionarioModel.getTelefonoFunionario());
		model.addAttribute("funcionario", userService.obtenerFuncionario(user.getUsername()));
		
		model.addAttribute("error", error);
		model.addAttribute("dias", diass);
		
		model.addAttribute("permiso", permiso);
		model.addAttribute("estado", estadoService.findAllEstadoModel());
		model.addAttribute("motivo", motivoService.findAllMotivoModel());
		model.addAttribute("tipo", tipoService.findAllTipoModel());
		return constante;
	}
	
	
	//VISUALIZAR PERMISOS DEL USUARIO
	@PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ALCALDE', 'JEFE INTERNO', 'JEFE SUPERIOR', 'FUNCIONARIO')")
	@GetMapping("/mispermisos")
	public ModelAndView misPermisos() {
		ModelAndView mav;
		String constante=null;
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String perfil = userService.obtenerPerfilByUsuario(user.getUsername());
		String rutFuncionario = userService.obtenerRutFuncionarioByUsuario(user.getUsername());
		
		switch (perfil) {
        case "SUPER_ADMIN":  constante = ViewConstant.MIS_PERMISOS_SU;
                 break;
        case "ALCALDE":  constante = ViewConstant.MIS_PERMISOS_A;
                 break;
        case "JEFE INTERNO":  constante = ViewConstant.MIS_PERMISOS_JI;
                 break;
        case "JEFE SUPERIOR":  constante = ViewConstant.MIS_PERMISOS_JS;
                 break;
        case "FUNCIONARIO":  constante = ViewConstant.MIS_PERMISOS_F;
                 break;
        default: perfil = "PERFIL INVALIDO";
                 break;
		}
		
		//retorna la vista
		mav = new ModelAndView(constante);
		
		mav.addObject("username", user.getUsername());
		mav.addObject("mispermisos", permisoService.findAllPermisoByRut(rutFuncionario));
		return mav;
		
	}
	
	
//**************************************************************************************************************************************************	
	//VISUALIZAR PERMISOS DEL DEPARTAMENTO.
	@PreAuthorize("hasAnyAuthority('ALCALDE', 'JEFE INTERNO', 'JEFE SUPERIOR')")
	@GetMapping("/deptopermisos")
	public ModelAndView departamentoPermisos() {
		
		ModelAndView mav=new ModelAndView(ViewConstant.DEPTO_PERMISOS);

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int departamentoId = userService.obtenerIdDepartamentoByUsuario(user.getUsername());
		
		String perfil = userService.obtenerPerfilByUsuario(user.getUsername());
		switch (perfil) {
        case "JEFE INTERNO":  
        	LOG.info("METHOD: departamentoPermisos() -- ENTRA COMO : " + perfil.toString());
        	mav.addObject("deptopermisos", permisoService.findAllPermisoByDepartamento(departamentoId));
                 break;
        case "JEFE SUPERIOR":
        	LOG.info("METHOD: departamentoPermisos() -- ENTRA COMO: " + perfil.toString());
        	mav.addObject("deptopermisos", permisoService.findAllPermiso());
                 break;
        default: perfil = "PERFIL INVALIDO";
                 break;
		}
		mav.addObject("username", user.getUsername());
		return mav;
		
	}
	
	//VISUALIZAR PERMISOS DEL DEPARTAMENTO.
	@PreAuthorize("hasAnyAuthority('JEFE INTERNO', 'JEFE SUPERIOR')")
	@GetMapping("/detallepermiso")
	public String redirectDetallePermiso(@RequestParam(name="idPermiso", required=false) int idPermiso,
			Model model) {
		PermisoModel permiso = new PermisoModel();
		FuncionarioInfoModel funcionario = new FuncionarioInfoModel();
		LOG.info("METHOD: redirectDetallePermiso() -- PARAMS IN: " + permiso.toString());
		
		if(idPermiso != 0) {
			permiso = permisoService.findPermisoModelById(idPermiso);
		}
		LOG.info("METHOD: redirectPermisoForm() -- PARAMS OUT: " + permiso.toString());
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		funcionario = funcionarioService.findFuncionarioModelByRut(permiso.getRutFuncionario());
		String nomfuncionario = funcionario.getPrimerNombre().trim()+" "+funcionario.getSegundoNombre().trim()+" "+funcionario.getPrimerApellido().trim()+" "+funcionario.getSegundoApellido().trim();
		
		model.addAttribute("permiso", permiso);
		model.addAttribute("funcionario", funcionario);
		model.addAttribute("nomfuncionario", nomfuncionario.trim());
		return ViewConstant.PERMISO_DETALLE;
	}
	
	
	//AUTORIZAR O RECHAZAR PERMISO
	@PreAuthorize("hasAnyAuthority('JEFE INTERNO', 'JEFE SUPERIOR')")
	@PostMapping("/authpermiso")
	public String authPermiso(@ModelAttribute(name="permiso") PermisoModel permiso,
							  Model model) throws FileNotFoundException, DocumentException {
		LOG.info("METHOD: authPermiso() -- PARAMS: " + permiso.toString());
		LOG.info("METHOD: authPermiso() -- VALOR ESTADO: " + permiso.getEstado());
	
		LocalDate localDate = LocalDate.now();
		Date hora_actual=(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		
		PermisoModel permi = permisoService.findPermisoModelById(permiso.getIdPermiso());
		permi.setEstado(permiso.getEstado());
		permi.setResolucionPermiso(permiso.getResolucionPermiso());
		
		
		if(null != permisoService.addPermiso(permi,
											 funcionarioService.findFuncionarioByRut(permi.getRutFuncionario()),
											 estadoService.findEstadoById(permi.getEstado()),
											 motivoService.findMotivoById(permi.getMotivo()),
											 tipoService.findTipoById(permi.getTipo())))
		{
			String P_nombre = funcionarioService.findFuncionarioByRut(permiso.getRutFuncionario()).getPrimerNombre();
			String S_nombre = funcionarioService.findFuncionarioByRut(permiso.getRutFuncionario()).getSegundoNombre();
			String P_apellido = funcionarioService.findFuncionarioByRut(permiso.getRutFuncionario()).getPrimerApellido();
			String S_apellido = funcionarioService.findFuncionarioByRut(permiso.getRutFuncionario()).getSegundoApellido();
			String nombre= P_nombre +" "+ S_nombre +" "+ P_apellido +" "+ S_apellido;
			
			String rut = permiso.getRutFuncionario();
			String estado = estadoService.findEstadoById(permi.getEstado()).getNombreEstado();
			String fecha = String.valueOf(hora_actual);
			int id_numero_resolucion = permiso.getIdPermiso();
			String motivo =  motivoService.findMotivoById(permi.getMotivo()).getDescripcionMotivo();
			String fInicio = String.valueOf(permiso.getFechaInicio());
			String fTermino = String.valueOf(permiso.getFechaTermino());
			String nombre_departamento = permiso.getNombreDepartamento();
			String nombre_funcionario = nombre;
			
			GenerarPDF resolucion= new GenerarPDF();
			resolucion.generarPDFresolucion(rut, estado, fecha, id_numero_resolucion, motivo, fInicio, fTermino, nombre_departamento, nombre_funcionario);
			
			model.addAttribute("result", 1);
		}else {
			model.addAttribute("result", 0);
		}
		
		return "redirect:/permisos/deptopermisos";
		
	}
	
	
	
//**************************************************************************************************************************************************	

	
	//Se agrega este metodo que trabaja sin Model (NO DEBERIA IR)
	@PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ALCALDE', 'JEFE INTERNO', 'JEFE SUPERIOR', 'FUNCIONARIO')")
	@PostMapping("/addpermiso")
	public String addPermiso(@ModelAttribute(name="permiso") PermisoModel permiso,
							 Model model) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fechaI = permiso.getAnioI()+"-"+permiso.getMesI()+"-"+permiso.getDiaI();
		String fechaF = permiso.getAnioF()+"-"+permiso.getMesF()+"-"+permiso.getDiaF();
		sdf.setLenient(true);
		
		LOG.info("METHOD: addPermiso() -- PARAMS: " + permiso.toString());
		LOG.info("METHOD: addPermiso() -- FECHA INICIO: " + fechaI);
		LOG.info("METHOD: addPermiso() -- FECHA FIN: " + fechaF);
		
		try {
			permiso.setFechaInicio(sdf.parse(fechaI));
			permiso.setFechaTermino(sdf.parse(fechaF));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//OBTENER DIAS
		int dias =(int) (permiso.getFechaTermino().getTime() - permiso.getFechaInicio().getTime())/86400000;
		if(dias > 0) {
			
			//CONSULTA LOS DIAS DISPONIBLES A LA API REST DE RRHH DE LA MUNICIPALIDAD
			//------------------------------------------------------------------------------------------------------------------
			HttpJsonRequestLibreria test = new HttpJsonRequestLibreria();

			String url=ViewConstant.URL_WS+permiso.getRutFuncionario();
			String diasDisponibles=test.obtieneJsonAPIRest(url);
			//------------------------------------------------------------------------------------------------------------------
			
			
			LOG.info("METHOD: addPermiso() -- DIAS DE PERMISO SOLICITADOS: " + dias);
			LOG.info("METHOD: addPermiso() -- DIAS DE PERMISO DISPONIBLES: " + diasDisponibles);
			
			
			permiso.setResolucionPermiso("PENDIENTE");
			LocalDate localDate = LocalDate.now();
			permiso.setFechaSolicitud(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
			int idMotivo=motivoService.addMotivo(permiso.getDescripcionMotivo().trim()).getIdMotivo();
			


			if(Integer.parseInt(diasDisponibles) >= dias) {
				LOG.info("METHOD: addPermiso() -- Este el el motivo: " + permiso.getDescripcionMotivo().trim());	
			if(null != permisoService.addPermiso(permiso,
											 funcionarioService.findFuncionarioByRut(permiso.getRutFuncionario()),
											 estadoService.findEstadoById(3),
											 motivoService.findMotivoById(idMotivo),
											 tipoService.findTipoById(permiso.getTipo()))) 
			{
				model.addAttribute("result", 1);
			}else {
				model.addAttribute("result", 0);
				}
			return "redirect:/permisos/mispermisos";
			}
			
			//String mensajeError1="No puedes solicitar mas de "+dias+" Días de permiso.";
			//model.addAttribute("mensajeError1", mensajeError1);
			return "redirect:/permisos/permisoform?idPermiso=0&error=1&diass="+dias;

		}
		
		//String mensajeError2="No tienes mas Días disponibles.";
		//model.addAttribute("mensajeError1", mensajeError2);
		return "redirect:/permisos/permisoform?idPermiso=0&error=2&diass="+0;

	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	
	

}
