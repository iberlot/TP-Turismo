package Vista;

import funciones.Funciones;

public class VReservas {

	public void mostrarTotal(float total) {
		System.out.println("Total: $" + total);
	}

	public void mostrarFormaPago(String fpago) {
		System.out.println("Forma de pago: " + fpago);

	}

	public int pedirNumVenta() {
		return Funciones.pedirEnteroPositivo("Ingrese el numero de venta: ");

	}

	public String pedirFormaDePago() {
		switch (Funciones.pedirEnteroPositivo("Ingrese forma de pago ([1] Efectivo, [2] Tarjeta [3] Puntos)", 1, 3)) {
		case 1:
			return "Efectivo";
		case 2:
			return "Tarjeta";
		case 3:
			return "Puntos";
		default:
			return null;
		}

	}

	public int pedirNdoc() {
		return Funciones.pedirEnteroPositivo("Ingrese el numero de documento: ");
	}

	public int pedirCuotas() {
		// TODO Auto-generated method stub
		return Funciones.pedirEnteroPositivo("Ingrese la cantidad de cuotas.");
	}

	public boolean peirMasEquipaje() {
		return Funciones.pedirBooleano("Desea ampliar el equipaje? S/N", "S", "N");
	}

	public boolean peirTratoPreferencial() {
		return Funciones.pedirBooleano("Requiere un trato preferencial? S/N", "S", "N");
	}
	
	public void mostrar(int numero, float total) {

		System.out.println("\n\n\n\n\n\n\n*************************************************\n\n\n");
		
		System.out.println("Numero de reserva: " + numero);
		System.out.println("Total: $" + total);
		
	}
}
