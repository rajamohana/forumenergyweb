package com.cyientinsights.forumenergyweb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cyientinsights.forumenergyweb.model.Site;

public class AssetGroupDetailsForCatwalk implements RowMapper<Site> {

	@Override
	public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
		Site catwalkSite=new Site();
		catwalkSite.setId(rs.getString("AssetId"));
		catwalkSite.setAssetName(rs.getString("assetName"));
		catwalkSite.setSiteType(rs.getString("AssetType"));
		catwalkSite.setCategory(rs.getString("Asset_Commission_date"));//assetcommisiondate
		catwalkSite.setSiteLocation(rs.getString("LogDateTime"));//logdatetime
		catwalkSite.setSiteCode(rs.getString("EOL_Date"));//Eoldate
		catwalkSite.setLocation(rs.getString("LocationName"));
		catwalkSite.setAvgHealthsite(rs.getDouble("Health"));//health
		catwalkSite.setSiteId(rs.getString("SiteId"));//
		catwalkSite.setSiteName(rs.getString("SiteName"));
		catwalkSite.setAvgRodsite(rs.getDouble("ROD"));//rod
		catwalkSite.setLongitude(rs.getDouble("UsedLife"));//useflife
		catwalkSite.setAvgRulsite(rs.getDouble("RUL"));
		catwalkSite.setLatitude(rs.getDouble("TotalExpectedLife"));//total expected life
		//catwalkSite.setGood(rs.getInt("Life_Metric"));
		return catwalkSite;
	}

}
