package com.dominikazb.earthquakes.engine;

import java.util.HashMap;
import java.util.Map;

public class Countries {
	
	private static Map<String, Coordinates> countries = new HashMap<>();
	
	public static Map<String, Coordinates> getCountries() {
		return countries;
	}

	public static void setCountries(Map<String, Coordinates> countries) {
		Countries.countries = countries;
	}

	public void addCountriesToMap() {
		countries.put("NewYorkCity", new Coordinates(40.712776, -74.005974));
		countries.put("Seattle", new Coordinates(47.606209, -122.332069));
		countries.put("WashingtonDC", new Coordinates(47.751076, -120.740135));
	}
	

}

