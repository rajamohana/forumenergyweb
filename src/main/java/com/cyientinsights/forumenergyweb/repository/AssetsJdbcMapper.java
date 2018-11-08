package com.cyientinsights.forumenergyweb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cyientinsights.forumenergyweb.model.Assets;

public class AssetsJdbcMapper implements RowMapper<Assets> {

	@Override
	public Assets mapRow(ResultSet rs, int rowNum) throws SQLException {
		Assets assets= new Assets();
		assets.setAssetId(rs.getString("AssetId"));
		assets.setAssetName(rs.getString("AssetName"));
		assets.setAssetType(rs.getString("AssetType"));
		assets.setSiteId(rs.getString("SiteId"));
		assets.setSiteName(rs.getString("SiteName"));
		assets.setRul(rs.getDouble("RUL_Hrs"));
		assets.setRod(rs.getDouble("ROD"));
		assets.setSmh(rs.getDouble("UsedLife_Hrs"));
		assets.setExpectedLife(rs.getDouble("TotalExpectedLife_Hrs"));
		assets.setHealthPercentage(rs.getDouble("Health"));
		//assets.setLatitude(rs.getDouble("Latitude"));
		//assets.setLongitude(rs.getDouble("Longitude"));
		assets.setPurchaseDate(rs.getString("Asset_Commission_Date"));
		assets.setEolDate(rs.getString("EOL_Date"));
		//assets.setLogDateTime(rs.getInt("Log_Date_Time"));
		return assets;
	}

}
