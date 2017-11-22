package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class PantallaPpal extends JFrame implements ActionListener {

	//Atributos
	
	/** Botones */
	private JButton btnDenuncia; 
	private JButton btnConsultar;
	private JButton btnMapa;
	private JButton btnInfracciones;
	private JButton btnSugerencias;
	private JButton btnPanico;
	private JButton btnEvaluacion;
	private JButton btnRegistrar;
	
	/** ComboBox*/
	private JComboBox tipoArchivo;
	
	/**Imágenes*/
	private JLabel logo;
	
	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public PantallaPpal(){
		//1)Crear los objetos gráficos y lógicos
		btnDenuncia  = new JButton("Denuncia", new ImageIcon("img/denuncia.png"));
		btnConsultar = new JButton("Consultar", new ImageIcon("img/denuncia.png"));
		btnMapa = new JButton("Mapa", new ImageIcon("img/denuncia.png"));
		btnInfracciones = new JButton("Infracciones frecuentes", new ImageIcon("img/denuncia.png"));
		btnSugerencias = new JButton("Sugerencias", new ImageIcon("img/denuncia.png"));
		btnPanico = new JButton("Pánico", new ImageIcon("img/denuncia.png"));
		btnEvaluacion = new JButton("¿Qué tanto sabes del código de policía? ", new ImageIcon("img/denuncia.png"));
		btnRegistrar = new JButton("Registrar", new ImageIcon("img/denuncia.png"));

		String[] formasVisualizacion = {"Material didáctico", "PDF"};
		tipoArchivo = new JComboBox(formasVisualizacion);
		
		this.logo = new JLabel(new ImageIcon("./img/logo.png"));
		
		// 2)Configuración de los elemntos gráficos
		this.setTitle("Poliapp");
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout());
		
		btnDenuncia.setBackground(Color.WHITE);
		btnConsultar.setBackground(Color.WHITE);
		btnMapa.setBackground(Color.WHITE);
		btnInfracciones.setBackground(Color.WHITE);
		btnSugerencias.setBackground(Color.WHITE);
		btnPanico.setBackground(Color.WHITE);
		btnEvaluacion.setBackground(Color.WHITE);
		btnRegistrar.setBackground(Color.WHITE);
		tipoArchivo.setBackground(Color.WHITE);
		
		/* Configura los oidores de eventos dde los botones */
		btnDenuncia.addActionListener(this);
		btnConsultar.addActionListener(this);
		btnMapa.addActionListener(this);
		btnInfracciones.addActionListener(this);
		btnSugerencias.addActionListener(this);
		btnPanico.addActionListener(this);
		btnEvaluacion.addActionListener(this);
		btnRegistrar.addActionListener(this);
		
		btnDenuncia.setPreferredSize(new Dimension(100, 40));
		btnMapa.setPreferredSize(new Dimension(100, 40));
		btnInfracciones.setPreferredSize(new Dimension(100, 40));
		btnSugerencias.setPreferredSize(new Dimension(100, 40));
		btnPanico.setPreferredSize(new Dimension(100, 40));
		btnEvaluacion.setPreferredSize(new Dimension(600, 40));
		btnRegistrar.setPreferredSize(new Dimension(100, 40));
		
		JPanel panelTemp = new JPanel(new GridLayout(2, 1));
		panelTemp.setPreferredSize(new Dimension(100, 40));
		panelTemp.add(this.btnConsultar);
		panelTemp.add(this.tipoArchivo);
		
		// 3) Añadirlos al contenedor 
		
		/* Configura un panel auxiliar para los campos de entrada*/
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(900, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		//nel.setBackground(new Color(38, 122, 52));
		panel.setBackground(Color.BLACK);
		
		condiciones.fill = GridBagConstraints.NONE;
		condiciones.anchor = GridBagConstraints.CENTER;
		condiciones.weighty = 0.2;
		condiciones.weightx = 0.5;
		
		condiciones.gridwidth = 2;
		condiciones.gridx = 1;
		condiciones.gridy = 1;
		panel.add(this.logo, condiciones);
		condiciones.gridwidth = 1;
		
		condiciones.ipady = 20;
		condiciones.ipadx = 20;
		condiciones.gridx = 3;
		condiciones.gridy = 1;
		panel.add(this.btnRegistrar, condiciones);
		
		condiciones.ipady = 30;
		condiciones.ipadx = 150;
		condiciones.weighty = 1.0;
		condiciones.gridx = 1;
		condiciones.gridy = 2;
		panel.add(panelTemp, condiciones);
		
		condiciones.gridx = 2;
		condiciones.gridy = 2;
		panel.add(this.btnMapa, condiciones);
		
		condiciones.gridx = 3;
		condiciones.gridy = 2;
		panel.add(this.btnDenuncia, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 3;
		panel.add(this.btnInfracciones, condiciones);
		
		condiciones.gridx = 2;
		condiciones.gridy = 3;
		panel.add(this.btnSugerencias, condiciones);
		
		condiciones.gridx = 3;
		condiciones.gridy = 3;
		panel.add(this.btnPanico, condiciones);
		
		condiciones.gridwidth = 3;
		condiciones.gridx = 1;
		condiciones.gridy = 4;
		panel.add(this.btnEvaluacion, condiciones);
		
		/*Adiciona los páneles a la ventana */
		
		this.add (panel);
		this.pack();
		this.setVisible (true);
	}

	public static void main(String[] args) {
		new PantallaPpal();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
