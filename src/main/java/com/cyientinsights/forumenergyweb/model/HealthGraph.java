package com.cyientinsights.forumenergyweb.model;

import java.util.List;



public class HealthGraph {
private Object graphDisplayName;
	
	private Object xLabel;
	
	private Object yLabel;
	
	private Object xMax;
	
	private Object xNumIntrevals;
	
	private Object yMax;
	
	private Object yNumIntrevals;
	
	private Object xAxisToday;
	
	private Object yAxisToday;
	
	private List<GraphDatum> healthGraph;
	
	private List<GraphDatum> trendGraph;
	
	/*private List<HealthData> siteAvgGraph;*/
	
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

	public Object getxMax() {
		return xMax;
	}

	public void setxMax(Object xMax) {
		this.xMax = xMax;
	}

	public Object getxNumIntrevals() {
		return xNumIntrevals;
	}

	public void setxNumIntrevals(Object xNumIntrevals) {
		this.xNumIntrevals = xNumIntrevals;
	}

	public Object getyMax() {
		return yMax;
	}

	public void setyMax(Object yMax) {
		this.yMax = yMax;
	}

	public Object getyNumIntrevals() {
		return yNumIntrevals;
	}

	public void setyNumIntrevals(Object yNumIntrevals) {
		this.yNumIntrevals = yNumIntrevals;
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

	public List<GraphDatum> getTrendGraph() {
		return trendGraph;
	}

	public void setTrendGraph(List<GraphDatum> trendGraph) {
		this.trendGraph = trendGraph;
	}

	/*public List<HealthData> getSiteAvgGraph() {
		return siteAvgGraph;
	}

	public void setSiteAvgGraph(List<HealthData> siteAvgGraph) {
		this.siteAvgGraph = siteAvgGraph;
	}*/

	public Object getBinOrDate() {
		return binOrDate;
	}

	public void setBinOrDate(Object binOrDate) {
		this.binOrDate = binOrDate;
	}
	
}
