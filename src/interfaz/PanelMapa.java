package interfaz;

import java.awt.*;

import javax.swing.JPanel;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

public class PanelMapa extends JPanel {
	private Browser navegador;
	private BrowserView visualizador;
	
	private String URL = "https://goo.gl/Go7sV8";
	
	public PanelMapa() {
		super(new GridLayout(1, 1));
	    this.navegador = new Browser();
	    this.visualizador = new BrowserView(navegador);
	    
	    this.add(this.visualizador);
	    this.setPreferredSize(new Dimension(650, 450));

	    this.navegador.loadURL(this.URL);
	    this.setVisible(false);
	}
}
