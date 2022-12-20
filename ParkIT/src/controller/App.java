package controller;

import java.util.concurrent.Semaphore;
import javax.swing.SwingUtilities;

import model.Parking;
import view.Frame;

public class App {

	public static void main(String[] args) {

		final int PLAZAS = 107;
		final int PLAZAS_MR = 2;

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

					Semaphore semaforo = new Semaphore(PLAZAS, true);
					Semaphore semaforoMovilidadReducida = new Semaphore(PLAZAS_MR, true);

					GeneradorTiempo generadorTiempo = new GeneradorTiempo();
					new Thread(generadorTiempo).start();

					Parking parking = new Parking(
							generadorTiempo,
							frame,
							semaforo,
							semaforoMovilidadReducida,
							"Parking DAM-30",
							PLAZAS,
							PLAZAS_MR);

					new Thread(new GeneradorCoches(parking)).start();

					new ControladorPrincipal(frame, parking);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
