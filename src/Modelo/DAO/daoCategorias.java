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

import Modelo.Categorias;
import funciones.Archivos;

/**
 * @author iberlot <@> ivanberlot@gmail.com
 *
 */
public class daoCategorias implements Idao<Categorias> {

	private static final String ARCHIVO = "Archivos/Precios.txt";

	/**
	 * {@inheritDoc}
	 * 
	 * @see Modelo.DAO.Idao#cargar_archivo(java.lang.Object)
	 */
	@Override
	public void cargar_archivo(Categorias categoria) throws IOException {

		String[] info = new String[5];

		info[0] = '"' + Integer.toString(categoria.getNumero()) + '"';
		info[1] = '"' + categoria.getCategoria() + '"';
		info[2] = '"' + Float.toString(categoria.getPrecio()) + '"';
		info[3] = '"' + Boolean.toString(categoria.isDiscap()) + '"';
		info[4] = '"' + Integer.toString(categoria.getCantDisponibles()) + '"';

		File archivo = new File(ARCHIVO);

		Archivos.escribeCamposSepararPor(archivo, info, ';');

	}

	@Override
	public Categorias conv_a_objeto(String[] datos) throws NumberFormatException, ParseException {

		Categorias categoria = new Categorias(Integer.parseInt(datos[0]), datos[1], Float.parseFloat(datos[2]),
				Boolean.parseBoolean(datos[3]), Integer.parseInt(datos[4]));

		return categoria;
	}

	@Override
	public ArrayList<Categorias> recuperar_datos_archivo() throws IOException, Exception {

		ArrayList<Categorias> categorias = new ArrayList<>();

		ArrayList<String[]> cat = funciones.Archivos.traeLineasParceadas(ARCHIVO, ";");

		for (String[] datos : cat) {
			for (int i = 0; i < datos.length; i++) {
				datos[i] = datos[i].substring(1, (datos[i].length() - 1));
			}
			categorias.add(conv_a_objeto(datos));
		}

		return categorias;
	}

}
