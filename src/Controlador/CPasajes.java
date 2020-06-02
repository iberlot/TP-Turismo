package Controlador;

import Modelo.Categorias;
import Modelo.Pasajeros;
import Modelo.Pasajes;
import Modelo.Vuelos;
import Modelo.DAO.daoPasajesVendidos;
import Vista.VPasajes;

public class CPasajes implements Icontroler {

	private Pasajes modeloPasaje;
	private VPasajes vistaPasaje;

	public CPasajes(Pasajes modeloPasaje, VPasajes vistaPasaje) {
		super();
		this.modeloPasaje = modeloPasaje;
		this.vistaPasaje = vistaPasaje;
	}

	public Pasajeros getCliente() {
		return modeloPasaje.getCliente();
	}

	public void setCliente(Pasajeros cliente) {
		modeloPasaje.setCliente(cliente);
	}

	public Vuelos getVuelo() {
		return modeloPasaje.getVuelo();
	}

	public void setVuelo(Vuelos vuelo) {
		modeloPasaje.setVuelo(vuelo);
	}

	public boolean getPreferencial() {
		return modeloPasaje.isPreferencial();
	}

	public void setPreferencial(boolean preferencial) {
		modeloPasaje.setPreferencial(preferencial);;
	}

	public boolean getMasEquipaje() {
		return modeloPasaje.isMasEquipaje();
	}

	public void setMasEquipaje(boolean masEquipaje) {
		modeloPasaje.setMasEquipaje(masEquipaje);
	}
	
	@Override
	public void grabar() throws Exception {
		daoPasajesVendidos dao = new daoPasajesVendidos();

		dao.cargar_archivo(modeloPasaje);

	}

	@Override
	public void mostrar() {
		vistaPasaje.mostrarInfo(
				modeloPasaje.getVuelo().getNumero(),
				modeloPasaje.getVuelo().getCompaniaAerea(),
				modeloPasaje.getVuelo().getCiudadPartida(), 
				modeloPasaje.getVuelo().getCiudadDestino(), 
				modeloPasaje.getVuelo().getFecha(), 
				modeloPasaje.getVuelo().getFranjaHoraria(),  
				modeloPasaje.getCliente().getNombre(), 
				modeloPasaje.getCliente().getApellido(), 
				modeloPasaje.getCliente().getNdoc(), 
				modeloPasaje.isMasEquipaje(), 
				modeloPasaje.isPreferencial());
	}

}
