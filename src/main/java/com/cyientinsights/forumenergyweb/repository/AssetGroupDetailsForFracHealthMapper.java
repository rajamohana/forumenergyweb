package com.cyientinsights.forumenergyweb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cyientinsights.forumenergyweb.model.Site;

public class AssetGroupDetailsForFracHealthMapper implements RowMapper<Site>  {

	@Override
	public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Site sitess= new Site();
		sitess.setCategory(rs.getString("FeatureType"));
		sitess.setSiteId(rs.getString("Machine_Id"));
		sitess.setAvgHealthsite(rs.getDouble("Health"));
		sitess.setAvgRodsite(rs.getDouble("Rod_per_day__"));
		
		
		return sitess;
	}

}
