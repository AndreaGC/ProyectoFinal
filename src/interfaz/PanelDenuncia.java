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
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import logica.Correo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PanelDenuncia extends JPanel{
	private JTextArea txtInstruccion;
	private JTextField txtNorma;
	private JTextArea txtDescripcion;
	private JPasswordField txtContrasenia;
	private JLabel lblContrasenia;
	
	private JButton btnEnviarDenuncia;
	private JButton btnRegresar;
	private JButton btnAgregarImagen;
	
	private JCheckBox cbPrivado;
	
	private ArrayList<String> imagenes;
	
	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public PanelDenuncia(){
		//1)Crear los objetos gráficos y lógicos
		txtInstruccion = new JTextArea("Completa la información, envía la denuncia y te llegará una confirmación a tu correo");
		txtDescripcion = new JTextArea("Descripción");
		txtNorma = new JTextField("Número de artículo");
		txtContrasenia = new JPasswordField();
		lblContrasenia = new JLabel("Contraseña de Gmail (omitir para envío privado)");
		
		this.btnEnviarDenuncia  = new JButton("Enviar denuncia");
		this.btnRegresar = new JButton("Regresar");
		this.btnAgregarImagen = new JButton("Agregar multimedia");
		
		this.cbPrivado = new JCheckBox("Mensaje privado");
		
		// 2)Configuración de los elemntos gráficos
		this.setLayout(new GridLayout());
		
		btnEnviarDenuncia.setBackground(Color.WHITE);
		btnRegresar.setBackground(Color.WHITE);
		btnEnviarDenuncia.setPreferredSize(new Dimension(150, 40));
		btnRegresar.setPreferredSize(new Dimension(150, 40));
		btnAgregarImagen.setPreferredSize(new Dimension(150, 40));
		btnAgregarImagen.setBackground(Color.WHITE);
		
		lblContrasenia.setPreferredSize(new Dimension(300, 20));
		txtInstruccion.setPreferredSize(new Dimension(300, 40));
		txtNorma.setPreferredSize(new Dimension(100, 40));
		txtDescripcion.setPreferredSize(new Dimension(100, 40));
		txtContrasenia.setPreferredSize(new Dimension(300, 20));
		
		txtNorma.setBorder(BorderFactory.createLineBorder(Color.black));
		txtContrasenia.setBorder(BorderFactory.createLineBorder(Color.black));
		txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.black));
		
		txtInstruccion.setPreferredSize(new Dimension(300,40));
		txtInstruccion.setLineWrap(true);
		txtInstruccion.setOpaque(false);
		txtInstruccion.setEditable(false);
				
		// 3) Añadirlos al contenedor 
		/* Configura un panel auxiliar para los campos de entrada*/
		JPanel pa = new JPanel(new GridBagLayout());
		pa.setPreferredSize(new Dimension (300, 200));
		GridBagConstraints cond = new GridBagConstraints();
		
		cond.insets = new Insets(5, 5, 5, 5);
		cond.fill = GridBagConstraints.HORIZONTAL;

		cond.weightx = 1.0;
		
		cond.gridx = 1;
		cond.gridy = 1;
		pa.add(cbPrivado,cond);
		
		cond.gridx = 1;
		cond.gridy = 2;
		pa.add(txtNorma,cond);
		
		cond.fill = GridBagConstraints.BOTH;
		cond.weighty = 1.0;
		cond.gridx = 1;
		cond.gridy = 3;
		pa.add(txtDescripcion, cond);
		
		cond.weighty = 0.0;
		cond.gridx = 1;
		cond.gridy = 4;
		pa.add(btnAgregarImagen, cond);
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(650, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		condiciones.fill = GridBagConstraints.NONE;
		
		condiciones.weightx = 1.0;
		condiciones.gridx = 1;
		condiciones.gridy = 2;
		panel.add(this.lblContrasenia, condiciones);
		
		condiciones.gridx = 2;
		condiciones.gridy = 2;
		panel.add(this.txtContrasenia, condiciones);
		
		condiciones.gridwidth = 2;
		condiciones.weighty = 1.0;
		condiciones.gridx = 1;
		condiciones.gridy = 4;
		panel.add(this.btnEnviarDenuncia, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 1;
		panel.add(this.txtInstruccion, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 3;
		panel.add(pa, condiciones);

		/*Adiciona los páneles a la ventana */
		this.add (panel);
		this.setVisible(false);
	}
	
	public void agregarImagen() {
		JFileChooser archivo = new JFileChooser("./img/"); //Abre una ventana del explorador de archivos
		int boton = archivo.showOpenDialog(null);
			
		if (boton == JFileChooser.APPROVE_OPTION) {
			//TODO
		} 
	}
	
	public void enviarDenuncia(String correoUsuario) {
		//TODO
	}
	
	public JButton getBtnEnviarDenuncia() {
		return btnEnviarDenuncia;
	}

	public void setBtnEnviarDenuncia(JButton btnEnviarDenuncia) {
		this.btnEnviarDenuncia = btnEnviarDenuncia;
	}

	public JButton getBtnRegresar() {
		return btnRegresar;
	}

	public void setBtnRegresar(JButton btnRegresar) {
		this.btnRegresar = btnRegresar;
	}
}
