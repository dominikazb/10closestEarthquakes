package com.dominikazb.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.dominikazb.earthquakes.engine.HarvesineFormula;


public class EarthQuakeProject {
	
	HarvesineFormula harvesine = new HarvesineFormula();

	@Test
	@DisplayName("Calculating distance between New York City and Seattle")
	void harvesineFormula() {
		
		double latitudeNYC = 40.712776;
		double longitudeNYC = -74.005974;
		double latitudeSeattle = 47.606209;
		double longitudeSeattle = -74.005974;
		
		double calculatedDistance = harvesine.haversine(latitudeNYC, longitudeNYC, 
				latitudeSeattle, longitudeSeattle);
		String calculatedDistanceString = String.format("%.1f", calculatedDistance); 
		double calculatedDistanceRounded = Double.valueOf(calculatedDistanceString);
		double expectedDistance = 766.5;

		assertEquals(expectedDistance, calculatedDistanceRounded);
		
	}
}
