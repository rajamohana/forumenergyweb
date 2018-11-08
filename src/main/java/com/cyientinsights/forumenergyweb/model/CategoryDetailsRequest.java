package com.cyientinsights.forumenergyweb.model;

import java.util.List;

public class CategoryDetailsRequest {
private Object userId;
	
	private Object siteId;
	
	private Object assetId;
	
	private String assetType;
	
	private Object categoryId;
	
	private Object deviceType;
	
	private List<String> sensorNames;

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
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

	public Object getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Object categoryId) {
		this.categoryId = categoryId;
	}

	public Object getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Object deviceType) {
		this.deviceType = deviceType;
	}

	public List<String> getSensorNames() {
		return sensorNames;
	}

	public void setSensorNames(List<String> sensorNames) {
		this.sensorNames = sensorNames;
	}
}
