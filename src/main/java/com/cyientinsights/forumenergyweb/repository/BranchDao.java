package com.cyientinsights.forumenergyweb.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.data.repository.query.Param;

import com.cyientinsights.forumenergyweb.model.AssetDetailsCatWalk;
import com.cyientinsights.forumenergyweb.model.AssetGroup;
import com.cyientinsights.forumenergyweb.model.AssetJdbcEx;
import com.cyientinsights.forumenergyweb.model.Assets;
import com.cyientinsights.forumenergyweb.model.SensorsData;
import com.cyientinsights.forumenergyweb.model.Site;
import com.microsoft.azure.documentdb.DocumentClientException;

public interface BranchDao {

	public void setDataSource(DataSource ds);
	public List<Site> getGeographicData(@Param("siteIds_list") List<String> siteIds_list);
	
	public List<AssetGroup> getAssetGroups(@Param("siteIds_list") List<String> siteIds_list);
	
	public List<Assets> getAllAssets(@Param("siteIds_list") List<String> siteIds_list);
	
	public List<Site> getSummaryAssetGroupDetails(@Param("siteId") String siteId);
	
	public List<Site> getHealthAssetGroupDetails(@Param("siteId") String siteId);
	
	public List<Site> getSummaryAssetGroupCatwalkDetails(@Param("siteId") String siteId);
	
	
	public List<AssetJdbcEx> getAssetDetailsForFracType(@Param("Machine_Id") String machineId);
	
	public List<AssetDetailsCatWalk> getAssetDetailsForCatwalk(@Param("Machine_Id") String machineId);
	
	
	public List<Site> getHealthChartData(@Param("machine_id") String machine_id);
	
	 public List<Site> getSimHealthChartData(@Param("machine_id") String machine_id);
	 
     public List<Site> getHealthChartDataCatWalk(@Param("machine_id") String machine_id);
	
	 public List<Site> getSimHealthChartDataCatWalk(@Param("machine_id") String machine_id);
	
	 
	 public List<SensorsData> executeSimpleQueryForFrac(String Startdate, String endDate);
	 
	 public void executeStoredProcWithArgs(String sensorList)throws DocumentClientException ;
	 
	
	
	
}
