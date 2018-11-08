package com.cyientinsights.forumenergyweb.model;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
public class GraphDatum {
	private BigDecimal xAxis;

	private Object xAxisDate;

	private BigDecimal yAxis;

	public BigDecimal getxAxis() {
		return xAxis;
	}

	public void setxAxis(BigDecimal xAxis) {
		this.xAxis = xAxis;
	}

	public Object getxAxisDate() {
		return xAxisDate;
	}

	public void setxAxisDate(Object xAxisDate) {
		this.xAxisDate = xAxisDate;
	}

	public BigDecimal getyAxis() {
		return yAxis;
	}

	public void setyAxis(BigDecimal yAxis) {
		this.yAxis = yAxis;
	}

}
