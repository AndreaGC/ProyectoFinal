package interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelUsuario extends JPanel {
	private boolean sesionIniciada;
	
	private JButton btnIniciarSesion;
	private JButton btnRegistrar;
	
	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public PanelUsuario(){
		this.setLayout(new GridLayout());
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(650, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		btnIniciarSesion  = new JButton("Iniciar sesión");
		btnRegistrar = new JButton("Registrar");

		btnIniciarSesion.setPreferredSize(new Dimension(350, 50));
		btnRegistrar.setPreferredSize(new Dimension(350, 50));
			
		condiciones.fill = GridBagConstraints.NONE;
		condiciones.insets = new Insets(30, 30, 30, 30);
		condiciones.weightx = 1.0;
		condiciones.gridx = 1;
		condiciones.gridy = 1;
		panel.add(this.btnIniciarSesion, condiciones);
			
		condiciones.gridx = 1;
		condiciones.gridy = 2;
		panel.add(this.btnRegistrar, condiciones);
		
		/*Adiciona los páneles a la ventana */
		this.add(panel);
		this.setVisible (false);
	}
}
