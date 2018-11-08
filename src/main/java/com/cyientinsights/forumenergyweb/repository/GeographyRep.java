/*package com.cyientinsights.forumenergyweb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cyientinsights.forumenergyweb.model.Sites;

public class GeographyRep implements GeographyRespository {
	@PersistenceContext
    private EntityManager entityManager;
	@Override
	public List<Object[]> getGeographicData(List<String> siteIds_list) {
		
		Query createNativeQuery = null;
		createNativeQuery = entityManager.createNativeQuery("WITH X AS( 	SELECT SA.SiteId, SA.SiteName, SA.LocationName, SA.Latitude, SA.Longitude, SA.SiteType 	, SA.AssetId 	, FP.machine_id 	, FP.duration_hrs 	, FP.health 	, FP.rod_per_day__ 	, FP.rul_mean 	, FP.runtime_per_day_hrs 	, CASE WHEN Health <= 20 THEN 1 ELSE 0 END HealthCritical_Flag 	, CASE WHEN Health > 20 AND Health <= 60 THEN 1 ELSE 0 END HealthStable_Flag 	, CASE WHEN Health > 60 THEN 1 ELSE 0 END HealthGood_Flag 	FROM dbo.Site_Asset SA 	JOIN [dbo].[fracpump_cidb_rul] FP 	ON SA.AssetId = FP.machine_id AND SiteId IN ('TestSite1')	 )  SELECT SiteId, SiteName, LocationName, Latitude, Longitude, SiteType , AVG(Health) AS Avg_Health_Site , AVG(rod_per_day__) Avg_ROD_Site , AVG(RUL_Mean) AS Avg_RUL_Site , COUNT(Machine_Id) AS NumberOfAssets , SUM(HealthCritical_Flag) Critical , SUM(HealthStable_Flag) Stable , SUM(HealthGood_Flag) Good FROM X GROUP BY SiteId, SiteName, LocationName, Latitude, Longitude, SiteTypeWITH X AS( 	SELECT SA.SiteId, SA.SiteName, SA.LocationName, SA.Latitude, SA.Longitude, SA.SiteType 	, SA.AssetId 	, FP.machine_id 	, FP.duration_hrs 	, FP.health 	, FP.rod_per_day__ 	, FP.rul_mean 	, FP.runtime_per_day_hrs 	, CASE WHEN Health <= 20 THEN 1 ELSE 0 END HealthCritical_Flag 	, CASE WHEN Health > 20 AND Health <= 60 THEN 1 ELSE 0 END HealthStable_Flag 	, CASE WHEN Health > 60 THEN 1 ELSE 0 END HealthGood_Flag 	FROM dbo.Site_Asset SA 	JOIN [dbo].[fracpump_cidb_rul] FP 	ON SA.AssetId = FP.machine_id AND SiteId IN (:siteIds_list)	 )  SELECT SiteId, SiteName, LocationName, Latitude, Longitude, SiteType , AVG(Health) AS Avg_Health_Site , AVG(rod_per_day__) Avg_ROD_Site , AVG(RUL_Mean) AS Avg_RUL_Site , COUNT(Machine_Id) AS NumberOfAssets , SUM(HealthCritical_Flag) Critical , SUM(HealthStable_Flag) Stable , SUM(HealthGood_Flag) Good FROM X GROUP BY SiteId, SiteName, LocationName, Latitude, Longitude, SiteType",Sites.class);
		createNativeQuery.setParameter("siteIds_list", siteIds_list);
		if (createNativeQuery != null) {
			List<Object[]> resultList = (List<Object[]>) createNativeQuery.getResultList();
		
			
			return resultList;
		} else {
			return null;
		}
	}
	

}
*/