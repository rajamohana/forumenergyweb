package com.cyientinsights.forumenergyweb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cyientinsights.forumenergyweb.model.Site;

public class SimHealthChartDataMapper implements RowMapper<Site> {

	@Override
	public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Site simhealthSite=new Site();
		simhealthSite.setSiteId(rs.getString("Machine_id"));
		simhealthSite.setSiteName((rs.getString("LogDateTime")));//logdatetime
		simhealthSite.setAvgHealthsite(rs.getDouble("Health_min"));//heathmin
		simhealthSite.setAvgRodsite(rs.getDouble("Health_max"));//Health_max
		simhealthSite.setAvgRulsite(rs.getDouble("Health_mean"));//Health_mean
		simhealthSite.setLatitude(rs.getDouble("Duration_hrs"));//Duration_hrs
		return simhealthSite;
	}

}
