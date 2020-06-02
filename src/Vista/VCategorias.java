package Vista;

import funciones.*;


public class VCategorias {
	
	public void mostrarNumTipo(int num, String tipo) {
		System.out.println("Numero de categoria: "+num);
		System.out.println("Descripcion: "+ tipo);
	}
	
	public void mostrarPrecio(float precio) {
		System.out.println("Precio: "+precio);
	}

	public void mostrarAsientoDiscap(boolean discap) {
		if(discap = true) {
			System.out.println("Es apta para discapacitados.");
		}else {
			System.out.println("No es apta para discapacitados.");
		}
	}
	
	public void mostrarDisponibles(int dispo) {
		System.out.println("Cantidad disponibles: "+dispo);
	}
	
	public int pedirNumero() {
		return Funciones.pedirEnteroPositivo("Ingrese el numero de la categoria");
	}
	
	public String pedirCategoria() {
		return Funciones.pedirString("Ingrese el nombre de la categoria");
	}
	
	public float pedirPrecio(){
		return Funciones.pedirFloat("Ingrese el precio de la categoria");
	}
	
	public boolean pedirDiscap() {
		return Funciones.pedirBooleano("Es apta para discapacitados? Si/No", "Si", "No");
	}
	
	public int pedirCantDisponibles() {
		return Funciones.pedirEnteroPositivo("Ingrese la cantida de asientos disponibles");
	}
	
	public int pedirCantidadPasajes() {
		return Funciones.pedirEnteroPositivo("Ingrese la cantidad de pasajes que necesita: ");
	}
}
