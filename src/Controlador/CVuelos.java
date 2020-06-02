/**
 * @file Vuelos.java
 * @author iberlot <@> ivanberlot@gmail.com
 * @since 6 may. 2019
 * @version 0.1 - Version de inicio
 */

/*
 * Querido programador:
 *
 * Cuando escribi este codigo, solo Dios y yo sabiamos como funcionaba.
 * Ahora, Solo Dios lo sabe!!!
 *
 * Asi que, si esta tratando de 'optimizar' esta rutina y fracasa (seguramente),
 * por favor, incremente el siguiente contador como una advertencia para el
 * siguiente colega:
 *
 * totalHorasPerdidasAqui = 1
 *
 */

package Controlador;

import java.util.ArrayList;
import java.util.Calendar;

import Modelo.Categorias;
import Modelo.Vuelos;
import Modelo.DAO.daoVuelos;
import Vista.VVuelos;

/**
 * @author iberlot <@> ivanberlot@gmail.com
 *
 */
public class CVuelos implements Icontroler {

	private Vuelos modeloVuelos;
	private VVuelos vistaVuelos;

	public CVuelos(Vuelos modeloVuelos, VVuelos vistaVuelos) {
		this.modeloVuelos = modeloVuelos;
		this.vistaVuelos = vistaVuelos;
	}

	public int getNumero() {
		return modeloVuelos.getNumero();
	}

	public void setNumero() {
		modeloVuelos.setNumero(vistaVuelos.pedirNumero());
	}

	public String getCiudadDestino() {
		return modeloVuelos.getCiudadDestino();
	}

	public void setCiudadDestino() {
		modeloVuelos.setCiudadDestino(vistaVuelos.pedirCiudadDestino());
	}

	public String getCiudadPartida() {
		return modeloVuelos.getCiudadPartida();
	}

	public void setCiudadPartida() {
		modeloVuelos.setCiudadPartida(vistaVuelos.pedirCiudadPartida());
	}

	public float getHorasDeViaje() {
		return modeloVuelos.getHorasDeViaje();
	}

	public void setHorasDeViaje() {
		modeloVuelos.setHorasDeViaje(vistaVuelos.pedirHorasDeViaje());
	}

	public String getFranjaHoraria() {
		return modeloVuelos.getFranjaHoraria();
	}

	public void setFranjaHoraria() {
		modeloVuelos.setFranjaHoraria(vistaVuelos.pedirFranjaHoraria());
	}

	public Calendar getFecha() {
		return modeloVuelos.getFecha();
	}

	public void setFecha() {
		modeloVuelos.setFecha(vistaVuelos.pedirFecha());
	}
public float getPrecio() {
	return modeloVuelos.getPrecio();
}
	public void setPrecio() {
		modeloVuelos.setPrecio(vistaVuelos.pedirPrecio());
	}
	public void grabar() throws Exception {

		daoVuelos dao = new daoVuelos();

		dao.cargar_archivo(modeloVuelos);
	}

	public void mostrar() {
		vistaVuelos.mostrarDatosVuelo(getNumero(), getCompania(), getPrecio(), getHorasDeViaje());
	}
	
	public void setCompania() {
		modeloVuelos.setCompaniaAerea(vistaVuelos.pedirCompania());
	}

	public String getCompania() {
		return modeloVuelos.getCompaniaAerea();
	}
	

	public void restarAsiento() {
		modeloVuelos.setCantDisponibles((modeloVuelos.getCantDisponibles()) - 1);
	}

}
