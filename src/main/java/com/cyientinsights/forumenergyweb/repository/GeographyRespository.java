/*package com.cyientinsights.forumenergyweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//simport org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cyientinsights.forumenergyweb.model.Fracpump_cidb_rul;
import com.cyientinsights.forumenergyweb.model.Sites;

public interface GeographyRespository{
	//@Query(value="WITH X AS( 	SELECT SA.SiteId, SA.SiteName, SA.LocationName, SA.Latitude, SA.Longitude, SA.SiteType 	, SA.AssetId 	, FP.machine_id 	, FP.duration_hrs 	, FP.health 	, FP.rod_per_day__ 	, FP.rul_mean 	, FP.runtime_per_day_hrs 	, CASE WHEN Health <= 20 THEN 1 ELSE 0 END HealthCritical_Flag 	, CASE WHEN Health > 20 AND Health <= 60 THEN 1 ELSE 0 END HealthStable_Flag 	, CASE WHEN Health > 60 THEN 1 ELSE 0 END HealthGood_Flag 	FROM dbo.Site_Asset SA 	JOIN [dbo].[fracpump_cidb_rul] FP 	ON SA.AssetId = FP.machine_id AND SiteId IN ('TestSite1')	 )  SELECT SiteId, SiteName, LocationName, Latitude, Longitude, SiteType , AVG(Health) AS Avg_Health_Site , AVG(rod_per_day__) Avg_ROD_Site , AVG(RUL_Mean) AS Avg_RUL_Site , COUNT(Machine_Id) AS NumberOfAssets , SUM(HealthCritical_Flag) Critical , SUM(HealthStable_Flag) Stable , SUM(HealthGood_Flag) Good FROM X GROUP BY SiteId, SiteName, LocationName, Latitude, Longitude, SiteType",nativeQuery=true)
	public List<Object[]> getGeographicData(@Param("siteIds_list") List<String> siteIds_list);
	
}
*/