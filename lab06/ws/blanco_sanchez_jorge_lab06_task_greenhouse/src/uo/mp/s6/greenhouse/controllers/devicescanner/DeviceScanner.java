package uo.mp.s6.greenhouse.controllers.devicescanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeviceScanner implements Checkable {

	private List<Checkable> items = new ArrayList<>();

	
	
	
	public void add(Checkable itm) {
		items.add(itm);
	}
	
	public List<String> scan() {
		List<String> messages = new ArrayList<>();
		for(int i=0; i< items.size();i++) {
			if(!(items.get(i).check())) {
				messages.add(error(items.get(i)));
			}
		}
		return messages;
	}
	
	
	
	@Override
	public boolean check() {
		return new Random().nextDouble() >= 0.005;
	}
	
	private String error(Checkable item) {
		return ("WARNING: " +item.toString()+" do not work");
	}
	
}

