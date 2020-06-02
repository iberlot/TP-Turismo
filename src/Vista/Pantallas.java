/**
 * @file Pantallas.java
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

import java.util.Calendar;

import funciones.Funciones;

/**
 * @author iberlot <@> ivanberlot@gmail.com
 *
 */
public class Pantallas {

	public void pre_venta() {
		Calendar fecha = Funciones.pedirFecha("Fecha");
		String destino = Funciones.pedirString("Ciudad de destino");
		String partida = Funciones.pedirString("Ciudad de partida");
		String categoria = Funciones.pedirString("Categoria");
		int franjaHoraria = Funciones.pedirEnteroPositivo("Franja horaria ([1] Mañana, [2] Tarde, [3] Noche)", 1, 3);
		int cantidad = Funciones.pedirEnteroPositivo("cantidad");

	}

	public void datos_vuelo() {
		System.out.println("Numero de vuelo: ");
		System.out.println("Cantidad de horas: ");
		System.out.println("Precio: ");
	}

	public void cambiar_datos_vuelos() {
		int respuesta = Funciones
				.pedirEnteroPositivo("Desea cambiar: \n [1] Categoria. \n [2] Franja horaria. \n [3] Cancelar.", 1, 3);

		switch (respuesta) {
		case 1:
			String categoria = Funciones.pedirString("Categoria");

			break;
		case 2:
			int franjaHoraria = Funciones.pedirEnteroPositivo("Franja horaria (1-Mañana, 2-Tarde, 3-Noche)", 1, 3);
			break;
		case 3:

			break;
		default:
			break;
		}
	}

	public void ingrese_documento() {

		int documento = Funciones.pedirEnteroPositivo("Ingrese el numero de documento: ");

	}

	public void pedir_datos_cliente(int documento) {
		System.out.println("Para el cliente con documento: " + documento);
		String nombre = Funciones.pedirString("Ingrese el nombre: ");
		Calendar fechaNac = Funciones.pedirFecha("Ingrese la fecha de nacimiento: ");
		boolean sexo = Funciones.pedirBooleano("ingrese el sexo (V/M): ", "V", "M");

	}

	public static boolean pedirConfirmacionAlta(String dato) {
		return Funciones.pedirBooleano("Decea dar de alta un/a nuevo/a " + dato + " ? s/n", "s", "n");
	}

	public static void mensajes(int codigo) {
		switch (codigo) {
		case 1:
			System.out.println("No se encontraron vuelos con esos parametros. Buscando en otro horario: ");
			break;
		case 2:
			System.out.println("No hay otros horarios. Comience nuevamente: ");
			break;
		case 3:
			System.out.println("Categoria no encontrada");
			break;
		case 4:
			System.out.println("Cantidad de asientos no disponible");
			break;
		case 5:
			System.out.println("No hay otros categorias. Comience nuevamente: ");
			break;
		case 6:
			System.out.println("No se encontro categoria con esa cantidad de asientos. Buscando en otra categoria: ");
			break;
		case 7:
			System.out.println("No se encontraron vuelos con esa categoria. Buscando en otra categoria: ");
			break;
		case 8:
			System.out.println("Cliente nuevo. Ingrese sus datos");
			break;
		default:
			System.out.println("Error de definicion de mensaje.");
			break;
		}
	}
}
