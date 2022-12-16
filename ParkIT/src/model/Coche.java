package model;

import java.util.concurrent.ThreadLocalRandom;

import view.AnsiColor;

public class Coche implements Runnable {
	
	private String matricula;
	private String modelo;
	private boolean movilidadReducida;
	private Parking parking;
	private int duracionEstancia;
	private String permisoAparcamiento;
	private String plaza;
	
	public Coche(String matricula, String modelo, Parking parking, boolean movilidadReducida) {
		this.matricula = matricula;
		this.modelo = modelo; 
		this.movilidadReducida = movilidadReducida;
		this.parking = parking;
		this.duracionEstancia = ThreadLocalRandom.current().nextInt(40, 60);
		this.permisoAparcamiento = "pendiente";
		this.plaza = "";
	}
	
	@Override
	public String toString() {
		return "Coche\n [matricula=" + matricula + ",\n modelo=" + modelo + ",\n movilidadReducida="
				+ movilidadReducida + ",\n plaza=" + plaza + "]";
	}

	@Override
	public void run() {
		System.out.println(
				AnsiColor.WHITE 
				+ this.matricula 
				+ " " + this.modelo 
				+ (this.isMovilidadReducida() ? " (((movilidad reducida)))," : "")
				+ " solicita aparcar"
				+ AnsiColor.RESET
		);
		try {
			Thread.sleep(2_000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		permisoAparcamiento = parking.solicitarPlaza(this);
		
		if (!permisoAparcamiento.equals("expirado")) {
			if (permisoAparcamiento.equals("permitido")) {
				this.plaza = parking.aparcarCoche(this);
				
				try {
					Thread.sleep(parking.getGeneradorTiempo().getTiempoDuracionEstanciaCoches() * 1_000);
				} catch (InterruptedException e) { }
				
				parking.marcharCoche(this, this.plaza);
			}
		} else {
			System.out.println(
				AnsiColor.RED 
				+ this.matricula
				+ " " + this.modelo
				+ (this.isMovilidadReducida() ? " (((movilidad reducida)))," : "")
				+ " ha agotado su paciencia y se marcha"
				+ AnsiColor.RESET
			);
		}
		
	}

	public String getMatricula() {
		return matricula;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getDuracionEstancia() {
		return duracionEstancia;
	}

	public boolean isMovilidadReducida() {
		return movilidadReducida;
	}

	public String getPermisoAparcamiento() {
		return permisoAparcamiento;
	}

	public String getPlaza() {
		return plaza;
	}
	
}




