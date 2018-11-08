package com.cyientinsights.forumenergyweb.model;

import java.util.List;
import java.util.Map;



public class AssetGrpDetailsForFracTypeResponse {
private Object assetGrpId;
	
	private Object assetGrpName;
	
	private Object assetGrpType;
	
	/*private Object category;
	
    private Object operationalDate;*/
	
	private HealthData healthData;
	
	private List<Map<String,AssetData>> assetsData;
	
	private List<AssetMetaData> assetGrpMetaData; 
	
	private List<AssetGrpMajorAssets> assetgrpMajorAssets;

	public Object getAssetGrpId() {
		return assetGrpId;
	}

	public void setAssetGrpId(Object assetGrpId) {
		this.assetGrpId = assetGrpId;
	}

	public Object getAssetGrpName() {
		return assetGrpName;
	}

	public void setAssetGrpName(Object assetGrpName) {
		this.assetGrpName = assetGrpName;
	}

	public Object getAssetGrpType() {
		return assetGrpType;
	}

	public void setAssetGrpType(Object assetGrpType) {
		this.assetGrpType = assetGrpType;
	}

	public HealthData getHealthData() {
		return healthData;
	}

	public void setHealthData(HealthData healthData) {
		this.healthData = healthData;
	}

	public List<Map<String, AssetData>> getAssetsData() {
		return assetsData;
	}

	public void setAssetsData(List<Map<String, AssetData>> assetsData) {
		this.assetsData = assetsData;
	}

	public List<AssetMetaData> getAssetGrpMetaData() {
		return assetGrpMetaData;
	}

	public void setAssetGrpMetaData(List<AssetMetaData> assetGrpMetaData) {
		this.assetGrpMetaData = assetGrpMetaData;
	}

	public List<AssetGrpMajorAssets> getAssetgrpMajorAssets() {
		return assetgrpMajorAssets;
	}

	public void setAssetgrpMajorAssets(List<AssetGrpMajorAssets> assetgrpMajorAssets) {
		this.assetgrpMajorAssets = assetgrpMajorAssets;
	}
	

}
