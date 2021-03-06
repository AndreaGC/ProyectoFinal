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
	private JTextArea txtPerfil;
	
	private JButton btnCambiarContrasenia;
	private JButton btnCerrarSesion;
	
	private CuentaUsuario usuario;
	private ArrayList <CuentaUsuario> usuarios;
	
	/**
	 * Constructor por omisi�n: Construye la ventana
	 * @param args
	 */
	public PanelPerfil(){
		this.usuarios = new ArrayList();
		cargarDatos();
		
		this.usuario = this.buscar();
		
		if (this.usuario == null) {
			this.txtPerfil = new JTextArea("None");
		} else {
			this.txtPerfil = new JTextArea(this.usuario.getApodo() + " (" + this.usuario.getPuntos() + ")");
		}
		
		this.btnCambiarContrasenia  = new JButton("Cambiar contrase�a");
		this.btnCerrarSesion = new JButton("Cerrar Sesion");
		
		// 2)Configuraci�n de los elemntos gr�ficos
		this.setLayout(new GridLayout());
		
		this.btnCambiarContrasenia.setBackground(Color.WHITE);
		this.btnCerrarSesion.setBackground(Color.WHITE);
		this.btnCambiarContrasenia.setPreferredSize(new Dimension(200, 50));
		this.btnCerrarSesion.setPreferredSize(new Dimension(200, 50));
		
		this.txtPerfil.setPreferredSize(new Dimension(450, 200));
		this.txtPerfil.setFont(new Font("Monospaced", Font.BOLD, 70));
		this.txtPerfil.setLineWrap(true);
		this.txtPerfil.setWrapStyleWord(true);
		this.txtPerfil.setOpaque(false);
		this.txtPerfil.setEditable(false);
		
		// 3) A�adirlos al contenedor 
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(650, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		condiciones.fill = GridBagConstraints.NONE;
		
		condiciones.gridwidth = 2;
		condiciones.gridx = 1;
		condiciones.gridy = 1;
		panel.add(this.txtPerfil, condiciones);
		
		condiciones.gridwidth = 1;
		condiciones.weightx = 1.0;
		condiciones.gridx = 1;
		condiciones.gridy = 2;
		panel.add(this.btnCambiarContrasenia, condiciones);
		
		condiciones.gridwidth = 1;
		condiciones.gridx = 2;
		condiciones.gridy = 2;
		panel.add(this.btnCerrarSesion, condiciones);
		
		this.add(panel);
		this.setVisible(false);
	}
	
	public void cerrarSesion() {
		this.usuario.setEstado(false);
		this.grabarDatos();
	}
	
	public void actualizar() {
		this.cargarDatos();
		this.usuario = this.buscar();
		this.txtPerfil = new JTextArea(this.usuario.getApodo() + " (" + this.usuario.getPuntos() + ")");
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
