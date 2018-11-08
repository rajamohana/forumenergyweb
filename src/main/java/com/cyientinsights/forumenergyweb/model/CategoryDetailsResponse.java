package com.cyientinsights.forumenergyweb.model;

import java.util.List;



public class CategoryDetailsResponse implements Cloneable {
	
    private Object userId;
	
	private Object siteId;
	
	private Object assetId;
	
	private Object variableName;
	
	private Object minOptimal;
	
	private Object maxOptimal;
	
	private Object minRange;
	
	private Object maxRange;
	
	private Object units;
	
	private Object xLabel;
	
	private Object yLabel;
	
	private List<VariableGraph> variableGraph;

	public List<VariableGraph> getVariableGraph() {
		return variableGraph;
	}

	public void setVariableGraph(List<VariableGraph> variableGraph) {
		this.variableGraph = variableGraph;
	}

	public Object getUserId() {
		return userId;
	}

	public void setUserId(Object userId) {
		this.userId = userId;
	}

	public Object getSiteId() {
		return siteId;
	}

	public void setSiteId(Object siteId) {
		this.siteId = siteId;
	}

	public Object getAssetId() {
		return assetId;
	}

	public void setAssetId(Object assetId) {
		this.assetId = assetId;
	}

	public Object getVariableName() {
		return variableName;
	}

	public void setVariableName(Object variableName) {
		this.variableName = variableName;
	}

	public Object getMinOptimal() {
		return minOptimal;
	}

	public void setMinOptimal(Object minOptimal) {
		this.minOptimal = minOptimal;
	}

	public Object getMaxOptimal() {
		return maxOptimal;
	}

	public void setMaxOptimal(Object maxOptimal) {
		this.maxOptimal = maxOptimal;
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
	
	public Object getMinRange() {
		return minRange;
	}

	public void setMinRange(Object minRange) {
		this.minRange = minRange;
	}

	public Object getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(Object maxRange) {
		this.maxRange = maxRange;
	}

	public Object getUnits() {
		return units;
	}

	public void setUnits(Object units) {
		this.units = units;
	}

	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		} 

}
