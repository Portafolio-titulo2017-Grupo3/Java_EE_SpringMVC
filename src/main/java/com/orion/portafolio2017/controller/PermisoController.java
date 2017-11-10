package com.orion.portafolio2017.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.orion.portafolio2017.constant.ViewConstant;
import com.orion.portafolio2017.model.PermisoModel;
import com.orion.portafolio2017.service.impl.PermisoServiceImpl;
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
	@Qualifier("permisoServiceImpl")
	private PermisoServiceImpl permisoServiceImpl;
	
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
		mav.addObject("mispermisos", permisoServiceImpl.findAllPermisoByRut(rutFuncionario));
		return mav;
		
	}

	
	//@PostMapping("/crearpermiso")

}
