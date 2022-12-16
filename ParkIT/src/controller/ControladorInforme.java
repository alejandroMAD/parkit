package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import model.Coche;
import model.Parking;
import view.Frame;

/**
 * Muestra la información del vehículo alojado en una plaza
 *
 */
public class ControladorInforme implements ActionListener {
	
	private Frame frame;
	private Parking parking;
	
	public ControladorInforme(Frame frame, Parking parking) {
		this.frame = frame;
		this.parking = parking;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton botonPlaza = (JButton) e.getSource();
		String plaza = botonPlaza.getName();
		Coche coche = parking.getMapaPlazasCoches().get(plaza);

		UIManager.put("OptionPane.messageFont", new FontUIResource(
				new Font("Arial", Font.BOLD, 22))
		);  
		
		if (coche != null) {
			JOptionPane.showMessageDialog(
					frame, 
					coche.toString(), 
					"Información sobre el vehículo en la plaza "
					+ coche.getPlaza(),
					JOptionPane.INFORMATION_MESSAGE
			);			
		} else {
			JOptionPane.showMessageDialog(
					frame, 
					"La plaza " + plaza + " está vacía", 
					"Información sobre la plaza", 
					JOptionPane.ERROR_MESSAGE
			);
		}
	}
}
