package com.cyientinsights.forumenergyweb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
public class AssetsResponse {
	
	private String assetId;

	private String assetName;
	
	private Object assetType;

	private String siteName;

	private String siteId;

	private String category;

	private BigDecimal rul;

	private BigDecimal rod;

	private BigDecimal smh;

	private Object expectedLife;

	private Date purchaseDate;

	private BigDecimal latitude;

	private BigDecimal Longitude;

	private BigInteger logDateTime;

	private BigDecimal healthPercentage;

	/*private BigInteger assetAvgHealth;*/

	private List<AssetMetaData> assetMetaData;

	private ProgressGraph progressGraph;
	
	public Object getAssetType() {
		return assetType;
	}

	public void setAssetType(Object assetType) {
		this.assetType = assetType;
	}

	public String getAssetId() {
		return assetId;
	}
	
	public List<AssetMetaData> getAssetMetaData() {
		return assetMetaData;
	}

	public void setAssetMetaData(List<AssetMetaData> assetMetaData) {
		this.assetMetaData = assetMetaData;
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

	public BigDecimal getRul() {
		return rul;
	}

	public void setRul(BigDecimal rul) {
		this.rul = rul;
	}

	public BigDecimal getRod() {
		return rod;
	}

	public void setRod(BigDecimal rod) {
		this.rod = rod;
	}

	public BigDecimal getSmh() {
		return smh;
	}

	public void setSmh(BigDecimal smh) {
		this.smh = smh;
	}

	public Object getExpectedLife() {
		return expectedLife;
	}

	public void setExpectedLife(Object expectedLife) {
		this.expectedLife = expectedLife;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return Longitude;
	}

	public void setLongitude(BigDecimal Longitude) {
		this.Longitude = Longitude;
	}

	public BigInteger getLogDateTime() {
		return logDateTime;
	}

	public void setLogDateTime(BigInteger logDateTime) {
		this.logDateTime = logDateTime;
	}

	public BigDecimal getHealthPercentage() {
		return healthPercentage;
	}

	public void setHealthPercentage(BigDecimal healthPercentage) {
		this.healthPercentage = healthPercentage;
	}

	/*public BigInteger getAssetAvgHealth() {
		return assetAvgHealth;
	}

	public void setAssetAvgHealth(BigInteger assetAvgHealth) {
		this.assetAvgHealth = assetAvgHealth;
	}*/
	

	public ProgressGraph getProgressGraph() {
		return progressGraph;
	}

	public void setProgressGraph(ProgressGraph progressGraph) {
		this.progressGraph = progressGraph;
	}


}
