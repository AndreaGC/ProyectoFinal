package interfaz;

import java.awt.*;

import javax.swing.*;

public class PanelDidactico  extends JPanel{
	private ImageIcon imagen[] = new ImageIcon[40];
	
	public PanelDidactico() {
		this.setLayout(new GridLayout());
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints condiciones = new GridBagConstraints();
		
		condiciones.fill = GridBagConstraints.NONE;
		condiciones.insets = new Insets(30, 30, 30, 30);
		condiciones.gridx = 1;
		
		for(int i = 1; i <= 40; i++) {
			this.imagen[i - 1] = new ImageIcon("img/codigo/" + i + ".jpg");
			Image scaleImage = this.imagen[i - 1].getImage().getScaledInstance(630, 450, Image.SCALE_SMOOTH);
			JLabel img = new JLabel(new ImageIcon(scaleImage));
			
			condiciones.gridy = i;
			panel.add(img, condiciones);
		}
		
		JScrollPane panelDeslizable = new JScrollPane(this);
		panelDeslizable.setPreferredSize(new Dimension(650, 450));
		this.add(panel);
		this.setVisible(false);
	}
}
