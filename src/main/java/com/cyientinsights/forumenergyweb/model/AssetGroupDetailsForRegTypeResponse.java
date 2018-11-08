package com.cyientinsights.forumenergyweb.model;

import java.util.List;



public class AssetGroupDetailsForRegTypeResponse {

private Object assetGrpId;
	
	private Object assetGrpName;
	
	private Object assetGrpType;
	
	/*private Object category;*/
	
	private Object operationalDate;
	
	/*private HealthData healthData;*/
	
	/*private List<AssetMetaData> assetGrpMetaData;*/
	
	private List<AssetsDataRigType> assetsData;
	
	private List<SiteMetaData> siteMetaData;
	
	public List<AssetsDataRigType> getAssetsData() {
		return assetsData;
	}

	public void setAssetsData(List<AssetsDataRigType> assetsData) {
		this.assetsData = assetsData;
	}

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

	/*public Object getCategory() {
		return category;
	}

	public void setCategory(Object category) {
		this.category = category;
	}*/

	public Object getOperationalDate() {
		return operationalDate;
	}

	public void setOperationalDate(Object operationalDate) {
		this.operationalDate = operationalDate;
	}

	public List<SiteMetaData> getSiteMetaData() {
		return siteMetaData;
	}

	public void setSiteMetaData(List<SiteMetaData> siteMetaData) {
		this.siteMetaData = siteMetaData;
	}

	/*public List<AssetMetaData> getAssetGrpMetaData() {
		return assetGrpMetaData;
	}

	public void setAssetGrpMetaData(List<AssetMetaData> assetGrpMetaData) {
		this.assetGrpMetaData = assetGrpMetaData;
	}*/
	
}
