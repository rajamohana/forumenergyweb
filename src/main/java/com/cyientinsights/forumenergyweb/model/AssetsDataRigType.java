package com.cyientinsights.forumenergyweb.model;

import java.util.List;


public class AssetsDataRigType {
private Object assetId;
	
	private Object assetName;
	
	private Object assetType;
	
	private Object category;
	
	private Object expectedLife;
	
	private Object operationalDate;
	
	/*private Object SMH;
	
	private Object RUL;
	
	private HealthData healthGraph;*/
	
	private Object healthPercentage;
	
	private ProgressGraph progressGraph;
	
	private List<AssetMetaData> metaData;
	
	public Object getHealthPercentage() {
		return healthPercentage;
	}

	public void setHealthPercentage(Object healthPercentage) {
		this.healthPercentage = healthPercentage;
	}

	public List<AssetMetaData> getMetaData() {
		return metaData;
	}

	public void setMetaData(List<AssetMetaData> metaData) {
		this.metaData = metaData;
	}

	public Object getAssetId() {
		return assetId;
	}

	public void setAssetId(Object assetId) {
		this.assetId = assetId;
	}

	public Object getAssetName() {
		return assetName;
	}

	public void setAssetName(Object assetName) {
		this.assetName = assetName;
	}

	public Object getAssetType() {
		return assetType;
	}

	public void setAssetType(Object assetType) {
		this.assetType = assetType;
	}

	public Object getCategory() {
		return category;
	}

	public void setCategory(Object category) {
		this.category = category;
	}

	public Object getExpectedLife() {
		return expectedLife;
	}

	public void setExpectedLife(Object expectedLife) {
		this.expectedLife = expectedLife;
	}

	public Object getOperationalDate() {
		return operationalDate;
	}

	public void setOperationalDate(Object operationalDate) {
		this.operationalDate = operationalDate;
	}

	/*public Object getSMH() {
		return SMH;
	}

	public void setSMH(Object sMH) {
		SMH = sMH;
	}

	public Object getRUL() {
		return RUL;
	}

	public void setRUL(Object rUL) {
		RUL = rUL;
	}

	public HealthData getHealthGraph() {
		return healthGraph;
	}

	public void setHealthGraph(HealthData healthGraph) {
		this.healthGraph = healthGraph;
	}*/

	public ProgressGraph getProgressGraph() {
		return progressGraph;
	}

	public void setProgressGraph(ProgressGraph progressGraph) {
		this.progressGraph = progressGraph;
	}
	
}
