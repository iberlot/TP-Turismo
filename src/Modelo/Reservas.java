/**
 * @file Reservas.java
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

public class Reservas {

	private static int SIGUIENTE_ID = 0;

//	private static int INTERES_ANUAL = 35;

//	private static int DESCUENTO_CLIENTE = 5;

	private int idVenta;
	private Calendar fecha = Calendar.getInstance();
	private String operador;
	private ArrayList<Pasajes> pasajes = new ArrayList<Pasajes>();
//	private String formaPago;

	public Reservas(int id, Calendar fec, String op) {
		idVenta = id;
		fecha = fec;
		operador = op;
//		formaPago = fPago;
	}

	public Reservas() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return El valor de pasajes
	 */
	public ArrayList<Pasajes> getPasajes() {
		return pasajes;
	}

	/**
	 * @param pasajes para cargar en pasajes
	 */
	public void setPasajes(ArrayList<Pasajes> pasajes) {
		this.pasajes = pasajes;
	}
	
	public void addPasaje(Pasajes pasaje)
	{
		this.pasajes.add(pasaje);
	}

	public void addNuevoPasaje(Pasajeros cli, Vuelos vue,boolean preferencial,boolean masEquipaje)
	{
		this.pasajes.add(new Pasajes(cli, vue, preferencial, masEquipaje));
	}
	

	public void addNuevoPasaje(Pasajeros cli, Vuelos vue)
	{
		this.pasajes.add(new Pasajes(cli, vue));
	}
	
	public void setPasaje(Pasajeros cli, Vuelos vue) {
		Pasajes pas = new Pasajes(cli, vue);
//		System.out.println(pas);
		// XXX Puta mierda 1 hora luchando con un null point y resulta que la lista no
		// estaba inicialiada
		pasajes.add(pas);
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

	/**
	 * @return El valor de id
	 */
	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	/**
	 * @return El valor de operador
	 */
	public String getOperador() {
		return operador;
	}

	/**
	 * @param operador para cargar en operador
	 */
	public void setOperador(String operador) {
		this.operador = operador;
	}

	public float calcularTotal() {

		float total = 0;
		for (Pasajes pasaje : pasajes) {
			
			total = total+pasaje.getVuelo().getPrecio();
			
			if(pasaje.isMasEquipaje()==true) {
				total = total+pasaje.getVuelo().getCostoExtra();
				
			}

			System.out.println(total);
		}

		return total;
	}
//
//	/**
//	 * @return El valor de fPago
//	 */
//	public String getFormaPago() {
//		return formaPago;
//	}
//
//	/**
//	 * @param fPago para cargar en fPago
//	 */
//	public void setFormaPago(String fPago) {
//		this.formaPago = fPago;
//	}

	/**
	 * @return
	 */
	public static int getSIGUIENTE_ID() {
		return SIGUIENTE_ID;
	}

	public static void setSIGUIENTE_ID(int numero) {
		SIGUIENTE_ID = numero;
	}

	/**
	 */
	public static int suma_SIGUIENTE_ID() {

		SIGUIENTE_ID = SIGUIENTE_ID + 1;
		return SIGUIENTE_ID;
	}
//
//	/**
//	 * @return El valor de iNTERES_ANUAL
//	 */
//	public static int getINTERES_ANUAL() {
//		return INTERES_ANUAL;
//	}
//
//	/**
//	 * @param iNTERES_ANUAL para cargar en iNTERES_ANUAL
//	 */
//	public static void setINTERES_ANUAL(int iNTERES_ANUAL) {
//		INTERES_ANUAL = iNTERES_ANUAL;
//	}
//
//	/**
//	 * @return El valor de dESCUENTO_CLIENTE
//	 */
//	public static int getDESCUENTO_CLIENTE() {
//		return DESCUENTO_CLIENTE;
//	}
//
//	/**
//	 * @param dESCUENTO_CLIENTE para cargar en dESCUENTO_CLIENTE
//	 */
//	public static void setDESCUENTO_CLIENTE(int dESCUENTO_CLIENTE) {
//		DESCUENTO_CLIENTE = dESCUENTO_CLIENTE;
//	}
}
