package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPAreaC extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<JButton> parkingCButtons;
	private Icon iconoMR;
	private int[] xCoordinates;
	private int[] xMRCoordinates;
	private  Color verdeLibre, rojoOcupado;

	public PanelPAreaC() {
		// Valores necesarios para ajustar botones a las ligeras desproporciones de la fotografía de fondo
		this.xCoordinates = new int[] {
				2, 41, 81, 121, 161, 201, 241, 281, 321, 361, 401,
				441, 481, 521, 561, 601, 641, 681, 722, 762, 802, 842
		};
		this.iconoMR = new ImageIcon(getClass().getClassLoader().getResource("images/disabled.png"));
		this.xMRCoordinates = new int[] { 762, 821 };
		this.parkingCButtons = new ArrayList<JButton>();
		this.verdeLibre = new Color(50, 205, 50);
		this.rojoOcupado = new Color(255, 99, 71);

		setOpaque(false);
		setBounds(10, 441, 873, 151);
		setLayout(null);

		for (int i = 0; i < 22; i++) {
			JButton button = new JButton();
			button.setBounds(xCoordinates[i], 3, 30, 65);
			button.setName("C" + String.format("%02d", i + 1));
			button.setBackground(verdeLibre);
			// TODO: button.addActionListener(controlador);
			parkingCButtons.add(button);
			add(button);
		}

		for (int i = 22; i < 41; i++) {
			JButton button = new JButton();
			button.setBounds(xCoordinates[i - 22], 82, 30, 65);
			button.setName("C" + String.format("%02d", i + 1));
			button.setBackground(verdeLibre);
			// TODO: button.addActionListener(controlador);
			parkingCButtons.add(button);
			add(button);
		}

		for (int i = 0; i < 2; i++) {
			JButton button = new JButton();
			button.setBounds(xMRCoordinates[i], 82, 50, 65);
			button.setBackground(verdeLibre);
			button.setIcon(iconoMR);
			button.setName("MR" + String.format("%02d", i + 1));
			// TODO: button.addActionListener(controlador);
			parkingCButtons.add(button);
			add(button);
		}
	}

	public JButton getBtnByName(String name) {
		JButton matchedButton = null;
		for (JButton btn : parkingCButtons) {
			if (btn.getName().equals(name)) {
				matchedButton = btn;
			}
		}
		return matchedButton;
	}

	public ArrayList<JButton> getParkingCButtons() {
		return parkingCButtons;
	}
}
