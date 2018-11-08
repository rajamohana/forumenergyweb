package com.cyientinsights.forumenergyweb.repository;

import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cyientinsights.forumenergyweb.model.Asset;
import com.cyientinsights.forumenergyweb.model.AssetDetailsCatWalk;
import com.cyientinsights.forumenergyweb.model.AssetGroup;
import com.cyientinsights.forumenergyweb.model.AssetJdbcEx;
import com.cyientinsights.forumenergyweb.model.Assets;
import com.cyientinsights.forumenergyweb.model.SensorsData;
import com.cyientinsights.forumenergyweb.model.Site;
import com.google.gson.Gson;
import com.microsoft.azure.documentdb.ConnectionPolicy;
import com.microsoft.azure.documentdb.ConsistencyLevel;
import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.DocumentClientException;
import com.microsoft.azure.documentdb.FeedOptions;
import com.microsoft.azure.documentdb.FeedResponse;
import com.microsoft.azure.documentdb.PartitionKey;
import com.microsoft.azure.documentdb.RequestOptions;

@Repository
public class BranchJDBCTemplate implements BranchDao{

	@Autowired
	private DataSource dataSource;

	@Autowired
	protected NamedParameterJdbcTemplate template;  

	private DocumentClient client;
	Gson gson = new Gson();
	   
	@Autowired
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}
	@Override
	public List<Site> getGeographicData(List<String> siteIds_list) {
		List<Site> sitesValues=null;
		System.out.println(siteIds_list);
		siteIds_list.add("TestSite2");
		siteIds_list.add("TestSite3");
		System.out.println(siteIds_list);
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", siteIds_list);

		String sql="WITH X AS( 	SELECT SA.SiteId, SA.SiteName, SA.LocationName, SA.Latitude, SA.Longitude, SA.SiteType 	, SA.AssetId 	, FP.machine_id 	, FP.duration_hrs 	, FP.health 	, FP.rod_per_day__ 	, FP.rul_mean 	, FP.runtime_per_day_hrs 	, CASE WHEN Health <= 20 THEN 1 ELSE 0 END HealthCritical_Flag 	, CASE WHEN Health > 20 AND Health <= 60 THEN 1 ELSE 0 END HealthStable_Flag 	, CASE WHEN Health > 60 THEN 1 ELSE 0 END HealthGood_Flag 	FROM dbo.Site_Asset SA 	JOIN [dbo].[fracpump_cidb_rul] FP 	ON SA.AssetId = FP.machine_id AND SiteId IN (:ids)	 )  SELECT SiteId, SiteName, LocationName, Latitude, Longitude, SiteType , AVG(Health) AS Avg_Health_Site , AVG(rod_per_day__) Avg_ROD_Site , AVG(RUL_Mean) AS Avg_RUL_Site , COUNT(Machine_Id) AS NumberOfAssets , SUM(HealthCritical_Flag) Critical , SUM(HealthStable_Flag) Stable , SUM(HealthGood_Flag) Good FROM X GROUP BY SiteId, SiteName, LocationName, Latitude, Longitude, SiteType ;";
		System.out.println(sql);

		try {
			sitesValues=template.query(sql,parameters,new GeoGraphyJdbcMapper());
			System.out.println(sitesValues);

			//return sitesValues;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return sitesValues;

	}
	@Override
	public List<AssetGroup> getAssetGroups(List<String> siteIds_list) {

		List<AssetGroup> sitesValues=null;
		System.out.println(siteIds_list);
		siteIds_list.add("TestSite2");
		siteIds_list.add("TestSite3");
		System.out.println(siteIds_list);
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", siteIds_list);

		String sql="SELECT SiteName,SiteId,LocationName,SiteType, AVG(Health) Health , SUM(CASE WHEN LOWER(AssetType) LIKE '%frac%' THEN 1 ELSE 0 END ) AS FracPump_Count , SUM(CASE WHEN LOWER(AssetType) LIKE  '%cat%' THEN 1 ELSE 0 END ) AS CatWalk_Count , SUM(CASE WHEN LOWER(AssetType) LIKE '%iron%' THEN 1 ELSE 0 END ) AS IronRoughneck_Count FROM ( 	SELECT SiteName, SA.SiteId, SiteType, [LocationName], [Health], AssetType 	FROM dbo.fracpump_cidb_rul FP 	JOIN [dbo].[Site_Asset] SA 	ON FP.machine_id = SA.AssetId AND SA.SiteId IN(:ids) ) N GROUP BY SiteName,SiteId,LocationName,SiteType";

		System.out.println(sql);

		try {
			sitesValues=template.query(sql,parameters,new AssetGroupJdbcMapper());
			System.out.println(sitesValues);
			//return sitesValues;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return sitesValues;
	}
	@Override
	public List<Assets> getAllAssets(List<String> siteIds_list) {
		
		
		
		List<Assets> sitesValues=null;
		System.out.println(siteIds_list);
		siteIds_list.add("TestSite2");
		siteIds_list.add("TestSite3");
		System.out.println(siteIds_list);
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", siteIds_list);
		
		String sql="SELECT AssetId, [AssetName], [AssetType], [Asset_Commission_Date], FP.Log_Date_Time, SH.EOL_Date, [LocationName], [Health] , SiteId, SiteName , [rod_per_day__] AS ROD, [duration_hrs] AS UsedLife_Hrs, RUL_Mean AS RUL_Hrs , [duration_hrs] + RUL_Mean AS TotalExpectedLife_Hrs FROM (   SELECT Machine_Id, Data_Taken_Till, Duration_Hrs, Rod_per_day__, Log_date_time, Health, RUl_Mean 	, ROW_NUMBER() OVER (PARTITION BY Machine_Id ORDER BY Data_taken_till DESC) RN 	FROM dbo.fracpump_cidb_rul )FP JOIN [dbo].[Site_Asset] SA ON FP.machine_id = SA.AssetId 	AND SA.SiteId IN  (:ids) 	AND RN = 1 JOIN ( SELECT Machine_Id, CAST(MAX(LogDateTime) AS DATE) AS EOL_Date 		FROM [dbo].[fracpump_cidb_sim_health] 		GROUP BY Machine_Id ) SH ON FP.Machine_Id = SH.Machine_id  ;";
		

		System.out.println(sql);

		try {
		        sitesValues=template.query(sql,parameters,new AssetsJdbcMapper());
			System.out.println(sitesValues);
			//return sitesValues;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return sitesValues;
		
		
	}
	@Override
	public List<Site> getSummaryAssetGroupDetails(String siteId) {
		List<Site> sitesValues=null;
		System.out.println(siteId);
		
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", siteId);

		String sql="WITH T1 AS ( 	SELECT machine_id 	, CASE WHEN Health <= 20 THEN 1 ELSE 0 END HealthCritical_Flag 	, CASE WHEN Health > 20 AND Health <= 60 THEN 1 ELSE 0 END HealthStable_Flag 	, CASE WHEN Health > 60 THEN 1 ELSE 0 END HealthGood_Flag 	, rod_per_day__ 	, duration_hrs 	, rul_mean	 	FROM dbo.fracpump_cidb_rul 	WHERE machine_id IN (SELECT DISTINCT AssetId FROM dbo.Site_Asset WHERE SiteId IN(:ids)) ) SELECT SUM(HealthCritical_Flag) Critical 	, SUM(HealthStable_Flag) Stable 	, SUM(HealthGood_Flag) Good 	, COUNT(*) Total_Assests 	, AVG(duration_hrs) AS AverageHours 	, AVG(rul_mean) AS AverageRUL 	, AVG(rod_per_day__) AverageROD FROM T1 ;";
		System.out.println(sql);

		try {
			sitesValues=template.query(sql,parameters,new AssetGroupDetailsForFracMapper());
			System.out.println(sitesValues);

			//return sitesValues;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return sitesValues;		
	}
	@Override
	public List<Site> getSummaryAssetGroupCatwalkDetails(String siteId) {
		
		List<Site> sitesValues=null;
		System.out.println(siteId);
		
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", siteId);

		String sql="SELECT AD.AssetId, [AssetName], AD.[AssetType], [Asset_Commission_Date], AD.LogDateTime, AD.EOL_Date, [LocationName], [Health] , SiteId, SiteName , AD.ROD , UsedLife , RUL , TotalExpectedLife , [Life_Metric] FROM [dbo].[vAssetDetails_User] AD JOIN [dbo].[Site_Asset] SA ON AD.AssetId = SA.AssetId 	AND SA.SiteId IN  (:ids) 	AND AD.AssetType = 'Catwalk' ;";
		System.out.println(sql);

		try {
			sitesValues=template.query(sql,parameters,new AssetGroupDetailsForCatwalk());
			System.out.println(sitesValues);

			//return sitesValues;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return sitesValues;
	} 
	
	@Override
	public List<Site> getHealthAssetGroupDetails(String siteId) {
		
		List<Site> sitesValues=null;
		System.out.println(siteId);
		
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", siteId);

		String sql="SELECT Machine_Id, Duration_Hrs, Health, Rod_per_day__, 'Least Health' AS FeatureType FROM (	SELECT Machine_Id, Duration_Hrs, Health, Rod_per_day__ 	, ROW_NUMBER() OVER (ORDER BY Health) RN_health 	FROM dbo.fracpump_cidb_rul 	WHERE machine_id IN (SELECT DISTINCT AssetId FROM dbo.Site_Asset WHERE SiteId IN(:ids)) ) T WHERE RN_health = 1 UNION ALL SELECT Machine_Id, Duration_Hrs, Health, Rod_per_day__, 'Highest Runtime' AS FeatureType FROM (	SELECT Machine_Id, Duration_Hrs, Health, Rod_per_day__ 	, ROW_NUMBER() OVER (ORDER BY Duration_Hrs DESC) RN_Runtime 	FROM dbo.fracpump_cidb_rul 	WHERE machine_id IN (SELECT DISTINCT AssetId FROM dbo.Site_Asset WHERE SiteId IN (:ids)) ) T WHERE RN_Runtime = 1 UNION ALL SELECT Machine_Id, Duration_Hrs, Health, Rod_per_day__, 'Highest Deterioration' AS FeatureType FROM (	SELECT Machine_Id, Duration_Hrs, Health, Rod_per_day__ 	, ROW_NUMBER() OVER (ORDER BY Rod_per_day__ DESC) RN_Deterioration 	FROM dbo.fracpump_cidb_rul 	WHERE machine_id IN (SELECT DISTINCT AssetId FROM dbo.Site_Asset WHERE SiteId IN(:ids)) ) T WHERE RN_Deterioration = 1;";
		System.out.println(sql);

		try {
			sitesValues=template.query(sql,parameters,new AssetGroupDetailsForFracHealthMapper());
			System.out.println(sitesValues);

			//return sitesValues;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return sitesValues;		
		
	}
	@Override
	public List<AssetJdbcEx> getAssetDetailsForFracType(String machineId) {
		
		List<AssetJdbcEx> sitesValues=null;
		System.out.println(machineId);
		
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", machineId); 
       //Todo changes ids in query
		String sql="SELECT SiteName, SA.SiteId, SiteType, [LocationName] , FP.Machine_Id, Log_Date_Time, Duration_Hrs, Health, ROD_Per_Day__ , Rul_Mean AS Projection_RUL , Runtime_per_day_hrs , [Health], AssetType , Total_Cavitation_Count , Total_Cavitation_Time , Total_MTBA_mins , Total_Events_Count FROM dbo.fracpump_cidb_rul FP JOIN [dbo].[Site_Asset] SA ON FP.machine_id = SA.AssetId JOIN (	 	SELECT Machine_Id, SUM([Cavitation_count]) Total_Cavitation_Count 	, SUM([Cav_duration_mins]) Total_Cavitation_Time 	, SUM([MTBA_mins]) Total_MTBA_mins 	, COUNT(*) Total_Events_Count 	FROM [dbo].[fracpump_cidb_events] FE 	GROUP BY Machine_id ) Q ON Q.Machine_id = FP.Machine_Id WHERE FP.Machine_id IN (:ids);";
		System.out.println(sql);

		try {
			sitesValues=template.query(sql,parameters,new AssetDetailsJdbcMapper());
			System.out.println(sitesValues);

			//return sitesValues;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return sitesValues;		
		
		
		

	}
	@Override
	public List<AssetDetailsCatWalk> getAssetDetailsForCatwalk(String machineId) {
		
		
		
		
		List<AssetDetailsCatWalk> sitesValues=null;
		System.out.println(machineId);
		
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", machineId);
          //todo change ids,given static
		String sql="SELECT * FROM (	SELECT A.Machine_id AS Asset_id 	, A.Health 	, A.Cycle_Count AS Cycles_Till_Today 	, A.ROD_per_day_perc AS ROD_Perc 	, A.Cycles_per_day 	, B.[Overload_event_cycles_count] AS Overload_Events 	, A.[Total_abnl_events_count] AS Abuse_Events 	, A.MTBA_mins 	, B.[Model_Confidence_perc] AS Model_Confidence 	, A.[RUL_max] AS ProjectionRUL 	, ROW_NUMBER() OVER(PARTITION BY A.Machine_Id ORDER BY A.LogDateTime DESC, B.LogDateTime DESC) RN 	FROM [dbo].[Catwalk_cidb_RUL] A 	JOIN [dbo].[Catwalk_cidb_Events] B 	ON A.Machine_id = B.Machine_Id 	WHERE A.Machine_ID IN(:ids) ) X WHERE RN = 1;";
		System.out.println(sql);

		try {
			sitesValues=template.query(sql,parameters,new AssetDetailsCatwalkMapper());
			System.out.println(sitesValues);

			//return sitesValues;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return sitesValues;		
		
	}
	@Override
	public List<Site> getHealthChartData(String machine_id) {
		List<Site> sitesValues=null;
		System.out.println(machine_id);
		
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", machine_id);

		String sql="SELECT [Machine_id], [LogDateTime], [Health], [Duration_hrs] FROM [dbo].[fracpump_cidb_health] WHERE Machine_id IN(:ids);";
		System.out.println(sql);

		try {
			sitesValues=template.query(sql,parameters,new HealthChartDataJDBCMapper());
			System.out.println(sitesValues);

			//return sitesValues;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return sitesValues;		
		
	}
	@Override
	public List<Site> getSimHealthChartData(String machine_id) {
		
		List<Site> sitesValues=null;
		System.out.println(machine_id);
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", machine_id);
//todo change ids
		String sql="SELECT [Machine_id], [LogDateTime], [Health_min], [Health_max], [Health_mean], [Duration_hrs] FROM [dbo].[fracpump_cidb_sim_health] WHERE Machine_id IN(:ids);";
		System.out.println(sql);

		try {
			sitesValues=template.query(sql,parameters,new SimHealthChartDataMapper());
			System.out.println(sitesValues);

			//return sitesValues;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return sitesValues;		
		
	}
	@Override
	public List<Site> getHealthChartDataCatWalk(String machine_id) {
		List<Site> sitesValues=null;
		System.out.println(machine_id);
		
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", machine_id);

		String sql="SELECT [Machine_id], [LogDateTime], [Health], [Duration_hrs] FROM [dbo].[Catwalk_cidb_Health] WHERE Machine_id IN(:ids);";
		System.out.println(sql);

		try {
			sitesValues=template.query(sql,parameters,new HealthChartDataJDBCMapper());
			System.out.println(sitesValues);

			//return sitesValues;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return sitesValues;		
	}
	@Override
	public List<Site> getSimHealthChartDataCatWalk(String machine_id) {
		List<Site> sitesValues=null;
		System.out.println(machine_id);
		
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", machine_id);

		String sql="SELECT [Machine_id], [LogDateTime], [Health_min], [Health_max], [Health_mean], [Duration_hrs] FROM [dbo].[Catwalk_cidb_sim_Health] WHERE Machine_id IN(:ids);";
		System.out.println(sql);

		try {
			sitesValues=template.query(sql,parameters,new SimHealthChartDataMapper());
			System.out.println(sitesValues);

			//return sitesValues;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return sitesValues;		
		
	  }
	
	   @Override
        public List<SensorsData> executeSimpleQueryForFrac(String Startdate, String endDate) {
		 
		/* this.client = new DocumentClient("https://cyientcosmos.documents.azure.com:443/",
	                "aYKTlOp0rlEhhVvj7x7GMohKGh4WOgFPOdqLFuitN0GLmHSvpJqE39DJ5syF765RA7QfxgHkXDyW9wZfIAAVMQ==", 
	                new ConnectionPolicy(),
	                ConsistencyLevel.Session);
		    String databaseName="iotdata2";
		    String collectionName="fracdata";*/
		   this.client = new DocumentClient("https://cyienttestcosmos.documents.azure.com:443/",
	                "aEI5eenbq5DLyskFDJ82CbjpZ8v5Qw8YTTVFeribVoVl78dtvjnGYTeiavtdU0X2bnNboToOXqwibmbchVc6MQ==", 
	                new ConnectionPolicy(),
	                ConsistencyLevel.Session);
		    String databaseName="iotdata";
		    String collectionName="newData";
		 
		    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		   
		    
		   long timemil5hrsback= System.currentTimeMillis()-(3600 * 1000 *5);
		   long timesec5hrsback=TimeUnit.MILLISECONDS.toSeconds(timemil5hrsback);
		   System.out.println("Last five hoursback time stamp"+timesec5hrsback);
		   
		    Long tmtmilsec=System.currentTimeMillis();
		   long tmtsec =TimeUnit.MILLISECONDS.toSeconds(tmtmilsec);
		   System.out.println("current Time stamp"+tmtsec);
	     
	        // Set some common query options
	        FeedOptions queryOptions = new FeedOptions();
	        queryOptions.setPageSize(-1);
	        queryOptions.setEnableCrossPartitionQuery(true);

	        String collectionLink = String.format("/dbs/%s/colls/%s", databaseName, collectionName);
	        FeedResponse<Document> queryResults = this.client.queryDocuments(collectionLink,
	                "SELECT f._ts,f.inletTemp FROM fracdata f where f._ts >"+ timesec5hrsback+" AND f._ts < "+ tmtsec +"" , queryOptions);
	        
	        //1537879820
	        //SELECT f._ts,f.inletTemp FROM fracdata f where f._ts > 1540453820 AND f._ts < 1540471820//5hrs
	        
	        //SELECT f._ts,f.inletTemp FROM fracdata f where f._ts > 1537879820 AND f._ts < 1540471820// 30 days

	        System.out.println("Running SQL query...");
	        
	        List<Document> family=queryResults.getQueryIterable().toList();
	        
	        List<SensorsData> listsensorData=new ArrayList<SensorsData>();
	        
	        for(int i=0;i<family.size();i++)
	        {
	        SensorsData sensedata=gson.fromJson(family.get(i).toString(), SensorsData.class);
	        
	        listsensorData.add(sensedata);
	        
	        }
	       
	        // System.out.println(sensedata.getInletTemp()+" "+sensedata.get_ts());
	        
	        /*for (Document family : queryResults.getQueryIterable()) {
	            System.out.println(String.format("\tRead %s", family));
	        }*/
	    
	      return listsensorData;
	 }
	   
	   public void executeStoredProcWithArgs(String sensorList) throws DocumentClientException {
	   
		   this.client = new DocumentClient("https://cyienttestcosmos.documents.azure.com:443/",
	                "aEI5eenbq5DLyskFDJ82CbjpZ8v5Qw8YTTVFeribVoVl78dtvjnGYTeiavtdU0X2bnNboToOXqwibmbchVc6MQ==", 
	                new ConnectionPolicy(),
	                ConsistencyLevel.Session);
		    String databaseName="iotdata";
		    String collectionName="newData";
		    
		    
		   RequestOptions requestOptions = new RequestOptions();
	        requestOptions.setPartitionKey(new PartitionKey("SFE300_SPE300"));
	        String storedProcLink = String.format("/dbs/%s/colls/%s/sprocs/%s", databaseName,collectionName, "something");
	        
	        String sensorNames="inletTemp,outletTemp";
	        
	        
	        long timemils30daysback= System.currentTimeMillis()-(3600 * 1000 *24*30);
			   long timesec30daysback=TimeUnit.MILLISECONDS.toSeconds(timemils30daysback);
			   System.out.println("timesec30daysback"+timesec30daysback);
			   
			    Long tmtmilsec=System.currentTimeMillis();
			   long tmtsec =TimeUnit.MILLISECONDS.toSeconds(tmtmilsec);
			   System.out.println("current Time stamp"+tmtsec);
	        
	        Object[] storedProcedureArgs = new Object[] {sensorList,timesec30daysback,tmtsec};
	        
	        
	        String storedProcResultAsString = client.executeStoredProcedure(storedProcLink, requestOptions, storedProcedureArgs).getResponseAsString();
	  
	        System.out.println(storedProcResultAsString);
	        
	   }
	
	

}
