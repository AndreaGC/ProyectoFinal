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

import java.io.*;

import javax.swing.*;

import controlador.CuentaUsuario;

public class PanelRegistro extends JPanel implements ActionListener {
	JLabel lblApodo;
	JLabel lblCorreo;
	JLabel lblContrasenia;
	JLabel lblConfirmarContrasenia;
	
	JTextField txtApodo;
	JTextField txtCorreo;
	JTextField txtContrasenia;
	JTextField txtConfirmarContrasenia;
	
	/** Botones */
	JButton btnAceptar; 
	JButton btnCancelar;
	
	/** Objetos del modelo lógico */
	CuentaUsuario usuario;
	
	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public PanelRegistro(){
		//1)Crear los objetos gráficos y lógicos
		lblApodo = new JLabel("Usuario: ");
		lblCorreo = new JLabel("Correo: ");
		lblContrasenia = new JLabel ( "Contraseña: ");
		lblConfirmarContrasenia = new JLabel("Confirmar contraseña: ");
		
		txtApodo = new JTextField(20);
		txtCorreo = new JTextField(20);
		txtContrasenia = new JTextField (20);
		txtConfirmarContrasenia = new JTextField(20);
		
		btnAceptar = new JButton("Aceptar");
		btnCancelar = new JButton("Cancelar");
		
		// 2)Configuración de los elemntos gráficos
		this.setLayout(new BorderLayout());
		
		lblApodo.setHorizontalAlignment(JLabel.RIGHT);
		lblContrasenia.setHorizontalAlignment(JLabel.RIGHT);
		/* Configura los oidores de eventos dde los botones */
		btnAceptar.addActionListener(this);
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
		panel.add(this.lblApodo, condiciones);

		condiciones.gridx = 1;
		condiciones.gridy = 2;
		panel.add(this.lblCorreo, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 3;
		panel.add(this.lblContrasenia, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 4;
		panel.add(this.lblConfirmarContrasenia, condiciones);
		
		condiciones.weightx = 1.0;
		condiciones.gridx = 2;
		condiciones.gridy = 1;
		panel.add(this.txtApodo, condiciones);
		
		condiciones.gridx = 2;
		condiciones.gridy = 2;
		panel.add(this.txtCorreo, condiciones);
		
		condiciones.gridx = 2;
		condiciones.gridy = 3;
		panel.add(this.txtContrasenia, condiciones);
		
		condiciones.gridx = 2;
		condiciones.gridy = 4;
		panel.add(this.txtConfirmarContrasenia, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 5;
		panel.add(this.btnAceptar, condiciones);
		
		condiciones.gridx = 2;
		condiciones.gridy = 5;
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
			this.cancelar();
		} else if (evento.getSource() == btnAceptar) {
			this.aceptar();
		}
	}
	
	/** 
	 * Método de respuesta al botón salir
	 */
	public void cancelar(){
		this.setVisible(false);
	}
	/** 
	 * Método de respuesta al botón autenticar
	 */
	public void aceptar(){
		if(this.txtContrasenia.getText().equals(this.txtConfirmarContrasenia.getText())) {
			usuario = new CuentaUsuario(this.txtApodo.getText(), this.txtCorreo.getText(), this.txtContrasenia.getText());
			if(grabarDatos()) {
				JOptionPane.showMessageDialog(this, "Datos almacenados correctamente");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
		}
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
	
	public void desactivarVisualizacion() {
		this.setVisible(false);
	}
	
	public void activarVisualizacion() {
		this.setVisible(true);
	}
}


