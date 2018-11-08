/*package com.cyientinsights.forumenergyweb.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Site_Asset")
public class Sites {
	
	
	
	private Long Id;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="siteId")
	private Integer siteId;
	
	
	private String siteName;
	
	
	private String location;
	
	
	private BigDecimal latitude;
	
	
	private BigDecimal longitude;
	
	
	private Timestamp operatingFrom;
	
	
	private String siteType;

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public Timestamp getOperatingFrom() {
		return operatingFrom;
	}

	public void setOperatingFrom(Timestamp operatingFrom) {
		this.operatingFrom = operatingFrom;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

}

*/