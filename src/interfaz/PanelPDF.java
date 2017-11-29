package interfaz;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class PanelPDF {
	public void mostrarPDF() {
		if (Desktop.isDesktopSupported()) {
			try {
				File myFile = new File("docs/codigo.pdf");
				Desktop.getDesktop().open(myFile);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "FUCK");
			}
		}
	}
}
