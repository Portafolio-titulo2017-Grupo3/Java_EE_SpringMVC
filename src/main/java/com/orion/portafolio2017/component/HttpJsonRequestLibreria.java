package com.orion.portafolio2017.component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.jdbc.datasource.init.ScriptStatementFailedException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;



public class HttpJsonRequestLibreria {
	
	
	public static void obtieneJsonAPIRestTest(String url1)
	{
	    try
	    {
	        //creamos una URL donde esta nuestro webservice
	        URL url = new URL(url1);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        //indicamos por que verbo HTML ejecutaremos la solicitud
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        
	        /*
	        if (conn.getResponseCode() != 200) 
	        {
	            //si la respuesta del servidor es distinta al codigo 200 lanzaremos una Exception
	            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	        }
	        */
	        
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	        //creamos un StringBuilder para almacenar la respuesta del web service
	        StringBuilder sb = new StringBuilder();
	        int cp;
	        while ((cp = br.read()) != -1)
	        {
	          sb.append((char) cp);
	        }
	        //en la cadena output almacenamos toda la respuesta del servidor
	        String output = sb.toString();
	        //convertimos la cadena a JSON a traves de la libreria GSON
	        JsonObject json = new Gson().fromJson(output,JsonObject.class);
	        //JsonPrimitive json = new Gson().fromJson(output,JsonPrimitive.class);
	        //imprimimos como Json
	        System.out.println("salida como JSON " +  json.get("permisosDisponibles"));
	        //imprimimos como String
	        System.out.println("salida como String : " +output);

	        conn.disconnect();
	    }
	    catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	    }
	}
	
	
	
	
	public String obtieneJsonAPIRest(String url1)
	{
		int diasDisponibles=0;
		String resultado=String.valueOf(0);
	    try
	    {
	    	
	        //creamos una URL donde esta nuestro webservice
	        URL url = new URL(url1);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        //indicamos por que verbo HTML ejecutaremos la solicitud
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        
	        /*
	        if (conn.getResponseCode() != 200) 
	        {
	            //si la respuesta del servidor es distinta al codigo 200 lanzaremos una Exception
	            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	        }
	        */
	        
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	        //creamos un StringBuilder para almacenar la respuesta del web service
	        StringBuilder sb = new StringBuilder();
	        
	        	
	            int cp;
		        while ((cp = br.read()) != -1)
		        {
		          sb.append((char) cp);
		        }
		        //en la cadena output almacenamos toda la respuesta del servidor
		        String output = sb.toString();
		        //convertimos la cadena a JSON a traves de la libreria GSON
		        JsonObject json = new Gson().fromJson(output,JsonObject.class);

		        conn.disconnect();
		        return json.get("permisosDisponibles").toString();
		        
	    
	    }
	    catch(Exception e)
	    {
	    	//System.out.println(e.getMessage());
	    	return resultado;
	        
	    }
	    
	}
	
	
	public static void main(String[] args) {
		HttpJsonRequestLibreria test = new HttpJsonRequestLibreria();
		String url="http://localhost:8082/api-rest/v1/funcionario/22222222-2&15";
		//test.obtieneJsonAPIRestTest(url);
		System.out.println("salida como String : " +test.obtieneJsonAPIRest(url));
		//test.obtieneJsonAPIRest(url);
	}
	
	
	
	

}
