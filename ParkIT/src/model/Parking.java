package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import controller.GeneradorTiempo;
import view.AnsiColor;
import view.Frame;

public class Parking {
	
	private Frame frame;
	private	Semaphore semaforo;
	private	Semaphore semaforoMovilidadReducida;
	private String nombre;
	private GeneradorTiempo generadorTiempo;
	private int totalPlazas, plazasLibres, plazasOcupadas;
	private int totalMRPlazas, plazasMRLibres, plazasMROcupadas;
	private ArrayList<String> parkingPlazas, spotsLibres, spotsOcupados;
	private ArrayList<String> parkingMRSpots, spotsMRLibres, spotsMROcupados;
	private HashMap<String, Coche> mapaPlazasCoches = new HashMap<String, Coche>();
	private Color verdeLibre, rojoOcupado;
	
	public Parking(GeneradorTiempo generadorTiempo, Frame frame, Semaphore semaforo, Semaphore semaforoMR, 
			String nombre, int totalPlazas, int totalMRPlazas) {
		this.generadorTiempo = generadorTiempo;
		this.frame = frame;
		this.semaforo = semaforo;
		this.semaforoMovilidadReducida = semaforoMR;
		this.nombre = nombre;
		this.totalPlazas = totalPlazas;
		this.totalMRPlazas = totalMRPlazas;
		this.plazasLibres = totalPlazas;
		this.plazasMRLibres = totalMRPlazas;
		this.plazasOcupadas = 0;
		this.plazasMROcupadas = 0;
		
		this.parkingPlazas = new ArrayList<String>();
		this.spotsOcupados = new ArrayList<String>();
		this.parkingMRSpots = new ArrayList<String>();
		this.spotsMROcupados = new ArrayList<String>();
		
		this.verdeLibre = new Color(50, 205, 50);
		this.rojoOcupado = new Color(255, 99, 71);
		
		crearPlazasParking();
		crearPlazasMR();
		this.spotsLibres = parkingPlazas;
		this.spotsMRLibres = parkingMRSpots;
		
	}
	
	@Override
	public String toString() {
		return "Parking [nombre=" + nombre + ", totalPlazas=" + totalPlazas + ", plazasLibres="
				+ plazasLibres + ", plazasOcupadas=" + plazasOcupadas + ", totalMRPlazas="
				+ totalMRPlazas + ", plazasMRLibres=" + plazasMRLibres + ", plazasMROcupadas="
				+ plazasMROcupadas + "]";
	}

	public String solicitarPlaza(Coche coche) {
		String respuesta = "pendiente";
		
		try {
			
			if (coche.isMovilidadReducida()) {
				if (semaforoMovilidadReducida.tryAcquire(
						generadorTiempo.getPacienciaCochesMR(), TimeUnit.SECONDS) == true
				) {
					respuesta = "permitido";
				} else {
					respuesta = "expirado";
				}
			} else {
				if (semaforo.tryAcquire(
						generadorTiempo.getPacienciaCochesNormales(), TimeUnit.SECONDS) == true
				) {
					respuesta = "permitido";
				} else {
					respuesta = "expirado";
				};
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return respuesta;
	}
	
	public synchronized String aparcarCoche(Coche coche) {
		
		String plaza;
		
		if (coche.isMovilidadReducida()) {
			plazasMROcupadas++;
			plazasMRLibres--;
			
			int indiceAleatorio = ThreadLocalRandom.current().nextInt(0, spotsMRLibres.size());
			plaza = spotsMRLibres.get(indiceAleatorio);
			spotsMRLibres.remove(indiceAleatorio);
			spotsMROcupados.add(plaza);
			
			this.frame.getPanelParking().getPanelPAreaC().getBtnByName(plaza).setBackground(rojoOcupado);
		} else {
			plazasOcupadas++;
			plazasLibres--;	
			
			int indiceAleatorio = ThreadLocalRandom.current().nextInt(0, spotsLibres.size());
			plaza = spotsLibres.get(indiceAleatorio);
			spotsLibres.remove(indiceAleatorio);
			spotsOcupados.add(plaza);
			
			if (plaza.startsWith("A")) {
				this.frame.getPanelParking().getPanelPAreaA().getBtnByName(plaza).setBackground(rojoOcupado);
			} else if (plaza.startsWith("B")) {
				this.frame.getPanelParking().getPanelPAreaB().getBtnByName(plaza).setBackground(rojoOcupado);
			} else if (plaza.startsWith("C")) {
				this.frame.getPanelParking().getPanelPAreaC().getBtnByName(plaza).setBackground(rojoOcupado);
			}
		}
		
		mapaPlazasCoches.put(plaza, coche);
			
		System.out.println(
				AnsiColor.GREEN
				+ coche.getMatricula() 
				+ " " + coche.getModelo()
				+ (coche.isMovilidadReducida() ? " (((movilidad reducida)))," : "")
				+ " ha recibido un PERMIT y ha APARCADO en la plaza " + plaza
				+ AnsiColor.RESET
		);
		
		System.out.println(
				AnsiColor.PURPLE 
				+ "plazasLibres: " 
				+ this.plazasLibres
				+ " plazasOcupadas: " 
				+ this.plazasOcupadas
				+ AnsiColor.RESET
		);
		
		return plaza;

	}
	
	public synchronized void marcharCoche(Coche coche, String plaza) {
		if (coche.isMovilidadReducida()) {
			semaforoMovilidadReducida.release();
			
			plazasMRLibres++;
			plazasMROcupadas--;
			
			spotsMROcupados.remove(plaza);
			spotsMRLibres.add(plaza);
			
			this.frame.getPanelParking().getPanelPAreaC().getBtnByName(plaza).setBackground(verdeLibre);
		} else {
			semaforo.release();
			
			plazasLibres++;
			plazasOcupadas--;
			
			spotsOcupados.remove(plaza);
			spotsLibres.add(plaza);	
			
			if (plaza.startsWith("A")) {
				this.frame.getPanelParking().getPanelPAreaA().getBtnByName(plaza).setBackground(verdeLibre);
			} else if (plaza.startsWith("B")) {
				this.frame.getPanelParking().getPanelPAreaB().getBtnByName(plaza).setBackground(verdeLibre);
			} else if (plaza.startsWith("C")) {
				this.frame.getPanelParking().getPanelPAreaC().getBtnByName(plaza).setBackground(verdeLibre);
			}
		}
		
		System.err.println(
				AnsiColor.YELLOW 
				+ coche.getMatricula()
				+ " " + coche.getModelo()
				+ (coche.isMovilidadReducida() ? " (((movilidad reducida)))," : "")
				+ " abandona la plaza " + plaza + " de aparcamiento"
				+ AnsiColor.RESET
		);
		
		
		System.out.println(
				AnsiColor.PURPLE 
				+ "plazasLibres: " 
				+ this.plazasLibres
				+ " plazasOcupadas: " 
				+ this.plazasOcupadas
				+ AnsiColor.RESET
		);	
	}
	
	public void crearPlazasParking() {
		String plaza;
		for (int i = 1; i <= 22; i++) {
			plaza = "A" + String.format("%02d", i);
			parkingPlazas.add(plaza);
			mapaPlazasCoches.put(plaza, null);
		}
		for (int i = 1; i <= 44; i++) {
			plaza = "B" + String.format("%02d", i);
			parkingPlazas.add(plaza);
			mapaPlazasCoches.put(plaza, null);
		}
		for (int i = 1; i <= 41; i++) {
			plaza = "C" + String.format("%02d", i);
			parkingPlazas.add(plaza);
			mapaPlazasCoches.put(plaza, null);
		}
	}
	
	public void crearPlazasMR() {
		parkingMRSpots.add("MR01");
		parkingMRSpots.add("MR02");
		mapaPlazasCoches.put("MR01", null);
		mapaPlazasCoches.put("MR02", null);
	}

	public synchronized int getPlazasLibres() {
		return plazasLibres;
	}

	public synchronized int getPlazasOcupadas() {
		return plazasOcupadas;
	}
	
	public GeneradorTiempo getGeneradorTiempo() {
		return generadorTiempo;
	}

	public void setGeneradorTiempo(GeneradorTiempo generadorTiempo) {
		this.generadorTiempo = generadorTiempo;
	}

	public HashMap<String, Coche> getMapaPlazasCoches() {
		return mapaPlazasCoches;
	}
	
}







