package com.dominikazb.earthquakes.engine;

/*
The Haversine formula calculates the shortest distance between two points on a sphere 
using their latitudes and longitudes measured along the surface.

https://www.movable-type.co.uk/scripts/latlong.html
*/


public class HarvesineFormula {

	public double haversine(double latitude1stCity, double longitude1stCity, 
			double latitude2ndCity, double longitude2ndCity) {
		
		// distance between latitudes and longitudes 
		double distanceBetweenLatitudes = Math.toRadians(latitude2ndCity - latitude1stCity);
		double distanceBetweenLongitudes = Math.toRadians(longitude2ndCity - longitude1stCity);

		// convert to radians 
		latitude1stCity = Math.toRadians(latitude1stCity);
		latitude2ndCity = Math.toRadians(latitude2ndCity);

		// apply formulae 
		double a = Math.pow(Math.sin(distanceBetweenLatitudes / 2), 2) + 
				Math.pow(Math.sin(distanceBetweenLongitudes / 2), 2) * 
				Math.cos(latitude1stCity) * Math.cos(latitude2ndCity);
		double radiusOfTheEarth = 6371;
		double c = 2 * Math.asin(Math.sqrt(a));
		return radiusOfTheEarth * c;
	}

}