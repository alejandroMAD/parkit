package controller;

import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class GeneradorTiempo implements Runnable {
	
	private Double probabilidadesMinusvalia;
	
	private Integer tiempoGeneracionCoches;
	
	private Integer tiempoDuracionEstanciaCoches;
	
	private Integer PacienciaCochesNormales;
	
	private Integer PacienciaCochesMR;
	
	private HashSet<Integer> ColeccionTiempoGeneracionCoches = new HashSet<>();
	
	private HashSet<Integer> ColecciontiempoDuracionEstanciaCoches = new HashSet<>();
	
	private HashSet<Integer> ColeccionPacienciaCochesNormales = new HashSet<>();
	
	private HashSet<Integer> ColeccionPacienciaCochesMR = new HashSet<>();
	
	private HashSet<Double> ColeccionTiempoMinusvaliaCoches = new HashSet<>();
	
	public GeneradorTiempo() {
		setProbabilidadesMinusvalia(ThreadLocalRandom.current().nextDouble());
		setTiempoGeneracionCoches(ThreadLocalRandom.current().nextInt(2, 8));
		setTiempoDuracionEstanciaCoches(ThreadLocalRandom.current().nextInt(40, 60));
		setPacienciaCochesMR(ThreadLocalRandom.current().nextInt(5));
		setPacienciaCochesNormales(ThreadLocalRandom.current().nextInt(2));
	}
	
	private void ComprobarGeneracionCoches() {
		if (!ColeccionTiempoGeneracionCoches.add(getTiempoGeneracionCoches())) {
			ColeccionTiempoGeneracionCoches.remove(getTiempoGeneracionCoches());
		}
	}
	private void ComprobarEstanciaCoches() {
		if (!ColecciontiempoDuracionEstanciaCoches.add(getTiempoDuracionEstanciaCoches())) {
			ColecciontiempoDuracionEstanciaCoches.remove(getTiempoDuracionEstanciaCoches());
		}
	}
	
	private void ComprobarPacienciaCochesNormales() {
		if (!ColeccionPacienciaCochesNormales.add(getPacienciaCochesNormales())) {
			ColeccionPacienciaCochesNormales.remove(getPacienciaCochesNormales());
		}
	}
	
	private void ComprobarPacienciaCochesNormalesMR() {
		if (!ColeccionPacienciaCochesMR.add(getPacienciaCochesMR())) {
			ColeccionPacienciaCochesMR.remove(getPacienciaCochesMR());
		}
	}
	
	private void ComprobarMinusvaliaCoches() {
		if (!ColeccionTiempoMinusvaliaCoches.add(getProbabilidadesMinusvalia())) {
			ColeccionTiempoMinusvaliaCoches.remove(getProbabilidadesMinusvalia());
		}
	}

	public Double getProbabilidadesMinusvalia() {
		return probabilidadesMinusvalia;
	}
	public void setProbabilidadesMinusvalia(Double probabilidadesMinusvalia) {
		this.probabilidadesMinusvalia = probabilidadesMinusvalia;
	}
	public Integer getTiempoGeneracionCoches() {
		return tiempoGeneracionCoches;
	}
	public void setTiempoGeneracionCoches(Integer tiempoGeneracionCoches) {
		this.tiempoGeneracionCoches = tiempoGeneracionCoches;
	}
	public Integer getTiempoDuracionEstanciaCoches() {
		return tiempoDuracionEstanciaCoches;
	}
	public void setTiempoDuracionEstanciaCoches(Integer tiempoDuracionEstanciaCoches) {
		this.tiempoDuracionEstanciaCoches = tiempoDuracionEstanciaCoches;
	}
	public Integer getPacienciaCochesNormales() {
		return PacienciaCochesNormales;
	}
	public void setPacienciaCochesNormales(Integer pacienciaCochesNormales) {
		PacienciaCochesNormales = pacienciaCochesNormales;
	}
	public Integer getPacienciaCochesMR() {
		return PacienciaCochesMR;
	}
	public void setPacienciaCochesMR(Integer pacienciaCochesMR) {
		PacienciaCochesMR = pacienciaCochesMR;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(PacienciaCochesMR, PacienciaCochesNormales, probabilidadesMinusvalia,
				tiempoDuracionEstanciaCoches, tiempoGeneracionCoches);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeneradorTiempo other = (GeneradorTiempo) obj;
		return Objects.equals(PacienciaCochesMR, other.PacienciaCochesMR)
				&& Objects.equals(PacienciaCochesNormales, other.PacienciaCochesNormales)
				&& Objects.equals(probabilidadesMinusvalia, other.probabilidadesMinusvalia)
				&& Objects.equals(tiempoDuracionEstanciaCoches, other.tiempoDuracionEstanciaCoches)
				&& Objects.equals(tiempoGeneracionCoches, other.tiempoGeneracionCoches);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			setProbabilidadesMinusvalia(ThreadLocalRandom.current().nextDouble());
			ComprobarMinusvaliaCoches();
			setTiempoGeneracionCoches(ThreadLocalRandom.current().nextInt(2, 5));
			ComprobarGeneracionCoches();
			setTiempoDuracionEstanciaCoches(ThreadLocalRandom.current().nextInt(40, 60));
			ComprobarEstanciaCoches();
			setPacienciaCochesMR(ThreadLocalRandom.current().nextInt(5));
			ComprobarPacienciaCochesNormalesMR();
			setPacienciaCochesNormales(ThreadLocalRandom.current().nextInt(2));
			ComprobarPacienciaCochesNormales();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
