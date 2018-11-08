package com.cyientinsights.forumenergyweb.model;

import java.util.List;



public class OptimalValues {
private Object graphDisplayName;
	
	private Object xLabel;
	
	private Object yLabel;
	
	private Object xAxisToday;
	
	private Object yAxisToday;
	
	private Object minOptimalValue;
	
	private Object maxOptimalValue;
	
	private List<GraphDatum> healthGraph;
	
	private Object binOrDate;
	
	
	
	public Object getGraphDisplayName() {
		return graphDisplayName;
	}

	public void setGraphDisplayName(Object graphDisplayName) {
		this.graphDisplayName = graphDisplayName;
	}

	public Object getxLabel() {
		return xLabel;
	}

	public void setxLabel(Object xLabel) {
		this.xLabel = xLabel;
	}

	public Object getyLabel() {
		return yLabel;
	}

	public void setyLabel(Object yLabel) {
		this.yLabel = yLabel;
	}
	public Object getxAxisToday() {
		return xAxisToday;
	}

	public void setxAxisToday(Object xAxisToday) {
		this.xAxisToday = xAxisToday;
	}

	public Object getyAxisToday() {
		return yAxisToday;
	}

	public void setyAxisToday(Object yAxisToday) {
		this.yAxisToday = yAxisToday;
	}

	public List<GraphDatum> getHealthGraph() {
		return healthGraph;
	}

	public void setHealthGraph(List<GraphDatum> healthGraph) {
		this.healthGraph = healthGraph;
	}

	public Object getBinOrDate() {
		return binOrDate;
	}

	public void setBinOrDate(Object binOrDate) {
		this.binOrDate = binOrDate;
	}

	public Object getMinOptimalValue() {
		return minOptimalValue;
	}

	public void setMinOptimalValue(Object minOptimalValue) {
		this.minOptimalValue = minOptimalValue;
	}

	public Object getMaxOptimalValue() {
		return maxOptimalValue;
	}

	public void setMaxOptimalValue(Object maxOptimalValue) {
		this.maxOptimalValue = maxOptimalValue;
	}

}
