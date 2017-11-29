package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelConsulta extends JPanel{
	private JButton btnConsultarPDF;
	private JButton btnConsultarDidactico;

	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public PanelConsulta(){
		this.setLayout(new GridLayout());
		
		btnConsultarPDF  = new JButton("Consultar PDF");
		btnConsultarDidactico = new JButton("Consultar material didáctico");

		btnConsultarPDF.setPreferredSize(new Dimension(350, 50));
		btnConsultarDidactico.setPreferredSize(new Dimension(350, 50));
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(650, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		condiciones.fill = GridBagConstraints.NONE;
		
		condiciones.insets = new Insets(30, 30, 30, 30);
		condiciones.weightx = 1.0;
		condiciones.gridx = 1;
		condiciones.gridy = 1;
		panel.add(this.btnConsultarPDF, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 2;
		panel.add(this.btnConsultarDidactico, condiciones);
		
		/*Adiciona los páneles a la ventana */
		this.add(panel);
		this.setVisible (false);
	}
	
	public JButton getBtnConsultarPDF() {
		return btnConsultarPDF;
	}

	public void setBtnConsultarPDF(JButton btnConsultarPDF) {
		this.btnConsultarPDF = btnConsultarPDF;
	}

	public JButton getBtnConsultarDidactico() {
		return btnConsultarDidactico;
	}

	public void setBtnConsultarDidactico(JButton btnConsultarDidactico) {
		this.btnConsultarDidactico = btnConsultarDidactico;
	}
}
