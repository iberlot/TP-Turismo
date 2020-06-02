/**
 * @file Categorias.java
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

public class Categorias {

	private int numero;

	private String categoria;

	private float precio;

	private boolean discap;

	private int cantDisponibles;

	/**
	 * @param numero
	 * @param categoria
	 * @param precio
	 * @param discap
	 * @param cantDisponibles
	 */
	public Categorias(int numero, String categoria, float precio, boolean discap, int cantDisponibles) {
		this.numero = numero;
		this.categoria = categoria;
		this.precio = precio;
		this.discap = discap;
		this.cantDisponibles = cantDisponibles;
	}

	public Categorias() {
		// TODO Auto-generated constructor stub
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
	 * @return El valor de categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria para cargar en categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return El valor de precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * @param precio para cargar en precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * @return El valor de discap
	 */
	public boolean isDiscap() {
		return discap;
	}

	/**
	 * @param discap para cargar en discap
	 */
	public void setDiscap(boolean discap) {
		this.discap = discap;
	}

	/**
	 * @return El valor de cantDisponibles
	 */
	public int getCantDisponibles() {
		return cantDisponibles;
	}

	/**
	 * @param cantDisponibles para cargar en cantDisponibles
	 */
	public void setCantDisponibles(int cantDisponibles) {
		this.cantDisponibles = cantDisponibles;
	}

}
