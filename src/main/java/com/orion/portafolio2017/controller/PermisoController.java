package com.orion.portafolio2017.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.orion.portafolio2017.constant.ViewConstant;
import com.orion.portafolio2017.entity.Funcionario;
import com.orion.portafolio2017.model.FuncionarioModel;
import com.orion.portafolio2017.service.impl.UserService;


@Controller
@RequestMapping("/permisos")
public class PermisoController {
	
	private static final Log LOG = LogFactory.getLog(PermisoController.class);
	
	/** The user repository. */
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@GetMapping("/mispermisos")
	public ModelAndView showContacts() {
		ModelAndView mav = new ModelAndView(ViewConstant.MIS_PERMISOS);
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Funcionario funcionario = userService.obtenerFuncionarioByUsuario(user.getUsername());
		
		mav.addObject("username", user.getUsername());
		mav.addObject("mispermisos", funcionario.getPermisos());
		return mav;
		
	}

	
	//@PostMapping("/crearpermiso")

}
