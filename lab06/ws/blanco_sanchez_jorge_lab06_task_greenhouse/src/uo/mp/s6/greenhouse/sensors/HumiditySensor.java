package uo.mp.s6.greenhouse.sensors;

import java.util.Random;

import uo.mp.s6.greenhouse.controllers.devicescanner.Checkable;

public class HumiditySensor implements Checkable {

	
	private int id;
	
	public  HumiditySensor(int id) {
		this.id = id;
	}
	
	
	
	/**
	 * Simulates a humidity measurement 
	 * 
	 * It returns a value in the range [0, 100)
	 * @return The temperature measured by the sensor.
	 */
	public int getHumidity() {
		return new Random().nextInt(101);
	}
	
	@Override
	public String toString() {
		return "[HumiditySensor] " + id ;
	}
	
	
	@Override
	public boolean check() {
		return new Random().nextDouble() >= 0.005;
	}

}
