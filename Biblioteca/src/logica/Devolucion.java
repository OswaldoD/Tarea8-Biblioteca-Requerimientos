package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * Instituto Tecnológico de Costa Rica
 * Requerimientos de Software
 * Grupo 1
 * @author Oswaldo Davila - 201222296, Estefanny Porras - 201241100
 * Tarea 8 - Biblioteca
 *
 */
public class Devolucion {
	
	
	public Devolucion(){
		
	}
	public ArrayList<String> cargaPrestamo(String idU, String clibro){
		ArrayList<String> prestamo = new ArrayList<String>();
		
		String ruta = "src/database/Prestamos/"+ idU + "-" +clibro + ".txt";
		Carga_archivo cprestamo = new Carga_archivo(ruta);
		prestamo = cprestamo.load_file();
		System.out.println("ruta a buscar : "+ruta);
		
		
		return prestamo;
		
	}
	public void generaDevolucion(ArrayList<String> datos_prestamo, String idU, String clibro){
		
		String ruta = "src/database/Prestamos/"+ idU + "-" +clibro + ".txt";
		
		datos_prestamo.remove(datos_prestamo.size()-1);
		datos_prestamo.add("1"); // codigo para indicar que ya se devolvio el libro
		
		Calendar c = new GregorianCalendar();
		String fecha_prestamo = Integer.toString(c.get(Calendar.DATE))+ "/" + 
					            Integer.toString(c.get(Calendar.MONTH)) + "/" + 
					            Integer.toString(c.get(Calendar.YEAR));
		datos_prestamo.add(fecha_prestamo);
		
		
		Carga_archivo devolucion = new Carga_archivo(ruta);
		devolucion.escribe_archivo(datos_prestamo);
		
		
	}
	

}
