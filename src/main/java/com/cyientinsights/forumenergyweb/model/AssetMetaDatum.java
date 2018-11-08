package com.cyientinsights.forumenergyweb.model;
import java.util.HashMap;
import java.util.Map;
public class AssetMetaDatum {
	
	private String name;
	private String displayName;
	private Double value;
	private String trend;
	private String units;


	public String getName() {
	return name;
	}

	public void setName(String name) {
	this.name = name;
	}

	public String getDisplayName() {
	return displayName;
	}

	public void setDisplayName(String displayName) {
	this.displayName = displayName;
	}

	public Double getValue() {
	return value;
	}

	public void setValue(Double value) {
	this.value = value;
	}

	public String getTrend() {
	return trend;
	}

	public void setTrend(String trend) {
	this.trend = trend;
	}

	public String getUnits() {
	return units;
	}

	public void setUnits(String units) {
	this.units = units;
	}


}
