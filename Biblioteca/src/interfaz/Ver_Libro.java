package interfaz;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import logica.Busqueda;

import javax.swing.JTextField;
/**
 * Instituto Tecnológico de Costa Rica
 * Requerimientos de Software
 * Grupo 1
 * @author Oswaldo Davila - 201222296, Estefanny Porras - 201241100
 * Tarea 8 - Biblioteca
 *
 */
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
	private JLabel lblInformacinDelLibro;
	private TextArea txtResultados;


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
		creaTextArea();
		mostrarLibro(clibro);
		this.clibro=clibro;
	}
	
	private void configuraFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 326);
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
		   btnSolicitarPrstamo.setBounds(251, 245, 150, 25);
		   btnSolicitarPrstamo.addActionListener(this);
		   contenedor.add(btnSolicitarPrstamo);
		   		
	}
	private void creaLabels(){
		   JLabel lblIdentificacion = new JLabel("Ingrese un n\u00FAmero de identificaci\u00F3n v\u00E1lido");
		   lblIdentificacion.setBounds(10, 225, 400, 14);
		   contenedor.add(lblIdentificacion);
		   
		   lblInformacinDelLibro = new JLabel("Informaci\u00F3n del libro");
		   lblInformacinDelLibro.setBounds(10, 34, 120, 14);
		   contenedor.add(lblInformacinDelLibro);
		
	}
	private void creaTextFields(){
		   txtIdU = new JTextField();
		   txtIdU.setBounds(121, 245, 120, 20);
		   contenedor.add(txtIdU);
		   txtIdU.setColumns(10);
		   
	}
	private void creaTextArea(){
		   txtResultados = new TextArea();
		   txtResultados.setEditable(false);
		   txtResultados.setBounds(70, 61, 307, 160);
		   contenedor.add(txtResultados);
		
	}
	
	
	
	private void mostrarLibro(String clibro){
		//ArrayList<String> libro = new ArrayList<String>();
		
		Busqueda carga_libro = new Busqueda();
		libro = carga_libro.cargaLibro(clibro);
		
		String resultados_mostrar = "";
		for(int i = 0; i<libro.size();i++){
			resultados_mostrar+= libro.get(i) + "\n";
		
		}
		
		txtResultados.setText(resultados_mostrar);
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
			Buscar_Libro buscar = new Buscar_Libro();
			buscar.setVisible(true);	
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
