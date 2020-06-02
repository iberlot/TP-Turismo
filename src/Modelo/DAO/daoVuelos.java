/**
 * @file daoVuelos.java
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
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import Modelo.Categorias;
import Modelo.Vuelos;
import funciones.Archivos;
import funciones.Fechas;

/**
 * @author iberlot <@> ivanberlot@gmail.com
 *
 */
public class daoVuelos implements Idao<Vuelos> {

	private String ARCHIVO = "Archivos/Precios.txt";
	@Override
	public void cargar_archivo(Vuelos vuelo) throws IOException {

		String[] info = new String[11];

		info[0] = "\""+Integer.toString(vuelo.getNumero())+"\"";
		info[1] = vuelo.getCompaniaAerea();
		info[2] = vuelo.getCiudadDestino();
		info[3] = vuelo.getCiudadPartida();
		info[4] = "\""+Float.toString(vuelo.getHorasDeViaje())+"\"";
		info[5] = vuelo.getFranjaHoraria();
		info[6] = vuelo.getFecha().get(Calendar.DATE) + "/" + (vuelo.getFecha().get(Calendar.MONTH) + 1) + "/"
				+ vuelo.getFecha().get(Calendar.YEAR);
		info[7] = Boolean.toString(vuelo.isDirecto());
		info[8] = "\""+Float.toString(vuelo.getPrecio())+"\"";
		info[9] = "\""+Integer.toString(vuelo.getCantButacas())+"\"";
		info[10] = "\""+Integer.toString(vuelo.getCantDisponibles())+"\"";

		File archivo = new File(ARCHIVO);
		Archivos.escribeCamposPipe(archivo, info);
	}

	@Override
	public Vuelos conv_a_objeto(String[] datos) throws NumberFormatException, ParseException {
		
		datos[0] = datos[0].substring(1, (datos[0].length() - 1));

		datos[4] = datos[4].substring(1, (datos[4].length() - 1));
		datos[8] = datos[8].substring(1, (datos[8].length() - 1));
		datos[9] = datos[9].substring(1, (datos[9].length() - 1));
		datos[10] = datos[10].substring(1, (datos[10].length() - 1));
		
		Vuelos vuelo = new Vuelos(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], Float.parseFloat(datos[4]),
				datos[5], Fechas.stringToCalendar(datos[6], "dd/M/yyyy"), Boolean.parseBoolean(datos[7]),
				Float.parseFloat(datos[8]), Integer.parseInt(datos[9]));
		
		vuelo.setCantDisponibles(Integer.parseInt(datos[10]));
		
		return vuelo;
	}

	@Override
	public ArrayList<Vuelos> recuperar_datos_archivo() throws IOException, Exception {

		ArrayList<Vuelos> vuelos = new ArrayList<Vuelos>();
		ArrayList<String[]> vuel = funciones.Archivos.traeLineasParceadas(ARCHIVO, "|");

		for (String[] datos : vuel) {

			Vuelos vuelo = new Vuelos();
			vuelo = conv_a_objeto(datos);

			vuelos.add(vuelo);
		}

		return vuelos;
	}


}
