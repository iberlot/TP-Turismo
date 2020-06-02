package Modelo.DAO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Modelo.Pasajes;
import funciones.Archivos;

public class daoPasajesVendidos implements Idao<Pasajes> {
	private static final String ARCHIVO = "Archivos/PasajesVendidos.txt";

	public void cargar_archivo(Pasajes pasaje, int idVenta) throws IOException {

		String[] info = new String[7];

		info[0] = Integer.toString(idVenta);
		info[1] = Integer.toString(pasaje.getVuelo().getNumero());
//		info[2] = pasaje.getCat().getCategoria();
		info[3] = pasaje.getCliente().getNombre();
		info[4] = pasaje.getCliente().getApellido();
		info[5] = Integer.toString(pasaje.getCliente().getNdoc());
//		info[6] = Boolean.toString(pasaje.getCat().isDiscap());

		File archivo = new File(ARCHIVO);
		Archivos.escribeCampoPuntoComa(archivo, info);
	}

	@Override
	public void cargar_archivo(Pasajes dato) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Pasajes conv_a_objeto(String[] datos) throws Exception {

		// XXX hay que buscar el cliente con el numero de documento

		// XXX hay que buscar el buelo con el numero de este

		// XXX hay que buscar la categoria con la descripcion

		Pasajes pasaje = new Pasajes();
//		Pasajes pasaje = new Pasajes(cli, vue, cat);
//				(Integer.parseInt(datos[0]), datos[2], datos[1],
//				Fechas.stringToCalendar(datos[4], "dd/MM/yyyy"), Boolean.parseBoolean(datos[3]),
//				Boolean.parseBoolean(datos[5]));

		return pasaje;
	}

	@Override
	public ArrayList<Pasajes> recuperar_datos_archivo() throws Exception {

		ArrayList<Pasajes> pasajes = new ArrayList<>();

		ArrayList<String[]> pas = funciones.Archivos.traeLineasParceadas(ARCHIVO, ";");

		for (String[] datos : pas) {

			Pasajes pasaje = conv_a_objeto(datos);

			pasajes.add(pasaje);

		}

		return pasajes;
	}

}