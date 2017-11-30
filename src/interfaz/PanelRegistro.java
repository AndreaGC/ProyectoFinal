package interfaz;

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
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.swing.*;

import logica.CuentaUsuario;

public class PanelRegistro extends JPanel{
	JLabel lblApodo;
	JLabel lblCorreo;
	JLabel lblContrasenia;
	JLabel lblConfirmarContrasenia;
	
	JTextField txtApodo;
	JTextField txtCorreo;
	JPasswordField txtContrasenia;
	JPasswordField txtConfirmarContrasenia;
	
	/** Botones */
	private JButton btnAceptar; 
	private JButton btnCancelar;
	
	/** Objetos del modelo lógico */
	//CuentaUsuario usuario;
	ArrayList <CuentaUsuario> usuarios;
	
	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public PanelRegistro(){
		//1)Crear los objetos gráficos y lógicos
		lblApodo = new JLabel("Usuario: ");
		lblCorreo = new JLabel("Correo Gmail: ");
		lblContrasenia = new JLabel ( "Contraseña: ");
		lblConfirmarContrasenia = new JLabel("Confirmar contraseña: ");
		
		txtApodo = new JTextField(20);
		txtCorreo = new JTextField(20);
		txtContrasenia = new JPasswordField (20);
		txtConfirmarContrasenia = new JPasswordField(20);
		
		btnAceptar = new JButton("Aceptar");
		btnCancelar = new JButton("Cancelar");
		
		usuarios = new ArrayList();
		this.cargarDatos();
		
		// 2)Configuración de los elemntos gráficos
		this.setLayout(new BorderLayout());
		
		lblApodo.setHorizontalAlignment(JLabel.RIGHT);
		lblContrasenia.setHorizontalAlignment(JLabel.RIGHT);
		
		/* Configura los oidores de eventos dde los botones */
		
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
		condiciones.gridy = 6;
		panel.add(this.btnAceptar, condiciones);
		
		condiciones.gridx = 2;
		condiciones.gridy = 6;
		panel.add(this.btnCancelar, condiciones);
		
		/*Adiciona los páneles a la ventana */
		
		this.add (panel, BorderLayout.CENTER);
		this.setVisible (false);
	}
	
	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
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
	public boolean registrar(){
		if(this.verificarDatos()) {
			CuentaUsuario usuario;
			usuario = new CuentaUsuario(this.txtApodo.getText(), this.txtCorreo.getText(), this.txtContrasenia.getText());
			usuario.setEstado(true);
			this.usuarios.add(usuario);
			if(grabarDatos()) {
				JOptionPane.showMessageDialog(this, "Usuario creado exitosamente.");
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean verificarDatos() {
		return verificarDatosCompletos() && verificarCorreo() && verificarContrasenia() && verificarDisponibilidadCuenta();
	}
	
	public boolean verificarDatosCompletos() {
		boolean ok = true;
		
		if (txtApodo.getText().equals("")) {
			ok = false;
		} 
		
		if (txtCorreo.getText().equals("")) {
			ok = false;
		} 
		
		if (txtContrasenia.getText().equals("")) {
			ok = false;
		}
		
		if (!ok) {
			JOptionPane.showMessageDialog(this, "Por favor ingrese todos los campos requeridos.");
		}
		
		return ok;
	}
	
	public boolean verificarCorreo() {
		int indiceArroba = txtCorreo.getText().indexOf("@gmail.com");
		
		if (indiceArroba >= 0) {
			return true;
		} else {
			JOptionPane.showMessageDialog(this, "Ingrese un correo de gmail válido.");
			return false;
		}
	}
	
	public boolean verificarContrasenia() {
		boolean ok = true;
		String textoAVerificar = txtContrasenia.getText();
		
		if (textoAVerificar.length() < 8) {
			JOptionPane.showMessageDialog(this, "La contraseña debe contener al menos 8 carácteres.");
			ok = false;
		} else if (textoAVerificar == textoAVerificar.toLowerCase()) {
			JOptionPane.showMessageDialog(this, "La contraseña debe contener al menos una mayúscula.");
			ok = false;
		} else if (textoAVerificar == textoAVerificar.toUpperCase()) {
			JOptionPane.showMessageDialog(this, "La contraseña debe contener al menos una minúscula.");
			ok = false;
		} 
		
		return ok;
	}
	
	public boolean verificarDisponibilidadCuenta() {
		CuentaUsuario usuario;
		boolean usuarioDisponible = true; 
		
		for(int i=0; i < usuarios.size() && usuarioDisponible; i++) {
			usuario = usuarios.get(i);
			if(usuario.getApodo().equals(txtApodo.getText())){
				JOptionPane.showMessageDialog(this, "El apodo ya está en uso. Pruebe uno diferente.");
				usuarioDisponible = false;
			} else if (usuario.getCorreo().equals(txtCorreo.getText())) {
				JOptionPane.showMessageDialog(this, "El correo ya está en uso.");
				usuarioDisponible = false;
			}
		}
		
		if (!this.txtContrasenia.getText().equals(this.txtConfirmarContrasenia.getText())) {
			JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
			usuarioDisponible = false;
		}
		
		return usuarioDisponible;
	}
	
	/**
	 * Método de persistencia: almacena los datos del usuario en archivo binario 
	 */
	public boolean grabarDatos() {
		try {
			FileOutputStream fout = new FileOutputStream ("./data/usuarios.dat");
			ObjectOutputStream out = new ObjectOutputStream (fout);
			out.writeObject(usuarios);
			out.close();
			fout.close();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,  "Error al crear usuario. Pruebe nuevamente.");
			return false;
		}
	}
	
	/**
	 * Método de persistencia :recupera los datos de usuario desde archivo binario
	 */
	public boolean cargarDatos() {
		try {
			FileInputStream fin = new FileInputStream ("./data/usuarios.dat");
			ObjectInputStream in = new ObjectInputStream (fin);
			usuarios =  (ArrayList<CuentaUsuario>) in.readObject();
			in.close();
			fin.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}


