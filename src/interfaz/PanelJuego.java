package interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import javax.swing.*;

import logica.CuentaUsuario;
import logica.Evaluacion;

public class PanelJuego extends JPanel {
	private String enunciado;
	private String respuesta;
	
	private JTextArea txtEnunciado;
	
	private JRadioButton btnVerdadero;
	private JRadioButton btnFalso;
	private ButtonGroup btnRespuestas;
	private JButton btnEnviar;
	
	private Evaluacion evaluacion;
	private ArrayList<CuentaUsuario> usuarios;
	private CuentaUsuario usuario;
	
	private int indice;

	public PanelJuego() {
		indice = (int) (Math.random() * 30);
		evaluacion = new Evaluacion();
		
		if (cargarDatos()) {
			this.usuario = this.buscar();
		}
		
		this.enunciado = evaluacion.getEnunciado(indice);
		this.respuesta = evaluacion.getRespuesta(indice);
		this.txtEnunciado = new JTextArea(this.enunciado);
		
		this.btnFalso = new JRadioButton("Falso");
		this.btnVerdadero = new JRadioButton("Verdadero");
		
		this.btnEnviar = new JButton("Enviar respuesta");
		
		this.btnRespuestas = new ButtonGroup();
		this.btnRespuestas.add(this.btnVerdadero);
		this.btnRespuestas.add(this.btnFalso);
		
		this.setLayout(new GridLayout());
		
		btnFalso.setPreferredSize(new Dimension(250, 50));
		btnVerdadero.setPreferredSize(new Dimension(250, 50));
		
		txtEnunciado.setPreferredSize(new Dimension (400,100));
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(650, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		condiciones.fill = GridBagConstraints.NONE;
		
		condiciones.weightx = 1.0;
		condiciones.weighty = 1.0;
		condiciones.gridx = 1;
		condiciones.gridy = 1;
		panel.add(this.txtEnunciado, condiciones);
			
		condiciones.gridx = 1;
		condiciones.gridy = 2;
		panel.add(this.btnVerdadero, condiciones);
		
		condiciones.gridx = 2;
		condiciones.gridy = 2;
		panel.add(this.btnFalso, condiciones);
		
		condiciones.gridx = 2;
		condiciones.gridy = 3;
		panel.add(this.btnEnviar, condiciones);
		
		
		//Añadir el panel a la ventana
		this.add(panel);
		this.setVisible (false);
	}
	
	public void cambiarIndice() {
		indice = (int) (Math.random() * 30);
		this.enunciado = evaluacion.getEnunciado(indice);
		this.respuesta = evaluacion.getRespuesta(indice);
		
		this.txtEnunciado.setText(enunciado);
	}
	
	public boolean verificarRespuesta() {
		boolean ok = false;
		
		if (this.btnFalso.isSelected()) {
			if (this.respuesta == "Falso") {
				this.usuario.aumentarPuntaje();
				JOptionPane.showMessageDialog(this, "Respuesta correcta.");
				ok = true;
			}
		} else if (this.btnVerdadero.isSelected()) {
			if (this.respuesta == "Verdadero") {
				JOptionPane.showMessageDialog(this, "Respuesta correcta.");
				ok = true;
			}
		}
		
		if (!ok) {
			JOptionPane.showMessageDialog(this, "Respuesta incorrecta.");
		}
		
		return ok;
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
		
		if(encontrado) {
			return usuarioTemp;
		} else {
			return null; 
		}
	}
	
	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	public void setBtnEnviar(JButton btnEnviar) {
		this.btnEnviar = btnEnviar;
	}

}
