package interfaz;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import javax.swing.*;
import logica.*;


public class PanelDidactico  extends JPanel{
	private JLabel imagen;
	
	private JButton btnComentar;
	private JButton btnVerComentarios;
	
	private Norma norma;
	private ArrayList <Norma> normas;
	
	private int articulo;
	
	public PanelDidactico() {
		this.setLayout(new GridLayout());
		
		normas = new ArrayList();
		cargarDatos();
		
		if (this.cargarDatoArticulo()) {
			this.norma = this.buscar(this.articulo);
		} else {
			this.norma = this.buscar(7);
		}
		
		ImageIcon imagenTemp = new ImageIcon(this.norma.getDireccionImagen());
		Image caricatura = imagenTemp.getImage().getScaledInstance(600, 420, Image.SCALE_AREA_AVERAGING);
		
		this.imagen = new JLabel(new ImageIcon(caricatura));
		
		this.btnComentar = new JButton("Comentar");
		this.btnVerComentarios = new JButton("Ver comentarios");
		
		this.btnComentar.setPreferredSize(new Dimension(30, 325));
		this.btnVerComentarios.setPreferredSize(new Dimension(30, 325));
	
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setPreferredSize(new Dimension(650, 450));
		GridBagConstraints condiciones = new GridBagConstraints();
		
		condiciones.fill = GridBagConstraints.BOTH;
		condiciones.gridwidth = 2;
		condiciones.gridx = 0;
		condiciones.gridy = 0;
		panel.add(this.imagen, condiciones);
		
		condiciones.fill = GridBagConstraints.HORIZONTAL;
		condiciones.gridwidth = 1;
		condiciones.weightx = 1.0;
		condiciones.gridx = 0;
		condiciones.gridy = 1;
		panel.add(this.btnComentar, condiciones);
		
		condiciones.gridx = 1;
		condiciones.gridy = 1;
		panel.add(this.btnVerComentarios, condiciones);
		
		this.add(panel);
		this.setVisible(false);
	}
	
	public void resetearImagen() {
		cargarDatoArticulo();
		
		if (this.cargarDatoArticulo()) {
			this.norma = this.buscar(this.articulo);
		} else {
			this.norma = this.buscar(7);
		}
		
		ImageIcon imagenTemp = new ImageIcon(this.norma.getDireccionImagen());
		Image caricatura = imagenTemp.getImage().getScaledInstance(600, 420, Image.SCALE_AREA_AVERAGING);
		
		this.imagen.setIcon(new ImageIcon(caricatura));
	}
	
	public Norma buscar(int articulo) {
		Norma norma = null;
		boolean encontrado = false; 
		
		for(int i=0; i< this.normas.size() && !encontrado; i++) {
			norma = this.normas.get(i);
			if(norma.getArticulo() == articulo){
				encontrado=true;
			}
		}
		
		if (encontrado) {
			return norma;
		} else {
			return null;
		}
	}
	
	public boolean cargarDatos() {
		try {
			FileInputStream fin = new FileInputStream ("./data/normas.dat");
			ObjectInputStream in = new ObjectInputStream (fin);
			this.normas = (ArrayList<Norma>) in.readObject();
			in.close();
			fin.close();
			return true;
		} catch (Exception e) {
			this.crearNormas();
			return false;
		}
	}
	
	public boolean cargarDatoArticulo() {
		try {
			FileInputStream fin = new FileInputStream ("./data/normaAConsultar.dat");
			ObjectInputStream in = new ObjectInputStream (fin);
			this.articulo = (int) in.readObject();
			in.close();
			fin.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void crearNormas() {
		for (int i = 1; i <= 243; i++) {
			Norma normaTemp = new Norma(i);
			this.normas.add(normaTemp);
		}
		this.grabarDatos();
	}
	
	public boolean grabarDatos() {
		try {
			FileOutputStream fout = new FileOutputStream ("./data/normas.dat");
			ObjectOutputStream out = new ObjectOutputStream (fout);
			out.writeObject(this.normas);
			out.close();
			fout.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public JButton getBtnComentar() {
		return btnComentar;
	}

	public void setBtnComentar(JButton btnComentar) {
		this.btnComentar = btnComentar;
	}

	public JButton getBtnVerComentarios() {
		return btnVerComentarios;
	}

	public void setBtnVerComentarios(JButton btnVerComentarios) {
		this.btnVerComentarios = btnVerComentarios;
	}
}
