package interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

public class PanelIniciarJuego extends JPanel {
	
	//Atributos
	/**
	 * Etiqueta de instrucciones sobre el juego
	 */
	private JTextField txtInstruccionDeJuego;
	
	/**
	 * Bot�n para empezar a jugar
	 */
	private JButton btnEmpezarJuego;
	
	//M�todos
	
	/**
	 * Constructor por defecto: construye la ventana.
	 */
	public PanelIniciarJuego() {
		this.setLayout(new GridLayout());
		
		txtInstruccionDeJuego  = new JTextField("Juega y descubre qu� tanto conoces del c�digo de polic�a.\n "
				+ "Responde a los enunciados s� o no para determinar si son verdaderos o falsos.");
		btnEmpezarJuego = new JButton("Empezar a jugar");

		btnEmpezarJuego.setPreferredSize(new Dimension(350, 50));
		
		txtInstruccionDeJuego.setPreferredSize(new Dimension(450,100));
		txtInstruccionDeJuego.setOpaque(false);
		txtInstruccionDeJuego.setEditable(false);
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(650, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		condiciones.fill = GridBagConstraints.NONE;
		
		condiciones.weightx = 1.0;
		condiciones.weighty = 1.0;
		condiciones.gridx = 1;
		condiciones.gridy = 1;
		panel.add(this.txtInstruccionDeJuego, condiciones);
			
		condiciones.gridx = 1;
		condiciones.gridy = 2;
		panel.add(this.btnEmpezarJuego, condiciones);
		
		
		//A�adir el panel a la ventana
		this.add(panel);
		this.setVisible (false);
	}
	
	/**
	 * M�todos getters / setters 
	 * @return
	 */
	public JTextField getTxtInstruccionDeJuego() {
		return txtInstruccionDeJuego;
	}

	public void setLblInstrucci�nDeJuego(JTextField txtInstruccionDeJueg) {
		this.txtInstruccionDeJuego = txtInstruccionDeJuego;
	}

	public JButton getBtnEmpezarJuego() {
		return btnEmpezarJuego;
	}

	public void setBtnEmpezarJuego(JButton btnEmpezarJuego) {
		this.btnEmpezarJuego = btnEmpezarJuego;
	}
	
}
