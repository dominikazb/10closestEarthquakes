package com.dominikazb.earthquakes.engine;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReadJsonFile {

	private String place;
	private double longitude;
	private double latitude;	
	private Map<Double, String> distanceAndPlaceMapForAllCities = new TreeMap<>();
	private HarvesineFormula harvesine = new HarvesineFormula();

	@SuppressWarnings("unchecked")
	public void convertJsonToJavaObjects(String latitudeOfSearchedCity, String longitudeOfSearchedCity) throws IOException, JsonParseException {
		
		distanceAndPlaceMapForAllCities = new TreeMap<>();
		ObjectMapper om = new ObjectMapper();				
		om.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false); //ignore fields that are not formatted properly
		TypeReference<HashMap<Object,Object>> typeRef = new TypeReference<HashMap<Object,Object>>() {};
		HashMap<Object, Object> resultMap = om.readValue(new URL("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson"), typeRef);

		ArrayList<Object> featuresArrayList = (ArrayList<Object>) resultMap.get("features");
		
		for(Object o : featuresArrayList) {
			try {
				LinkedHashMap<Object, Object> featuresLinkedHashMapInside = (LinkedHashMap<Object, Object>) o;
				Map<Object, Object> newMapping = (Map<Object, Object>) featuresLinkedHashMapInside.get("properties");
				place = newMapping.get("place").toString();
				Map<Object, Object> geometryMap = (Map<Object, Object>) featuresLinkedHashMapInside.get("geometry");
				ArrayList<Object> coordinatesArrayList = (ArrayList<Object>) geometryMap.get("coordinates");			
				longitude = (double) coordinatesArrayList.get(0);
				latitude = (double) coordinatesArrayList.get(1);
				
				double latitudeOfSearchedCityDouble = Double.parseDouble(latitudeOfSearchedCity);
				double longitudeOfSearchedCityDouble = Double.parseDouble(longitudeOfSearchedCity);
				
	            double distanceBetweenTheCityAndEarthquakes = 
	            		harvesine.haversine(latitudeOfSearchedCityDouble, longitudeOfSearchedCityDouble, latitude, longitude);

				distanceAndPlaceMapForAllCities.put(distanceBetweenTheCityAndEarthquakes, place);

				
			} catch (ClassCastException | NullPointerException e) {
				continue;
			}
		}			
	}
	
	public TreeMap<Double, String> read10closestCities() {
	    TreeMap<Double, String> first10resultsFromTheList = distanceAndPlaceMapForAllCities.entrySet().stream()
	    	    .limit(10)
	    	    .collect(TreeMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);	 

	    System.out.println("*******************************************");
	    for(Map.Entry<Double, String> entry : first10resultsFromTheList.entrySet()) {
	    	System.out.println(entry.getKey() + " || " + entry.getValue());
	    }
	    System.out.println("*******************************************");
	    return first10resultsFromTheList;
	}
}
