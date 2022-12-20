package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Frame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private PanelParking panelParking;
	private PanelTop panelTop;

	public Frame() {
		this.panelParking = new PanelParking();
		this.panelTop = new PanelTop();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1000, 800);
		setResizable(false);
		setTitle("parkIT");

		getContentPane().setLayout(new BorderLayout());

		getContentPane().add(panelTop, BorderLayout.NORTH);
		getContentPane().add(panelParking, BorderLayout.CENTER);
		panelTop.setLayout(null);

		this.pack();
	}

	public PanelParking getPanelParking() {
		return panelParking;
	}

	public PanelTop getPanelTop() {
		return panelTop;
	}
}
