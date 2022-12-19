package controller;

import java.util.HashSet;
import java.util.Objects;
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
