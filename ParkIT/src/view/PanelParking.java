package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelParking extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Image backgroundImage;
	private PanelPAreaA panelPAreaA;
	private PanelPAreaB panelPAreaB;
	private PanelPAreaC panelPAreaC;

	public PanelParking() {
		this.backgroundImage = new ImageIcon(
				getClass().getClassLoader().getResource("images/parking.jpg")).getImage();

		setPreferredSize(new Dimension(940, 700));
		setLayout(null);

		panelPAreaA = new PanelPAreaA();
		panelPAreaB = new PanelPAreaB();
		panelPAreaC = new PanelPAreaC();
		add(panelPAreaA);
		add(panelPAreaB);
		add(panelPAreaC);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
	}

	public PanelPAreaA getPanelPAreaA() {
		return panelPAreaA;
	}

	public PanelPAreaB getPanelPAreaB() {
		return panelPAreaB;
	}

	public PanelPAreaC getPanelPAreaC() {
		return panelPAreaC;
	}

}
