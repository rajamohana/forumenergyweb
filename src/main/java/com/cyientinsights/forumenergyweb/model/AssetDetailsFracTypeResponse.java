package com.cyientinsights.forumenergyweb.model;

import java.util.List;

public class AssetDetailsFracTypeResponse {

private Object assetId;
	
	private Object assetName;
	
	private Object assetType;
	
	private Object siteId;
	
	private Object siteName;
	
	private Object siteType;
	
	private Object siteLocation;
	
	private List<AssetMetaData> assetHealthData;
	
	private List<RULLife> assetMetaData;
	
	private OptimalValues deteriorationGraphs;
	
	/*private List<HealthGraph> healthGraphs;
	
	private List<HealthGraph> deteriorationGraphs;
	
	private List<Sensors> sensors;*/

	public Object getAssetId() {
		return assetId;
	}

	public OptimalValues getDeteriorationGraphs() {
		return deteriorationGraphs;
	}

	public void setDeteriorationGraphs(OptimalValues deteriorationGraphs) {
		this.deteriorationGraphs = deteriorationGraphs;
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

	public Object getSiteId() {
		return siteId;
	}

	public void setSiteId(Object siteId) {
		this.siteId = siteId;
	}

	public Object getSiteName() {
		return siteName;
	}

	public void setSiteName(Object siteName) {
		this.siteName = siteName;
	}

	public Object getSiteType() {
		return siteType;
	}

	public void setSiteType(Object siteType) {
		this.siteType = siteType;
	}

	public Object getSiteLocation() {
		return siteLocation;
	}

	public void setSiteLocation(Object siteLocation) {
		this.siteLocation = siteLocation;
	}

	public List<AssetMetaData> getAssetHealthData() {
		return assetHealthData;
	}

	public void setAssetHealthData(List<AssetMetaData> assetHealthData) {
		this.assetHealthData = assetHealthData;
	}

	public List<RULLife> getAssetMetaData() {
		return assetMetaData;
	}

	public void setAssetMetaData(List<RULLife> assetMetaData) {
		this.assetMetaData = assetMetaData;
	}

	/*public List<HealthGraph> getHealthGraphs() {
		return healthGraphs;
	}

	public void setHealthGraphs(List<HealthGraph> healthGraphs) {
		this.healthGraphs = healthGraphs;
	}

	public List<HealthGraph> getDeteriorationGraphs() {
		return deteriorationGraphs;
	}

	public void setDeteriorationGraphs(List<HealthGraph> deteriorationGraphs) {
		this.deteriorationGraphs = deteriorationGraphs;
	}

	public List<Sensors> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensors> sensors) {
		this.sensors = sensors;
	}*/
	
}
