package com.orion.portafolio2017.converter;

import java.util.Calendar;

import com.orion.portafolio2017.constant.ViewConstant;

public class Fechas {

	public String fechaActual() {
		// Fecha actual desglosada:
		Calendar fecha = Calendar.getInstance();
		int year = fecha.get(Calendar.YEAR);
		int moth = fecha.get(Calendar.MONTH) + 1;
		int day = fecha.get(Calendar.DAY_OF_MONTH);
		
		String dia = String.valueOf(day);
		String mes = null;
		String anio = String.valueOf(year);

		switch (moth) {
		case 1: mes = "Ene";
			break;
		case 2: mes = "Feb";
			break;
		case 3: mes = "Mar";
			break;
		case 4: mes = "Abr";
			break;
		case 5: mes = "May";
			break;
		case 6: mes = "Jun";
			break;
		case 7: mes = "Jul";
			break;
		case 8: mes = "Ago";
			break;
		case 9: mes = "Sep";
			break;
		case 10: mes = "Oct";
			break;
		case 11: mes = "Nov";
			break;
		case 12: mes = "Dic";
			break;
		default:
			break;
		}
		
		String fechas = mes+" "+dia+", "+anio;

		return fechas;

	}
	
	public String horaActual() {
		// Fecha actual desglosada:
		Calendar fecha = Calendar.getInstance();

		int hour = fecha.get(Calendar.HOUR_OF_DAY);
		int minute = fecha.get(Calendar.MINUTE);
		
		String minuto = String.valueOf(minute);
		String hora = String.valueOf(hour);

		String tiempo = hora+":"+minuto;

		return tiempo;

	}

	public static void main(String[] args) {

		Fechas fecha = new Fechas();

		System.out.println(fecha.fechaActual());
		System.out.println(fecha.horaActual());
	}

}
