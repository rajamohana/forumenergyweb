package com.cyientinsights.forumenergyweb.model;

public class AssetDetailsCatWalk {
	private String assetId;
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public Integer getCycles_Till_Today() {
		return cycles_Till_Today;
	}
	public void setCycles_Till_Today(Integer cycles_Till_Today) {
		this.cycles_Till_Today = cycles_Till_Today;
	}
	public double getRodpersec() {
		return rodpersec;
	}
	public void setRodpersec(double rodpersec) {
		this.rodpersec = rodpersec;
	}
	public Integer getCyclesperday() {
		return cyclesperday;
	}
	public void setCyclesperday(Integer cyclesperday) {
		this.cyclesperday = cyclesperday;
	}
	public Integer getOverloadevenets() {
		return overloadevenets;
	}
	public void setOverloadevenets(Integer overloadevenets) {
		this.overloadevenets = overloadevenets;
	}
	public Integer getAbuseEvents() {
		return abuseEvents;
	}
	public void setAbuseEvents(Integer abuseEvents) {
		this.abuseEvents = abuseEvents;
	}
	public double getMtbamins() {
		return mtbamins;
	}
	public void setMtbamins(double mtbamins) {
		this.mtbamins = mtbamins;
	}
	public double getModelconfidence() {
		return modelconfidence;
	}
	public void setModelconfidence(double modelconfidence) {
		this.modelconfidence = modelconfidence;
	}
	public Integer getProjectionrul() {
		return projectionrul;
	}
	public void setProjectionrul(Integer projectionrul) {
		this.projectionrul = projectionrul;
	}
	public Integer getRownumber() {
		return rownumber;
	}
	public void setRownumber(Integer rownumber) {
		this.rownumber = rownumber;
	}
	private double health;
	private Integer cycles_Till_Today;
	private double rodpersec;
	private Integer cyclesperday;
	private Integer overloadevenets;
	private Integer abuseEvents;
	private double mtbamins;
	private double modelconfidence;
	private Integer projectionrul;
	private Integer rownumber;

}