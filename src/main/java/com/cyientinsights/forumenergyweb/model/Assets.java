package com.cyientinsights.forumenergyweb.model;

import java.util.List;

public class Assets {
	
	private String assetId;
	private String assetName;
	private String assetType;
	private String siteName;
	private String siteId;
	private String category;
	private Double rul;
	private Double rod;
	private Double smh;
	private Double expectedLife;
	private String purchaseDate;
	private String eolDate;
	
	public String getEolDate() {
		return eolDate;
	}

	public void setEolDate(String eolDate) {
		this.eolDate = eolDate;
	}

	private Double latitude;
	private Integer logDateTime;
	private Double healthPercentage;
	private List<AssetMetaDatum> assetMetaData = null;
	private ProgressGraph progressGraph;
	private Double longitude;
	

	public String getAssetId() {
	return assetId;
	}

	public void setAssetId(String assetId) {
	this.assetId = assetId;
	}

	public String getAssetName() {
	return assetName;
	}

	public void setAssetName(String assetName) {
	this.assetName = assetName;
	}

	public String getAssetType() {
	return assetType;
	}

	public void setAssetType(String assetType) {
	this.assetType = assetType;
	}

	public String getSiteName() {
	return siteName;
	}

	public void setSiteName(String siteName) {
	this.siteName = siteName;
	}

	public String getSiteId() {
	return siteId;
	}

	public void setSiteId(String siteId) {
	this.siteId = siteId;
	}

	public String getCategory() {
	return category;
	}

	public void setCategory(String category) {
	this.category = category;
	}

	public Double getRul() {
	return rul;
	}

	public void setRul(Double rul) {
	this.rul = rul;
	}

	public Double getRod() {
	return rod;
	}

	public void setRod(Double rod) {
	this.rod = rod;
	}

	public Double getSmh() {
	return smh;
	}

	public void setSmh(Double smh) {
	this.smh = smh;
	}

	public Double getExpectedLife() {
	return expectedLife;
	}

	public void setExpectedLife(Double expectedLife) {
	this.expectedLife = expectedLife;
	}

	public String getPurchaseDate() {
	return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
	this.purchaseDate = purchaseDate;
	}

	public Double getLatitude() {
	return latitude;
	}

	public void setLatitude(Double latitude) {
	this.latitude = latitude;
	}

	public Integer getLogDateTime() {
	return logDateTime;
	}

	public void setLogDateTime(Integer logDateTime) {
	this.logDateTime = logDateTime;
	}

	public Double getHealthPercentage() {
	return healthPercentage;
	}

	public void setHealthPercentage(Double healthPercentage) {
	this.healthPercentage = healthPercentage;
	}

	public List<AssetMetaDatum> getAssetMetaData() {
	return assetMetaData;
	}

	public void setAssetMetaData(List<AssetMetaDatum> assetMetaData) {
	this.assetMetaData = assetMetaData;
	}

	public ProgressGraph getProgressGraph() {
	return progressGraph;
	}

	public void setProgressGraph(ProgressGraph progressGraph) {
	this.progressGraph = progressGraph;
	}

	public Double getLongitude() {
	return longitude;
	}

	public void setLongitude(Double longitude) {
	this.longitude = longitude;
	}

}
