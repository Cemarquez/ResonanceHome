package com.resonance.model.hospedajes;

/**
 * Proyecto de programaci�n - Analisis de algoritmos
 * 
 * @author Cesar Marquez, Brian Giraldo, Esteban Sanchez
 *
 */
public class Prestacion {

	private int numHuesped;
	private int numBanios;
	private int numCamas;
	private int numHabitaciones;
	
	private boolean cocina;

	public int getNumHuesped() {
		return numHuesped;
	}

	public void setNumHuesped(int numHuesped) {
		this.numHuesped = numHuesped;
	}

	public int getNumBanios() {
		return numBanios;
	}

	public void setNumBanios(int numBanios) {
		this.numBanios = numBanios;
	}

	public boolean isCocina() {
		return cocina;
	}

	public void setCocina(boolean cocina) {
		this.cocina = cocina;
	}

	/**
	 * @param numHuesped
	 * @param numBanios
	 * @param numCamas
	 * @param numHabitaciones
	 * @param cocina
	 */
	public Prestacion(int numHuesped, int numBanios, int numCamas, int numHabitaciones, boolean cocina) {
		super();
		this.numHuesped = numHuesped;
		this.numBanios = numBanios;
		this.numCamas = numCamas;
		this.numHabitaciones = numHabitaciones;
		this.cocina = cocina;
	}

	public String toString() {
		String cocinaS = "con cocina";

		if (cocina)
			cocinaS = "sin cocina";

		return numBanios + " huespedes, " + numBanios + " ba�os, " + cocinaS;
	}

	/**
	 * @return the numCamas
	 */
	public int getNumCamas() {
		return numCamas;
	}

	/**
	 * @param numCamas the numCamas to set
	 */
	public void setNumCamas(int numCamas) {
		this.numCamas = numCamas;
	}

	/**
	 * @return the numHabitaciones
	 */
	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	/**
	 * @param numHabitaciones the numHabitaciones to set
	 */
	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}
	
	
}
