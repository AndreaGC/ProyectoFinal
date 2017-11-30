package interfaz;
//FlatIcon
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.*;

import logica.CuentaUsuario;

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
	
	//Botones provenientes de paneles alternos
	private JButton btnIniciarSesion;
	private JButton btnRegistrar;
	private JButton btnAceptarRegistro;
	private JButton btnCancelarRegistro;
	private JButton btnDenunciar;
	private JButton btnCancelarDenuncia;
	private JButton btnValidarSesion;
	private JButton btnNoIniciarSesion;
	private JButton btnEnviarSugerencia;
	private JButton btnLimpiarSugerencia;
	private JButton btnConsultarPDF;
	private JButton btnConsultarDidactico;
	private JButton btnCambiarContrasenia;
	private JButton btnCerrarSesion;
	private JButton btnEmpezarJuego;
	private JButton btnEnviar;
	private JButton btnComentar;
	
	private ArrayList <CuentaUsuario> usuarios;
	
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
	private PanelRegistro pnlRegistro;
	private PanelIniciarSesion pnlSesion;
	private PanelPDF pnlPDF;
	private PanelPerfil pnlPerfil;
	private PanelIniciarJuego pnlIniciarJuego;
	private PanelComentario pnlComentario;
	
	/**
	 * Constructor por omisión: Construye la ventana
	 * @param args
	 */
	public VentanaPrincipal(){
		this.setTitle("Poliapp");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout());
		
		pnlDenuncia = new PanelDenuncia();
		pnlSugerencias = new PanelSugerencias();
		pnlConsulta = new PanelConsulta();
		pnlUsuario = new PanelUsuario();
		pnlMapa = new PanelMapa();
		pnlInfracciones = new PanelInfracciones();
		pnlPanico = new PanelPanico();
		pnlJuego = new PanelJuego();
		pnlRegistro = new PanelRegistro();
		pnlSesion = new PanelIniciarSesion();
		this.pnlPerfil = new PanelPerfil();
		this.pnlPDF = new PanelPDF();
		this.pnlDidactico = new PanelDidactico();
		this.pnlIniciarJuego = new PanelIniciarJuego();
		this.pnlComentario = new PanelComentario();
		
		btnUsuario = new JButton("Usuario", new ImageIcon("img/usuario.png"));
		btnConsultar = new JButton("Consultar norma", new ImageIcon("img/documento.png"));
		btnMapa = new JButton("Mapa", new ImageIcon("img/mapa.png"));
		btnDenuncia  = new JButton("Denuncia", new ImageIcon("img/denuncia.png"));
		btnInfracciones = new JButton("Infracciones frecuentes", new ImageIcon("img/reloj.png"));
		btnSugerencias = new JButton("Sugerencias", new ImageIcon("img/sugerencias.png"));
		btnPanico = new JButton("Pánico", new ImageIcon("img/panico.png"));
		btnJuego = new JButton("Jugar", new ImageIcon("img/juego.png"));
		
		usuarios = new ArrayList();
		
		this.definirPropiedades(btnUsuario);
		this.definirPropiedades(btnConsultar);
		this.definirPropiedades(btnMapa);
		this.definirPropiedades(btnDenuncia);
		this.definirPropiedades(btnInfracciones);
		this.definirPropiedades(btnSugerencias);
		this.definirPropiedades(btnPanico);
		this.definirPropiedades(btnJuego);
		
		this.btnIniciarSesion = pnlUsuario.getBtnIniciarSesion();
		this.btnRegistrar = pnlUsuario.getBtnRegistrar();
		this.btnAceptarRegistro = pnlRegistro.getBtnAceptar();
		this.btnCancelarRegistro = pnlRegistro.getBtnCancelar();
		this.btnDenunciar = pnlDenuncia.getBtnEnviarDenuncia();
		this.btnCancelarDenuncia = pnlDenuncia.getBtnRegresar();
		this.btnValidarSesion = pnlSesion.getBtnVerificar();
		this.btnNoIniciarSesion = pnlSesion.getBtnCancelar();
		this.btnEnviarSugerencia = pnlSugerencias.getBtnEnviarSugerencia();
		this.btnLimpiarSugerencia = pnlSugerencias.getBtnCancelar();
		this.btnConsultarPDF = pnlConsulta.getBtnConsultarPDF();
		this.btnConsultarDidactico = pnlConsulta.getBtnConsultarDidactico();
		this.btnCerrarSesion = pnlPerfil.getBtnCerrarSesion();
		this.btnCambiarContrasenia = pnlPerfil.getBtnCambiarContrasenia();
		this.btnEmpezarJuego = pnlIniciarJuego.getBtnEmpezarJuego();
		this.btnEnviar = pnlJuego.getBtnEnviar();
		this.btnComentar = pnlDidactico.getBtnComentar();
		
		this.btnIniciarSesion.addActionListener(this);
		this.btnRegistrar.addActionListener(this);
		this.btnAceptarRegistro.addActionListener(this);
		this.btnCancelarRegistro.addActionListener(this);
		this.btnDenunciar.addActionListener(this);
		this.btnCancelarDenuncia.addActionListener(this);
		this.btnValidarSesion.addActionListener(this);
		this.btnNoIniciarSesion.addActionListener(this);
		this.btnEnviarSugerencia.addActionListener(this);
		this.btnLimpiarSugerencia.addActionListener(this);
		this.btnConsultarPDF.addActionListener(this);
		this.btnConsultarDidactico.addActionListener(this);
		this.btnCerrarSesion.addActionListener(this);
		this.btnCambiarContrasenia.addActionListener(this);
		this.btnEmpezarJuego.addActionListener(this);
		this.btnEnviar.addActionListener(this);
		this.btnComentar.addActionListener(this);
		
		this.logo = new JLabel(new ImageIcon("./img/logo.png"));
		this.logo.setBackground(new Color(0, 0, 51));
		this.logo.setOpaque(true);
		
		opcionInicial = new JPanel();
		opcionInicial.setOpaque(false);
		opcionInicial.setPreferredSize(new Dimension(650, 450));
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(900, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		panel.setBackground(Color.WHITE);
		
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
		panel.add(this.btnPanico, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 8;
		panel.add(this.btnJuego, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 9;
		panel.add(this.btnSugerencias, condiciones);
		
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
		panel.add(this.pnlRegistro, condiciones);
		panel.add(this.pnlSesion, condiciones);
		panel.add(this.pnlMapa, condiciones);
		panel.add(this.pnlPerfil, condiciones);
		panel.add(this.pnlIniciarJuego, condiciones);
		panel.add(this.pnlJuego, condiciones);
		panel.add(this.pnlComentario, condiciones);
		
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
		if (evento.getSource() == this.btnUsuario) {
			this.cargarDatos();
			if (buscar()) {
				this.ocultarPaneles(this.pnlPerfil);
			} else {
				this.ocultarPaneles(this.pnlUsuario);
			}
		} else if (evento.getSource() == this.btnConsultar){
			this.ocultarPaneles(this.pnlConsulta);
		} else if (evento.getSource() == this.btnMapa) {
			this.ocultarPaneles(this.pnlMapa);
		} else if (evento.getSource() == this.btnDenuncia) {
			this.ocultarPaneles(this.pnlDenuncia);
		} else if (evento.getSource() == this.btnInfracciones) {
			//TODO
		} else if (evento.getSource() == this.btnSugerencias) {
			this.ocultarPaneles(this.pnlSugerencias);
		} else if (evento.getSource() == this.btnPanico) {
			//TODO
		} else if (evento.getSource() == this.btnJuego) {
			this.ocultarPaneles(this.pnlIniciarJuego);
		} else if (evento.getSource() == this.btnIniciarSesion) {
			this.ocultarPaneles(this.pnlSesion);
		} else if (evento.getSource() == this.btnRegistrar) {
			this.ocultarPaneles(this.pnlRegistro);
		} else if (evento.getSource() == this.btnAceptarRegistro) {
			if (this.pnlRegistro.registrar()) {
				this.ocultarPaneles(this.pnlUsuario);
			}
		} else if (evento.getSource() == this.btnCancelarRegistro) {
			this.ocultarPaneles(this.pnlUsuario);
		} else if (evento.getSource() == this.btnDenunciar) {
			//TODO
		} else if (evento.getSource() == this.btnCancelarDenuncia) {
			//TODO
		} else if (evento.getSource() == this.btnValidarSesion) {
			if (this.pnlSesion.verificar()) {
				dispose();
				new VentanaPrincipal();
			}
		} else if (evento.getSource() == this.btnNoIniciarSesion) {
			this.ocultarPaneles(this.pnlUsuario);
		} else if (evento.getSource() == this.btnEnviarSugerencia) {
			this.pnlSugerencias.enviarSugerencia("dremliv@gmail.com");
		} else if (evento.getSource() == this.btnLimpiarSugerencia) {
			//TODO
		} else if (evento.getSource() == this.btnConsultarPDF) {
			pnlPDF.mostrarPDF();
		} else if (evento.getSource() == this.btnConsultarDidactico) {
			this.pnlConsulta.grabarDatos();
			this.pnlDidactico.resetearImagen();
			this.ocultarPaneles(this.pnlDidactico);
		} else if (evento.getSource() == this.btnCerrarSesion) {
			this.pnlPerfil.cerrarSesion();
			this.ocultarPaneles(this.pnlUsuario);
		} else if (evento.getSource() == this.btnCambiarContrasenia) {
			//TODO
		} else if (evento.getSource() == this.pnlIniciarJuego.getBtnEmpezarJuego()) {
			this.ocultarPaneles(pnlJuego);
		} else if (evento.getSource() == this.pnlJuego.getBtnEnviar()) {
			this.pnlJuego.verificarRespuesta();
			this.pnlJuego.cambiarIndice();
			this.ocultarPaneles(pnlJuego);
		}else if (evento.getSource() == this.btnComentar) {
			this.ocultarPaneles(pnlComentario);
		}
	}
	
	public void ocultarPaneles(JPanel panel) {
		this.pnlSugerencias.setVisible(false);
		this.pnlDenuncia.setVisible(false);
		this.pnlConsulta.setVisible(false);
		this.pnlDidactico.setVisible(false);
		this.pnlUsuario.setVisible(false);
		this.pnlSesion.setVisible(false);
		this.pnlRegistro.setVisible(false);
		this.pnlSesion.setVisible(false);
		this.pnlMapa.setVisible(false);
		this.pnlPerfil.setVisible(false);
		this.pnlIniciarJuego.setVisible(false);
		this.pnlJuego.setVisible(false);
		this.pnlComentario.setVisible(false);
		panel.setVisible(true);
	}
	
	public boolean cargarDatos() {
		try {
			FileInputStream fin = new FileInputStream ("./data/usuarios.dat");
			ObjectInputStream in = new ObjectInputStream (fin);
			usuarios =  (ArrayList<CuentaUsuario>) in.readObject();
			in.close();
			fin.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean buscar() {
		CuentaUsuario usuarioTemp = null;
		boolean encontrado = false; 
		
		for(int i=0; i< usuarios.size() && !encontrado; i++) {
			usuarioTemp = usuarios.get(i);
			if(usuarioTemp.getEstado()){
				encontrado = true;
			}
		}
		
		return encontrado;
	}
	
	public static void main(String[] args) {
		new VentanaPrincipal();
	}
}
