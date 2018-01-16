package org.shops.entities;

import java.util.ArrayList;

public class Point{
private ArrayList<Double> coordinates;
	
	
	public Point(ArrayList<Double> coordinates) {
		super();
		this.coordinates = coordinates;
	}

	public ArrayList<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(ArrayList<Double> coordinates) {
		this.coordinates = coordinates;
	}
	//The calculus of distance between 2 points 
	public Double distance() {
		double dist=Math.hypot(getCoordinates().get(0) - 0, getCoordinates().get(1) - 0);
	    return dist;
	}
	
}
