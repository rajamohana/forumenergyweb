package com.cyientinsights.forumenergyweb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cyientinsights.forumenergyweb.model.AssetGroup;
import com.cyientinsights.forumenergyweb.model.Site;

public class AssetGroupJdbcMapper implements RowMapper<AssetGroup> {

	@Override
	public AssetGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		AssetGroup   assetsGroup= new AssetGroup();
		
		assetsGroup.setAssetGrpId(rs.getString("SiteId"));
		assetsGroup.setAssetGrpName(rs.getString("SiteName"));
		assetsGroup.setAssetGrpLocation(rs.getString("LocationName"));
		assetsGroup.setAssetGrpType(rs.getString("SiteType"));
		assetsGroup.setHealthPercentage(rs.getDouble("Health"));
		assetsGroup.setFracCount(rs.getString("FracPump_Count"));
		assetsGroup.setCatwalkCount(rs.getString("CatWalk_Count"));
		
		return assetsGroup;
	}

}
