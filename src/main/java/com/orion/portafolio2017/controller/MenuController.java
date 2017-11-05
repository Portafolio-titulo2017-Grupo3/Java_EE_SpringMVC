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
import com.orion.portafolio2017.entity.Funcionario;
import com.orion.portafolio2017.service.impl.UserService;

@Controller
//@PreAuthorize("permitAll()")
@RequestMapping("/menu")
public class MenuController {
	
	private static final Log LOG = LogFactory.getLog(MenuController.class);
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/menu/micuenta";
	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	//@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	//@PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
	//@PreAuthorize("permitAll()")
	//@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	//@PreAuthorize("hasAuthority('ALCALDE')")
	@PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ALCALDE', 'JEFE INTERNO', 'JEFE SUPERIOR', 'FUNCIONARIO')")
	@GetMapping("/micuenta")
	public ModelAndView showContacts() {
			ModelAndView mav;
			String constante=null;
			
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String perfil = userService.obtenerPerfilByUsuario(user.getUsername());
			Funcionario funcionario = userService.obtenerFuncionarioByUsuario(user.getUsername());
			
			switch (perfil) {
            case "SUPER_ADMIN":  constante = ViewConstant.MENUSA;
                     break;
            case "ALCALDE":  constante = ViewConstant.MENUA;
                     break;
            case "JEFE INTERNO":  constante = ViewConstant.MENUJI;
                     break;
            case "JEFE SUPERIOR":  constante = ViewConstant.MENUJS;
                     break;
            case "FUNCIONARIO":  constante = ViewConstant.MENUF;
                     break;
            default: perfil = "PERFIL INVALIDO";
                     break;
			}
			
			//retorna la vista
			mav = new ModelAndView(constante);
			
			
			//Devuelve el Nombre del Usuario y el Tipo de Perfil
			mav.addObject("username", user.getUsername());
			mav.addObject("perfil", perfil);
			mav.addObject("rut", funcionario.getRutFuncionario());
			mav.addObject("nombres", funcionario.getPrimerNombre()+" "+funcionario.getSegundoNombre());
			mav.addObject("apellidos", funcionario.getPrimerApellido()+" "+funcionario.getSegundoApellido());
			return mav;	
	}

}
