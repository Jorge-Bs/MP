package uo.mp.s6.greenhouse.controllers;

import java.util.ArrayList;

import java.util.List;

import uo.mp.s6.greenhouse.controllers.devicescanner.Checkable;
import uo.mp.s6.greenhouse.sensors.HumiditySensor;


public class HumidityController {

	public static final double MAX_HUMIDITY = 60;
	public static final double MIN_HUMIDITY = 40;

	private List<HumiditySensor> sensors = new ArrayList<>();
	private List<Status> statusList = new ArrayList<>();

	private Status status;

	private enum Status {
		OFF, LOW, MEDIUM, HIGH
	}

	/**
	 * Inicializa el sistema de riego en off
	 */
	public HumidityController() {
		setStatus(Status.OFF);
		createList();
	}

	public List<String> monitor() {
		List<String> messages = new ArrayList<>();
		double humidity = getAverageHumidity();
		messages.add("Current humidity is: " + humidity);
		if (humidity > (MAX_HUMIDITY)) {
			if (humidity > (MAX_HUMIDITY) + 20) {
				messages.add("Is too damp.");
				messages.add(setLevel(Status.OFF));
			} else {
				messages.add("It is a bit too damp.");
				messages.add(setLevel(calculateLevel(false)));
			}

		} else if (humidity < (MIN_HUMIDITY)) {
			if (humidity < (MIN_HUMIDITY) - 20) {
				messages.add("Is too dry.");
				messages.add(setLevel(Status.HIGH));
			} else {
				messages.add("It is a bit too dry.");
				messages.add(setLevel(calculateLevel(true)));
			}
		} else {
			messages.add("Humidity is right");
		}
		return messages;
	}

	/**
	 * Añade un item a lista
	 * 
	 * @param sensor
	 */
	public void add(HumiditySensor sensor) {
		sensors.add(sensor);
	}

	/**
	 * Devuelve el estado del sistema
	 * 
	 * @return status 
	 */
	private Status getStatus() {
		return status;
	}

	/**
	 * Establece el estado del sistema
	 * 
	 * @param status
	 */
	private void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Cambia el estado del sistema
	 * 
	 * @param status
	 */
	private String setLevel(Status status) {
		Status st= getStatus();
		setStatus(status);
		return "Irrigator sistem is: " + st + " and is set to: " + status;

	}

	/**
	 * Obtiene la media del nivel de humedad de los sensores
	 * 
	 * @return humidity
	 */
	private double getAverageHumidity() {
		double addition = 0;
		for (HumiditySensor sensor : sensors) {
			addition += sensor.getHumidity();
		}
		return addition / sensors.size();
	}

	/**
	 * Calcula el nivel y devuelve el nivel al que se tiene que cambiar
	 * @param value de tipo boolean nivel a cambiar, true aumenta en uno el nivel, si es posible,
	 * 			false lo disminuye
	 */
	private Status calculateLevel(boolean value) {
		int index = statusList.indexOf(getStatus());
		if(value && index<statusList.size()-1) {
			return statusList.get(index+1);
		}else if(!value && index>=1){
			return statusList.get(index-1);
		}else {
			return getStatus();
			}
		}

	/**
	 * Crea una lista con los estados
	 */
	private void createList() {
		for (Status status : Status.values()) {
			statusList.add(status);
		}
	}

}
