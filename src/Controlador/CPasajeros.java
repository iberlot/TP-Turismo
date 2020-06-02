package Controlador;

import java.util.Calendar;

import Modelo.Pasajeros;
import Modelo.DAO.daoPasajeros;
import Vista.VPasajeros;

public class CPasajeros implements Icontroler {

	private Pasajeros modeloCliente;
	private VPasajeros vistaCliente;

	public CPasajeros(Pasajeros modeloCliente, VPasajeros vistaCliente) {

		this.modeloCliente = modeloCliente;
		this.vistaCliente = vistaCliente;
	}

	public Pasajeros getCliente() {
		return modeloCliente;
	}

	public int getNdoc() {
		return modeloCliente.getNdoc();
	}

	public void setNdoc(int ndoc) throws Exception {
		modeloCliente.setNdoc(ndoc);
	}

	public String getApellido() {
		return modeloCliente.getApellido();
	}

	public void setApellido() {
		modeloCliente.setApellido(vistaCliente.pedirApellido());
	}

	public void setApellido(String apellido) {
		modeloCliente.setApellido(apellido);
	}

	public String getNombre() {
		return modeloCliente.getNombre();
	}

	public void setNombre(String nombre) {
		modeloCliente.setNombre(nombre);
	}

	public Calendar getFechaNac() {
		return modeloCliente.getFechaNac();
	}

	public void setFechaNac(Calendar fechaNac) {
		modeloCliente.setFechaNac(fechaNac);
	}

	public boolean getSexo() {
		return modeloCliente.getSexo();
	}

	public void setSexo(boolean sexo) {
		modeloCliente.setSexo(sexo);
	}

	public boolean getClienteFrecuente() {
		return modeloCliente.getClienteFrecuente();
	}

	public void setClienteFrecuente(boolean clienteFrecuente) {
		modeloCliente.isClienteFrecuente(clienteFrecuente);
	}

	public int getPuntos() {
		return modeloCliente.getPuntos();
	}

	public void setPuntos(int puntos) {
		modeloCliente.setPuntos(puntos);
	}

	public void setPuntos() {
		modeloCliente.setPuntos(vistaCliente.pedirPuntos());
	}

	public void calcularSumarPuntos(float monto) {
		int puntos = (int) Math.ceil((monto / 350));
		modeloCliente.setPuntos((modeloCliente.getPuntos() + puntos));
	}

	public void setNDoc() throws Exception {
		modeloCliente.setNdoc(vistaCliente.pedirNdoc());
	}

	public void setNombre() {
		modeloCliente.setNombre(vistaCliente.pedirNombre());
	}

	public void setSexo() {
		modeloCliente.setSexo(vistaCliente.pedirSexo());
	}

	public void setFechaNac() {
		modeloCliente.setFechaNac(vistaCliente.pedirFechaNac());
	}

	public void grabar() throws Exception {

		daoPasajeros dao = new daoPasajeros();

		dao.cargar_archivo(modeloCliente);
	}

	public void mostrar() {
		vistaCliente.mostrarNombreNacSexo(getApellido(), getNombre(), getFechaNac(), getSexo());
	}
}
