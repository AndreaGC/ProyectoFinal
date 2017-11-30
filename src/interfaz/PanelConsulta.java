package interfaz;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

public class PanelConsulta extends JPanel{
	private JButton btnConsultarPDF;
	private JButton btnConsultarDidactico;
	
	private JComboBox cbArticulos;
	
	private String[] articulos = {"7", "10", "14", "16", "17", "18", "21", "27", "28", "29", "30", "31",
			"32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "43", "46", "48", "50", 
			"53", "74", "95", "100", "101", "118", "141", "155", "160", "163", "193"};

	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public PanelConsulta(){
		this.setLayout(new GridLayout());
		
		cbArticulos = new JComboBox(this.articulos);
		btnConsultarPDF  = new JButton("Consultar PDF");
		btnConsultarDidactico = new JButton("Consultar material didáctico");
		
		cbArticulos.setPreferredSize(new Dimension(350, 50));
		btnConsultarPDF.setPreferredSize(new Dimension(400, 50));
		btnConsultarDidactico.setPreferredSize(new Dimension(350, 50));
		
		JPanel panelTemp = new JPanel(new GridBagLayout());
		panelTemp.setPreferredSize(new Dimension(400, 50));
		GridBagConstraints condicionesTemp = new GridBagConstraints();
		
		condicionesTemp.fill = GridBagConstraints.BOTH;
		condicionesTemp.weighty = 1.0;
		condicionesTemp.gridx = 0;
		condicionesTemp.gridy = 0;
		panelTemp.add(this.cbArticulos, condicionesTemp);
		
		condicionesTemp.weightx = 1.0;
		condicionesTemp.gridx = 1;
		condicionesTemp.gridy = 0;
		panelTemp.add(this.btnConsultarDidactico, condicionesTemp);
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(650, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		condiciones.fill = GridBagConstraints.NONE;
		condiciones.insets = new Insets(50, 30, 50, 30);
		condiciones.weightx = 1.0;
		
		condiciones.gridx = 1;
		condiciones.gridy = 1;
		panel.add(this.btnConsultarPDF, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 2;
		panel.add(panelTemp, condiciones);
		
		/*Adiciona los páneles a la ventana */
		this.add(panel);
		this.setVisible (false);
	}
	
	public boolean grabarDatos() {
		try {
			FileOutputStream fout = new FileOutputStream ("./data/normaAConsultar.dat");
			ObjectOutputStream out = new ObjectOutputStream (fout);
			out.writeObject(Integer.parseInt(this.articulos[this.cbArticulos.getSelectedIndex()]));
			out.close();
			fout.close();
			return true;
		} catch (Exception e) {
			return false;
		}
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
