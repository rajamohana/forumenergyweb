/*package com.cyientinsights.forumenergyweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import com.cyientinsights.forumenergyweb.model.Fracpump_cidb_rul;
import com.cyientinsights.forumenergyweb.model.Site;

public interface AssetGroupsRepository extends JpaRepository<Fracpump_cidb_rul, Long> {
	
	@Query(value="SELECT SUM(HealthCritical_Flag) Critical\r\n" + 
			"	, SUM(HealthStable_Flag) Stable\r\n" + 
			"	, SUM(HealthGood_Flag) Good\r\n" + 
			"	, COUNT(*) Total_Assests\r\n" + 
			"	, AVG(duration_hrs) AS AverageHours\r\n" + 
			"	, AVG(rul_mean) AS AverageRUL\r\n" + 
			"	, AVG(rod_per_day__) AverageROD\r\n" + 
			"	FROM (\r\n" + 
			"	SELECT machine_id\r\n" + 
			"	, CASE WHEN Health <= 20 THEN 1 ELSE 0 END HealthCritical_Flag\r\n" + 
			"	, CASE WHEN Health > 20 AND Health <= 60 THEN 1 ELSE 0 END HealthStable_Flag\r\n" + 
			"	, CASE WHEN Health > 60 THEN 1 ELSE 0 END HealthGood_Flag\r\n" + 
			"	, rod_per_day__\r\n" + 
			"	, duration_hrs\r\n" + 
			"	, rul_mean	\r\n" + 
			"	FROM dbo.fracpump_cidb_rul\r\n" + 
			"	--WHERE machine_id IN ('UL5P6BR7T7')\r\n" + 
			") T1",nativeQuery=true)
	//public List<Object[]> getAssetClassTypeSummary(@Param("siteId") Integer siteId);
	public List<Object[]> getAssetClassTypeSummary();
	
	@Query(value="SELECT Machine_Id, Duration_Hrs, Health, Rod_per_day__, 'Least Health' AS FeatureType\r\n" + 
			"FROM \r\n" + 
			"(\r\n" + 
			"	SELECT Machine_Id, Duration_Hrs, Health, Rod_per_day__\r\n" + 
			"	, ROW_NUMBER() OVER (ORDER BY Health) RN_health\r\n" + 
			"	FROM dbo.fracpump_cidb_rul\r\n" + 
			") T\r\n" + 
			"WHERE RN_health = 1\r\n" + 
			"UNION ALL\r\n" + 
			"SELECT Machine_Id, Duration_Hrs, Health, Rod_per_day__, 'Highest Runtime' AS FeatureType\r\n" + 
			"FROM \r\n" + 
			"(\r\n" + 
			"	SELECT Machine_Id, Duration_Hrs, Health, Rod_per_day__\r\n" + 
			"	, ROW_NUMBER() OVER (ORDER BY Duration_Hrs DESC) RN_Runtime\r\n" + 
			"	FROM dbo.fracpump_cidb_rul\r\n" + 
			") T\r\n" + 
			"WHERE RN_Runtime = 1\r\n" + 
			"UNION ALL\r\n" + 
			"SELECT Machine_Id, Duration_Hrs, Health, Rod_per_day__, 'Highest Deterioration' AS FeatureType\r\n" + 
			"FROM \r\n" + 
			"(\r\n" + 
			"	SELECT Machine_Id, Duration_Hrs, Health, Rod_per_day__\r\n" + 
			"	, ROW_NUMBER() OVER (ORDER BY Rod_per_day__ DESC) RN_Deterioration\r\n" + 
			"	FROM dbo.fracpump_cidb_rul\r\n" + 
			") T\r\n" + 
			"WHERE RN_Deterioration = 1",nativeQuery=true)
	public List<Object[]> getListOfHighLowFeatures();
	//public List<Object[]> getListOfHighLowFeatures(@Param("siteId") Integer siteId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
*/