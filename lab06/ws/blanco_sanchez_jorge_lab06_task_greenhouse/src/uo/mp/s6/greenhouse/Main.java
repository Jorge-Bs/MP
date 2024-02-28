package uo.mp.s6.greenhouse;


import uo.mp.s6.greenhouse.actuators.doors.AutomaticDoors;
import uo.mp.s6.greenhouse.actuators.doors.Door;
import uo.mp.s6.greenhouse.controlpanel.GreenhouseController;
import uo.mp.s6.greenhouse.sensors.HumiditySensor;
import uo.mp.s6.greenhouse.sensors.TemperatureSensor;

/**
 * <p>Title: Application</p>
 * <p>Description: Class that executes the program.</p>
 * <p>Copyright: Copyright (c) 2022</p>
 * <p>Computer Science Engineering School</p>
 * <p>Programming Methodology</p>
 * 
 * @author Lectures of Programming Methodology
 * @version 2.0
 */
public class Main {
	
	private GreenhouseController greenhouse;

	/**
	 * Main method that launches the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Main()
			.configure()
			.run();
	}

	/*
	 * Set doors, temperature and humidity sensors
	 */
	private Main configure() {
		greenhouse = new GreenhouseController();
		
		for (int i = 0; i < 10; i++) {
			greenhouse.add( new TemperatureSensor(i) );			
			greenhouse.add( new Door(i) );
			greenhouse.add( new AutomaticDoors(i) );
			greenhouse.add(new HumiditySensor(i));
		}

		return this;
	}

	/**
	 * Method that executes the application.
	 */
	public void run() {
		greenhouse.start();
	}

}
