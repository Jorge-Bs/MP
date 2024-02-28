package uo.mp.s6.greenhouse.actuators.doors;

import java.util.Random;

import uo.mp.s6.greenhouse.controllers.devicescanner.Checkable;

public class AutomaticDoors extends Door implements Checkable{

	public AutomaticDoors(int id) {
		super(id);
	}

	@Override
	public String open() {
		if ( ! isOpened()) {			
			this.opened = true;
			return "Door " + getId()+" opened automatically";
		}
		return "";
	}

	@Override
	public String close() {
		if ( isOpened()) {
			opened = false;
			return "Door " + getId()+" closed automatically";
		}
		return "";
	}

	@Override
	public boolean check() {
		return new Random().nextDouble() >= 0.005;
	}

	@Override
	public String toString() {
		return "[AutomaticDoors] " + id ;
	}
	
}
