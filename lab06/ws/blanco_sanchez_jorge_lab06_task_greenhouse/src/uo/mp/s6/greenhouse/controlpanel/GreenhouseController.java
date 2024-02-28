package uo.mp.s6.greenhouse.controlpanel;


import java.util.List;

import uo.mp.s6.greenhouse.actuators.doors.Door;
import uo.mp.s6.greenhouse.controllers.HumidityController;
import uo.mp.s6.greenhouse.controllers.TemperatureController;
import uo.mp.s6.greenhouse.controllers.devicescanner.Checkable;
import uo.mp.s6.greenhouse.controllers.devicescanner.DeviceScanner;
import uo.mp.s6.greenhouse.sensors.HumiditySensor;
import uo.mp.s6.greenhouse.sensors.TemperatureSensor;

/**
 * <p>Title: GreenHouse</p>
 * <p>Description: Class that simulates a greenhouse.</p>
 * <p>Copyright: Copyright (c) 2022</p>
 * <p>Computer Science Engineering School</p>
 * <p>Programming Methodology</p>
 * 
 * @author Lectures of Programming Methodology
 * @version 2.0
 */
public class GreenhouseController {
	
	private TemperatureController tempCtrl = new TemperatureController();
	private DeviceScanner dvScan = new DeviceScanner();
	private HumidityController hCtrl = new HumidityController();
	
	
	/**
	 * Adds temperature sensors to temperature controller
	 * @param sensor
	 */
	public void add(TemperatureSensor sensor) {
		tempCtrl.add( sensor );
		dvScan.add((Checkable)sensor);
	}

	/**
	 * Adds doors operated by gardener to temperature controller
	 * to simulate gardener operation
	 * @param door
	 */
	public void add(Door door) {
		tempCtrl.add( door );	
		if( door instanceof Checkable) {
			dvScan.add((Checkable)door);
		}
	}
	
	/**
	 * Añade sensores de humedad
	 * @param sensor
	 */
	public void add(HumiditySensor sensor) {
		hCtrl.add(sensor);
		dvScan.add((Checkable)sensor);
	}

	/**
	 * Starts each and every control operation
	 * Displays messages returned by them
	 */
	public void start() {
		while (true) {
			display(tempCtrl.monitor());
			display(hCtrl.monitor());
			display(dvScan.scan());
			
			sleep(2000);
		}
	}

	private void display(List<String> arg) {
		for (String message: arg) {
			System.out.println(message);
		}		
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// Ignore it
		}
	}

}
