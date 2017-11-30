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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;

import logica.CuentaUsuario;

public class PanelIniciarSesion extends JPanel {
	
	//Atributos
	/**
	 * Etiquetas
	 */
	JLabel lblUsuario;
	JLabel lblContrasenia;
	
	/** Campos de texto*/
	JTextField txtUsuario;
	JPasswordField txtContrasenia;
	
	/** Botones */
	private JButton btnVerificar;
	private JButton btnCancelar;
	
	ArrayList <CuentaUsuario> usuarios;
	
	public JButton getBtnVerificar() {
		return btnVerificar;
	}

	public void setBtnVerificar(JButton btnVerificar) {
		this.btnVerificar = btnVerificar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	/** Objetos del modelo l�gico */
	CuentaUsuario usuario;
	
	
	/**
	 * Constructor por omisi�n: Construye la ventana
	 * @param args
	 */
	public PanelIniciarSesion(){
		//1)Crear los objetos gr�ficos y l�gicos
		lblUsuario = new JLabel("Usuario: ");
		lblContrasenia = new JLabel ( "Contrase�a: ");
		txtUsuario = new JTextField(20);
		txtContrasenia = new JPasswordField(20);
		btnVerificar = new JButton("Verificar");
		btnCancelar = new JButton("Cancelar");
		
		usuarios = new ArrayList();
		
		// 2)Configuraci�n de los elemntos gr�ficos
		this.setLayout(new BorderLayout());
		lblUsuario.setHorizontalAlignment(JLabel.RIGHT);
		lblUsuario.setFont(new Font (Font.SANS_SERIF,Font.BOLD, 18));
		txtUsuario.setFont(new Font (Font.SANS_SERIF, Font.BOLD, 18));
		lblContrasenia.setFont(new Font (Font.SANS_SERIF,Font.BOLD, 18));
		txtContrasenia.setFont(new Font (Font.SANS_SERIF, Font.BOLD, 18));
		
		lblUsuario.setHorizontalAlignment(JLabel.RIGHT);
		lblContrasenia.setHorizontalAlignment(JLabel.RIGHT);
		
		// 3) A�adirlos al contenedor 
		
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
		
		/*Adiciona los p�neles a la ventana */
		
		this.add (panel, BorderLayout.CENTER);
		this.setVisible (false);
	}
	
	/** 
	 * M�todo de respuesta al bot�n autenticar
	 */
	public boolean verificar(){
		this.cargarDatos();
		this.usuario = this.buscar();
		if (this.usuario != null) {
			if (usuario.iniciarSesion(txtUsuario.getText(), txtContrasenia.getText())) {
				this.usuario.setEstado(true);
				grabarDatos();
				return true;
			} else {
				JOptionPane.showMessageDialog(this,"�Usuario o contrase�a incorrectos!");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Usuario inexistente.");
			return false;
		}
	}
	
	/**
	 * M�todo de persistencia: almacena los datos del usuario en archivo binario 
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
			JOptionPane.showMessageDialog(this,  "Eror en el almacenamiento de datos. "
					+ "Se perder�n los �ltimos cambios...");
			return false;
		}
	}
		
	/**
	 * M�todo de persistencia :recupera los datos de usuario desde archivo binario
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
	
	/** 
	 * M�todo auxiliar para buscar un usuario en el arreglo
	 */
	public CuentaUsuario buscar() {
		CuentaUsuario usuario = null;
		boolean encontrado = false; 
		
		System.out.println(usuarios.size());
		for(int i=0; i< usuarios.size() && !encontrado; i++) {
			usuario = usuarios.get(i);
			System.out.println(usuario.getApodo() + "*******" + usuario.getCorreo());
			if(usuario.getApodo().equals(txtUsuario.getText()) || usuario.getCorreo().equals(txtUsuario.getText())){
				encontrado=true;
			}
		}
		
		if (encontrado) {
			return usuario;
		} else {
			return null;
		}
	}
}


