package com.resonance.model.hospedajes;

/**
 * Proyecto de programaci�n - Analisis de algoritmos
 * 
 * @author Cesar Marquez, Brian Giraldo, Esteban Sanchez
 *
 */
public class Plus {
	private boolean cocina;
	private boolean wifi;
	private boolean utencilios;
	private boolean aireAc;
	private boolean kitBanio;

	/**
	 * Metodo constructor de la clase
	 * 
	 * @param cocina
	 * @param wifi
	 * @param utencilios
	 * @param aireAc
	 * @param kitBanio
	 */
	public Plus(boolean cocina, boolean wifi, boolean utencilios, boolean aireAc, boolean kitBanio) {
		super();

		this.cocina = cocina;
		this.wifi = wifi;
		this.utencilios = utencilios;
		this.aireAc = aireAc;
		this.kitBanio = kitBanio;
	}

	/**
	 * Metodo que retorna si cuenta con el servicio de cocina
	 * 
	 * @return
	 */
	public boolean isCocina() {
		return cocina;
	}

	/**
	 * Metodo que retorna si cuenta con el servicio de WIFI
	 * 
	 * @return
	 */
	public boolean isWifi() {
		return wifi;
	}

	/**
	 * Metodo que retorna si cuenta con el servicio de utencilios
	 * 
	 * @return
	 */
	public boolean isUtencilios() {
		return utencilios;
	}

	/**
	 * Metodo que retorna si cuenta con el servicio de aire acondicionado
	 * 
	 * @return
	 */
	public boolean isAireAc() {
		return aireAc;
	}

	/**
	 * Metodo que retorna si cuenta con el servicio de banio
	 * 
	 * @return
	 */
	public boolean isKitBanio() {
		return kitBanio;
	}

	public String toString() {
		String a = "";
		if (cocina)
			a += "cocina, ";

		if (wifi)
			a += "wifi, ";

		if (utencilios)
			a += "utencilios, ";

		if (aireAc)
			a += "aire acondicionado, ";

		if (kitBanio)
			a += "kit de ba�o";

		return a;
	}

}
