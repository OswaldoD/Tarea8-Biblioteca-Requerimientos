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

public class Buscar_Prestamo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contenedor;
	private JMenuItem mntmAtras, mntmSalir;
	private JButton btnBuscar;
	private JLabel lblIdentificacion;
	private JTextField txtIdentificacion;
	private JTextField txtCodigo;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar_Prestamo frame = new Buscar_Prestamo();
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
	public Buscar_Prestamo() {
		configuraFrame();
		creaBarraMenu();
		creaBotones();
		creaLabels();
		creaTextFields();
	}
	
	private void configuraFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Búsqueda de Préstamos");
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
		   btnBuscar.addActionListener(this);
		   btnBuscar.setBounds(335, 212, 89, 23);
		   contenedor.add(btnBuscar);
		   	
	}
	
	private void creaLabels(){
		   lblIdentificacion = new JLabel("Ingrese un n\u00FAmero de identificaci\u00F3n v\u00E1lido");
		   lblIdentificacion.setBounds(21, 46, 400, 14);
		   contenedor.add(lblIdentificacion);
		   
		   JLabel lblIngreseElCdigo = new JLabel("Ingrese el c\u00F3digo del libro");
		   lblIngreseElCdigo.setBounds(21, 125, 200, 14);
		   contenedor.add(lblIngreseElCdigo);
	}
	private void creaTextFields(){
		   txtIdentificacion = new JTextField();
		   txtIdentificacion.setBounds(101, 88, 150, 20);
		   contenedor.add(txtIdentificacion);
		   txtIdentificacion.setColumns(10);
		   
		   txtCodigo = new JTextField();
		   txtCodigo.setBounds(101, 163, 150, 20);
		   contenedor.add(txtCodigo);
		   txtCodigo.setColumns(10);
	}
	private void muestraPrestamo(){
		String parametros[] = new String[2];
		parametros[0] = txtIdentificacion.getText();
		parametros[1] = txtCodigo.getText();
		
		Ver_Prestamo prestamo = new Ver_Prestamo(parametros);
		prestamo.setVisible(true);
		
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
			/*
			Resultados_Prestamos resultados = new Resultados_Prestamos();
			resultados.setVisible(true);*/
			muestraPrestamo();
			dispose();
		}
	}
}
