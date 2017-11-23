package visualizacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import controlador.CuentaUsuario;

public class PanelIniciarSesion extends JPanel implements ActionListener {
	
	//Atributos
	/**
	 * Etiquetas
	 */
	JLabel lblUsuario;
	JLabel lblContrasenia;
	
	/** Campos de texto*/
	JTextField txtUsuario;
	JTextField txtContrasenia;
	
	/** Botones */
	JButton btnVerificar;
	JButton btnCancelar;
	
	/** Objetos del modelo lógico */
	CuentaUsuario usuario;
	
	
	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public PanelIniciarSesion(){
		//1)Crear los objetos gráficos y lógicos
		lblUsuario = new JLabel("Usuario: ");
		lblContrasenia = new JLabel ( "Contraseña: ");
		txtUsuario = new JTextField(20);
		txtContrasenia = new JTextField (20);
		btnVerificar = new JButton("Verificar");
		btnCancelar = new JButton("Cancelar");
		
		// 2)Configuración de los elemntos gráficos
		this.setLayout(new BorderLayout());
		lblUsuario.setHorizontalAlignment(JLabel.RIGHT);
		lblUsuario.setFont(new Font (Font.SANS_SERIF,Font.BOLD, 18));
		txtUsuario.setFont(new Font (Font.SANS_SERIF, Font.BOLD, 18));
		lblContrasenia.setFont(new Font (Font.SANS_SERIF,Font.BOLD, 18));
		txtContrasenia.setFont(new Font (Font.SANS_SERIF, Font.BOLD, 18));
		
		lblUsuario.setHorizontalAlignment(JLabel.RIGHT);
		lblContrasenia.setHorizontalAlignment(JLabel.RIGHT);
		/* Configura los oidores de eventos dde los botones */
		btnVerificar.addActionListener(this);
		btnCancelar.addActionListener(this);
		//this.setLayout(new GridLayout(2,2));
		
		// 3) Añadirlos al contenedor 
		
		/* Configura un panel auxiliar para los campos de entrada*/
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(650, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		condiciones.weighty = 1.0;
		condiciones.gridx = 1;
		condiciones.gridy = 1;
		panel.add(this.lblUsuario, condiciones);

		condiciones.gridx = 1;
		condiciones.gridy = 2;
		panel.add(this.lblContrasenia, condiciones);
		
		condiciones.weightx = 1.0;
		condiciones.gridx = 2;
		condiciones.gridy = 1;
		panel.add(this.txtUsuario, condiciones);
		
		condiciones.gridx = 2;
		condiciones.gridy = 2;
		panel.add(this.txtContrasenia, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 3;
		panel.add(this.btnVerificar, condiciones);
		
		condiciones.gridx = 2;
		condiciones.gridy = 3;
		panel.add(this.btnCancelar, condiciones);
		
		/*Adiciona los páneles a la ventana */
		
		this.add (panel, BorderLayout.CENTER);
		this.setVisible (false);
	}
	
	/**
	 * Implementación de las acciones de los botones
	 * @param evento Objeto que encapsula la información del evento capturado
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == btnCancelar) {
			this.salir();
		} else if (evento.getSource() == btnVerificar) {
			this.verificar();
		}
	}
	
	/** 
	 * Método de respuesta al botón salir
	 */
	public void salir(){
		if(grabarDatos())
			JOptionPane.showMessageDialog(this,  "Datos almacenados correctamente");
		System.exit(0);
		//this.setVisible(false);
	}
	/** 
	 * Método de respuesta al botón autenticar
	 */
	public void verificar(){
		if (usuario.validar(txtUsuario.getText(),txtContrasenia.getText()))
			JOptionPane.showMessageDialog(this,"¡Usuario autenticado correctamente!");
		else 
			JOptionPane.showMessageDialog(this,"¡Usuario o contraseña incorrectos!");
	}
	/** 
	 * Método de respuesta al botón salir
	 */
	public void cambiar(){
		usuario.cambiarContrasenia(txtContrasenia.getText(), txtContrasenia.getText());
		JOptionPane.showMessageDialog(this,  "Contraseña cambiada exitosamente");
		txtContrasenia.setText("");
	}
	
	//Estos métodos los tiene la clase ppal
	/**
	 * Método de persistencia: almacena los datos del usuario en archivo binario 
	 */
	public boolean grabarDatos() {
		try {
			FileOutputStream fout = new FileOutputStream ("./data/" + usuario.consultarId() + ".dat");
			ObjectOutputStream out = new ObjectOutputStream (fout);
			out.writeObject(usuario);
			out.close();
			fout.close();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,  "Eror en el almacenamiento de datos. "
					+ "Se perderán los últimos cambios...");
			return false;
		}
	}
		
	/**
	 * Método de persistencia :recupera los datos de usuario desde archivo binario
	 */
	public boolean cargarDatos(String idUsuario) {
		try {
			FileInputStream fin = new FileInputStream ("./data/" + idUsuario + ".dat");
			ObjectInputStream in = new ObjectInputStream (fin);
			usuario = (CuentaUsuario) in.readObject();
			in.close();
			fin.close();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,  "Eror en la lectura de datos. "
					+ "Imposible inicializar usuario...");
			return false;
		}
	}
	
	public void desactivarVisualizacion() {
		this.setVisible(false);
	}
	
	public void activarVisualizacion() {
		this.setVisible(true);
	}

}


