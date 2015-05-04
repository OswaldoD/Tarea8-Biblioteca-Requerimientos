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

import logica.Devolucion;

public class Ver_Prestamo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contenedor;
	private JMenuItem mntmAtras, mntmSalir;
	private JButton btnDevolverLibro;
	private String parametros[] = new String[2];
	private ArrayList<String> p_mostrar = new ArrayList<String>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Ver_Prestamo frame = new Ver_Prestamo();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ver_Prestamo(String parametros[]) {
		configuraFrame();
		creaBarraMenu();
		crearLabels();
		crearTextFields();
		mostrarPrestamo(parametros);
		this.parametros = parametros;

	}
	
	private void configuraFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Devolver Libro");
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
		   
		   btnDevolverLibro = new JButton("Devolver Libro");
		   btnDevolverLibro.addActionListener(this);
		   btnDevolverLibro.setBounds(291, 227, 121, 23);
		   contenedor.add(btnDevolverLibro);
		
	}
	private void crearLabels(){
		
	}
	private void crearTextFields(){
		
	}
	private void mostrarPrestamo(String parametros[]){
		//ArrayList<String> p_mostrar = new ArrayList<String>();
		Devolucion mostrar_prestamo = new Devolucion();
		p_mostrar = mostrar_prestamo.cargaPrestamo(parametros[0], parametros[1]);
		//mostrar los datos en el frame
		
		
	}
	private void generaDevolucion(){
		Devolucion g_devolucion = new Devolucion();
		g_devolucion.generaDevolucion(p_mostrar, parametros[0], parametros[1]);
		
		
	    JOptionPane.showMessageDialog(null,"La devolución se ha realizado con éxito",
					  "Devolución Realizada",JOptionPane.WARNING_MESSAGE);
	    
	    Menu_Principal principal = new Menu_Principal();
		principal.setVisible(true);
		dispose();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==mntmAtras){
			System.out.println("Prestar");
			Menu_Principal principal = new Menu_Principal();
			principal.setVisible(true);
			dispose();
		}
		
		else if (e.getSource()==mntmSalir){
			dispose();
		}
		else if(e.getSource()==btnDevolverLibro){
			generaDevolucion();
			System.out.println("Devolver");
		}
	}

}
