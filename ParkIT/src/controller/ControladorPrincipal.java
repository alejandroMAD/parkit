package controller;

import javax.swing.JButton;

import model.Parking;
import view.Frame;

public class ControladorPrincipal {

	private Frame frame;
	private Parking parking;
	private ControladorParking controladorParking;
	private ControladorAfluencia controladorAfluencia;
	private ControladorInforme controladorInforme;

	public ControladorPrincipal(Frame frame, Parking parking) {
		this.frame = frame;
		this.parking = parking;
		this.controladorAfluencia = new ControladorAfluencia(frame);
		this.controladorInforme = new ControladorInforme(frame, parking);

		iniciarVista();
		iniciarControladores();
	}

	public void iniciarVista() {
		// TODO: L�gica inicializadora de la Vista
	}

	public void iniciarControladores() {
		this.frame.getPanelTop().getBtnAfluenciaBaja().addActionListener(controladorAfluencia);
		this.frame.getPanelTop().getBtnAfluenciaMedia().addActionListener(controladorAfluencia);
		this.frame.getPanelTop().getBtnAfluenciaAlta().addActionListener(controladorAfluencia);

		for (JButton boton : this.frame.getPanelParking().getPanelPAreaA().getParkingAButtons()) {
			boton.addActionListener(controladorInforme);
		}
		for (JButton boton : this.frame.getPanelParking().getPanelPAreaB().getParkingBButtons()) {
			boton.addActionListener(controladorInforme);
		}
		for (JButton boton : this.frame.getPanelParking().getPanelPAreaC().getParkingCButtons()) {
			boton.addActionListener(controladorInforme);
		}

	}

}
