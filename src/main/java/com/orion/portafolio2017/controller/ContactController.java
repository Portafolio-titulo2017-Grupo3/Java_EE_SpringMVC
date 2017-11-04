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
import com.orion.portafolio2017.service.impl.UserService;

@Controller
//@PreAuthorize("permitAll()")
@RequestMapping("/contacts")
public class ContactController {
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contacts/showcontacts";
	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	//@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	//@PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
	//@PreAuthorize("permitAll()")
	//@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	//@PreAuthorize("hasAuthority('ALCALDE')")
	@PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ALCALDE', 'JEFE INTERNO', 'JEFE SUPERIOR', 'FUNCIONARIO')")
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
			ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);	
			
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String perfil = userService.obtenerPerfilByUsuario(user.getUsername());
			
			mav.addObject("perfil", perfil);
			mav.addObject("username", user.getUsername());
			return mav;	
	}

}
