package interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import logica.Busqueda;

import javax.swing.JTextField;

public class Ver_Libro extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 05;
	private JPanel contenedor;
	private JMenuItem mntmAtras, mntmSalir;
	private JButton btnSolicitarPrstamo;
	private	ArrayList<String> libro = new ArrayList<String>();
	private JTextField txtIdU;
	private String clibro;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Ver_Libro frame = new Ver_Libro();
					//frame.setVisible(true);
				} catch (Exception e) {
					//e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ver_Libro(String clibro) {
		configuraFrame();
		creaBarraMenu();
		creaLabels();
		creaTextFields();
		mostrarLibro(clibro);
		this.clibro=clibro;
	}
	
	private void configuraFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Ver Libro consultado");
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(null);
		setContentPane(contenedor);
		
	}
	private void creaBarraMenu(){
		   JMenuBar Barra_menu = new JMenuBar();
		   Barra_menu.setBounds(0, 0, 550, 25);
		   contenedor.add(Barra_menu);
		   
		   JMenu mnArchivo = new JMenu("Archivo");
		   Barra_menu.add(mnArchivo);
		  
		   mntmAtras = new JMenuItem("Atras");
		   mntmAtras.addActionListener(this);
		   mnArchivo.add(mntmAtras);
		   
		   mntmSalir = new JMenuItem("Salir");
		   mntmSalir.addActionListener(this);
		   mnArchivo.add(mntmSalir);
		   
		   btnSolicitarPrstamo = new JButton("Solicitar Pr\u00E9stamo");
		   btnSolicitarPrstamo.setBounds(257, 214, 150, 25);
		   btnSolicitarPrstamo.addActionListener(this);
		   contenedor.add(btnSolicitarPrstamo);
		   		
	}
	private void creaLabels(){
		
	}
	private void creaTextFields(){
		   txtIdU = new JTextField();
		   txtIdU.setBounds(121, 216, 120, 20);
		   contenedor.add(txtIdU);
		   txtIdU.setColumns(10);
		
	}
	private void mostrarLibro(String clibro){
		//ArrayList<String> libro = new ArrayList<String>();
		
		Busqueda carga_libro = new Busqueda();
		libro = carga_libro.cargaLibro(clibro);
		
		//parametros para mostrar en interfaz
	}
	private void generarPrestamo(){
		String idU = txtIdU.getText();
		
		Busqueda prestamo = new Busqueda();
		prestamo.generaPrestamo(libro, idU, this.clibro);
		
	    JOptionPane.showMessageDialog(null,"El préstamo se ha realizado con éxito",
				  "Préstamo Realizado",JOptionPane.WARNING_MESSAGE);
	    
	    Menu_Principal principal = new Menu_Principal();
	    principal.setVisible(true);
	    dispose();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==mntmAtras){
			System.out.println("Prestar");
			Buscar_Libro buscar = new Buscar_Libro();
			buscar.setVisible(true);
			
			/* Acá debiera ir
			Resultados_Busqueda resultado = new Resultados_Busqueda();
			resultado.setVisible(true);*/
			
			dispose();
		}
		else if(e.getSource()==btnSolicitarPrstamo){
			generarPrestamo();
		}
		
		else if (e.getSource()==mntmSalir){
			dispose();
		}
		
	}


}
