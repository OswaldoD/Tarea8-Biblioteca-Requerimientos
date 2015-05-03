package interfaz;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Resultados_Prestamos extends JFrame implements ActionListener{

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
					Resultados_Prestamos frame = new Resultados_Prestamos();
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
	public Resultados_Prestamos() {
		configuraFrame();
		creaBarraMenu();
		creaBotones();
		creaLabels();
		creaTextArea();
		creaTextFields();
		
	}
	
	private void configuraFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 303);
		setTitle("Resultados Préstamos");
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
		   btnConsultar.setBounds(372, 231, 89, 23);
		   btnConsultar.addActionListener(this);
		   contenedor.add(btnConsultar);
	}
	private void creaLabels(){
		   JLabel lblResultadosEncontrados = new JLabel("Resultados Encontrados");
		   lblResultadosEncontrados.setBounds(23, 36, 171, 19);
		   contenedor.add(lblResultadosEncontrados);
		   
		   JLabel lblIngreseElNmero = new JLabel("Ingrese el n\u00FAmero de pr\u00E9stamo que desea consultar");
		   lblIngreseElNmero.setBounds(10, 231, 300, 14);
		   contenedor.add(lblIngreseElNmero);
		
	}
	private void creaTextFields(){
		   txtNConsulta = new JTextField();
		   txtNConsulta.setBounds(321, 231, 40, 22);
		   contenedor.add(txtNConsulta);
		   txtNConsulta.setColumns(10);
	}
	private void creaTextArea(){
		   txtResultados = new TextArea();
		   txtResultados.setEditable(false);
		   txtResultados.setBounds(70, 61, 307, 160);
		   contenedor.add(txtResultados);
		
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
		else if(e.getSource()==btnConsultar){
			Ver_Prestamo prestamo = new Ver_Prestamo();
			prestamo.setVisible(true);
			dispose();
		}
	}

}
