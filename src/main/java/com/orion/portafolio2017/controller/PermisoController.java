package com.orion.portafolio2017.controller;

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

import com.orion.portafolio2017.constant.ViewConstant;
import com.orion.portafolio2017.model.PermisoModel;
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
	
	/** The user repository. */
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
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/permisos/mispermisos";
	}
	
	
	//Se agrega este metodo que trabaja sin Model (NO DEBERIA IR)
	@PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ALCALDE', 'JEFE INTERNO', 'JEFE SUPERIOR', 'FUNCIONARIO')")
	@GetMapping("/permisoform")
	public String redirectPermisoForm(@RequestParam(name="idPermiso", required=false) int idPermiso,
			Model model) {
		PermisoModel permiso = new PermisoModel();
		LOG.info("METHOD: redirectPermisoForm() -- PARAMS IN: " + permiso.toString());
		
		if(idPermiso != 0) {
			permiso = permisoService.findPermisoModelById(idPermiso);
		}
		LOG.info("METHOD: redirectPermisoForm() -- PARAMS OUT: " + permiso.toString());
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("funcionario",userService.obtenerFuncionario(user.getUsername()));
		model.addAttribute("permiso", permiso);
		model.addAttribute("estado", estadoService.findAllEstadoModel());
		model.addAttribute("motivo", motivoService.findAllMotivoModel());
		model.addAttribute("tipo", tipoService.findAllTipoModel());
		return ViewConstant.CREAR_PERMISO_F;
	}
	
	@PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ALCALDE', 'JEFE INTERNO', 'JEFE SUPERIOR', 'FUNCIONARIO')")
	@GetMapping("/mispermisos")
	public ModelAndView showContacts() {
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


	
	//Se agrega este metodo que trabaja sin Model (NO DEBERIA IR)
	@PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ALCALDE', 'JEFE INTERNO', 'JEFE SUPERIOR', 'FUNCIONARIO')")
	@PostMapping("/addpermiso")
	public String addPermiso(@ModelAttribute(name="permiso") PermisoModel permiso,
			Model model) {
		LOG.info("METHOD: addPermiso() -- PARAMS: " + permiso.toString());
	
		if(permiso.getResolucionPermiso().length() == 0 || permiso.getResolucionPermiso().isEmpty()) {
			permiso.setResolucionPermiso("Pendiente Revisión");
		}
		LocalDate localDate = LocalDate.now();
		permiso.setFechaSolicitud(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		if(null != permisoService.addPermiso(permiso,
											 funcionarioService.findFuncionarioByRut(permiso.getRutFuncionario()),
											 estadoService.findEstadoById(3),
											 motivoService.findMotivoById(permiso.getMotivo()),
											 tipoService.findTipoById(permiso.getTipo()))) 
		{
			model.addAttribute("result", 1);
		}else {
			model.addAttribute("result", 0);
		}
		
		
		return "redirect:/permisos/mispermisos";
		
	}
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	   // binder.registerCustomEditor(Integer.class,null,new CustomNumberEditor(Integer.class,null,true));
	   //binder.registerCustomEditor(Long.class,null,new CustomNumberEditor(Long.class,null,true));
	}

}
