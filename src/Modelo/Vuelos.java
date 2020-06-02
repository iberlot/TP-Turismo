/**

	private static int SIGUIENTE_NUMERO = 0;
 * @file Vuelos.java
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

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author iberlot <@> ivanberlot@gmail.com
 *
 */
public class Vuelos {

	private static int SIGUIENTE_NUMERO = 0;

	private int numero;

	private String companiaAerea;
	
	private String ciudadDestino;

	private String ciudadPartida;

	private float horasDeViaje;

	private String franjaHoraria;

	private Calendar fecha;
	
	private boolean directo;

	private float precio;

	private int cantButacas;
	
	private int cantDisponibles;
	
	private float costoExtra;
	
	public Vuelos() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param numero
	 * @param ciudadDestino
	 * @param ciudadPartida
	 * @param cat
	 * @param horasDeViaje
	 * @param franjaHoraria
	 * @param fecha
	 */
	public Vuelos(int numero, Calendar fecha, String ciudadPartida, String ciudadDestino, float horasDeViaje,
			String franjaHoraria) {
		this.numero = numero;
		this.ciudadDestino = ciudadDestino;
		this.ciudadPartida = ciudadPartida;
		this.horasDeViaje = horasDeViaje;
		this.franjaHoraria = franjaHoraria;
		this.fecha = fecha;
		this.directo = true;
	}
	/**
	 * @param numero
	 * @param ciudadDestino
	 * @param ciudadPartida
	 * @param cat
	 * @param horasDeViaje
	 * @param franjaHoraria
	 * @param fecha
	 * @param directo
	 */
	public Vuelos(int numero, Calendar fecha, String ciudadPartida, String ciudadDestino, float horasDeViaje,
			String franjaHoraria, boolean directo) {
		this.numero = numero;
		this.ciudadDestino = ciudadDestino;
		this.ciudadPartida = ciudadPartida;
		this.horasDeViaje = horasDeViaje;
		this.franjaHoraria = franjaHoraria;
		this.fecha = fecha;
		this.directo = directo;
	}
	
	/**
	 * @param numero
	 * @param companiaAerea
	 * @param ciudadDestino
	 * @param ciudadPartida
	 * @param horasDeViaje
	 * @param franjaHoraria
	 * @param fecha
	 * @param directo
	 * @param precio
	 * @param cantButacas
	 */
	public Vuelos(int numero, String companiaAerea, String ciudadDestino, String ciudadPartida, float horasDeViaje,
			String franjaHoraria, Calendar fecha, boolean directo, float precio, int cantButacas) {
		this.numero = numero;
		this.companiaAerea = companiaAerea;
		this.ciudadDestino = ciudadDestino;
		this.ciudadPartida = ciudadPartida;
		this.horasDeViaje = horasDeViaje;
		this.franjaHoraria = franjaHoraria;
		this.fecha = fecha;
		this.directo = directo;
		this.precio = precio;
		this.cantButacas = cantButacas;
		
		this.cantDisponibles= cantButacas;
	}


	public String toString() {
		
		return "\ncompania Aerea: "+companiaAerea
				+ "\nciudadDestino: "+ciudadDestino
				+"\nciudadPartida: "+ciudadPartida
				+"\nhorasDeViaje: "+horasDeViaje
				+ "\nfranjaHoraria: "+franjaHoraria
				+ "\nfecha: "+fecha
				+ "\ndirecto: "+directo
				+"\nprecio: "+precio
				+ "\ncantButacas: "+cantButacas
				+"\ncantDisponibles: "+ cantDisponibles+"\n\n";
	}
	
	/**
	 * @return the directo
	 */
	public boolean isDirecto() {
		return directo;
	}

	/**
	 * @param directo the directo to set
	 */
	public void setDirecto(boolean directo) {
		this.directo = directo;
	}


	/**
	 * @return El valor de numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero para cargar en numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return El valor de ciudadDestino
	 */
	public String getCiudadDestino() {
		return ciudadDestino;
	}

	/**
	 * @param ciudadDestino para cargar en ciudadDestino
	 */
	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

	/**
	 * @return El valor de ciudadPartida
	 */
	public String getCiudadPartida() {
		return ciudadPartida;
	}

	/**
	 * @param ciudadPartida para cargar en ciudadPartida
	 */
	public void setCiudadPartida(String ciudadPartida) {
		this.ciudadPartida = ciudadPartida;
	}

	/**
	 * @return El valor de horasTardadas
	 */
	public float getHorasDeViaje() {
		return horasDeViaje;
	}

	/**
	 * @param horasTardadas para cargar en horasTardadas
	 */
	public void setHorasDeViaje(float horasDeViaje) {
		this.horasDeViaje = horasDeViaje;
	}

	/**
	 * @return El valor de franjaHoraSalida
	 */
	public String getFranjaHoraria() {
		return franjaHoraria;
	}

	/**
	 * @param franjaHoraSalida para cargar en franjaHoraSalida
	 */
	public void setFranjaHoraria(String franjaHoraria) {
		this.franjaHoraria = franjaHoraria;
	}

	/**
	 * @return El valor de fecha
	 */
	public Calendar getFecha() {
		return fecha;
	}

	/**
	 * @param fecha para cargar en fecha
	 */
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public static int getSIGUIENTE_NUMERO() {
		return SIGUIENTE_NUMERO;
	}

	public static void setSIGUIENTE_NUMERO(int sIGUIENTE_NUMERO) {
		SIGUIENTE_NUMERO = sIGUIENTE_NUMERO;
	}

	/**
	 */
	public static int suma_SIGUIENTE_NUMERO() {
		SIGUIENTE_NUMERO = SIGUIENTE_NUMERO + 1;
		return SIGUIENTE_NUMERO;
	}

	/**
	 * @return the companiaAerea
	 */
	public String getCompaniaAerea() {
		return companiaAerea;
	}

	/**
	 * @param companiaAerea the companiaAerea to set
	 */
	public void setCompaniaAerea(String companiaAerea) {
		this.companiaAerea = companiaAerea;
	}

	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * @return the cantButacas
	 */
	public int getCantButacas() {
		return cantButacas;
	}

	/**
	 * @param cantButacas the cantButacas to set
	 */
	public void setCantButacas(int cantButacas) {
		this.cantButacas = cantButacas;
	}

	/**
	 * @return the cantDisponibles
	 */
	public int getCantDisponibles() {
		return cantDisponibles;
	}

	/**
	 * @param cantDisponibles the cantDisponibles to set
	 */
	public void setCantDisponibles(int cantDisponibles) {
		this.cantDisponibles = cantDisponibles;
	}
	
	public void venderButaca() {
		this.cantDisponibles--;
	}

	/**
	 * @return the costoExtra
	 */
	public float getCostoExtra() {
		return costoExtra;
	}

	/**
	 * @param costoExtra the costoExtra to set
	 */
	public void setCostoExtra(float costoExtra) {
		this.costoExtra = costoExtra;
	}
}
