package Modelo.DAO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import Modelo.Pasajeros;
import funciones.Archivos;
import funciones.Fechas;

/**
 * @author iberlot <@> ivanberlot@gmail.com
 *
 */
public class daoPasajeros implements Idao<Pasajeros> {

	private final String ARCHIVO = "Archivos/Pasajeros.txt";

	/**
	 * {@inheritDoc}
	 * 
	 * @see Modelo.DAO.Idao#cargar_archivo(java.lang.Object)
	 */
	@Override
	public void cargar_archivo(Pasajeros cliente) throws IOException {

		String[] info = new String[6];

		info[0] = Integer.toString(cliente.getNdoc());
		info[1] = cliente.getNombre();
		info[2] = cliente.getApellido();
		info[3] = Boolean.toString(cliente.getSexo());
		info[4] = cliente.getFechaNac().get(Calendar.DATE) + "/" + (cliente.getFechaNac().get(Calendar.MONTH) + 1) + "/"
				+ cliente.getFechaNac().get(Calendar.YEAR);
		info[5] = Boolean.toString(cliente.getClienteFrecuente());

		File archivo = new File(ARCHIVO);
		Archivos.escribeCampoTab(archivo, info);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see Modelo.DAO.Idao#conv_a_objeto(java.lang.String[])
	 */
	@Override
	public Pasajeros conv_a_objeto(String[] datos) throws Exception {

		Pasajeros cliente = new Pasajeros(Integer.parseInt(datos[0]), datos[2], datos[1],
				Fechas.stringToCalendar(datos[4], "dd/MM/yyyy"), Boolean.parseBoolean(datos[3]),
				Boolean.parseBoolean(datos[5]));

		return cliente;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see Modelo.DAO.Idao#recuperar_datos_archivo()
	 */
	@Override
	public ArrayList<Pasajeros> recuperar_datos_archivo() throws Exception {

		ArrayList<Pasajeros> Pasajeros = new ArrayList<>();

		ArrayList<String[]> clien = funciones.Archivos.traeLineasParceadas(ARCHIVO, "\t");

		for (String[] datos : clien) {

			Pasajeros cliente = conv_a_objeto(datos);

			ArrayList<String[]> puntos = funciones.Archivos
					.traeLineasParceadas(("Archivos/Puntos/Puntos" + cliente.getNdoc()), "|");

			if (puntos.size() > 0) {
				int p = Integer.parseInt(puntos.get(puntos.size() - 1)[0]);

				if (puntos.get(puntos.size() - 1)[2].equals("-")) {
					p = p - (Integer.parseInt(puntos.get(puntos.size() - 1)[5]));
				} else {
					p = p + (Integer.parseInt(puntos.get(puntos.size() - 1)[5]));
				}
				cliente.setPuntos(p);
			}
			Pasajeros.add(cliente);

		}

		return Pasajeros;
	}

}