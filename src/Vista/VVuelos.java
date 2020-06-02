package Vista;

import java.util.Calendar;

import funciones.Funciones;

public class VVuelos {

	public void mostrarNumPrecHoras(int num, float precio, float horasDeViaje) {
		System.out.println("N de vuelo: " + num);
		System.out.println("Precio: " + precio);
		System.out.println("Duracion del vuelo: " + horasDeViaje);
	}

	public void mostrarNum(int num) {
		System.out.println("N de vuelo: " + num);
	}

	public void mostrarFranjaHorario(String franja) {
		System.out.println("Franja horaria: " + franja);
	}

	public void mostrarCiudadDestino(String destino) {
		System.out.println("Ciudad destino: " + destino);
	}

	public void mostrarCiudadPartida(String partida) {
		System.out.println("Ciudad partida: " + partida);
	}

	public void mostrarFechaPartida(Calendar fecha) {
		System.out.println(
				fecha.get(Calendar.DATE) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR));
	}

	public void mostrarButacasDisponibles(int cantidadDisponible) {
		System.out.println("En el vuelo quedan un total de " + cantidadDisponible + " butacas disponibles.");
	}

	public boolean pedirDirecto() {
		return Funciones.pedirBooleano("Es un vulo directo? Si/No", "Si", "No");
	}

	public void mostrarAsientoDiscap(boolean discap) {
		if (discap = true) {
			System.out.println("Es un vuelo directo.");
		} else {
			System.out.println("Es un vuelo con escalas.");
		}
	}

	public void mostrarDisponibles(int dispo) {
		System.out.println("Cantidad de asientos disponibles: " + dispo);
	}

	public void mostrarPrecio(float precio) {
		System.out.println("Precio: " + precio);
	}

	public float pedirPrecio() {
		return Funciones.pedirFloat("Ingrese el precio del vuelo");
	}

	public int pedirCantDisponibles() {
		return Funciones.pedirEnteroPositivo("Ingrese la cantida de asientos disponibles");
	}

	public String pedirCompania() {

		return Funciones.pedirString("Ingrese la compania del vuelo.");
	}

	public int pedirNumero() {
		return Funciones.pedirEnteroPositivo("Ingrese el numero de vuelo: ");
	}

	public String pedirCiudadDestino() {
		return Funciones.pedirString("Ingrese la ciudad de destino.");
	}

	public String pedirCiudadPartida() {
		return Funciones.pedirString("Ingrse la ciudad de partida: ");
	}

	public float pedirHorasDeViaje() {
		return Funciones.pedirFloat("Ingrese la cantidad de horas del viaje: ");
	}

	public float pedirCostoExtra() {
		return Funciones.pedirFloat("Ingrese el costo por equipaje extra: ");
	}

	public void mostrarEquipajeExtra(float costo) {
		System.out.println("El costo por equipaje extra es: " + costo);
	}

	public String pedirFranjaHoraria() {
		switch (Funciones.pedirEnteroPositivo("Franja horaria ([1] Mañana, [2] Tarde, [3] Noche)", 1, 3)) {
		case 1:
			return "Mañana";
		case 2:
			return "Tarde";
		case 3:
			return "Noche";
		}
		return null;
	}

	public Calendar pedirFecha() {
		return Funciones.pedirFecha("Ingrese la fecha de salida: ");
	}

	public void mostrarDatosVuelo(int numero, String ciudadPartida, String ciudadDestino, Calendar fecha, String franja,
			float horasDeViaje) {
		System.out.println("N de vuelo: " + numero);

		System.out.println("Ciudad de partida: " + ciudadPartida);
		System.out.println("Ciudad de destino: " + ciudadDestino);
		System.out.println(
				fecha.get(Calendar.DATE) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR));
		System.out.println("Duracion del vuelo" + horasDeViaje);
		System.out.println("Franja horaria: " + franja);
		System.out.println("Duracion del vuelo" + horasDeViaje);
	}

	public void mostrarDatosVuelo(int numero, String compania, float precio, float horasDeViaje) {
		System.out.println("N de vuelo: " + numero);
		System.out.println("Compania: " + compania);

		System.out.println("Precio: " + precio);
		System.out.println("Duracion del vuelo: " + horasDeViaje);

	}

	public int pedirCantidadPasajes() {
		return Funciones.pedirEnteroPositivo("Ingrese la cantidad de pasajes que necesita: ");
	}
}
