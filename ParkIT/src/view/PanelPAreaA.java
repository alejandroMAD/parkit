package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ControladorInforme;

public class PanelPAreaA extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<JButton> parkingAButtons;
	private int[] xCoordinates;
	private Color verdeLibre, rojoOcupado;

	public PanelPAreaA() {
		// Valores necesarios para ajustar botones a las ligeras desproporciones de la
		// fotografía de fondo
		this.xCoordinates = new int[] {
				2, 42, 81, 121, 161, 201, 240, 280, 320, 360, 399,
				439, 479, 520, 560, 600, 640, 680, 720, 760, 801, 841
		};
		this.parkingAButtons = new ArrayList<JButton>();
		this.verdeLibre = new Color(50, 205, 50);
		this.rojoOcupado = new Color(255, 99, 71);

		setOpaque(false);
		setBounds(10, 5, 873, 75);
		setLayout(null);

		for (int i = 0; i < 22; i++) {
			JButton button = new JButton();
			button.setBounds(xCoordinates[i], 3, 30, 65);
			button.setName("A" + String.format("%02d", i + 1));
			button.setBackground(verdeLibre);
			parkingAButtons.add(button);
			add(button);
		}

	}

	public JButton getBtnByName(String name) {
		JButton matchedButton = null;
		for (JButton btn : parkingAButtons) {
			if (btn.getName().equals(name)) {
				matchedButton = btn;
			}
		}
		return matchedButton;
	}

	public ArrayList<JButton> getParkingAButtons() {
		return parkingAButtons;
	}
}
