/**
 * @file Menus.java
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
package Vista;

import funciones.Funciones;

public class Menus {

	public static int menu_inicio() {
		System.out.println("MENU del programa");
		System.out.println("1 - ABM de Vuelos");
		System.out.println("2 - ABM de Pasajeros");
		System.out.println("3 - Reserva de pasajes");
		System.out.println("4 - Listar reservas");
		System.out.println("66 - SALIR");

		return Funciones.pedirEnteroPositivo("");
	}

	public static int menu_vuelos() {
		System.out.println("ABM de Vuelos");
		System.out.println("1 - Alta de Vuelos");
//		System.out.println("2 - Baja de Vuelos");
//		System.out.println("3 - Modificacion de Vuelos");
		System.out.println("4 - Listado de Vuelos");
		System.out.println("66 - Menu anterior");

		return Funciones.pedirEnteroPositivo("");
	}
	
	public static int menu_Pasajeros() {
		System.out.println("ABM de Pasajeros");
		System.out.println("1 - Alta de Pasajeros");
//		System.out.println("2 - Baja de Pasajeros");
//		System.out.println("3 - Modificacion de Pasajeros");
		System.out.println("4 - Listado de Pasajeros");
		System.out.println("66 - Menu anterior");

		return Funciones.pedirEnteroPositivo("");
	}
	
	public static int menu_preventa() {
		System.out.println("ABM de Reservas");
		System.out.println("1 - Alta de Reservas");
		System.out.println("2 - Baja de Reservas");
		System.out.println("3 - Modificacion de Reservas");
		System.out.println("66 - Menu anterior");

		return Funciones.pedirEnteroPositivo("");
	}
}
