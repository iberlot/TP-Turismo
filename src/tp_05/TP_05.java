package tp_05;

import Controlador.CPrincipal;
import funciones.Funciones;

/**
 *
 * @author iberlot
 */
public class TP_05 {

	/**
	 * @param args the command line arguments
	 * @throws Exception
	 */
	public static void main(String[] args) {

		try {
			CPrincipal base = new CPrincipal();

			base.setOPERADOR(Funciones.pedirString("Ingrese el operador: "));

			base.inicializar_archivos();

			base.inicio();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
