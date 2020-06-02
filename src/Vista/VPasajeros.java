package Vista;

import java.util.Calendar;

import funciones.Funciones;

public class VPasajeros {

	public void mostrarNombreNacSexo(String apellido, String nombre, Calendar fechaNac, boolean sexo) {

		System.out.println("\n\n****************\n");
		System.out.println("Pasajero: ");
		System.out.println(nombre + " " + apellido);
		System.out.println(fechaNac.get(Calendar.DATE) + "/" + (fechaNac.get(Calendar.MONTH) + 1) + "/"
				+ fechaNac.get(Calendar.YEAR));

		// XXX jajajajajajajaja == > if (sexo = true) {
		if (sexo != true) {
			System.out.println("Femenino");
		} else {
			System.out.println("Masculino");
		}

		System.out.println("\n\n");
	}

	public void mostrarNombreApe(String apellido, String nombre) {
		System.out.println(nombre + " " + apellido);
	}

	public void mostrarDNI(int ndoc) {
		System.out.println("DNI: " + ndoc);
	}

	public String pedirApellido() {
		return Funciones.pedirString("Ingrese el apellido");
	}

	public int pedirNdoc() {

		return Funciones.pedirEnteroPositivo("Ingrese el numero de documento: ");
	}

	public String pedirNombre() {
		return Funciones.pedirString("Ingrese el nombre: ");
	}

	public Calendar pedirFechaNac() {
		return Funciones.pedirFecha("Ingrese la fecha de nacimiento: ");
	}

	public boolean pedirSexo() {
		return Funciones.pedirBooleano("Ingrese el sexo (V/M): ", "V", "M");
	}

	public int pedirPuntos() {
		return Funciones.pedirEnteroPositivo("Ingrese la nueva cantidad de puntos: ");
	}
}
