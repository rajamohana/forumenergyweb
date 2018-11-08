package com.cyientinsights.forumenergyweb.model;

public class Asset {
	private String id;
	private String assetName;
	private String assetCode;
	private String product;
	private String description;
	private Object notes;
	private String componentId;
	private Integer startDate;
	private Integer endDate;
	private String siteId;
	private Object assetCustomers;

	public String getId() {
	return id;
	}

	public void setId(String id) {
	this.id = id;
	}

	public String getAssetName() {
	return assetName;
	}

	public void setAssetName(String assetName) {
	this.assetName = assetName;
	}

	public String getAssetCode() {
	return assetCode;
	}

	public void setAssetCode(String assetCode) {
	this.assetCode = assetCode;
	}

	public String getProduct() {
	return product;
	}

	public void setProduct(String product) {
	this.product = product;
	}

	public String getDescription() {
	return description;
	}

	public void setDescription(String description) {
	this.description = description;
	}

	public Object getNotes() {
	return notes;
	}

	public void setNotes(Object notes) {
	this.notes = notes;
	}

	public String getComponentId() {
	return componentId;
	}

	public void setComponentId(String componentId) {
	this.componentId = componentId;
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

	public String getSiteId() {
	return siteId;
	}

	public void setSiteId(String siteId) {
	this.siteId = siteId;
	}

	public Object getAssetCustomers() {
	return assetCustomers;
	}

	public void setAssetCustomers(Object assetCustomers) {
	this.assetCustomers = assetCustomers;
	}

	

	
	private String name;
	private Integer value;
	private String displayName;
	
	public String getName() {
	return name;
	}

	public void setName(String name) {
	this.name = name;
	}

	public Integer getValue() {
	return value;
	}

	public void setValue(Integer value) {
	this.value = value;
	}

	public String getDisplayName() {
	return displayName;
	}

	public void setDisplayName(String displayName) {
	this.displayName = displayName;
	}
}
