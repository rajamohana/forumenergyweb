package com.cyientinsights.forumenergyweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RULLife {

	private Object name;
	
	private Object displayName;
	
	@JsonIgnore
	private Object life;
	
	private Object RUL;
	
	private Object units;

	public Object getUnits() {
		return units;
	}

	public void setUnits(Object units) {
		this.units = units;
	}

	public Object getName() {
		return name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public Object getDisplayName() {
		return displayName;
	}

	public void setDisplayName(Object displayName) {
		this.displayName = displayName;
	}

	public Object getLife() {
		return life;
	}

	public void setLife(Object life) {
		this.life = life;
	}

	public Object getRUL() {
		return RUL;
	}

	public void setRUL(Object rUL) {
		RUL = rUL;
	}
	
}
