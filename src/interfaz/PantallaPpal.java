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
	
	/**Paneles adicionales*/
	private Denunciar pnlDenuncia;
	
	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public PantallaPpal(){
		//1)Crear los objetos gráficos y lógicos
		btnDenuncia  = new JButton("Denuncia", new ImageIcon("img/circulo.png"));
		btnConsultar = new JButton("Consultar", new ImageIcon("img/circulo.png"));
		btnMapa = new JButton("Mapa", new ImageIcon("img/circulo.png"));
		btnInfracciones = new JButton("Infracciones frecuentes", new ImageIcon("img/circulo.png"));
		btnSugerencias = new JButton("Sugerencias", new ImageIcon("img/circulo.png"));
		btnPanico = new JButton("Pánico", new ImageIcon("img/circulo.png"));
		btnEvaluacion = new JButton("Jugar", new ImageIcon("img/circulo.png"));
		btnRegistrar = new JButton("Usuario", new ImageIcon("img/circulo.png"));
		pnlDenuncia = new Denunciar();

		String[] formasVisualizacion = {"Material didáctico", "PDF"};
		tipoArchivo = new JComboBox(formasVisualizacion);
		
		this.logo = new JLabel(new ImageIcon("./img/logo.png"));
		JPanel panelLogo = new JPanel(new GridLayout());
		panelLogo.setBackground(new Color(0, 0, 51));
		panelLogo.add(this.logo);
		
		// 2)Configuración de los elemntos gráficos
		this.setTitle("Poliapp");
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout());
		
		btnDenuncia.setBackground(new Color(0, 153, 51));
		btnConsultar.setBackground(new Color(0, 153, 51));
		btnMapa.setBackground(new Color(0, 153, 51));
		btnInfracciones.setBackground(new Color(0, 153, 51));
		btnSugerencias.setBackground(new Color(0, 153, 51));
		btnPanico.setBackground(new Color(0, 153, 51));
		btnEvaluacion.setBackground(new Color(0, 153, 51));
		btnRegistrar.setBackground(new Color(0, 153, 51));
		tipoArchivo.setBackground(new Color(0, 153, 51));
		
		btnDenuncia.setHorizontalAlignment(JLabel.LEFT);
		btnConsultar.setHorizontalAlignment(JLabel.LEFT);
		btnMapa.setHorizontalAlignment(JLabel.LEFT);
		btnInfracciones.setHorizontalAlignment(JLabel.LEFT);
		btnSugerencias.setHorizontalAlignment(JLabel.LEFT);
		btnPanico.setHorizontalAlignment(JLabel.LEFT);
		btnEvaluacion.setHorizontalAlignment(JLabel.LEFT);
		btnRegistrar.setHorizontalAlignment(JLabel.LEFT);
		
		/* Configura los oidores de eventos dde los botones */
		btnDenuncia.addActionListener(this);
		btnConsultar.addActionListener(this);
		btnMapa.addActionListener(this);
		btnInfracciones.addActionListener(this);
		btnSugerencias.addActionListener(this);
		btnPanico.addActionListener(this);
		btnEvaluacion.addActionListener(this);
		btnRegistrar.addActionListener(this);
		
		btnDenuncia.setPreferredSize(new Dimension(250, 50));
		btnMapa.setPreferredSize(new Dimension(250, 50));
		btnInfracciones.setPreferredSize(new Dimension(250, 50));
		btnSugerencias.setPreferredSize(new Dimension(250, 50));
		btnPanico.setPreferredSize(new Dimension(250, 50));
		btnEvaluacion.setPreferredSize(new Dimension(250, 50));
		btnRegistrar.setPreferredSize(new Dimension(250, 50));
		btnConsultar.setPreferredSize(new Dimension(250, 50));
		
		JPanel panelTemp = new JPanel(new GridLayout(2, 1));
		panelTemp.setPreferredSize(new Dimension(100, 40));
		panelTemp.add(this.btnConsultar);
		panelTemp.add(this.tipoArchivo);
		
		// 3) Añadirlos al contenedor 
		
		/* Configura un panel auxiliar para los campos de entrada*/
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(900, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		panel.setBackground(new Color(38, 122, 52));
		
		condiciones.fill = GridBagConstraints.BOTH;
		
		condiciones.weighty = 1.0;
		condiciones.weightx = 0.0;
		condiciones.gridx = 1;
		condiciones.gridy = 1;
		panel.add(panelLogo, condiciones);

		condiciones.gridx = 1;
		condiciones.gridy = 2;
		panel.add(this.btnRegistrar, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 3;
		panel.add(this.btnConsultar, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 4;
		panel.add(this.btnMapa, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 5;
		panel.add(this.btnDenuncia, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 6;
		panel.add(this.btnInfracciones, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 7;
		panel.add(this.btnSugerencias, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 8;
		panel.add(this.btnPanico, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 9;
		panel.add(this.btnEvaluacion, condiciones);
		
		condiciones.weightx = 1.0;
		condiciones.gridheight = 9;
		condiciones.gridx = 2;
		condiciones.gridy = 1;
		panel.add(this.pnlDenuncia, condiciones);
		
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
