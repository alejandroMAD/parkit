package controller;

import java.util.concurrent.ThreadLocalRandom;

public class GeneradorTiempo implements Runnable {

	private int GeneracionCochesNuevo;

	private int GeneracionCochesUsado;

	private int DuracionEstanciaCochesNuevo;

	private int DuracionEstanciaCochesUsado;

	private int PacienciaCochesNormalesNuevo;

	private int PacienciaCochesNormalesUsado;

	private int PacienciaCochesMRNuevo;

	private int PacienciaCochesMRUsado;

	public GeneradorTiempo() {
		setGeneracionCochesNuevo(ThreadLocalRandom.current().nextInt(2, 8));
		setDuracionEstanciaCochesNuevo(ThreadLocalRandom.current().nextInt(40, 60));
		setPacienciaCochesNormalesNuevo(ThreadLocalRandom.current().nextInt(5));
		setPacienciaCochesMRNuevo(ThreadLocalRandom.current().nextInt(2));
	}

	private void tiemposDesiguales() {
		System.out.println(GeneracionCochesNuevo);
		comprobarGeneracionCochesTiempo();
		System.out.println(DuracionEstanciaCochesNuevo);
		comprobarDuracionEstanciaPlaza();
		System.out.println(PacienciaCochesMRNuevo);
		comprobarPacienciaMR();
		System.out.println(PacienciaCochesNormalesNuevo);
		comprobarPacienciaNormal();
	}

	private void comprobarGeneracionCochesTiempo() {
		int valorGeneradoGeneracionCoches = ThreadLocalRandom.current().nextInt(2, 8);
		while (valorGeneradoGeneracionCoches == GeneracionCochesUsado) {
			valorGeneradoGeneracionCoches = ThreadLocalRandom.current().nextInt(2, 8);
		}
		if (valorGeneradoGeneracionCoches != GeneracionCochesUsado) {
			GeneracionCochesNuevo = valorGeneradoGeneracionCoches;
		}
		System.out.println(GeneracionCochesNuevo);
	}

	private void comprobarDuracionEstanciaPlaza() {
		int valorGeneradoEstanciaPlaza = ThreadLocalRandom.current().nextInt(40, 60);
		while (valorGeneradoEstanciaPlaza == DuracionEstanciaCochesUsado) {
			valorGeneradoEstanciaPlaza = ThreadLocalRandom.current().nextInt(40, 60);
		}
		if (valorGeneradoEstanciaPlaza != DuracionEstanciaCochesUsado) {
			DuracionEstanciaCochesNuevo = valorGeneradoEstanciaPlaza;
		}
		System.out.println(DuracionEstanciaCochesNuevo);
	}

	private void comprobarPacienciaNormal() {
		int valorGeneradoPacienciaNormal = ThreadLocalRandom.current().nextInt(5);
		while (valorGeneradoPacienciaNormal == PacienciaCochesNormalesUsado) {
			valorGeneradoPacienciaNormal = ThreadLocalRandom.current().nextInt(5);
		}
		if (valorGeneradoPacienciaNormal != PacienciaCochesNormalesUsado) {
			PacienciaCochesNormalesNuevo = valorGeneradoPacienciaNormal;
		}
		System.out.println(PacienciaCochesNormalesNuevo);
	}

	private void comprobarPacienciaMR() {
		int valorGeneradoPacienciaMR = ThreadLocalRandom.current().nextInt(2);
		while (valorGeneradoPacienciaMR == PacienciaCochesMRUsado) {
			valorGeneradoPacienciaMR = ThreadLocalRandom.current().nextInt(2);
		}
		if (valorGeneradoPacienciaMR != PacienciaCochesMRUsado) {
			PacienciaCochesMRNuevo = valorGeneradoPacienciaMR;
		}
		System.out.println(PacienciaCochesMRNuevo);
	}

	public int getGeneracionCochesNuevo() {
		return GeneracionCochesNuevo;
	}

	public void setGeneracionCochesNuevo(int GeneracionCochesNuevo) {
		this.GeneracionCochesNuevo = GeneracionCochesNuevo;
	}

	public int getGeneracionCochesUsado() {
		return GeneracionCochesUsado;
	}

	public void setGeneracionCochesUsado(int GeneracionCochesUsado) {
		this.GeneracionCochesUsado = GeneracionCochesUsado;
	}

	public int getDuracionEstanciaCochesNuevo() {
		return DuracionEstanciaCochesNuevo;
	}

	public void setDuracionEstanciaCochesNuevo(int DuracionEstanciaCochesNuevo) {
		this.DuracionEstanciaCochesNuevo = DuracionEstanciaCochesNuevo;
	}

	public int getDuracionEstanciaCochesUsado() {
		return DuracionEstanciaCochesUsado;
	}

	public void setDuracionEstanciaCochesUsado(int DuracionEstanciaCochesUsado) {
		this.DuracionEstanciaCochesUsado = DuracionEstanciaCochesUsado;
	}

	public int getPacienciaCochesNormalesNuevo() {
		return PacienciaCochesNormalesNuevo;
	}

	public void setPacienciaCochesNormalesNuevo(int PacienciaCochesNormalesNuevo) {
		this.PacienciaCochesNormalesNuevo = PacienciaCochesNormalesNuevo;
	}

	public int getPacienciaCochesNormalesUsado() {
		return PacienciaCochesNormalesUsado;
	}

	public void setPacienciaCochesNormalesUsado(int PacienciaCochesNormalesUsado) {
		this.PacienciaCochesNormalesUsado = PacienciaCochesNormalesUsado;
	}

	public int getPacienciaCochesMRNuevo() {
		return PacienciaCochesMRNuevo;
	}

	public void setPacienciaCochesMRNuevo(int PacienciaCochesMRNuevo) {
		this.PacienciaCochesMRNuevo = PacienciaCochesMRNuevo;
	}

	public int getPacienciaCochesMRUsado() {
		return PacienciaCochesMRUsado;
	}

	public void setPacienciaCochesMRUsado(int PacienciaCochesMRUsado) {
		this.PacienciaCochesMRUsado = PacienciaCochesMRUsado;
	}

	@Override
	public void run() {
		while (true) {
			tiemposDesiguales();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
