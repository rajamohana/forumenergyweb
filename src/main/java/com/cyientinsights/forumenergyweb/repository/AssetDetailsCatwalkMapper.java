package com.cyientinsights.forumenergyweb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cyientinsights.forumenergyweb.model.AssetDetailsCatWalk;

public class AssetDetailsCatwalkMapper implements RowMapper<AssetDetailsCatWalk> {

	@Override
	public AssetDetailsCatWalk mapRow(ResultSet rs, int rowNum) throws SQLException {

		AssetDetailsCatWalk asdc= new AssetDetailsCatWalk();
		asdc.setAssetId(rs.getString("Asset_id"));
		asdc.setHealth(rs.getDouble("Health"));
		asdc.setCycles_Till_Today(rs.getInt("Cycles_Per_day"));
		asdc.setRodpersec(rs.getDouble("ROD_Perc"));
		asdc.setCyclesperday(rs.getInt("Cycles_Per_day"));
		asdc.setOverloadevenets(rs.getInt("Overload_Events"));
		asdc.setAbuseEvents(rs.getInt("Abuse_Events"));
		asdc.setMtbamins(rs.getDouble("MTBA_mins"));
		asdc.setModelconfidence(rs.getDouble("Model_Confidence"));
		asdc.setProjectionrul(rs.getInt("projectionRul"));
		asdc.setRownumber(rs.getInt("RN"));
		return asdc;
	}

}
