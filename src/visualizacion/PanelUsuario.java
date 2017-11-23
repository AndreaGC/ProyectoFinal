package visualizacion;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelUsuario extends JPanel implements ActionListener{
	private boolean sesionIniciada;
	
	private JButton btnIniciarSesion;
	private JButton btnRegistrar;
	protected PanelRegistro pnlRegistro;
	protected PanelIniciarSesion pnlSesion;
	
	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public PanelUsuario(){
		this.setLayout(new GridLayout());
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(650, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		if (!sesionIniciada) {
			pnlRegistro = new PanelRegistro();
			pnlSesion = new PanelIniciarSesion();
			
			btnIniciarSesion  = new JButton("Iniciar sesión");
			btnRegistrar = new JButton("Registrar");

			btnIniciarSesion.setPreferredSize(new Dimension(350, 50));
			btnRegistrar.setPreferredSize(new Dimension(350, 50));
			
			btnIniciarSesion.addActionListener(this);
			btnRegistrar.addActionListener(this);
			
			condiciones.fill = GridBagConstraints.NONE;
			
			condiciones.insets = new Insets(30, 30, 30, 30);
			condiciones.weightx = 1.0;
			condiciones.gridx = 1;
			condiciones.gridy = 1;
			panel.add(this.btnIniciarSesion, condiciones);
			
			condiciones.gridx = 1;
			condiciones.gridy = 2;
			panel.add(this.btnRegistrar, condiciones);
		}
		
		/*Adiciona los páneles a la ventana */
		this.add(panel);
		this.setVisible (false);
	}
	
	public void desactivarVisualizacion() {
		this.setVisible(false);
	}
	
	public void activarVisualizacion() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == this.btnRegistrar) {
			this.setVisible(false);
			this.pnlRegistro.activarVisualizacion();
		} else if (evento.getSource() == this.btnIniciarSesion) {
			this.setVisible(true);
			this.pnlSesion.activarVisualizacion();
		} 
	}
}
