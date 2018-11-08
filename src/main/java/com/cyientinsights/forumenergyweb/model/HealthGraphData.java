package com.cyientinsights.forumenergyweb.model;



public class HealthGraphData extends GraphDatum {
private Object yAxisMin;
	
	private Object yAxisMax;

	public Object getyAxisMin() {
		return yAxisMin;
	}

	public void setyAxisMin(Object yAxisMin) {
		this.yAxisMin = yAxisMin;
	}

	public Object getyAxisMax() {
		return yAxisMax;
	}

	public void setyAxisMax(Object yAxisMax) {
		this.yAxisMax = yAxisMax;
	}
}
