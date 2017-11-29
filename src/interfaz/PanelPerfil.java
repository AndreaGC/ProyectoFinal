package interfaz;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;

import logica.*;

public class PanelPerfil extends JPanel{
	private JTextArea txtApodo;
	private JTextArea txtPuntos;
	
	private JButton btnCambiarContrasenia;
	private JButton btnCerrarSesion;
	
	private CuentaUsuario usuario;
	private ArrayList <CuentaUsuario> usuarios;
	
	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public PanelPerfil(){
		this.usuarios = new ArrayList();
		cargarDatos();
		
		this.usuario = this.buscar();
		
		this.txtApodo = new JTextArea();
		this.txtPuntos = new JTextArea();
		
		this.btnCambiarContrasenia  = new JButton("Cambiar contraseña");
		this.btnCerrarSesion = new JButton("Cerrar Sesion");
		
		// 2)Configuración de los elemntos gráficos
		this.setLayout(new GridLayout());
		
		this.btnCambiarContrasenia.setBackground(Color.WHITE);
		this.btnCerrarSesion.setBackground(Color.WHITE);
		this.btnCambiarContrasenia.setPreferredSize(new Dimension(150, 40));
		this.btnCerrarSesion.setPreferredSize(new Dimension(150, 40));
		
		this.txtApodo.setPreferredSize(new Dimension(300, 300));
		this.txtPuntos.setPreferredSize(new Dimension(300, 300));
		
		this.txtApodo.setLineWrap(true);
		this.txtApodo.setWrapStyleWord(true);
		this.txtApodo.setOpaque(false);
		this.txtApodo.setEditable(false);
		
		this.txtPuntos.setLineWrap(true);
		this.txtPuntos.setWrapStyleWord(true);
		this.txtPuntos.setOpaque(false);
		this.txtPuntos.setEditable(false);
				
		// 3) Añadirlos al contenedor 
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(650, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		condiciones.fill = GridBagConstraints.NONE;
		
		condiciones.gridwidth = 2;
		condiciones.weightx = 1.0;
		condiciones.weighty = 1.0;
		condiciones.gridx = 1;
		condiciones.gridy = 1;
		panel.add(this.txtApodo, condiciones);
		
		condiciones.weightx = 0.0;
		condiciones.gridx = 1;
		condiciones.gridy = 2;
		panel.add(this.txtPuntos, condiciones);
		
		condiciones.gridwidth = 1;
		condiciones.weightx = 1.0;
		condiciones.gridx = 1;
		condiciones.gridy = 3;
		panel.add(this.btnCambiarContrasenia, condiciones);
		
		condiciones.gridwidth = 1;
		condiciones.gridx = 2;
		condiciones.gridy = 3;
		panel.add(this.btnCerrarSesion, condiciones);
		
		this.add(panel);
		this.setVisible(false);
	}
	
	public void cerrarSesion() {
		this.usuario.setEstado(false);
		this.grabarDatos();
	}
	
	public boolean grabarDatos() {
		try {
			FileOutputStream fout = new FileOutputStream ("./data/usuarios.dat");
			ObjectOutputStream out = new ObjectOutputStream (fout);
			out.writeObject(usuarios);
			out.close();
			fout.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
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
	
	public CuentaUsuario buscar() {
		CuentaUsuario usuarioTemp = null;
		boolean encontrado = false; 
		
		for(int i=0; i< usuarios.size() && !encontrado; i++) {
			usuarioTemp = usuarios.get(i);
			if(usuarioTemp.getEstado()){
				encontrado=true;
			}
		}
		
		if (encontrado) {
			return usuarioTemp;
		} else {
			return null;
		}
	}
	
	public JButton getBtnCambiarContrasenia() {
		return btnCambiarContrasenia;
	}

	public void setBtnCambiarContrasenia(JButton btnCambiarContrasenia) {
		this.btnCambiarContrasenia = btnCambiarContrasenia;
	}

	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	public void setBtnCerrarSesion(JButton btnCerrarSesion) {
		this.btnCerrarSesion = btnCerrarSesion;
	}
}
