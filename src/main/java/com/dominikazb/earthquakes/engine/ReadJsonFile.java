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
	
	private static ReadJsonFile readJson = new ReadJsonFile();	
	private static String place;
	private static double longitude;
	private static double latitude;	
	private Map<Integer, String> distanceAndPlaceMapForAllCities = new TreeMap<>();
	private HarvesineFormula harvesine = new HarvesineFormula();
	
	public static ReadJsonFile getReadJson() {
		return readJson;
	}
	

	@SuppressWarnings("unchecked")
	public void convertJsonToJavaObjects(double latitude2ndCity, double longitude2ndCity) throws IOException, JsonParseException {
		
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
				
				Double distanceDOUBLE = calculateTheDistanceBetweenCities(latitude2ndCity, longitude2ndCity);
				int distanceKMS = distanceDOUBLE.intValue();
				distanceAndPlaceMapForAllCities.put(distanceKMS, place);
				
			} catch (ClassCastException | NullPointerException e) {
				continue;
			}
		}	

		
	}
	

	public double calculateTheDistanceBetweenCities(double latitude2ndCity, double longitude2ndCity) {		
		return harvesine.haversine(latitude, longitude, latitude2ndCity, longitude2ndCity);		
	}
	
	public TreeMap<Integer, String> read10closestCities() {
	    TreeMap<Integer, String> first10resultsFromTheList = distanceAndPlaceMapForAllCities.entrySet().stream()
	    	    .limit(10)
	    	    .collect(TreeMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);	 
	    return first10resultsFromTheList;
	}

	
}
