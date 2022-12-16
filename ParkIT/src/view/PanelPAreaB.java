package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPAreaB extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<JButton> parkingBButtons;
	private int[] xCoordinates;
	private  Color verdeLibre, rojoOcupado;
	
	public PanelPAreaB() {
		// Valores necesarios para ajustar botones a las ligeras desproporciones de la fotografía de fondo
		this.xCoordinates = new int[] {
				2, 42, 82, 121, 162, 201, 241, 280, 320, 360, 400,
				440, 480, 520, 560, 600, 639, 679, 720, 760, 800, 840
		};
		this.parkingBButtons = new ArrayList<JButton>();
		this.verdeLibre = new Color(50, 205, 50);
		this.rojoOcupado = new Color(255, 99, 71);
		
		setOpaque(false);
		setBounds(10, 186, 873, 151);
		setLayout(null);
		
		for (int i = 0; i < 22; i++) {
			JButton button = new JButton();
			button.setBounds(xCoordinates[i], 3, 30, 65);
			button.setName("B" + String.format("%02d", i + 1));
			button.setBackground(verdeLibre);
			// TODO: button.addActionListener(controlador);
			parkingBButtons.add(button);
			add(button);
		}
		
		for (int i = 22; i < 44; i++) {
			JButton button = new JButton();
			button.setBounds(xCoordinates[i - 22], 81, 30, 65);
			button.setName("B" + String.format("%02d", i + 1));
			button.setBackground(verdeLibre);
			// TODO: button.addActionListener(controlador);
			parkingBButtons.add(button);
			add(button);
		}
				
	}
	
	public JButton getBtnByName(String name) {
		JButton matchedButton = null;
		for (JButton btn : parkingBButtons) {
			if (btn.getName().equals(name)) {
				matchedButton = btn;
			}
		}
		return matchedButton;
	}

	public ArrayList<JButton> getParkingBButtons() {
		return parkingBButtons;
	}
	
}
