package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;

import logica.Comentario;
import logica.CuentaUsuario;

public class PanelComentario extends JPanel {

	//Atributos
	/**
	 * Texto instructivo sobre el comentario
	 */
	private JTextArea txtInstruccionComentario; 
	
	/**
	 * Campo de texto para realizar el comentario
	 */
	private JTextArea txtComentario;
	
	/**
	 * Botón para enviar comentario
	 */
	private JButton btnEnviarComentario;
	
	/**
	 * Arreglo de comentarios de la base de datos
	 */
	private ArrayList<Comentario> comentarios;
	
	/**
	 * Arreglo de usuarios
	 */
	private ArrayList<CuentaUsuario> usuarios;

	/**
	 * Apodo del usuario activo
	 */
	private CuentaUsuario usuario;
	
	public PanelComentario() {
		this.txtInstruccionComentario = new JTextArea("Como civil tienes la misión de retroalimentar "
				+ "la normativa que se implementa en tu país. Para esto, puedes comentar sobre el código "
				+ "de policía en el siguiente espacio. ");
		this.txtComentario = new JTextArea();
		
		this.btnEnviarComentario = new JButton("Enviar comentario");
		
		cargarDatos();
		usuario = buscar();
		
		this.setLayout(new GridLayout());
		
		this.txtInstruccionComentario.setPreferredSize(new Dimension(400,50));
		this.txtInstruccionComentario.setLineWrap(true);
		this.txtInstruccionComentario.setWrapStyleWord(true);
		this.txtInstruccionComentario.setOpaque(false);
		this.txtInstruccionComentario.setEditable(false);
		
		this.txtComentario.setPreferredSize(new Dimension(300, 250));
		this.txtComentario.setBorder(BorderFactory.createLineBorder(Color.black));
		this.btnEnviarComentario.setPreferredSize(new Dimension (150,50));
		
		JPanel pa = new JPanel(new GridBagLayout());
		pa.setPreferredSize(new Dimension (650, 450));
		GridBagConstraints cond = new GridBagConstraints();
		
		cond.fill = GridBagConstraints.NONE;
		cond.weighty = 1.0;
		cond.gridx = 1;
		cond.gridy = 1;
		pa.add(txtInstruccionComentario, cond);
		
		cond.weighty = 1.0;
		cond.gridx = 1;
		cond.gridy = 2;
		pa.add(txtComentario, cond);
		
		cond.weighty = 1.0;
		cond.gridx = 1;
		cond.gridy = 3;
		pa.add(btnEnviarComentario, cond);
		
		this.add(pa);
		this.setVisible(false);
		
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
	
	public void enviarComentario() {
		if (usuario == null) {
			Comentario comentario = new Comentario(this.usuario, this.txtComentario.getText());
			this.comentarios.add(comentario);
			this.grabarDatos();
		} else {
			JOptionPane.showMessageDialog(this, "No se ha podido enviar el comentario. Inicie sesión y pruebe nuevamente.");
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
	
	public boolean grabarDatos() {
		try {
			FileOutputStream fout = new FileOutputStream ("./data/comentarios.dat");
			ObjectOutputStream out = new ObjectOutputStream (fout);
			out.writeObject(usuarios);
			out.close();
			fout.close();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,  "Eror en el almacenamiento de datos. "
					+ "Se perderán los últimos cambios...");
			return false;
		}
	}
}
