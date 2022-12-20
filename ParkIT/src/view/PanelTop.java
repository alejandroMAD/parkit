package view;

import java.awt.*;
import javax.swing.*;

public class PanelTop extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon logo;
	private JLabel lblLogo;
	private JButton btnAfluenciaBaja, btnAfluenciaMedia, btnAfluenciaAlta;

	public PanelTop() {

		this.logo = new ImageIcon(
				getClass().getClassLoader().getResource("images/parkit_logo.png"));

		setPreferredSize(new Dimension(940, 74));
		setBackground(new Color(3, 34, 62));

		lblLogo = new JLabel(logo);
		lblLogo.setBounds(20, 11, 154, 52);
		add(lblLogo);

		btnAfluenciaBaja = new JButton("Afluencia baja");
		btnAfluenciaBaja.setBounds(480, 26, 125, 23);
		add(btnAfluenciaBaja);

		btnAfluenciaMedia = new JButton("Afluencia media");
		btnAfluenciaMedia.setBounds(635, 25, 125, 23);
		add(btnAfluenciaMedia);

		btnAfluenciaAlta = new JButton("Afluencia alta");
		btnAfluenciaAlta.setBounds(790, 25, 125, 23);
		add(btnAfluenciaAlta);

	}

	public JButton getBtnAfluenciaBaja() {
		return btnAfluenciaBaja;
	}

	public JButton getBtnAfluenciaMedia() {
		return btnAfluenciaMedia;
	}

	public JButton getBtnAfluenciaAlta() {
		return btnAfluenciaAlta;
	}

}
