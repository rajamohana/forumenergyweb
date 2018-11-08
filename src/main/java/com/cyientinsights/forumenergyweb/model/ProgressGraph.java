package com.cyientinsights.forumenergyweb.model;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ProgressGraph {
	private List<GraphDatum> graphData = null;
	private Integer xAxisToday;
	private BigDecimal yAxisToday;
	

	public List<GraphDatum> getGraphData() {
	return graphData;
	}

	public void setGraphData(List<GraphDatum> graphData) {
	this.graphData = graphData;
	}

	public Integer getXAxisToday() {
	return xAxisToday;
	}

	public void setXAxisToday(Integer xAxisToday) {
	this.xAxisToday = xAxisToday;
	}

	public BigDecimal getYAxisToday() {
	return yAxisToday;
	}

	public void setYAxisToday(BigDecimal yAxisToday) {
	this.yAxisToday = yAxisToday;
	}

}
