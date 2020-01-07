package com.dominikazb.earthquakes.engine;

import java.io.Serializable;
import java.util.Comparator;

public class Coordinates implements Serializable, Comparable<Coordinates> {
	

	private static final long serialVersionUID = 1L;
	
	private double latitude;
	private double longitude;
	
	public Coordinates(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
    @Override
    public int compareTo(Coordinates o){
        return Comparator.comparing(Coordinates::getLatitude)
                .thenComparing(Coordinates::getLongitude)
                .compare(this, o);
    }
	
}
