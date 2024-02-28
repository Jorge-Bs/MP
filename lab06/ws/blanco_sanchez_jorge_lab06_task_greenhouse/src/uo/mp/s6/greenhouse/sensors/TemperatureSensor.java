package uo.mp.s6.greenhouse.sensors;

import java.util.Random;

import uo.mp.s6.greenhouse.controllers.devicescanner.Checkable;


/**
 * <p>Title: Sensor</p>
 * <p>Description: Class that simulates a temperature sensor.</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Computer Science Engineering School</p>
 * <p>Programming Methodology</p>
 * 
 * @author Lectures of Programming Methodology
 * @version 1.0
 */
public class TemperatureSensor implements Checkable {

	private int id;

	public TemperatureSensor(int id) {
		this.id = id;
	}

	/**
	 * Simulates a temperature measurement 
	 * 
	 * It returns a value in the range [5, 40)
	 * @return The temperature measured by the sensor.
	 */
	public int getTemperature() {
		return new Random().nextInt(36) + 5;
	}

	
	
	@Override
	public String toString() {
		return "[TemperatureSensor] " + id ;
	}

	@Override
	public boolean check() {
		return new Random().nextDouble() >= 0.005;
	}
	
}
