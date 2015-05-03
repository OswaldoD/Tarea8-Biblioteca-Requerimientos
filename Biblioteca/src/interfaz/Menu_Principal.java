package interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Carga_archivo;

public class Menu_Principal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 01;
	private JPanel contenedor;
	private JMenuItem mntmPrestamoLibro, mtnmDevolverLibro, mntmSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Principal frame = new Menu_Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu_Principal() {

		
		configuraFrame();
		creaBarraMenu();
	}

	private void configuraFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Menú Principal");
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(null);
		setContentPane(contenedor);
	}
		   
	private void creaBarraMenu(){
		   /**
		    * Método que crea la barra de Menú del Frame 
		    * y sus respectivos componentes
		    */
		   JMenuBar Barra_menu = new JMenuBar();
		   Barra_menu.setBounds(0, 0, 550, 25);
		   contenedor.add(Barra_menu);
		   
		   JMenu mnArchivo = new JMenu("Archivo");
		   Barra_menu.add(mnArchivo);
		   
		   mntmPrestamoLibro = new JMenuItem("Pr\u00E9stamo Libro");
		   mntmPrestamoLibro.addActionListener(this);
		   mnArchivo.add(mntmPrestamoLibro);
		   
		   mtnmDevolverLibro = new JMenuItem("Devolver Libro");
		   mtnmDevolverLibro.addActionListener(this);
		   mnArchivo.add(mtnmDevolverLibro);
		   
		   mntmSalir = new JMenuItem("Salir");
		   mntmSalir.addActionListener(this);
		   mnArchivo.add(mntmSalir);
		   
	   }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//String source = (String) e.getSource();
		//source.equals(anObject)
		if (e.getSource()==mntmPrestamoLibro){
			System.out.println("Prestar");
			
			Buscar_Libro buscar = new Buscar_Libro();
			buscar.setVisible(true);
			
			Carga_archivo archivo = new Carga_archivo("hi");
			System.out.println("Cargo " + archivo.load_file().get(1));
			ArrayList <String> escribir = new ArrayList<String>();
			escribir.add("Hola");
			escribir.add("Como estas");
			archivo.escribe_archivo(escribir);
			
			dispose();
		}
		
		else if (e.getSource()==mtnmDevolverLibro){
			System.out.println("Devolver");
			
			Buscar_Prestamo devolver = new Buscar_Prestamo();
			devolver.setVisible(true);
			dispose();
		}
		
		else if (e.getSource()==mntmSalir){
			dispose();
		}

		
	}

}
