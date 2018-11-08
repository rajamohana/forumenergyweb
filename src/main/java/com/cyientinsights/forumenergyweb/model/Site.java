package com.cyientinsights.forumenergyweb.model;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



public class Site {
	
	private String id;
	
	private String siteCode;
	private String siteLocation;
	private Double longitude;
	private Double latitude;
	private Integer startDate;
	private Integer endDate;
	private List<Asset> assets = null;
	private Object siteCustomers;
	private List<Object> siteUsers = null;

	public String getId() {
	return id;
	}

	public void setId(String id) {
	this.id = id;
	}

	public String getSiteCode() {
	return siteCode;
	}

	public void setSiteCode(String siteCode) {
	this.siteCode = siteCode;
	}

	
	public String getSiteLocation() {
	return siteLocation;
	}

	public void setSiteLocation(String siteLocation) {
	this.siteLocation = siteLocation;
	}

	public Double getLongitude() {
	return longitude;
	}

	public void setLongitude(Double longitude) {
	this.longitude = longitude;
	}

	public Double getLatitude() {
	return latitude;
	}

	public void setLatitude(Double latitude) {
	this.latitude = latitude;
	}

	public Integer getStartDate() {
	return startDate;
	}

	public void setStartDate(Integer startDate) {
	this.startDate = startDate;
	}

	public Integer getEndDate() {
	return endDate;
	}

	public void setEndDate(Integer endDate) {
	this.endDate = endDate;
	}

	public List<Asset> getAssets() {
	return assets;
	}

	public void setAssets(List<Asset> assets) {
	this.assets = assets;
	}

	public Object getSiteCustomers() {
	return siteCustomers;
	}

	public void setSiteCustomers(Object siteCustomers) {
	this.siteCustomers = siteCustomers;
	}

	public List<Object> getSiteUsers() {
	return siteUsers;
	}

	public void setSiteUsers(List<Object> siteUsers) {
	this.siteUsers = siteUsers;
	}
	
	 private String siteId;
	 private String siteName;
	 private String siteType;
	 private String assetName;
	 private String location;
	 private String category;
	 
	 private Coordinates coordinates;
	 public Double getAvgHealthsite() {
		return avgHealthsite;
	}

	public void setAvgHealthsite(Double avgHealthsite) {
		this.avgHealthsite = avgHealthsite;
	}

	public Double getAvgRodsite() {
		return avgRodsite;
	}

	public void setAvgRodsite(Double avgRodsite) {
		this.avgRodsite = avgRodsite;
	}

	public Double getAvgRulsite() {
		return avgRulsite;
	}

	public void setAvgRulsite(Double avgRulsite) {
		this.avgRulsite = avgRulsite;
	}


	/*public List<AssetsDatum> getAssetsData() {
		return assetsData;
	}

	public void setAssetsData(List<AssetsDatum> assetsData) {
		this.assetsData = assetsData;
	}

	public List<Map<String, AssetData>> getAssetData() {
		return assetData;
	}

	public void setAssetData(List<Map<String, AssetData>> assetData) {
		this.assetData = assetData;
	}
*/
	
	private Double avgHealthsite;
	 public Integer getNoOfAssetss() {
		return noOfAssetss;
	}

	public void setNoOfAssetss(Integer noOfAssetss) {
		this.noOfAssetss = noOfAssetss;
	}

	public Integer getCritical() {
		return critical;
	}

	public void setCritical(Integer critical) {
		this.critical = critical;
	}

	public Integer getGood() {
		return good;
	}

	public void setGood(Integer good) {
		this.good = good;
	}

	public Integer getStable() {
		return stable;
	}

	public void setStable(Integer stable) {
		this.stable = stable;
	}

	private Double avgRodsite;
	 private Double avgRulsite;
	 private Integer noOfAssetss;
	 private Integer critical;
	 private Integer good;
	 private Integer stable;
	 

	private List<AssetsDatum> assetssData = null;
	 public List<AssetsDatum> getAssetssData() {
		return assetssData;
	}

	public void setAssetssData(List<AssetsDatum> assetssData) {
		this.assetssData = assetssData;
	}

	public List<Map<String, AssetData>> getAssetsData() {
		return assetsData;
	}

	public void setAssetsData(List<Map<String, AssetData>> assetsData) {
		this.assetsData = assetsData;
	}

	private List<Map<String,AssetData>> assetsData=null;
	 
	
	
	private List<DataToShowOnHover> dataToShowOnHover = null;
	// private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	 public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	

	
	public List<DataToShowOnHover> getDataToShowOnHover() {
		return dataToShowOnHover;
	}

	public void setDataToShowOnHover(List<DataToShowOnHover> dataToShowOnHover) {
		this.dataToShowOnHover = dataToShowOnHover;
	}

	/*public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}*/

	


	 // Getter Methods 

	 public String getSiteId() {
	  return siteId;
	 }

	 public String getSiteName() {
	  return siteName;
	 }

	 public String getSiteType() {
	  return siteType;
	 }

	 public String getAssetName() {
	  return assetName;
	 }

	 public String getLocation() {
	  return location;
	 }

	 public String getCategory() {
	  return category;
	 }

	

	 // Setter Methods 

	 public void setSiteId(String siteId) {
	  this.siteId = siteId;
	 }

	 public void setSiteName(String siteName) {
	  this.siteName = siteName;
	 }

	 public void setSiteType(String siteType) {
	  this.siteType = siteType;
	 }

	 public void setAssetName(String assetName) {
	  this.assetName = assetName;
	 }

	 public void setLocation(String location) {
	  this.location = location;
	 }

	 public void setCategory(String category) {
	  this.category = category;
	 }

	 
}
