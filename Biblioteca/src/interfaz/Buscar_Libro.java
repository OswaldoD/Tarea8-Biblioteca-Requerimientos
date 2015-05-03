package interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Buscar_Libro extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 04;
	private JPanel contenedor;
	private JMenuItem mntmAtras, mntmSalir;
	private JButton btnBuscar;
	private JTextField txtNombre;
	private JTextField txtAutor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar_Libro frame = new Buscar_Libro();
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
	public Buscar_Libro() {
		
		configuraFrame();
		creaBarraMenu();
		creaBotones();
		creaLabels();
		creaTextFields();
		
	}
	
	private void configuraFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Búsqueda de Libros");
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
		   
	}
	private void creaBotones(){
		   btnBuscar = new JButton("Buscar");
		   btnBuscar.setBounds(308, 212, 89, 23);
		   btnBuscar.addActionListener(this);
		   contenedor.add(btnBuscar);
		  
	}
	private void creaLabels(){
		   JLabel lblNombreDelLibro = new JLabel("Nombre del Libro");
		   lblNombreDelLibro.setBounds(20, 46, 148, 25);
		   contenedor.add(lblNombreDelLibro);
		   
		   JLabel lblAutorDelLibro = new JLabel("Autor del Libro");
		   lblAutorDelLibro.setBounds(20, 114, 148, 25);
		   contenedor.add(lblAutorDelLibro);
		
	}
	private void creaTextFields(){
		   txtNombre = new JTextField();
		   txtNombre.setBounds(96, 82, 140, 20);
		   contenedor.add(txtNombre);
		   txtNombre.setColumns(10);
		   
		   txtAutor = new JTextField();
		   txtAutor.setBounds(96, 163, 140, 20);
		   contenedor.add(txtAutor);
		   txtAutor.setColumns(10);
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
		else if(e.getSource()==btnBuscar){
			Resultados_Busqueda resultados = new Resultados_Busqueda();
			resultados.setVisible(true);
			dispose();
		}
	}
}
