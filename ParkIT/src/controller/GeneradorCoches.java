package controller;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

import model.Coche;
import model.Parking;

public class GeneradorCoches implements Runnable {

	// public static int contadorCoches = 0;
	// private static Object obj = new Object();
	private Parking parking;
	private ArrayList<String> modelosCoche;
	private static final String filePath = "/files/coches.txt";
	// private boolean apagado = false;

	public GeneradorCoches(Parking parking) {
		System.out.println("Generador de coches comienza su operaci�n");
		this.parking = parking;
		this.modelosCoche = new ArrayList<String>();

		leerModelosCoche();
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(parking.getGeneradorTiempo().getGeneracionCochesNuevo() * 220);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			parking.getGeneradorTiempo().setGeneracionCochesUsado(parking.getGeneradorTiempo().getGeneracionCochesNuevo());

			Coche coche = new Coche(
					generarMatricula(),
					generarModeloCoche(),
					parking,
					definirMovilidadReducida()

			);
			Thread thread = new Thread(coche);
			thread.setName("thread-" + coche.getMatricula());
			thread.start();

			// synchronized (obj) {
			// contadorCoches++;
			// if (contadorCoches>=100) {
			// apagado = true;
			// }
			// }
		}

	}

	public String generarMatricula() {
		String letrasPermitidas = "BCDFGHJKLMNPRSTVWXYZ";
		String parteAlfabetica = "";
		String parteNumerica = String.format(
				"%04d",
				ThreadLocalRandom.current().nextInt(0, 10_000));

		for (int i = 0; i < 3; i++) {
			parteAlfabetica += letrasPermitidas.charAt(
					ThreadLocalRandom.current().nextInt(letrasPermitidas.length()));
		}
		return parteNumerica + parteAlfabetica;
	}

	public void leerModelosCoche() {
		try (
				InputStream is = getClass().getResourceAsStream(filePath);
				BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));) {
			String modeloCoche;
			while ((modeloCoche = reader.readLine()) != null) {
				this.modelosCoche.add(modeloCoche);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String generarModeloCoche() {
		String modeloAleatorio = modelosCoche.get(
				ThreadLocalRandom.current().nextInt(modelosCoche.size()));
		return modeloAleatorio;
	}

	public boolean definirMovilidadReducida() {
		int porcentajeMovilidadReducida = ThreadLocalRandom.current().nextInt(100);
		if (porcentajeMovilidadReducida < 5) {
			return true;
		} else {
			return false;
		}
	}

}
