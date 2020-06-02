/**
 * @file Pasajeros.java
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

import java.util.Calendar;

public class Pasajeros {

	private int ndoc;

	private String apellido;

	private String nombre;

	private Calendar fechaNac;

	/**
	 * Definido en modelo como true para varon y false para mujer
	 * 
	 * @var boolean sexo
	 */
	private boolean sexo;

	private boolean clienteFrecuente;

	private int puntos;

	/**
	 * @param ndoc
	 * @param apellido
	 * @param nombre
	 * @param fechaNac
	 * @param sexo
	 * @param clienteFrecuente
	 * @param puntos
	 */
	public Pasajeros(int ndoc, String apellido, String nombre, Calendar fechaNac, boolean sexo, boolean clienteFrecuente,
			int puntos) {
		this.ndoc = ndoc;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		this.clienteFrecuente = clienteFrecuente;
		this.puntos = puntos;
	}

	/**
	 * @param ndoc
	 * @param apellido
	 * @param nombre
	 * @param fechaNac
	 * @param sexo
	 * @param clienteFrecuente
	 */
	public Pasajeros(int ndoc, String apellido, String nombre, Calendar fechaNac, boolean sexo,
			boolean clienteFrecuente) {
		this.ndoc = ndoc;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		this.clienteFrecuente = clienteFrecuente;
	}

	public Pasajeros() {
		// TODO Auto-generated constructor stub
	}

	public int getNdoc() {
		return ndoc;
	}

	public void setNdoc(int ndoc) throws Exception {
		if (ndoc > 99999999 || ndoc < 1) {
			throw new Exception("El numero de documento debe ser mayor a cero y menor a 99.999.999.");
		}
		this.ndoc = ndoc;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Calendar getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Calendar fechaNac) {
		this.fechaNac = fechaNac;
	}

	public boolean getSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public boolean getClienteFrecuente() {
		return clienteFrecuente;
	}

	public void isClienteFrecuente(boolean clienteFrecuente2) {
		this.clienteFrecuente = clienteFrecuente2;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}
