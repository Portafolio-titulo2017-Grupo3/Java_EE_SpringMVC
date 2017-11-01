package com.orion.portafolio2017.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		// Estas contraseñas encriptadas deben ir en el campo 'CLAVE_USUARIO' de la tabla 'USUARIO' de la DB ORACLE
		System.out.println("Contraseña de KRISTPAZ encriptada con Spring security : "+pe.encode("KRISTPAZ"));
		System.out.println("Contraseña de PATRIING encriptada con Spring security : "+pe.encode("PATRIING"));	
		System.out.println("Contraseña de MARTALUN encriptada con Spring security : "+pe.encode("MARTALUN"));	
		System.out.println("Contraseña de CARLOALO encriptada con Spring security : "+pe.encode("CARLOALO"));	
		System.out.println("Contraseña de SUSANXIM encriptada con Spring security : "+pe.encode("SUSANXIM"));	
	}

}
