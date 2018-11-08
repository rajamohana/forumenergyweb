package com.cyientinsights.forumenergyweb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cyientinsights.forumenergyweb.model.AssetJdbcEx;


public class AssetDetailsJdbcMapper implements RowMapper<AssetJdbcEx> {

	@Override
	public AssetJdbcEx mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		AssetJdbcEx assetjdbcex= new AssetJdbcEx();
		assetjdbcex.setSiteId(rs.getString("SiteId"));
		assetjdbcex.setSiteName(rs.getString("SiteName"));
		assetjdbcex.setSiteType(rs.getString("SiteType"));
		assetjdbcex.setLocation(rs.getString("LocationName"));
		assetjdbcex.setAssetid(rs.getString("Machine_Id"));
		assetjdbcex.setLogdatetime(rs.getString("Log_Date_Time"));
		assetjdbcex.setDurationshours(rs.getDouble("Duration_Hrs"));
		assetjdbcex.setHealth(rs.getDouble("Health"));
		assetjdbcex.setRopperday(rs.getDouble("ROD_Per_Day__"));
		assetjdbcex.setProjectionrul(rs.getDouble("Projection_RUL"));
		assetjdbcex.setRuntimeperdayhrs(rs.getDouble("Runtime_Per_Day_hrs"));
		assetjdbcex.setAssettype(rs.getString("AssetType"));
		assetjdbcex.setTotalcaviationcount(rs.getDouble("Total_Cavitation_Count"));
		assetjdbcex.setTotalcaviationtime(rs.getDouble("Total_Cavitation_Time"));
		assetjdbcex.setTotalmtbamins(rs.getDouble("Total_MTBA_mins"));
		assetjdbcex.setTotaleventscount(rs.getInt("Total_Events_Count"));	
		return assetjdbcex;
	}

}
