/**
 * @file CPrincipal.java
 * @author iberlot <@> ivanberlot@gmail.com
 * @since 15 may. 2019
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

package Controlador;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;

import Modelo.Categorias;
import Modelo.Pasajeros;
import Modelo.Pasajes;
import Modelo.Reservas;
import Modelo.Vuelos;
import Modelo.DAO.daoPasajeros;
import Modelo.DAO.daoReservas;
import Modelo.DAO.daoVuelos;
import Vista.Menus;
import Vista.Pantallas;
import Vista.VCategorias;
import Vista.VPasajeros;
import Vista.VPasajes;
import Vista.VReservas;
import Vista.VVuelos;
import funciones.Fechas;

/**
 * @author iberlot <@> ivanberlot@gmail.com
 *
 */
public class CPrincipal {

	/**
	 * Listados de los Pasajeros registrados en el sistema.
	 * 
	 * @var ArrayList<Pasajeros> Pasajeros
	 */
	private ArrayList<Pasajeros> pasajeros = new ArrayList<Pasajeros>();

	private ArrayList<Vuelos> vuelos = new ArrayList<Vuelos>();

	private ArrayList<Reservas> reservas = new ArrayList<Reservas>();

	private String OPERADOR;

	private Calendar fechaHoy = Calendar.getInstance();

	public void inicializar_archivos() throws Exception {

		daoPasajeros daoClient = new daoPasajeros();
		pasajeros = daoClient.recuperar_datos_archivo();

		daoVuelos daoVuelos = new daoVuelos();
		vuelos = daoVuelos.recuperar_datos_archivo();

		daoReservas daoreserva = new daoReservas();
		reservas = daoreserva.recuperar_datos_archivo(vuelos, pasajeros);

		for (int i = 0; i < reservas.size(); i++) {
			if (Fechas.diferenciaDiasTotal(reservas.get(i).getFecha(), fechaHoy) > 3) {
				reservas.remove(i);
			}

		}
	}

	public void inicio() throws Exception {

		switch (Menus.menu_inicio()) {
		case 1:
			abm_Vuelos();
			break;
		case 2:
			abm_Pasajeros();
			break;
		case 3:
			reservas.add(nuevareserva());
			break;
		case 4:
			listar_reservas();
			break;
		case 5:
			confirmar_reserva();
			break;
		case 66:
			System.exit(0);
			break;

		}
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Precione una tecla para continuar...");
		stdin.nextLine();
		inicio();
	}

	private void confirmar_reserva() throws IOException {
		VReservas vistareserva = new VReservas();
		daoReservas daoreserva = new daoReservas();
		int i = vistareserva.pedirNumVenta();

		daoreserva.crearJSON(reservas.get(i));
		reservas.remove(i);
	}

	private void listar_reservas() {

		for (int i = 0; i < reservas.size(); i++) {

			VReservas vistareserva = new VReservas();
			CReservas controlerReservas = new CReservas(reservas.get(i), vistareserva);

			controlerReservas.mostrar();

		}
	}

	public void abm_Vuelos() throws Exception {
		switch (Menus.menu_vuelos()) {
		case 1:
			vuelos.add(nuevoVuelo());
			break;
		case 2:

			break;
		case 3:

			break;
		case 4:
			listarVuelos();
			break;
		case 66:
			inicio();
			break;

		}
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Precione una tecla para continuar...");
		stdin.nextLine();
		abm_Vuelos();
	}

	private void listarVuelos() {

		for (int i = 0; i < vuelos.size(); i++) {

			VVuelos vistaVuelo = new VVuelos();

			CVuelos controlerVuelo = new CVuelos(vuelos.get(i), vistaVuelo);

			controlerVuelo.mostrar();

		}
	}

	private Vuelos nuevoVuelo() throws Exception {
		Vuelos vuelo = new Vuelos();

		VVuelos vistaVuelo = new VVuelos();

		CVuelos controlerVuelo = new CVuelos(vuelo, vistaVuelo);

		controlerVuelo.setNumero();
		controlerVuelo.setCiudadPartida();
		controlerVuelo.setCiudadDestino();
		controlerVuelo.setFecha();
		controlerVuelo.setFranjaHoraria();
		controlerVuelo.setHorasDeViaje();

//		nuevaCategoria(controlerVuelo);

		controlerVuelo.grabar();

		return vuelo;

	}

	public void abm_Pasajeros() throws Exception {
		switch (Menus.menu_Pasajeros()) {
		case 1:
			pasajeros.add(nuevoCliente());
			break;
		case 2:

			break;
		case 3:

			break;
		case 4:
			listarPasajeros();
			break;
		case 66:
			inicio();
			break;

		}
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Precione una tecla para continuar...");
		stdin.nextLine();
		abm_Pasajeros();
	}

	private void listarPasajeros() {

		for (int i = 0; i < pasajeros.size(); i++) {

			mostrarCliente(pasajeros.get(i));
		}
	}

	public void abm_Preventa() throws Exception {
		switch (Menus.menu_preventa()) {
		case 1:
			reservas.add(nuevareserva());
			break;
		case 2:

			break;
		case 3:

			break;
		case 66:
			inicio();
			break;

		}
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Precione una tecla para continuar...");
		stdin.nextLine();
		abm_Preventa();
	}

	private void mostrarCliente(Pasajeros cliente) {

		VPasajeros vistaCliente = new VPasajeros();

		CPasajeros controlerCliente = new CPasajeros(cliente, vistaCliente);

		controlerCliente.mostrar();

	}

	private Pasajeros nuevoCliente() throws Exception {

		Pasajeros cliente = new Pasajeros();

		VPasajeros vistaCliente = new VPasajeros();

		CPasajeros controlerCliente = new CPasajeros(cliente, vistaCliente);

		controlerCliente.setNDoc();
		controlerCliente.setApellido();
		controlerCliente.setNombre();
		controlerCliente.setSexo();
		controlerCliente.setFechaNac();

		controlerCliente.grabar();

		return cliente;
	}

	public Reservas nuevareserva() throws Exception {
		Reservas reserva = new Reservas();
		VReservas vistareserva = new VReservas();
		CReservas controlerReservas = new CReservas(reserva, vistareserva);

		VVuelos vistaVuelo = new VVuelos();
		VPasajeros vistaCliente = new VPasajeros();

		// Pido datos para buscar vuelo
		Calendar fecha = vistaVuelo.pedirFecha();
		String ciudadPartida = vistaVuelo.pedirCiudadPartida();
		String ciudadDestino = vistaVuelo.pedirCiudadDestino();
		String franja = vistaVuelo.pedirFranjaHoraria();

		boolean directo = vistaVuelo.pedirDirecto();
		int cantidadPasajes = vistaVuelo.pedirCantidadPasajes();

		int indexVuelo = -1;
		do {
			indexVuelo = buscarVuelo(fecha, ciudadPartida, ciudadDestino, franja, directo, cantidadPasajes);

			if (indexVuelo < 0) {
				// XXX pantallas es candidato de convertirse en excepcion
				Pantallas.mensajes(1);
				// XXX aca tiene que preguntar si la franja horaria nueva esta bien y si no es
				// asi cambiar la escala en la busqueda.

				indexVuelo = ofreceOtroHorarioVuelo(fecha, ciudadPartida, ciudadDestino, franja, directo,
						cantidadPasajes);

				if (indexVuelo < 0) {

					indexVuelo = ofreceOtroEscalaVuelo(fecha, ciudadPartida, ciudadDestino, franja, directo,
							cantidadPasajes);

					if (indexVuelo < 0) {
						Pantallas.mensajes(2);
						return null;
					}
				}

			}

		} while (indexVuelo < 0);

		// muestro info del vuelo
		CVuelos controlerVuelo = new CVuelos(vuelos.get(indexVuelo), vistaVuelo);

		controlerVuelo.mostrar();

		int flagPasajes = cantidadPasajes;

		do {
			int indexCliente = buscarCliente(vistareserva.pedirNdoc());

			if (indexCliente >= 0) {
				CPasajeros controlerCliente = new CPasajeros(pasajeros.get(indexCliente), vistaCliente);
				controlerCliente.mostrar();

			} else {
				Pantallas.mensajes(8);

				CPasajeros controlerCliente = new CPasajeros(nuevoCliente(), vistaCliente);

				controlerCliente.mostrar();
			}

			// creo el pasaje
			controlerReservas.addPasajes(pasajeros.get(indexCliente), vuelos.get(indexVuelo),
					vistareserva.peirTratoPreferencial(), vistareserva.peirMasEquipaje());
//			controlerReservas.getLastPasajes().setMasEquipaje(vistareserva.peirMasEquipaje());
//			controlerReservas.getLastPasajes().setPreferencial(vistareserva.peirTratoPreferencial());

			// le resto 1 asiento a la categoria
			controlerVuelo.restarAsiento();

			flagPasajes--;
		} while (flagPasajes > 0);

		controlerReservas.setOperador(getOPERADOR());
//		controlerReservas.mostrarTotal();
		// controlerReservas.setFormaPago();
		controlerReservas.calcular_total_pago();

		// mostrar pasajes
		Iterator<Pasajes> it = reserva.getPasajes().iterator();
		VPasajes vistaPasaje = new VPasajes();

		controlerReservas.mostrar();
		controlerVuelo.mostrar();

		while (it.hasNext()) {
			Pasajes pas = it.next();
			CPasajes controlerPasaje = new CPasajes(pas, vistaPasaje);
			controlerPasaje.mostrar();
		}

		// TODO Hay que calcular los puntos. Los puntos de la reserva van a ir al
		// cliente
		// del primer pasaje cargado en la misma ya que consideramos que este es el que
		// realiza la compra
		CPasajeros controlerCliente = new CPasajeros(reserva.getPasajes().get(0).getCliente(), vistaCliente);
		controlerCliente.calcularSumarPuntos(controlerReservas.calcularTotal());

		// TODO antes de cerrar la funcion hay que hacer el registro en los archivos
		controlerReservas.grabar();
		return reserva;
	}

	public int buscarVuelo(Calendar fecha, String ciudadPartida, String ciudadDestino, String franja, boolean directo,
			int cantidadPasajes) throws Exception {
		Iterator<Vuelos> it = vuelos.iterator();

		while (it.hasNext()) {
			Vuelos vue = it.next();
			// XXX aca lo modifico, tenemos que recordar que en java los string se comparan
			// con equals
			if ((Fechas.diferenciaDiasTotal(vue.getFecha(), fecha) == 0)
					&& (vue.getCiudadPartida().equalsIgnoreCase(ciudadPartida))
					&& (vue.getCiudadDestino().equalsIgnoreCase(ciudadDestino))
					&& (vue.getFranjaHoraria().equalsIgnoreCase(franja)) && (vue.isDirecto() == directo)
					&& (vue.getCantDisponibles() > cantidadPasajes)) {
				return vuelos.indexOf(vue);
			}
		}

		return -1;
	}

	public int ofreceOtroHorarioVuelo(Calendar fecha, String ciudadPartida, String ciudadDestino, String franja,
			boolean directo, int cantidadPasajes) throws ParseException {
		Iterator<Vuelos> it = vuelos.iterator();

		while (it.hasNext()) {
			Vuelos vue = it.next();

			if ((Fechas.diferenciaDiasTotal(vue.getFecha(), fecha) == 0)
					&& (vue.getCiudadPartida().equalsIgnoreCase(ciudadPartida))
					&& (vue.getCiudadDestino().equalsIgnoreCase(ciudadDestino))
					&& (!vue.getFranjaHoraria().equalsIgnoreCase(franja)) && (vue.isDirecto() == directo)
					&& (vue.getCantDisponibles() > cantidadPasajes)) {

				return vuelos.indexOf(vue);
			}
		}

		return -1;
	}

	public int ofreceOtroEscalaVuelo(Calendar fecha, String ciudadPartida, String ciudadDestino, String franja,
			boolean directo, int cantidadPasajes) throws ParseException {
		Iterator<Vuelos> it = vuelos.iterator();

		while (it.hasNext()) {
			Vuelos vue = it.next();

			if ((Fechas.diferenciaDiasTotal(vue.getFecha(), fecha) == 0)
					&& (vue.getCiudadPartida().equalsIgnoreCase(ciudadPartida))
					&& (vue.getCiudadDestino().equalsIgnoreCase(ciudadDestino))
					&& (vue.getFranjaHoraria().equalsIgnoreCase(franja)) && (!vue.isDirecto() == directo)
					&& (vue.getCantDisponibles() > cantidadPasajes)) {

				return vuelos.indexOf(vue);
			}
		}

		return -1;
	}
//
//	public int buscarCategoria(Vuelos vue, String categoria, int cantidadPasajes) {
//		Iterator<Categorias> itc = vue.getCat().iterator();
//
//		int flagCat = -1;
//
//		while (itc.hasNext()) {
//			Categorias cat = itc.next();
//
//			if (cat.getCategoria().equalsIgnoreCase(categoria)) {
//				flagCat = 1;
//				if (cat.getCantDisponibles() >= cantidadPasajes) {
//					// devuelve indice de la categoria buscada
//					return vue.getCat().indexOf(cat);
//				}
//			}
//		}
//
//		if (flagCat < -1) {
//			Pantallas.mensajes(3);
//			return -1;
//		} else {
//			Pantallas.mensajes(4);
//			return -2;
//		}
//
//	}
//
//	public int ofrecerOtraCategoria(Vuelos vue, String categoria, int cantidadPasajes) {
//
//		VCategorias vistaCategoria = new VCategorias();
//
//		Iterator<Categorias> itc = vue.getCat().iterator();
//
//		int flagCat = -1;
//
//		while (itc.hasNext()) {
//			Categorias cat = itc.next();
//
//			if (cat.getCategoria() != categoria) {
//				flagCat = 1;
//				if (cat.getCantDisponibles() >= cantidadPasajes) {
//
//					// devuelve indice de la categoria buscada
//					return vue.getCat().indexOf(cat);
//
//				}
//			}
//		}
//
//		if (flagCat < -1) {
//			System.out.println("Categoria no encontrada");
//			return -1;
//		} else {
//			System.out.println("Cantidad de asientos no disponible");
//			return -2;
//		}
//
//	}

	public int buscarCliente(int dni) {

		Iterator<Pasajeros> it = pasajeros.iterator();

		while (it.hasNext()) {
			Pasajeros cli = it.next();

			if (cli.getNdoc() == dni) {
				return pasajeros.indexOf(cli);
			}
		}

		return -1;

	}

	/**
	 * @return El valor de oPERADOR
	 */
	public String getOPERADOR() {
		return OPERADOR;
	}

	/**
	 * @param oPERADOR para cargar en oPERADOR
	 */
	public void setOPERADOR(String oPERADOR) {
		OPERADOR = oPERADOR;
	}

}
