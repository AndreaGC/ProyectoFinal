package visualizacion;

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

public class PanelSugerencias extends JPanel implements ActionListener{
	private JTextArea txtInstruccion;
	private JTextArea txtDescripcion;
	private JTextArea txtEmail;
	
	private JButton btnEnviarSugerencia;
	private JButton btnRegresar;
	
	private JLabel imagen;
	
	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public PanelSugerencias(){
		//1)Crear los objetos gráficos y lógicos
		txtInstruccion = new JTextArea("Para nostros es muy importante saber qué piensan los usuarios de esta aplicación, "
				+ "¿qué dices tú? Escribe aquí tu sugerencia");
		txtEmail = new JTextArea("Escribe aquí tu correo electrónico");
		txtDescripcion = new JTextArea("Fuck you putooooos");
		
		btnEnviarSugerencia  = new JButton("Enviar denuncia");
		btnRegresar = new JButton("Regresar");
		
		// 2)Configuración de los elemntos gráficos
		this.setLayout(new GridLayout());
		
		btnEnviarSugerencia.setBackground(Color.WHITE);
		btnRegresar.setBackground(Color.WHITE);
		btnEnviarSugerencia.setPreferredSize(new Dimension(150, 40));
		btnRegresar.setPreferredSize(new Dimension(150, 40));
		
		txtDescripcion.setPreferredSize(new Dimension(300, 40));
		txtEmail.setPreferredSize(new Dimension(300, 40));
		
		txtEmail.setBorder(BorderFactory.createLineBorder(Color.black));
		txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.black));
		
		txtInstruccion.setPreferredSize(new Dimension(300,50));
		txtInstruccion.setLineWrap(true);
		txtInstruccion.setWrapStyleWord(true);
		txtInstruccion.setOpaque(false);
		txtInstruccion.setEditable(false);
				
		this.imagen = new JLabel();
		
		/* Configura los oidores de eventos de los botones */
		btnEnviarSugerencia.addActionListener(this);
		btnRegresar.addActionListener(this);
		
		// 3) Añadirlos al contenedor 
		/* Configura un panel auxiliar para los campos de entrada*/
		JPanel pa = new JPanel(new GridBagLayout());
		pa.setPreferredSize(new Dimension (400, 300));
		GridBagConstraints cond = new GridBagConstraints();
		
		cond.insets = new Insets(5, 5, 5, 5);
		cond.fill = GridBagConstraints.HORIZONTAL;
		cond.gridx = 1;
		cond.gridy = 3;
		pa.add(txtEmail, cond);
		
		cond.fill = GridBagConstraints.BOTH;
		cond.weighty = 1.0;
		cond.gridx = 1;
		cond.gridy = 2;
		pa.add(txtDescripcion, cond);
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(650, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		condiciones.fill = GridBagConstraints.NONE;
		
		condiciones.weightx = 1.0;
		condiciones.weighty = 1.0;
		condiciones.gridx = 1;
		condiciones.gridy = 1;
		panel.add(this.txtInstruccion, condiciones);
		
		condiciones.weightx = 0.0;
		condiciones.gridx = 2;
		condiciones.gridy = 1;
		panel.add(this.imagen, condiciones);
		
		condiciones.gridwidth = 2;
		condiciones.weightx = 1.0;
		condiciones.gridx = 1;
		condiciones.gridy = 3;
		panel.add(this.btnEnviarSugerencia, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 2;
		panel.add(pa, condiciones);


		/*Adiciona los páneles a la ventana */
		this.add (panel);
		this.setVisible (false);
	}
	
	public void desactivarVisualizacion() {
		this.setVisible(false);
	}
	
	public void activarVisualizacion() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
}
