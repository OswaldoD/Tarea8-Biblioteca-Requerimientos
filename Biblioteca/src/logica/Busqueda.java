package logica;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
/**
 * Instituto Tecnológico de Costa Rica
 * Requerimientos de Software
 * Grupo 1
 * @author Oswaldo Davila - 201222296, Estefanny Porras - 201241100
 * Tarea 8 - Biblioteca
 *
 */
public class Busqueda {
	
	
	
	public Busqueda(){
		
	}
	
	public ArrayList<String> buscaLibros(String libro, String autor){
		String libro_buscar= "src/database/Libros/inventario.txt";
		ArrayList<String> resultados = new ArrayList<String>();
		
		Carga_archivo busqueda = new Carga_archivo(libro_buscar);
		resultados = busqueda.load_file();
		
		for(int i = 0; i< resultados.size(); i++){
			if( (!resultados.get(i).toLowerCase().contains(libro.toLowerCase())) &&
			    (!resultados.get(i).toLowerCase().contains(autor.toLowerCase())) ){
				resultados.remove(i);
			}		
		}
		//System.out.println("Contains -> " + hola.contains("como"));
		return resultados;
	}
	
	public String buscaCodigoLibro(int posicion){
		ArrayList<String> resultados = new ArrayList<String>();
		String libro_mostrar ="";
		
		String codigos = "src/database/Libros/inventarioC.txt";
		Carga_archivo busqueda = new Carga_archivo(codigos);
		resultados = busqueda.load_file();
		
		libro_mostrar = resultados.get(posicion-1);
		
		return libro_mostrar;
		
	}
	public ArrayList<String> cargaLibro(String codigo){
		String libro_cargar = "src/database/Libros/" + codigo + ".txt";
		
		ArrayList<String> libro = new ArrayList<String>();
		Carga_archivo busqueda = new Carga_archivo(libro_cargar);
		libro = busqueda.load_file();
		return libro;
		
	}
	public void generaPrestamo(ArrayList<String> datos_libro, String idU, String clibro){
		
		Calendar c = new GregorianCalendar();
		String fecha_prestamo = Integer.toString(c.get(Calendar.DATE))+ "/" + 
					            Integer.toString(c.get(Calendar.MONTH)) + "/" + 
					            Integer.toString(c.get(Calendar.YEAR));
		datos_libro.add(fecha_prestamo);
		datos_libro.add(idU);
		datos_libro.add("0"); //codigo para asignar que no ha sido devuelto
		
		String ruta="src/database/Prestamos/"+ idU + "-" +clibro + ".txt";
		Carga_archivo guarda_prestamo = new Carga_archivo(ruta);
		guarda_prestamo.escribe_archivo(datos_libro);
		
		//dia = 

		
		
		
	}

}
