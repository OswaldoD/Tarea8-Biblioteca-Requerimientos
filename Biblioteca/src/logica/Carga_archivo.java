package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Carga_archivo {
	private String ruta;
	
	
	public Carga_archivo(String ruta){
		//this.ruta = "src/database/hola.txt";
		this.ruta = ruta;
		
	}
	
	public ArrayList<String> load_file(){
		/**
		 * Método para cargar el archivo
		 * Entrada: ninguna
		 * Salida: retorna todo un archivo cargado linea por línea en un ArrayList
		 * Requiere de una ruta válida para poder cargar el archivo
		 * 
		 */
		ArrayList<String> datos_entrada = new ArrayList<String>();
		
		try{
			BufferedReader entrada = new BufferedReader(new FileReader(ruta)); 
			String lectura;
			while((lectura = entrada.readLine()) != null){
				datos_entrada.add(lectura);
			}
			entrada.close();

     		} catch(IOException e) {
     			e.printStackTrace();
     		}
		return datos_entrada;
	}
	
	public boolean escribe_archivo(ArrayList<String> escribir){
		/**
		 * Método para escribir un archivo
		 * Entrada: ArrayList de las lineas que se van a escribir.
		 * 			1 Línea equivale a 1 posición del ArrayList
		 * Salida: Retorna true si escribe el archivo sin problemas, 
		 * 		   false si ocurre algun error.
		 * 
		 */
		try{
			File archivo = new File(ruta);
			PrintWriter archivo_escribir = new PrintWriter(archivo);
			
			for(int i=0;i<escribir.size(); i++){
				archivo_escribir.println(escribir.get(i));
				
			}
			//archivo_escribir.println("Hola modificado");
			
			
			archivo_escribir.close();
			return true;
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
	
	
	
	
	
	

}


