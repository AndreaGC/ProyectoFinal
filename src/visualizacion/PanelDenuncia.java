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
import javax.swing.JTextField;

public class PanelDenuncia extends JPanel implements ActionListener{
	private JTextArea txtInstruccion;
	private JTextField txtNorma;
	private JTextArea txtDescripcion;
	private JTextArea txtPrueba;
	private JTextArea txtUbicacion;
	private JTextField txtFecha;
	private JTextField txtEmail;
	
	private JButton btnEnviarDenuncia;
	private JButton btnRegresar;
	
	private JLabel imagen;
	
	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public PanelDenuncia(){
		//1)Crear los objetos gráficos y lógicos
		txtInstruccion = new JTextArea("Completa la información, envía la denuncia y te llegará una confirmación a tu correo");
		txtDescripcion = new JTextArea("Descripción");
		txtNorma = new JTextField("Norma");
		txtEmail = new JTextField("Email");
		
		btnEnviarDenuncia  = new JButton("Enviar denuncia");
		btnRegresar = new JButton("Regresar");
		
		// 2)Configuración de los elemntos gráficos
		this.setLayout(new GridLayout());
		
		btnEnviarDenuncia.setBackground(Color.WHITE);
		btnRegresar.setBackground(Color.WHITE);
		btnEnviarDenuncia.setPreferredSize(new Dimension(150, 40));
		btnRegresar.setPreferredSize(new Dimension(150, 40));
		
		txtInstruccion.setPreferredSize(new Dimension(100, 40));
		txtNorma.setPreferredSize(new Dimension(100, 40));
		txtDescripcion.setPreferredSize(new Dimension(100, 40));
		txtEmail.setPreferredSize(new Dimension(100, 40));
		
		txtNorma.setBorder(BorderFactory.createLineBorder(Color.black));
		txtEmail.setBorder(BorderFactory.createLineBorder(Color.black));
		txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.black));
		
		txtInstruccion.setPreferredSize(new Dimension(300,40));
		txtInstruccion.setLineWrap(true);
		txtInstruccion.setOpaque(false);
		txtInstruccion.setEditable(false);
				
		this.imagen = new JLabel();
		
		/* Configura los oidores de eventos de los botones */
		btnEnviarDenuncia.addActionListener(this);
		btnRegresar.addActionListener(this);
		
		// 3) Añadirlos al contenedor 
		/* Configura un panel auxiliar para los campos de entrada*/
		JPanel pa = new JPanel(new GridBagLayout());
		pa.setPreferredSize(new Dimension (300, 300));
		GridBagConstraints cond = new GridBagConstraints();
		
		cond.insets = new Insets(5, 5, 5, 5);
		cond.fill = GridBagConstraints.HORIZONTAL;
		cond.gridx = 1;
		cond.gridy = 3;
		pa.add(txtEmail, cond);
		
		cond.weightx = 1.0;
		cond.gridx = 1;
		cond.gridy = 1;
		pa.add(txtNorma,cond);
		
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
		condiciones.gridy = 5;
		panel.add(this.btnEnviarDenuncia, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 1;
		panel.add(this.txtInstruccion, condiciones);
		
		condiciones.gridx = 2;
		condiciones.gridy = 1;
		panel.add(this.imagen, condiciones);
		
		condiciones.gridwidth = 2;
		condiciones.gridx = 1;
		condiciones.gridy = 2;
		panel.add(pa, condiciones);

		/*Adiciona los páneles a la ventana */
		this.add (panel);
		this.setVisible(false);
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
