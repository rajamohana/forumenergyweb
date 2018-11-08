package com.cyientinsights.forumenergyweb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cyientinsights.forumenergyweb.model.Site;

public class HealthChartDataJDBCMapper implements RowMapper<Site> {

	@Override
	public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Site healthsite=new Site();
		
		healthsite.setSiteId(rs.getString("Machine_id"));
		healthsite.setSiteName(rs.getString("LogDateTime"));//logdatetime
		healthsite.setAvgHealthsite(rs.getDouble("Health"));//health
		healthsite.setAvgRodsite(rs.getDouble("Duration_hrs"));
		return healthsite;
	}

}
