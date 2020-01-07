package com.dominikazb.earthquakes.engine;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReadJsonFile {
	
	private Map<Coordinates, String> coordinatesNamesMap = new HashMap<>();
	TreeMap<Coordinates, String> coordinatesNamesMapWithoutDuplicates = new TreeMap<>();

	@SuppressWarnings("unchecked")
	public Map<Coordinates, String> readJSonAndConvertToJavaObjects() throws IOException, JsonParseException {
		
		ObjectMapper om = new ObjectMapper();				
		om.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false); //ignore fields that are not formatted properly
		TypeReference<HashMap<Object,Object>> typeRef = new TypeReference<HashMap<Object,Object>>() {};
		HashMap<Object, Object> resultMap = om.readValue(new URL("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson"), typeRef);
		ArrayList<Object> featuresArrayList = (ArrayList<Object>) resultMap.get("features");	
		
		for(Object o : featuresArrayList) {
			try {
				LinkedHashMap<Object, Object> featuresLinkedHashMapInside = (LinkedHashMap<Object, Object>) o;
				Map<Object, Object> newMapping = (Map<Object, Object>) featuresLinkedHashMapInside.get("properties");
				String place = newMapping.get("place").toString();
				Map<Object, Object> geometryMap = (Map<Object, Object>) featuresLinkedHashMapInside.get("geometry");
				ArrayList<Object> coordinatesArrayList = (ArrayList<Object>) geometryMap.get("coordinates");			
				double longitude = (double) coordinatesArrayList.get(0);
				double latitude = (double) coordinatesArrayList.get(1);			
				coordinatesNamesMap.put(new Coordinates(latitude, longitude), place);
			} catch (ClassCastException | NullPointerException e) {
				continue;
			}
		}
		
		//getting rid of duplicates
		coordinatesNamesMapWithoutDuplicates.putAll(coordinatesNamesMap);

		return coordinatesNamesMapWithoutDuplicates;
	}
}
