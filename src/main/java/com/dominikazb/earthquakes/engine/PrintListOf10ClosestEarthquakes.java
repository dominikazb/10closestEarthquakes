package com.dominikazb.earthquakes.engine;

import java.util.Map;
import java.util.TreeMap;

public class PrintListOf10ClosestEarthquakes {
	
	HarvesineFormula formula = new HarvesineFormula();
	TreeMap<Double, String> temporaryMap = new TreeMap<>();
	
	public TreeMap<Double, String> print10closestEarthquakes(Map<Coordinates, String> coordinatesNamesMap, String latitude1stCityString, String longitude1stCityString) {
		
		temporaryMap = new TreeMap<>();
		for(Map.Entry<Coordinates, String> entry : coordinatesNamesMap.entrySet()) {
			String place = (String) entry.getValue();
			Coordinates newCoordinates = (Coordinates) entry.getKey();
			double latitude1stCity = Double.parseDouble(latitude1stCityString);
			double longitude1stCity = Double.parseDouble(longitude1stCityString);	
			double latitude2ndCity = newCoordinates.getLatitude();
			double longitude2ndCity = newCoordinates.getLongitude();
			double distance = formula.haversine(latitude1stCity, longitude1stCity, latitude2ndCity, longitude2ndCity);
			temporaryMap.put(distance, place);
		}
		
	    TreeMap<Double, String> first10resultsFromTheList = temporaryMap.entrySet().stream()
	    .limit(10)
	    .collect(TreeMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);	 

	    return first10resultsFromTheList;
	}
}
