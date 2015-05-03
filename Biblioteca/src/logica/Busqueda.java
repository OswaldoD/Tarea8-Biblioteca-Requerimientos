package logica;

import java.util.ArrayList;

public class Busqueda {
	
	
	
	public Busqueda(){
		
	}
	
	public ArrayList<String> buscaLibros(String libro){
		String libro_buscar= "src/database/Libros/inventario.txt";
		ArrayList<String> resultados = new ArrayList<String>();
		
		
		Carga_archivo busqueda = new Carga_archivo(libro_buscar);
		resultados = busqueda.load_file();
		
		for(int i = 0; i< resultados.size(); i++){
			if(!resultados.get(i).toLowerCase().contains(libro.toLowerCase())){
				resultados.remove(i);
			}		
		}
		//System.out.println("Contains -> " + hola.contains("como"));
		return resultados;
	}

}
