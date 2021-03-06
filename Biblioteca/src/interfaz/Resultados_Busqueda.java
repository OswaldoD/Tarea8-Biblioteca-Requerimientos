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

import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;

import logica.Busqueda;
/**
 * Instituto Tecnológico de Costa Rica
 * Requerimientos de Software
 * Grupo 1
 * @author Oswaldo Davila - 201222296, Estefanny Porras - 201241100
 * Tarea 8 - Biblioteca
 *
 */
public class Resultados_Busqueda extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contenedor;
	private JMenuItem mntmAtras, mntmSalir;
	private JButton btnConsultar;
	private JTextField txtNConsulta;
	private TextArea txtResultados;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Resultados_Busqueda frame = new Resultados_Busqueda(["",""]);
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
	public Resultados_Busqueda(String parametros_busqueda[]) {
		configuraFrame();
		creaBarraMenu();
		creaBotones();
		creaLabels();
		creaTextArea();
		creaTextFields();
		mostrarBusqueda(parametros_busqueda);
	}
	
	private void configuraFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 303);
		setTitle("Resultado Busquedas");
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
		   btnConsultar = new JButton("Consultar");
		   btnConsultar.setBounds(356, 231, 89, 23);
		   btnConsultar.addActionListener(this);
		   contenedor.add(btnConsultar);
		   		
	}
	
	private void creaLabels(){
		   JLabel lblResultadosEncontrados = new JLabel("Resultados Encontrados");
		   lblResultadosEncontrados.setBounds(23, 36, 171, 19);
		   contenedor.add(lblResultadosEncontrados);
		   
		   JLabel lblIngreseElNmero = new JLabel("Ingrese el n\u00FAmero de libro que desea consultar");
		   lblIngreseElNmero.setBounds(10, 231, 300, 14);
		   contenedor.add(lblIngreseElNmero);
		
	}
	private void creaTextFields(){
		   txtNConsulta = new JTextField();
		   txtNConsulta.setBounds(294, 227, 40, 22);
		   contenedor.add(txtNConsulta);
		   txtNConsulta.setColumns(10);
	}
	private void creaTextArea(){
		   txtResultados = new TextArea();
		   txtResultados.setEditable(false);
		   txtResultados.setBounds(70, 61, 307, 160);
		   contenedor.add(txtResultados);
		
	}
	private void mostrarBusqueda(String parametros_busqueda[]){
		
		Busqueda busqueda = new Busqueda();
	//	System.out.println(busqueda.buscaLibros(parametros_busqueda[0],parametros_busqueda[0]).get(0));
		ArrayList<String> resultados = new ArrayList<String>();
		resultados = busqueda.buscaLibros(parametros_busqueda[0], parametros_busqueda[0]);
		String resultados_mostrar = "";
		for(int i = 0; i<resultados.size();i++){
			resultados_mostrar+= (i+1) +" - "+ resultados.get(i) + "\n";
		
		}
		txtResultados.setText(resultados_mostrar);
	}
	private void mostrarLibro(){
		String tmp = txtNConsulta.getText();
		int opcion = Integer.parseInt(tmp);
		
		Busqueda busqueda = new Busqueda();
		
		Ver_Libro libro = new Ver_Libro(busqueda.buscaCodigoLibro(opcion));
		libro.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==mntmAtras){
			Buscar_Libro buscar = new Buscar_Libro();
			buscar.setVisible(true);
			dispose();
		}
		
		else if (e.getSource()==mntmSalir){
			dispose();
		}
		else if(e.getSource()==btnConsultar){
			mostrarLibro();
			dispose();
		}
	}
}
