
package com.orion.portafolio2017.component;

import com.itextpdf.text.BaseColor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerarPDF {

	public static void generarPDFresolucion(String rut, String estado, String fecha, int id_numero_resolucion,
			String motivo, String fInicio, String fTermino, String nombre_departamento, String nombre_funcionario) throws DocumentException, FileNotFoundException {

		String constante = "DOC";
		long tiempo_milisegundos = System.currentTimeMillis();
		String n_doc = constante + "_" + rut +"_"+ tiempo_milisegundos;

		GenerarCodigo cod = new GenerarCodigo();
		String codigo = cod.cod_verificar();

		// Crear las fuentes para el contenido y los titulos
		Font fontContenido = FontFactory.getFont(FontFactory.HELVETICA.toString(), 11, Font.NORMAL, BaseColor.BLACK);
		Font fontTitulos = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, Font.NORMAL, BaseColor.BLACK);

		// Ruta y nombre del documento
		FileOutputStream archivo = new FileOutputStream(new File(".").getAbsolutePath()+"\\resoluciones\\" + n_doc + ".pdf");
		// Creo el documento con el tipo de hoja y sus màrgenes
		Document documento = new Document(PageSize.A4, 35, 30, 50, 50);
		// Obtener la instancia del PdfWrite
		PdfWriter.getInstance(documento, archivo);
		documento.open();
		documento.add(new Paragraph("Resolución Solicitud de Permiso Nº" + id_numero_resolucion, fontTitulos));

		documento.add(new Paragraph("\n"));
		documento.add(new Paragraph(
				"Por medio del presente documento la Municipalidad de Vista Hermosa informa que su solicitud de permiso Nº "
						+ id_numero_resolucion + " generada el " + fecha + " por el funcionario(a) " + nombre_funcionario + " rut " + rut
						+ ",departamento " + nombre_departamento + "por el  motivo " + motivo + " Ha sido " + estado
						+ " desde el " + fInicio + " " + " hasta el " + fTermino,
				fontContenido));

		documento.add(new Paragraph("\n"));
		documento.add(new Paragraph("\n"));
		documento.add(new Paragraph("\n"));
		documento.add(new Paragraph("Código de verificacion:" + codigo));

		documento.close();

	}

	public static void main(String[] a3d) throws FileNotFoundException, DocumentException {

		String rut = "18.781.xxx-x";
		String estado = "aprobado";
		String fecha = "01/12/2017";
		int id_numero_resolucion = 123456;
		String motivo = "asdasdadasd";
		String fInicio = "04/12/2017";
		String fTermino = "08/12/2017";
		String nombre_departamento = "Informatica";
		String nombre_funcionario = "Daniela Sofía Flores Verdugo";
		
		GenerarPDF doc= new GenerarPDF();
		doc.generarPDFresolucion(rut, estado, fecha, id_numero_resolucion, motivo, fInicio, fTermino, nombre_departamento, nombre_funcionario);

	}

}
