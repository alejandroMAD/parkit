package controller;

import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class GeneradorTiempo implements Runnable {

	private int tiempoGeneracionCochesNuevo;

	private int tiempoGeneracionCochesUsado;



	private int tiempoDuracionEstanciaCochesNuevo;

	private int tiempoDuracionEstanciaCochesUsado;


	private int PacienciaCochesNormalesNuevo;

	private int PacienciaCochesNormalesUsado;

	private int PacienciaCochesMRNuevo;

	private int PacienciaCochesMRUsado;

	public GeneradorTiempo() {}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
