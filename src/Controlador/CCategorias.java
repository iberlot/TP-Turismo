package Controlador;

import Modelo.Categorias;
import Modelo.DAO.daoCategorias;
import Vista.VCategorias;

public class CCategorias implements Icontroler {

	private Categorias modeloCategoria;
	private VCategorias vistaCategoria;

	public CCategorias(Categorias modeloCategoria, VCategorias vistaCategoria) {
		this.modeloCategoria = modeloCategoria;
		this.vistaCategoria = vistaCategoria;
	}

	public int getNumero() {
		return modeloCategoria.getNumero();
	}

	public void setNumero(int numero) {
		modeloCategoria.setNumero(numero);
	}

	public String getCategoria() {
		return modeloCategoria.getCategoria();
	}

	public void setCategoria(String categoria) {
		modeloCategoria.setCategoria(categoria);
	}

	public float getPrecio() {
		return modeloCategoria.getPrecio();
	}

	public void setPrecio(float precio) {
		modeloCategoria.setPrecio(precio);
	}

	public boolean isDiscap() {
		return modeloCategoria.isDiscap();
	}

	public void setDiscap(boolean discap) {
		modeloCategoria.setDiscap(discap);
	}

	public int getCantDisponibles() {
		return modeloCategoria.getCantDisponibles();
	}

	public void setCantDisponibles(int cantDisponibles) {
		modeloCategoria.setCantDisponibles(cantDisponibles);
	}

	public void setNumero() {
		modeloCategoria.setNumero(vistaCategoria.pedirNumero());
	}

	public void setCategoria() {
		modeloCategoria.setCategoria(vistaCategoria.pedirCategoria());
	}

	public void setPrecio() {
		modeloCategoria.setPrecio(vistaCategoria.pedirPrecio());
	}

	public void setDiscap() {
		modeloCategoria.setDiscap(vistaCategoria.pedirDiscap());
	}

	public void setCantDisponibles() {
		modeloCategoria.setCantDisponibles(vistaCategoria.pedirCantDisponibles());
	}

	public void restarAsiento() {
		modeloCategoria.setCantDisponibles((modeloCategoria.getCantDisponibles()) - 1);
	}
	


	public void grabar() throws Exception {
		daoCategorias dao = new daoCategorias();
		dao.cargar_archivo(modeloCategoria);
	}

	public void mostrar() {
		vistaCategoria.mostrarNumTipo(getNumero(), getCategoria());
		vistaCategoria.mostrarPrecio(getPrecio());
		vistaCategoria.mostrarDisponibles(getCantDisponibles());
		vistaCategoria.mostrarAsientoDiscap(isDiscap());
	}

}
