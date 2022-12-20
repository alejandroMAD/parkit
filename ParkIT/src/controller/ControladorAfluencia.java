package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Frame;

public class ControladorAfluencia implements ActionListener {

	private Frame frame;

	public ControladorAfluencia(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(frame.getPanelTop().getBtnAfluenciaBaja())) {
			// L�gica de AFLUENCIA BAJA
		} else if (e.getSource().equals(frame.getPanelTop().getBtnAfluenciaMedia())) {
			// L�gica de AFLUENCIA MEDIA
		} else if (e.getSource().equals(frame.getPanelTop().getBtnAfluenciaAlta())) {
			// L�gica de AFLUENCIA ALTA
		}
	}
}
