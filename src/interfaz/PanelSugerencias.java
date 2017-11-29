package interfaz;

import java.awt.*;

import javax.swing.*;

import logica.Correo;

public class PanelSugerencias extends JPanel{
	private JLabel lblContrasenia;
	
	private JPasswordField txtContrasenia;
	private JTextArea txtInstruccion;
	private JTextArea txtDescripcion;
	
	private JButton btnEnviarSugerencia;
	private JButton btnCancelar;
	
	private JCheckBox cbPrivado;
	
	private Correo correo;
	
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public void setBtnEnviarSugerencia(JButton btnEnviarSugerencia) {
		this.btnEnviarSugerencia = btnEnviarSugerencia;
	}

	private JLabel imagen;
	
	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public PanelSugerencias(){
		//1)Crear los objetos gráficos y lógicos
		this.txtInstruccion = new JTextArea("Para nostros es muy importante saber qué piensan los usuarios"
				+ " de esta aplicación, ¿qué dices tú? Escribe aquí tu sugerencia");
		this.txtDescripcion = new JTextArea("");
		this.txtContrasenia = new JPasswordField(20);
		
		this.lblContrasenia = new JLabel("Contraseña de Gmail (En caso de envío privado omitir): ");
		
		this.btnEnviarSugerencia  = new JButton("Enviar sugerencia");
		this.btnCancelar = new JButton("Regresar");
		this.cbPrivado = new JCheckBox("Mensaje privado");
		
		// 2)Configuración de los elemntos gráficos
		this.setLayout(new GridLayout());
		
		btnEnviarSugerencia.setBackground(Color.WHITE);
		btnCancelar.setBackground(Color.WHITE);
		btnEnviarSugerencia.setPreferredSize(new Dimension(150, 40));
		btnCancelar.setPreferredSize(new Dimension(150, 40));
		
		txtDescripcion.setPreferredSize(new Dimension(300, 300));
		
		txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.black));
		
		txtInstruccion.setPreferredSize(new Dimension(300,50));
		txtInstruccion.setLineWrap(true);
		txtInstruccion.setWrapStyleWord(true);
		txtInstruccion.setOpaque(false);
		txtInstruccion.setEditable(false);
				
		this.imagen = new JLabel();
		
		// 3) Añadirlos al contenedor 
		/* Configura un panel auxiliar para los campos de entrada*/
		JPanel pa = new JPanel(new GridBagLayout());
		pa.setPreferredSize(new Dimension (400, 300));
		GridBagConstraints cond = new GridBagConstraints();
		
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
		condiciones.gridy = 2;
		panel.add(this.cbPrivado, condiciones);
		
		condiciones.gridwidth = 1;
		condiciones.gridx = 1;
		condiciones.gridy = 3;
		panel.add(this.lblContrasenia, condiciones);
		
		condiciones.gridx = 2;
		condiciones.gridy = 3;
		panel.add(this.txtContrasenia, condiciones);
		
		condiciones.gridwidth = 2;
		condiciones.gridx = 1;
		condiciones.gridy = 4;
		panel.add(this.txtDescripcion, condiciones);
		 
		condiciones.gridx = 1;
		condiciones.gridy = 5;
		panel.add(this.btnEnviarSugerencia, condiciones);
		

		this.add (panel);
		this.setVisible(false);
	}

	public JButton getBtnEnviarSugerencia() {
		return btnEnviarSugerencia;
	}
	
	public void enviarSugerencia(String correoUsuario) {
		if (this.cbPrivado.isSelected()) {
			this.correo = new Correo(correoUsuario, this.txtContrasenia.getText(), this.txtDescripcion.getText(),
					"acgc091199@gmail.com", "Sugerencia Poliapp");
		} else {
			this.correo = new Correo(correoUsuario, this.txtContrasenia.getText(), this.txtDescripcion.getText(),
					"acgc091199@gmail.com", "Sugerencia Poliapp");
		}
		
		if (this.correo.enviarCorreo()) {
			JOptionPane.showMessageDialog(null, "Su sugerencia ha sido enviada exitosamente.");
			this.txtInstruccion.setText("");
			this.txtDescripcion.setText("");
			this.txtContrasenia.setText("");
		} else {
			JOptionPane.showMessageDialog(null, "Error al enviar la sugerencia. Pruebe nuevamente.");
		}
	}
	
	
}
