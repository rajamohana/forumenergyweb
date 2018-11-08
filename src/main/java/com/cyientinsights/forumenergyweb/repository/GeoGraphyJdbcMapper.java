package com.cyientinsights.forumenergyweb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cyientinsights.forumenergyweb.model.Site;


public class GeoGraphyJdbcMapper implements RowMapper<Site> {

	@Override
	public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		
		Site sitess= new Site();
		sitess.setSiteId(rs.getString("SiteId"));
		sitess.setSiteName(rs.getString("SiteName"));
		sitess.setLocation(rs.getString("LocationName"));
		sitess.setLatitude(rs.getDouble("Latitude"));
		sitess.setLongitude(rs.getDouble("Longitude"));
		sitess.setSiteType(rs.getString("SiteType"));
		sitess.setAvgHealthsite(rs.getDouble("Avg_Health_Site"));
		sitess.setAvgRodsite(rs.getDouble("Avg_ROD_Site"));
		sitess.setAvgRulsite(rs.getDouble("Avg_RUL_Site"));
		sitess.setNoOfAssetss(rs.getInt("NumberOfAssets"));
		sitess.setCritical(rs.getInt("Critical"));
		sitess.setStable(rs.getInt("Stable"));
		sitess.setGood(rs.getInt("Good"));
		System.out.println(sitess);
		return sitess;
		
		
	}

}
