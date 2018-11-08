package com.cyientinsights.forumenergyweb.model;

import java.util.List;

public class Example {

	private Object title;
	private String firstName;
	private String lastName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String phoneCell;
	private String phoneHome;
	private String phoneWork;
	private Object userCustomers;
	private List<UserSite> userSites = null;
	private String id;
	private String userName;
	private String normalizedUserName;
	private String email;
	private String normalizedEmail;
	private Object lockoutEnd;
	private Boolean lockoutEnabled;
	private Integer accessFailedCount;

	public Object getTitle() {
		return title;
	}

	public void setTitle(Object title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneCell() {
		return phoneCell;
	}

	public void setPhoneCell(String phoneCell) {
		this.phoneCell = phoneCell;
	}

	public String getPhoneHome() {
		return phoneHome;
	}

	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}

	public String getPhoneWork() {
		return phoneWork;
	}

	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}

	public Object getUserCustomers() {
		return userCustomers;
	}

	public void setUserCustomers(Object userCustomers) {
		this.userCustomers = userCustomers;
	}

	public List<UserSite> getUserSites() {
		return userSites;
	}

	public void setUserSites(List<UserSite> userSites) {
		this.userSites = userSites;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNormalizedUserName() {
		return normalizedUserName;
	}

	public void setNormalizedUserName(String normalizedUserName) {
		this.normalizedUserName = normalizedUserName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNormalizedEmail() {
		return normalizedEmail;
	}

	public void setNormalizedEmail(String normalizedEmail) {
		this.normalizedEmail = normalizedEmail;
	}

	public Object getLockoutEnd() {
		return lockoutEnd;
	}

	public void setLockoutEnd(Object lockoutEnd) {
		this.lockoutEnd = lockoutEnd;
	}

	public Boolean getLockoutEnabled() {
		return lockoutEnabled;
	}

	public void setLockoutEnabled(Boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	public Integer getAccessFailedCount() {
		return accessFailedCount;
	}

	public void setAccessFailedCount(Integer accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

}
