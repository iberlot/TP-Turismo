package Vista;

import java.util.Calendar;

public class VPasajes {
	
	public void mostrarInfo(String origen, String destino, int numVuelo, Calendar fecha, String franja, String nombre,int i, boolean b, boolean discap) {
		System.out.println("Pasajero: ");
		System.out.println(nombre + " " + i);
		System.out.println("DNI: " + b);
		
		System.out.println("N de vuelo: " + numVuelo);
		System.out.println("Franja horaria: " + franja);
		System.out.println(fecha.get(Calendar.DATE) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/"
				+ fecha.get(Calendar.YEAR));
		System.out.println("Ciudad partida: " + origen);
		System.out.println("Ciudad destino: " + destino);
		
		
		if(discap = true) {
			System.out.println("Necesita asiento especial.");
		}
		
		
	}

	public void mostrarInfo(int numero, String companiaAerea, String ciudadPartida, String ciudadDestino,
			Calendar fecha, String franjaHoraria, String nombre, String apellido, int ndoc, boolean masEquipaje,
			boolean preferencial) {
		
		System.out.println("Pasajero: ");
		System.out.println(nombre + " " + apellido);
		System.out.println("DNI: " + ndoc);
		
		System.out.println("N de vuelo: " + numero);
		System.out.println("Compania: " + companiaAerea);
		System.out.println("Franja horaria: " + franjaHoraria);
		System.out.println(fecha.get(Calendar.DATE) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/"
				+ fecha.get(Calendar.YEAR));
		System.out.println("Ciudad partida: " + ciudadPartida);
		System.out.println("Ciudad destino: " + ciudadDestino);
		
		if(masEquipaje == true) {
			System.out.println("Contrata mas equipaje.");
		}
		
		if(preferencial == true) {
			System.out.println("Necesita tratamiento preferencial.");
		}
		
		
	}

}
