package com.orion.portafolio2017.component;

public class GenerarCodigo {

	public String cod_verificar() {
		int num1 = 97;
		int num2 = 122;
		char c = 0;
		String cv = "";
		
		int numAleatorio=0;
		
		for (int i = 0; i < 3; i++) {
			numAleatorio = (int) Math.floor(Math.random() * (num2 - num1) + num1);
			//Para transformar los números en letras según ACSII
			String caracter=String.valueOf((char) numAleatorio);

			cv+=numAleatorio+caracter;
		}
		return cv;
	}
	
	public static void main(String[] args) {
		GenerarCodigo cod = new GenerarCodigo();
		System.out.println(cod.cod_verificar());
	}
	
}
