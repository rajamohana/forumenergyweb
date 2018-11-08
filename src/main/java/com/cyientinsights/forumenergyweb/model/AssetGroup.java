package com.cyientinsights.forumenergyweb.model;

import java.util.List;

public class AssetGroup {

	private String assetGrpId;
	private String assetGrpName;
	private String assetGrpLocation;
	private String assetGrpType;
	private String category;
	private String operationalDate;
	private Double healthPercentage;
	private List<AssetGroup> assets = null;
	private String name;
	private String displayName;
	private Object value;
	private String fracCount;
	public String getFracCount() {
		return fracCount;
	}

	public void setFracCount(String fracCount) {
		this.fracCount = fracCount;
	}

	public String getCatwalkCount() {
		return catwalkCount;
	}

	public void setCatwalkCount(String catwalkCount) {
		this.catwalkCount = catwalkCount;
	}

	private String catwalkCount;
	
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

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}



	public String getAssetGrpId() {
		return assetGrpId;
	}

	public void setAssetGrpId(String assetGrpId) {
		this.assetGrpId = assetGrpId;
	}

	public String getAssetGrpName() {
		return assetGrpName;
	}

	public void setAssetGrpName(String assetGrpName) {
		this.assetGrpName = assetGrpName;
	}

	public String getAssetGrpLocation() {
		return assetGrpLocation;
	}

	public void setAssetGrpLocation(String assetGrpLocation) {
		this.assetGrpLocation = assetGrpLocation;
	}

	public String getAssetGrpType() {
		return assetGrpType;
	}

	public void setAssetGrpType(String assetGrpType) {
		this.assetGrpType = assetGrpType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOperationalDate() {
		return operationalDate;
	}

	public void setOperationalDate(String operationalDate) {
		this.operationalDate = operationalDate;
	}

	public Double getHealthPercentage() {
		return healthPercentage;
	}

	public void setHealthPercentage(Double healthPercentage) {
		this.healthPercentage = healthPercentage;
	}

	public List<AssetGroup> getAssets() {
		return assets;
	}

	public void setAssets(List<AssetGroup> assets) {
		this.assets = assets;
	}



}
