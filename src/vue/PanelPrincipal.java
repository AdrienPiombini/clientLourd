package vue;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {

	protected JLabel titre = new JLabel("");

	public PanelPrincipal() {
		// les caractéristique communes aux différents Panels
		this.setBounds(50, 100, 800, 300);
		this.setBackground(new Color(234, 176, 79));
		this.setLayout(null);

		this.titre.setBounds(300, 10, 300, 20);
		this.add(this.titre);

		this.setVisible(false);
	}
}
