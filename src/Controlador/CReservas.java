/**
 * @file CReservas.java
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

import Modelo.Pasajeros;
import Modelo.Pasajes;
import Modelo.Reservas;
import Modelo.Vuelos;
import Modelo.DAO.daoReservas;
import Vista.VReservas;

public class CReservas implements Icontroler {

	private Reservas modeloReservas;
	private VReservas vistaReservas;

	public CReservas(Reservas modeloReservas, VReservas vistaReservas) {

		this.modeloReservas = modeloReservas;
		this.vistaReservas = vistaReservas;
	}

	public void setIdVenta(int id) {
		modeloReservas.setIdVenta(id);
	}

	public int getIdVenta() {
		return modeloReservas.getIdVenta();
	}

	public float calcularTotal() {
		return modeloReservas.calcularTotal();
	}

	public void mostrarTotal() {
		vistaReservas.mostrarTotal(modeloReservas.calcularTotal());
	}

	public boolean equals(Object obj) {
		return modeloReservas.equals(obj);
	}

	public ArrayList<Pasajes> getPasajes() {
		return modeloReservas.getPasajes();
	}

	public Pasajes getLastPasajes() {
		return modeloReservas.getPasajes().get(modeloReservas.getPasajes().size() - 1);
	}

	public void addPasajes(Pasajes pasaje) {
		modeloReservas.addPasaje(pasaje);
	}

	public void setPasajes(ArrayList<Pasajes> pasajes) {
		modeloReservas.setPasajes(pasajes);
	}

	public Calendar getFecha() {
		return modeloReservas.getFecha();
	}

	public void setFecha(Calendar fecha) {
		modeloReservas.setFecha(fecha);
	}

	public String getOperador() {
		return modeloReservas.getOperador();
	}
//
//	public String getFormaPago() {
//		return modeloReservas.getFormaPago();
//	}

	public void setOperador(String operador) {
		modeloReservas.setOperador(operador);
	}
//
//	public void setFormaPago(String fPago) {
//		modeloReservas.setFormaPago(fPago);
//	}
//
//	public void setFormaPago() {
//		modeloReservas.setFormaPago(vistaReservas.pedirFormaDePago());
//	}

	@Override
	public void grabar() throws Exception {
		daoReservas dao = new daoReservas();

		dao.cargar_archivo(modeloReservas);
	}

	@Override
	public void mostrar() {
		vistaReservas.mostrar(modeloReservas.getIdVenta(), modeloReservas.calcularTotal());
		
	}

	public void calcular_total_pago() {
//		float interes = 0;
//		float descuento = 0;
//
//		if (modeloReservas.getFormaPago().equalsIgnoreCase("Tarjeta")) {
//			int cuotas = vistaReservas.pedirCuotas();
//
////			interes = modeloReservas.calcularTotal() * (((modeloReservas.getINTERES_ANUAL() / 12) * cuotas) / 100);
//		}
//
//		if (modeloReservas.getPasajes().get(0).getCliente().getClienteFrecuente() == true) {
//			descuento = modeloReservas.calcularTotal() * (modeloReservas.getDESCUENTO_CLIENTE() / 100);
//		}

//		vistaReservas.mostrarTotal((modeloReservas.calcularTotal() + interes - descuento));
		vistaReservas.mostrarTotal((modeloReservas.calcularTotal()));
	}

	public void addPasajes(Pasajeros pasajeros, Vuelos vuelos) {
		modeloReservas.addNuevoPasaje(pasajeros, vuelos);
	}

	public void addPasajes(Pasajeros pasajeros, Vuelos vuelos, boolean preferencial, boolean masEquipaje) {
		modeloReservas.addNuevoPasaje(pasajeros, vuelos, preferencial, masEquipaje);
	}
}
