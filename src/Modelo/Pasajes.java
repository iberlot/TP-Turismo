/**
 * @file Pasajes.java
 * @author iberlot <@> ivanberlot@gmail.com
 * @since 6 may. 2019
 * @version 0.1 - Version de inicio
 */

/*
 * Querido programador:
 *
 * Cuando escribi este codigo, solo Dios y yo sabiamos como funcionaba.
 * Ahora, Solo Dios lo sabe!!!
 *
 * Asi que, si esta tratando de 'optimizar' esta rutina y fracasa (seguramente),
 * por favor, incremente el siguiente contador como una advertencia para el
 * siguiente colega:
 *
 * totalHorasPerdidasAqui = 1
 *
 */
package Modelo;

public class Pasajes {

	private Pasajeros cliente;

	private Vuelos vuelo;

	private boolean preferencial;
	private boolean masEquipaje;

	public Pasajes(Pasajeros cli, Vuelos vue) {
		cliente = cli;
		vuelo = vue;
		preferencial = false;
		masEquipaje = false;
	}

	public Pasajes() {
		preferencial = false;
		masEquipaje = false;
		// TODO Auto-generated constructor stub
	}

	public Pasajes(Pasajeros cli, Vuelos vue, boolean preferencial2, boolean masEquipaje2) {

		cliente = cli;
		vuelo = vue;
		preferencial = preferencial2;
		masEquipaje = masEquipaje2;
	}

	public String toString() {

		String a = "";
		

		if(masEquipaje == true) {
			a += "Contrata mas equipaje.\n";
		}
		
		if(preferencial == true) {
			a += "Necesita tratamiento preferencial.\n";
		}
		
		return " Cliente: " + cliente.getApellido() + ", " + cliente.getNombre() + "\n Vuelo: " + vuelo.getNumero()
				+ " - " + vuelo.getCiudadPartida() + "/" + vuelo.getCiudadDestino() + "\n "
				+ a+ "\n\n";
	}

	/**
	 * @return El valor de cliente
	 */
	public Pasajeros getCliente() {
		return cliente;
	}

	/**
	 * @param cliente para cargar en cliente
	 */
	public void setCliente(Pasajeros cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return El valor de vuelo
	 */
	public Vuelos getVuelo() {
		return vuelo;
	}

	/**
	 * @param vuelo para cargar en vuelo
	 */
	public void setVuelo(Vuelos vuelo) {
		this.vuelo = vuelo;
	}

	/**
	 * @return the preferencial
	 */
	public boolean isPreferencial() {
		return preferencial;
	}

	/**
	 * @param preferencial the preferencial to set
	 */
	public void setPreferencial(boolean preferencial) {
		this.preferencial = preferencial;
	}

	/**
	 * @return the masEquipaje
	 */
	public boolean isMasEquipaje() {
		if(masEquipaje == true)
		{
			return masEquipaje;
		}
		else {
			return false;
		}
	}

	/**
	 * @param masEquipaje the masEquipaje to set
	 */
	public void setMasEquipaje(boolean masEquipaje) {
		this.masEquipaje = masEquipaje;
	}

}
