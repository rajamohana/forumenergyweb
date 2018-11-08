package com.cyientinsights.forumenergyweb.model;

import java.util.List;



public class AssetGrpMajorAssets {
private Object heading;
	
	private Object assetid;
	
	private Object assetName;
	
	private Object assetType;
	
	private List<AssetMetaData> metaData;

	public Object getHeading() {
		return heading;
	}

	public void setHeading(Object heading) {
		this.heading = heading;
	}

	public Object getAssetid() {
		return assetid;
	}

	public void setAssetid(Object assetid) {
		this.assetid = assetid;
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

	public List<AssetMetaData> getMetaData() {
		return metaData;
	}

	public void setMetaData(List<AssetMetaData> metaData) {
		this.metaData = metaData;
	}

}
