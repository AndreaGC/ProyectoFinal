package visualizacion;
//FlatIcon
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener  {
	/** Botones */
	private JButton btnDenuncia; 
	private JButton btnConsultar;
	private JButton btnMapa;
	private JButton btnInfracciones;
	private JButton btnSugerencias;
	private JButton btnPanico;
	private JButton btnJuego;
	private JButton btnUsuario;
	
	/** ComboBox*/
	private JComboBox tipoArchivo;
	
	/**Imágenes*/
	private JLabel logo;
	
	/**Paneles adicionales*/
	private PanelDenuncia pnlDenuncia;
	private PanelSugerencias pnlSugerencias;
	private PanelConsulta pnlConsulta;
	private PanelDidactico pnlDidactico;
	private PanelUsuario pnlUsuario;
	private PanelMapa pnlMapa;
	private PanelInfracciones pnlInfracciones;
	private PanelPanico pnlPanico;
	private PanelJuego pnlJuego;
	private JPanel opcionInicial;
	
	
	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public VentanaPrincipal(){
		this.setTitle("Poliapp");
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout());
		
		btnUsuario = new JButton("Usuario", new ImageIcon("img/usuario.png"));
		btnConsultar = new JButton("Consultar norma", new ImageIcon("img/documento.png"));
		btnMapa = new JButton("Mapa", new ImageIcon("img/mapa.png"));
		btnDenuncia  = new JButton("Denuncia", new ImageIcon("img/denuncia.png"));
		btnInfracciones = new JButton("Infracciones frecuentes", new ImageIcon("img/reloj.png"));
		btnSugerencias = new JButton("Sugerencias", new ImageIcon("img/sugerencias.png"));
		btnPanico = new JButton("Pánico", new ImageIcon("img/panico.png"));
		btnJuego = new JButton("Jugar", new ImageIcon("img/juego.png"));
		
		this.definirPropiedades(btnUsuario);
		this.definirPropiedades(btnConsultar);
		this.definirPropiedades(btnMapa);
		this.definirPropiedades(btnDenuncia);
		this.definirPropiedades(btnInfracciones);
		this.definirPropiedades(btnSugerencias);
		this.definirPropiedades(btnPanico);
		this.definirPropiedades(btnJuego);
		
		pnlDenuncia = new PanelDenuncia();
		pnlSugerencias = new PanelSugerencias();
		pnlConsulta = new PanelConsulta();
		pnlDidactico = new PanelDidactico();
		pnlUsuario = new PanelUsuario();
		pnlMapa = new PanelMapa();
		pnlInfracciones = new PanelInfracciones();
		pnlPanico = new PanelPanico();
		pnlJuego = new PanelJuego();
		
		
		this.logo = new JLabel(new ImageIcon("./img/logo.png"));
		this.logo.setBackground(new Color(0, 0, 51));
		this.logo.setOpaque(true);
		
		opcionInicial = new JPanel();
		opcionInicial.setOpaque(false);
		opcionInicial.setPreferredSize(new Dimension(650, 450));
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(900, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		panel.setBackground(new Color(38, 122, 52));
		
		condiciones.fill = GridBagConstraints.BOTH;
		
		condiciones.weighty = 1.0;
		condiciones.weightx = 0.0;
		condiciones.gridx = 1;
		condiciones.gridy = 1;
		panel.add(this.logo, condiciones);

		condiciones.gridx = 1;
		condiciones.gridy = 2;
		panel.add(this.btnUsuario, condiciones);
		
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
		panel.add(this.btnJuego, condiciones);
		
		condiciones.weightx = 1.0;
		condiciones.gridheight = 9;
		condiciones.gridx = 2;
		condiciones.gridy = 1;
		panel.add(opcionInicial, condiciones);
		panel.add(this.pnlSugerencias, condiciones);
		panel.add(this.pnlDenuncia, condiciones);
		panel.add(this.pnlConsulta, condiciones);
		panel.add(this.pnlDidactico, condiciones);
		panel.add(this.pnlUsuario, condiciones);
		panel.add(this.pnlUsuario.pnlRegistro, condiciones);
		panel.add(this.pnlUsuario.pnlSesion, condiciones);
		
		this.add (panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible (true);
	}
	
	public void definirPropiedades(JButton b) {
		b.setBackground(new Color(0, 153, 51));
		b.setHorizontalAlignment(JLabel.LEFT);
		b.setPreferredSize(new Dimension(250, 50));
		b.setBorderPainted(false);
		b.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == this.btnConsultar) {
			this.ocultarTodo();
			this.pnlConsulta.activarVisualizacion();
		} else if (evento.getSource() == this.btnUsuario){
			this.ocultarTodo();
			this.pnlUsuario.activarVisualizacion();
		} else if (evento.getSource() == this.btnMapa) {
			this.ocultarTodo();
			this.pnlConsulta.activarVisualizacion();
		} else if (evento.getSource() == this.btnDenuncia) {
			this.ocultarTodo();
			this.pnlDenuncia.activarVisualizacion();
		} else if (evento.getSource() == this.btnInfracciones) {
			this.ocultarTodo();
			this.pnlConsulta.activarVisualizacion();
		} else if (evento.getSource() == this.btnSugerencias) {
			this.ocultarTodo();
			this.pnlSugerencias.activarVisualizacion();
		} else if (evento.getSource() == this.btnPanico) {
			this.ocultarTodo();
			this.pnlConsulta.activarVisualizacion();
		} else if (evento.getSource() == this.btnJuego) {
			this.ocultarTodo();
			this.pnlConsulta.activarVisualizacion();
		}
	}
	
	public void ocultarTodo() {
		this.pnlSugerencias.desactivarVisualizacion();
		this.pnlDenuncia.desactivarVisualizacion();
		this.pnlConsulta.desactivarVisualizacion();
		this.pnlDidactico.desactivarVisualizacion();
		this.pnlUsuario.desactivarVisualizacion();
		this.pnlUsuario.pnlRegistro.desactivarVisualizacion();
		this.pnlUsuario.pnlSesion.desactivarVisualizacion();
	}
	
	public static void main(String[] args) {
		new VentanaPrincipal();
	}
}
