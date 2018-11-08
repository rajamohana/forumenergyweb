package com.cyientinsights.forumenergyweb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cyientinsights.forumenergyweb.model.Site;

public class AssetGroupDetailsForFracMapper implements RowMapper<Site> {

	@Override
	public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Site sitess= new Site();
		sitess.setAvgHealthsite(rs.getDouble("AverageHours"));
		sitess.setAvgRodsite(rs.getDouble("AverageROD"));
		sitess.setAvgRulsite(rs.getDouble("AverageRUL"));
		sitess.setNoOfAssetss(rs.getInt("Total_Assests"));
		sitess.setCritical(rs.getInt("Critical"));
		sitess.setStable(rs.getInt("Stable"));
		sitess.setGood(rs.getInt("Good"));
		
		
		
		return sitess;
	}

}
