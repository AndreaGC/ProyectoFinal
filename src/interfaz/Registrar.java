package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Registrar extends JPanel implements ActionListener {
	//Atributos
	/**
	 * Etiquetas
	 */
	JLabel lblUser;
	JLabel lblPassword;
	
	/** Campos de texto*/
	JTextField txtUser, txtPassword;
	
	/** Botones */
	JButton  btnCambiar, btnSalir;	
	
	/**
	 * Constructor por omisi�n: Construye la ventana
	 * @param args
	 */
	public Registrar (){
		//1)Crear los objetos gr�ficos y l�gicos
		lblUser = new JLabel("Usuario: ");
		lblPassword = new JLabel ( "Contrase�a: ");
		txtUser = new JTextField(20);
		txtPassword = new JTextField (20);
		btnCambiar = new JButton("Registrar");
		btnSalir = new JButton("Cancelar");
		
		// 2)Configuraci�n de los elemntos gr�ficos
		this.setLayout(new BorderLayout());
		
		lblUser.setHorizontalAlignment(JLabel.RIGHT);
		lblPassword.setHorizontalAlignment(JLabel.RIGHT);
		/* Configura los oidores de eventos dde los botones */
		btnCambiar.addActionListener(this);
		btnSalir.addActionListener(this);
		//this.setLayout(new GridLayout(2,2));
		
		// 3) A�adirlos al contenedor 
		
		/* Configura un panel auxiliar para los campos de entrada*/
		JPanel pe = new JPanel();
		//pe.setBackground(Color.BLACK);
		pe.setPreferredSize (new Dimension (300,50));
		pe.setLayout (new GridLayout (2,2));
		pe.add(lblUser);
		pe.add(txtUser);
		pe.add(lblPassword);
		pe.add(txtPassword);
		
		
		/* Configura un panel auxiliar para los comandos (botones)
		 */
		JPanel pc = new JPanel ();
		pc.setLayout(new FlowLayout());
		pc.add(btnCambiar);
		pc.add(btnSalir);
		
		/*Adiciona los p�neles a la ventana */
		
		this.add (pe, BorderLayout.CENTER);
		this.add (pc, BorderLayout.SOUTH);
	}
	
	/**
	 * Implementaci�n de las acciones de los botones
	 * @param evento Objeto que encapsula la informaci�n del evento capturado
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == btnSalir)
		this.salir();
	}
	
	public void salir(){
		System.exit(0);
	}
	
	public void cambiar(){
		
	}
		
}
