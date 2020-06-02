/**
 * @file daoReservas.java
 * @author iberlot <@> ivanberlot@gmail.com
 * @since 10 may. 2019
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

package Modelo.DAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import org.json.JSONArray;
// Sorry - descargue la libreria de https://mvnrepository.com/artifact/org.json/json/20190722
import org.json.JSONObject;

import Modelo.Pasajeros;
import Modelo.Pasajes;
import Modelo.Reservas;
import Modelo.Vuelos;
import funciones.Archivos;
import funciones.Fechas;

/**
 * @author iberlot <@> ivanberlot@gmail.com
 *
 */
public class daoReservas implements Idao<Reservas> {
//	fecha y numero de venta, nombre del operador, importe total de la venta y forma de pago.
	private static final String ARCHIVO = "Archivos/Reservas.txt";
	private static final String ARCHPASAJESXVENTA = "Archivos/ReservasPajeros.txt";

	private static final int[] ANCHO = { 10, 5, 30, 30, 10 };

	/**
	 * Recive una visita y lo graba parceado en el archivo de datos de estos.
	 * 
	 * @param visita Visitas
	 * @throws IOException
	 */
	public void cargar_archivo(Reservas venta) throws IOException {
		daoPasajesVendidos daoPasaje = new daoPasajesVendidos();

		String[] info = new String[5];

		info[0] = venta.getFecha().get(Calendar.DATE) + "/" + (venta.getFecha().get(Calendar.MONTH) + 1) + "/"
				+ venta.getFecha().get(Calendar.YEAR);
		info[1] = Integer.toString(venta.getIdVenta());
		info[2] = venta.getOperador();
		info[3] = venta.getPasajes().get(0).getCliente().getApellido();
		info[4] = Float.toString(venta.calcularTotal());

		File archivo = new File(ARCHIVO);
		Archivos.escribeCamposAnchoFijo(archivo, info, ANCHO);

		for (Pasajes pasaje : venta.getPasajes()) {

			daoPasaje.cargar_archivo(pasaje, venta.getIdVenta());
		}

		File arch = new File(ARCHPASAJESXVENTA);

		for (int x = 0; x < venta.getPasajes().size(); x++) {

			String[] infoPXV = new String[5];

			infoPXV[0] = Integer.toString(venta.getIdVenta());
			infoPXV[1] = Integer.toString(venta.getPasajes().get(x).getVuelo().getNumero());
			infoPXV[2] = Integer.toString(venta.getPasajes().get(x).getCliente().getNdoc());
			infoPXV[3] = Boolean.toString(venta.getPasajes().get(x).isPreferencial());
			infoPXV[4] = Boolean.toString(venta.getPasajes().get(x).isMasEquipaje());

			Archivos.escribeCampoPuntoComa(arch, infoPXV);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see Modelo.DAO.Idao#conv_a_objeto(java.lang.String[])
	 */
	@Override
	public Reservas conv_a_objeto(String[] datos) throws Exception {

		Reservas venta = new Reservas(Integer.parseInt(datos[1]), Fechas.stringToCalendar(datos[0], "dd/M/yyyy"),
				datos[2]);

		return venta;
	}

	public ArrayList<Reservas> recuperar_datos_archivo(ArrayList<Vuelos> vuelos, ArrayList<Pasajeros> pasajeros)
			throws Exception {

		ArrayList<Reservas> reservas = new ArrayList<Reservas>();
		ArrayList<Pasajes> pasajes = new ArrayList<Pasajes>();

		ArrayList<String[]> vent = funciones.Archivos.traeLineasAnchoFijo(ARCHIVO, ANCHO);
		ArrayList<String[]> pasXventa = funciones.Archivos.traeLineasParceadas(ARCHPASAJESXVENTA, ";");

//		daoPasajesVendidos datoPas = new daoPasajesVendidos();
//		pasajes = datoPas.recuperar_datos_archivo();

		// XXX aca funcion para recuperar categorias por vuelo

		for (String[] datos : vent) {

			Reservas venta = new Reservas();
			venta = conv_a_objeto(datos);

			for (String[] pas : pasXventa) {

				if (Integer.parseInt(pas[0]) == venta.getIdVenta()) {
					Vuelos vuelo = null;
					Pasajeros pasajero = null;

					for (int i = 0; i < vuelos.size(); i++) {
						if (vuelos.get(i).getNumero() == Integer.parseInt(pas[1])) {
							vuelo = vuelos.get(i);
						}

					}
					for (int i = 0; i < pasajeros.size(); i++) {
						if (pasajeros.get(i).getNdoc() == Integer.parseInt(pas[2])) {
							pasajero = pasajeros.get(i);
						}

					}

					venta.getPasajes().add(
							new Pasajes(pasajero, vuelo, Boolean.parseBoolean(pas[3]), Boolean.parseBoolean(pas[4])));
					venta.getPasajes()
							.add(buscar_pasaje_id(pasajes, Integer.parseInt(pas[1]), Integer.parseInt(pas[2])));
				}
			}
			if (venta.getSIGUIENTE_ID() < venta.getIdVenta()) {
				venta.setSIGUIENTE_ID(venta.getIdVenta());
			}

			reservas.add(venta);
		}

		return reservas;
	}

	private Pasajes buscar_pasaje_id(ArrayList<Pasajes> pasajes, int vuelo, int doc) {

		for (Pasajes pasajes2 : pasajes) {

			System.out.println(pasajes2);
		}
		Iterator<Pasajes> it = pasajes.iterator();
		// mientras al iterador queda proximo juego
		while (it.hasNext()) {
			Pasajes pas = it.next();

			if ((pas.getCliente().getNdoc() == doc) && (pas.getVuelo().getNumero() == vuelo)) {
				return pas;
			}
		}

		return null;
	}

	public void actualizar_puntos(Reservas venta) throws IOException {

		String[] info = new String[6];

		int puntosAnteriores;
//		char operador = (venta.getFormaPago().equalsIgnoreCase("puntos") ? '-' : '+');
		char operador = '+';

		if (operador == '+') {
			puntosAnteriores = (venta.getPasajes().get(0).getCliente().getPuntos()
					- ((int) Math.ceil((venta.calcularTotal() / 350))));
		} else {
			puntosAnteriores = (venta.getPasajes().get(0).getCliente().getPuntos()
					+ ((int) Math.ceil((venta.calcularTotal() / 350))));
		}

		info[0] = Integer.toString(puntosAnteriores);
		info[1] = Fechas.fechaAString(venta.getFecha(), '/');
		info[2] = Character.toString(operador);
		info[3] = Integer.toString(venta.getPasajes().get(0).getVuelo().getNumero());
		info[4] = Float.toString(venta.calcularTotal());
		info[5] = Integer.toString((int) Math.ceil((venta.calcularTotal() / 350)));

		File archivo = new File("Archivos/Puntos/Puntos" + venta.getPasajes().get(0).getCliente().getNdoc());
		Archivos.escribeCampoTab(archivo, info);

	}

	@Override
	public ArrayList<Reservas> recuperar_datos_archivo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void crearJSON(Reservas reserva) throws IOException {
		JSONObject myObject = new JSONObject();

		// Cadenas de texto básicas
		myObject.put("ID", reserva.getIdVenta());
		myObject.put("Fecha", reserva.getFecha());

		JSONArray pas = new JSONArray();

		for (int i = 0; i < reserva.getPasajes().size(); i++) {
			JSONObject cliente = new JSONObject();

			cliente.put("Documento", reserva.getPasajes().get(i).getCliente().getNdoc());
			cliente.put("Apellido", reserva.getPasajes().get(i).getCliente().getApellido());
			cliente.put("Nombre", reserva.getPasajes().get(i).getCliente().getNombre());
			cliente.put("Sexo", reserva.getPasajes().get(i).getCliente().getSexo());

			cliente.put("MasEquipaje", reserva.getPasajes().get(i).isMasEquipaje());
			cliente.put("Preferencial", reserva.getPasajes().get(i).isPreferencial());

			pas.put(cliente);
		}

		myObject.put("Clientes", pas);

		myObject.put("NumeroVuelo", reserva.getPasajes().get(0).getVuelo().getNumero());

		File archivo = new File("Archivos/jsons/reserva" + reserva.getIdVenta());

		FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);

		fw.append(myObject + "\t");

		fw.append("\n");
		fw.close();
	}
}
