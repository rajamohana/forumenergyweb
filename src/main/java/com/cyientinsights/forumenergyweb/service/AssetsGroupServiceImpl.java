package com.cyientinsights.forumenergyweb.service;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;


import com.cyientinsights.forumenergyweb.model.AssetData;
import com.cyientinsights.forumenergyweb.model.AssetDetailsCatWalk;
import com.cyientinsights.forumenergyweb.model.AssetDetailsFracTypeResponse;
import com.cyientinsights.forumenergyweb.model.AssetGroup;
import com.cyientinsights.forumenergyweb.model.AssetGroupDetailsForRegTypeResponse;
import com.cyientinsights.forumenergyweb.model.AssetGrpDetailsForFracTypeResponse;
import com.cyientinsights.forumenergyweb.model.AssetGrpMajorAssets;
import com.cyientinsights.forumenergyweb.model.AssetJdbcEx;
import com.cyientinsights.forumenergyweb.model.AssetMetaData;
import com.cyientinsights.forumenergyweb.model.AssetMetaData3;
import com.cyientinsights.forumenergyweb.model.AssetMetaData4;
import com.cyientinsights.forumenergyweb.model.Assets;
import com.cyientinsights.forumenergyweb.model.AssetsDataRigType;
import com.cyientinsights.forumenergyweb.model.AssetsResponse;
import com.cyientinsights.forumenergyweb.model.CategoryDetailsRequest;
import com.cyientinsights.forumenergyweb.model.CategoryDetailsResponse;
import com.cyientinsights.forumenergyweb.model.Coordinates;
import com.cyientinsights.forumenergyweb.model.DataToShowOnHover;
import com.cyientinsights.forumenergyweb.model.GraphDatum;
import com.cyientinsights.forumenergyweb.model.HealthData;
import com.cyientinsights.forumenergyweb.model.HealthGraph;
import com.cyientinsights.forumenergyweb.model.HealthGraphData;
import com.cyientinsights.forumenergyweb.model.OptimalValues;
import com.cyientinsights.forumenergyweb.model.ProgressGraph;
import com.cyientinsights.forumenergyweb.model.RULLife;
import com.cyientinsights.forumenergyweb.model.Site;
import com.cyientinsights.forumenergyweb.model.VariableGraph;



@Service
public class AssetsGroupServiceImpl {
	
	/*public AssetGrpDetailsForFracTypeResponse convertAssetGrpFracSiteToData(Object[] summaryDetailsObj, List<Object[]> highLevelDataObj,Site siteList) {
		AssetGrpDetailsForFracTypeResponse response = new AssetGrpDetailsForFracTypeResponse();
		
		//response.setAssetGrpId((summaryDetailsObj[0]==null)?null:summaryDetailsObj[0]);
		response.setAssetGrpId(siteList.getId());
		//response.setAssetGrpName((summaryDetailsObj[14]==null)?null:summaryDetailsObj[14]);
		response.setAssetGrpName(siteList.getSiteName());
		//response.setAssetGrpType((summaryDetailsObj[13]==null)?null:summaryDetailsObj[13]);
		String sitetypes=siteList.getSiteType().toLowerCase();
		response.setAssetGrpType(sitetypes);
		HealthData healthData = new HealthData();
		//healthData.setHealthPercentage((summaryDetailsObj[4]==null)?null:summaryDetailsObj[4]);
		healthData.setHealthPercentage(10.595000);
		//healthData.setSiteAvgHealth((summaryDetailsObj[2]==null)?null:summaryDetailsObj[2]);
		healthData.setSiteAvgHealth(46.6539076116763333);
		response.setHealthData(healthData);
		
		Map<String, AssetData> map = new HashMap<String, AssetData>();
		AssetData assetData = new AssetData();
		//assetData.setTotalAssets(summaryDetailsObj[1]==null?null:summaryDetailsObj[1]);
		assetData.setTotalAssets(siteList.getAssets().size());
		System.out.println(siteList.getAssets().size());
		//assetData.setGood(summaryDetailsObj[7]==null?null:summaryDetailsObj[7]);
		assetData.setGood(1);
		//assetData.setStable(summaryDetailsObj[6]==null?null:summaryDetailsObj[6]);
		assetData.setStable(0);
		//assetData.setCritical(summaryDetailsObj[5]==null?null:summaryDetailsObj[5]);
		assetData.setCritical(0);
		map.put("frackpumps",assetData);
		
		List<Map<String, AssetData>> list = new ArrayList<Map<String, AssetData>>();
		list.add(map);
		response.setAssetsData(list);
		
		AssetMetaData3 assetMetaData3 = new AssetMetaData3();
		AssetMetaData3 assetMData = new AssetMetaData3();
		AssetMetaData3 assetMetaData33 = new AssetMetaData3();
		
		assetMetaData33.setName(SecurityConstants.NO_OF_FRAC_PUMPS);
		assetMetaData33.setDisplayName(SecurityConstants.FRAC_PUMPS);
		//assetMetaData33.setValue((summaryDetailsObj[1]==null)?null:summaryDetailsObj[1]);
		assetMetaData33.setValue(2);
		AssetMetaData assetMetaData = new AssetMetaData();
		assetMetaData.setName(SecurityConstants.RUL);
		assetMetaData.setDisplayName(SecurityConstants.AVG_RUL);
		//assetMetaData.setValue((summaryDetailsObj[8]==null)?null:summaryDetailsObj[8]);
		assetMetaData.setValue(432.901667);
		assetMetaData3.setName(SecurityConstants.HOURS);
		assetMetaData3.setDisplayName(SecurityConstants.AVG_HOURS);
		//assetMetaData3.setValue((summaryDetailsObj[3]==null)?null:summaryDetailsObj[3]);
		assetMetaData3.setValue(141.633333);
		//assetMetaData3.setUnits("");
		
		assetMData.setName(SecurityConstants.ROD);
		assetMData.setDisplayName(SecurityConstants.ROD);
		//assetMData.setValue((summaryDetailsObj[4]==null)?null:summaryDetailsObj[4]);
		//assetMData.setUnits("");
		assetMData.setValue(10.595000);
		
		
		ArrayList<AssetMetaData> assetGrpMetaData = new ArrayList<AssetMetaData>();
		
		assetGrpMetaData.add(assetMetaData3);
		assetGrpMetaData.add(assetMetaData);
		assetGrpMetaData.add(assetMData);
		response.setAssetGrpMetaData(assetGrpMetaData);
		
		
		ArrayList<AssetGrpMajorAssets> assetGrpMajorAssets = new ArrayList<AssetGrpMajorAssets>();
		
		for(Object[] objOfHighlevelData : highLevelDataObj) {
			AssetGrpMajorAssets assetGrpMajor = new AssetGrpMajorAssets();
			
			assetGrpMajor.setHeading((objOfHighlevelData[7]==null)?null:objOfHighlevelData[7]);
			assetGrpMajor.setAssetid((objOfHighlevelData[1]==null)?null:objOfHighlevelData[1]);
			assetGrpMajor.setAssetName((objOfHighlevelData[1]==null)?null:objOfHighlevelData[1]);
			assetGrpMajor.setAssetType(SecurityConstants.FRAC);
			
			AssetMetaData assetMetaData2 = new AssetMetaData();
			AssetMetaData3 assetMetaData32 = new AssetMetaData3();
			
			assetMetaData2.setName(SecurityConstants.RUL);
			assetMetaData2.setDisplayName(SecurityConstants.HOURS);
			assetMetaData2.setValue((objOfHighlevelData[4]==null)?null:objOfHighlevelData[4]);
			
			assetMetaData32.setName(SecurityConstants.SMH);
			assetMetaData32.setDisplayName(SecurityConstants.HEALTH);
			assetMetaData32.setValue((objOfHighlevelData[3]==null)?null:objOfHighlevelData[3]);
			assetMetaData32.setUnits(SecurityConstants.PERCENTAGE);
			
			AssetMetaData4 assetMetaData4 = new AssetMetaData4();
			
			assetMetaData4.setName(SecurityConstants.ROD);
			assetMetaData4.setDisplayName(SecurityConstants.ROD);
			assetMetaData4.setValue((objOfHighlevelData[5]==null)?null:objOfHighlevelData[5]);
			assetMetaData4.setUnits(SecurityConstants.PERCENTAGE);
			assetMetaData4.setTrend((objOfHighlevelData[6]==null)?null:(BigDecimal)objOfHighlevelData[6]);
			
			ArrayList<AssetMetaData> arrayList = new ArrayList<AssetMetaData>();
			arrayList.add(assetMetaData2);
			arrayList.add(assetMetaData32);
			arrayList.add(assetMetaData4);
			
			assetGrpMajor.setMetaData(arrayList);
			assetGrpMajorAssets.add(assetGrpMajor);
		}
		
		
		AssetGrpMajorAssets assetGrpMajor = new AssetGrpMajorAssets();
		
		assetGrpMajor.setHeading("Highest Runtime");
		assetGrpMajor.setAssetid("UL5P6BR7T7");
		assetGrpMajor.setAssetName("UL5P6BR7T7");
		assetGrpMajor.setAssetType("frac");
		
		AssetMetaData assetMetaData2 = new AssetMetaData();
		AssetMetaData3 assetMetaData32 = new AssetMetaData3();
		
		assetMetaData2.setName(SecurityConstants.RUL);
		assetMetaData2.setDisplayName(SecurityConstants.HOURS);
		assetMetaData2.setValue(146.20);
		
		assetMetaData32.setName(SecurityConstants.SMH);
		assetMetaData32.setDisplayName(SecurityConstants.HEALTH);
		assetMetaData32.setValue(23.165493770000);
		assetMetaData32.setUnits(SecurityConstants.PERCENTAGE);
		
		AssetMetaData4 assetMetaData4 = new AssetMetaData4();
		
		assetMetaData4.setName(SecurityConstants.ROD);
		assetMetaData4.setDisplayName(SecurityConstants.ROD);
		assetMetaData4.setValue(13.99);
		assetMetaData4.setUnits(SecurityConstants.PERCENTAGE);
		assetMetaData4.setTrend(-14.16);
		
		ArrayList<AssetMetaData> arrayList = new ArrayList<AssetMetaData>();
		arrayList.add(assetMetaData2);
		arrayList.add(assetMetaData32);
		arrayList.add(assetMetaData4);
		
		assetGrpMajor.setMetaData(arrayList);
		
		///////////////
		
AssetGrpMajorAssets assetGrpMajor2 = new AssetGrpMajorAssets();
		
assetGrpMajor2.setHeading("Least Health");
assetGrpMajor2.setAssetid("UL5P6BR7T7");
assetGrpMajor2.setAssetName("UL5P6BR7T7");
assetGrpMajor2.setAssetType("frac");
		
		AssetMetaData assetMetaData23 = new AssetMetaData();
		AssetMetaData3 assetMetaData323 = new AssetMetaData3();
		
		assetMetaData23.setName(SecurityConstants.RUL);
		assetMetaData23.setDisplayName(SecurityConstants.HOURS);
		assetMetaData23.setValue(146.20);
		
		assetMetaData323.setName(SecurityConstants.SMH);
		assetMetaData323.setDisplayName(SecurityConstants.HEALTH);
		assetMetaData323.setValue(23.165493770000);
		assetMetaData323.setUnits(SecurityConstants.PERCENTAGE);
		
		AssetMetaData4 assetMetaData44 = new AssetMetaData4();
		
		assetMetaData44.setName(SecurityConstants.ROD);
		assetMetaData44.setDisplayName(SecurityConstants.ROD);
		assetMetaData44.setValue(13.99);
		assetMetaData44.setUnits(SecurityConstants.PERCENTAGE);
		assetMetaData44.setTrend(-14.16);
		
		ArrayList<AssetMetaData> arrayList1 = new ArrayList<AssetMetaData>();
		arrayList1.add(assetMetaData23);
		arrayList1.add(assetMetaData323);
		arrayList1.add(assetMetaData44);
		
		//assetGrpMajor.setMetaData(arrayList);
		assetGrpMajor2.setMetaData(arrayList1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		assetGrpMajorAssets.add(assetGrpMajor);
		assetGrpMajorAssets.add(assetGrpMajor2);
		
		response.setAssetgrpMajorAssets(assetGrpMajorAssets);
		
		//response.setAssetGrpId((summaryDetailsObj[0]==null)?null:summaryDetailsObj[0]);
		//response.setAssetGrpId((summaryDetailsObj[0]==null)?null:summaryDetailsObj[0]);
		
		return response;
	}
	*/
	
	public Site convertToResponseGeographicData(Site object) {
		
		Site geographicalResponse = new Site();
		
		geographicalResponse.setSiteId(object.getSiteId());
		geographicalResponse.setSiteName(object.getSiteName());
		String stype=object.getSiteType().toLowerCase();
		geographicalResponse.setSiteType(stype);
		geographicalResponse.setAssetName(object.getSiteName());
		geographicalResponse.setLocation(object.getLocation());
		geographicalResponse.setCategory("Stable");
		Coordinates coordinates = new Coordinates();
		coordinates.setX(object.getLatitude());
		coordinates.setY(object.getLongitude());
		geographicalResponse.setCoordinates(coordinates);
		Map<String, AssetData> map = new HashMap<String, AssetData>();
		if(geographicalResponse.getSiteType().equalsIgnoreCase(SecurityConstants.FRAC)){
			
			AssetData assetData = new AssetData();
			//BigDecimal totalFracAssets =(BigDecimal)((BigDecimal)(Integer.valueOf(object.getCritical()))).add((BigDecimal)object.getStable()).add((BigDecimal)object.getGood());
			assetData.setTotalAssets(object.getNoOfAssetss());
			assetData.setGood(object.getGood());
			assetData.setStable(object.getStable());
			assetData.setCritical(object.getCritical());
			map.put(SecurityConstants.FRACPUMP,assetData);
		}
		else {
			
			AssetData assetData2 = new AssetData();
			//BigDecimal totalCatwalkAssets = ((BigDecimal)object[12]).add((BigDecimal)object[13]).add((BigDecimal)object[14]);
			
			assetData2.setTotalAssets(object.getNoOfAssetss());
			assetData2.setGood(object.getGood());
			assetData2.setStable(object.getStable());
			assetData2.setCritical(object.getCritical());
			map.put(SecurityConstants.CATWALK,assetData2);
		}
		List<Map<String, AssetData>> list = new ArrayList<Map<String, AssetData>>();
		list.add(map);
		geographicalResponse.setAssetsData(list);

		DataToShowOnHover assetMetaData1 = new DataToShowOnHover();
		assetMetaData1.setName(SecurityConstants.NO_OF_ASSETS);
		assetMetaData1.setDisplayName(SecurityConstants.N_O_ASSETS);
		assetMetaData1.setValue(Double.valueOf(object.getNoOfAssetss()));
		
		DataToShowOnHover assetMetaData2 = new DataToShowOnHover();
		assetMetaData2.setName(SecurityConstants.OPERATIONAL_DATE);
		assetMetaData2.setDisplayName(SecurityConstants.O_DATE);
		assetMetaData2.setValue(null);
		
		DataToShowOnHover assetMetaData3 = new DataToShowOnHover();
		assetMetaData3.setName(SecurityConstants.HEALTH);
		assetMetaData3.setDisplayName(SecurityConstants.HEALTH);
		assetMetaData3.setValue(object.getAvgHealthsite());
		
		DataToShowOnHover assetMetaData4 = new DataToShowOnHover();
		assetMetaData4.setName(SecurityConstants.ROD);
		assetMetaData4.setDisplayName(SecurityConstants.ROD);
		assetMetaData4.setValue(object.getAvgRodsite());
		
		DataToShowOnHover assetMetaData5 = new DataToShowOnHover();
		assetMetaData5.setName(SecurityConstants.RUL);
		assetMetaData5.setDisplayName(SecurityConstants.RUL);
		assetMetaData5.setValue(object.getAvgRulsite());
		
		ArrayList<DataToShowOnHover> arrayList = new ArrayList<DataToShowOnHover>();
		arrayList.add(assetMetaData1);
		arrayList.add(assetMetaData2);
		arrayList.add(assetMetaData3);
		arrayList.add(assetMetaData4);
		arrayList.add(assetMetaData5);
		
		geographicalResponse.setDataToShowOnHover(arrayList);
		return geographicalResponse;
	}
	
	
	
public AssetGroup ConvertToAsestGroupResponse(AssetGroup object) {
		
	AssetGroup assetGroupResponse = new AssetGroup();
		
		assetGroupResponse.setAssetGrpId(object.getAssetGrpId());
		assetGroupResponse.setAssetGrpName(object.getAssetGrpName());
		assetGroupResponse.setAssetGrpLocation(object.getAssetGrpLocation());
		String stype=object.getAssetGrpType();
		assetGroupResponse.setAssetGrpType(stype.toLowerCase());
		assetGroupResponse.setCategory("stable");
		
		assetGroupResponse.setOperationalDate(null);
		assetGroupResponse.setHealthPercentage(object.getHealthPercentage());
		
		AssetGroup assetGroup = new AssetGroup();
		AssetGroup assetGroup2 = new AssetGroup();
		AssetGroup assetGroup3 = new AssetGroup();
		
		assetGroup.setName(SecurityConstants.FRACPUMP);
		assetGroup.setValue(object.getFracCount());
		assetGroup.setDisplayName(SecurityConstants.FRAC_PUMPS);
		
		assetGroup2.setName(SecurityConstants.CATWALK);
		assetGroup2.setValue(object.getCatwalkCount());
		assetGroup2.setDisplayName(SecurityConstants.CATWALK_);
		
		assetGroup3.setName(SecurityConstants.ROUGH_NECK);
		assetGroup3.setValue(null);
		assetGroup3.setDisplayName(SecurityConstants.I_R_NECK);
		
		ArrayList<AssetGroup> arrayList = new ArrayList<AssetGroup>();
		arrayList.add(assetGroup);
		arrayList.add(assetGroup2);
		arrayList.add(assetGroup3);
		
		assetGroupResponse.setAssets(arrayList);
		
		return assetGroupResponse;
	}
	
public AssetsResponse ConvertToAsestGroupResponse(Assets object) {
	
	AssetsResponse assetResponse= new AssetsResponse();
	
	assetResponse.setAssetId(object.getAssetId());
	assetResponse.setAssetName(object.getAssetName());
	String stype=object.getAssetType();
	assetResponse.setAssetType(stype.toLowerCase());
	assetResponse.setCategory(object.getCategory());
	assetResponse.setSiteId(object.getAssetId());
    assetResponse.setSiteName(object.getSiteName());
    assetResponse.setRul(BigDecimal.valueOf(object.getRul()));
    assetResponse.setRod(BigDecimal.valueOf(object.getRod()));
    assetResponse.setSmh(BigDecimal.valueOf(object.getSmh()));
    assetResponse.setExpectedLife(object.getExpectedLife());
    assetResponse.setLatitude(null);
    assetResponse.setHealthPercentage(BigDecimal.valueOf(object.getHealthPercentage()));
   
    AssetMetaData assetMetaData=new AssetMetaData();
    assetMetaData.setName("RUL");
    String assetType=(String)assetResponse.getAssetType();

	if (assetType.equalsIgnoreCase(SecurityConstants.IRONROUGHNECK))
		assetMetaData.setDisplayName(SecurityConstants.DISPLAYNAME);
	else if (assetType.equalsIgnoreCase(SecurityConstants.CATWALK))
		assetMetaData.setDisplayName(SecurityConstants.DISPLAYNAME);
	else
		assetMetaData.setDisplayName(SecurityConstants.DISPLAYNAME_FRACPUMP);

	assetMetaData.setValue(assetResponse.getRul());
	
	AssetMetaData4 assetMetaData2 = new AssetMetaData4();
	assetMetaData2.setName(SecurityConstants.ROD);
	assetMetaData2.setDisplayName(SecurityConstants.DETERIORATION);
	assetMetaData2.setValue(BigDecimal.valueOf(object.getRod()));

	BigDecimal rodValue = BigDecimal.valueOf(object.getRod());
	if (rodValue.compareTo(BigDecimal.ZERO) > 0)
		assetMetaData2.setTrend(SecurityConstants.INCREASE);
	else
		assetMetaData2.setTrend(SecurityConstants.DECREASE);

	// assetMetaData2.setTrend((object[15] == null) ? null : (BigDecimal)
	// object[15]);
	/* assetMetaData2.setShowChange(true); */
	assetMetaData2.setUnits(SecurityConstants.PERCENTAGE);

	ArrayList<AssetMetaData> arrayList = new ArrayList<AssetMetaData>();
	arrayList.add(assetMetaData);
	arrayList.add(assetMetaData2);

	assetResponse.setAssetMetaData(arrayList);

	GraphDatum graphData = new GraphDatum();
	GraphDatum graphData2 = new GraphDatum();
	GraphDatum graphData3 = new GraphDatum();

	graphData.setxAxis((BigDecimal)new BigDecimal(0));
	graphData.setxAxisDate(object.getPurchaseDate());
	graphData.setyAxis(new BigDecimal(100));

	graphData2.setxAxis(new BigDecimal(0));
	graphData2.setxAxisDate(object.getEolDate());
	graphData2.setyAxis(assetResponse.getHealthPercentage());

	BigDecimal xAxis = (assetResponse.getRul()).add(assetResponse.getSmh());
	graphData3.setxAxis((object.getSmh()== null && object.getRul() == null) ? null : xAxis);
	graphData3.setxAxisDate(object.getEolDate());
	graphData3.setyAxis(new BigDecimal(0));

	ArrayList<GraphDatum> graphArray = new ArrayList<GraphDatum>();
	graphArray.add(graphData);
	graphArray.add(graphData2);
	graphArray.add(graphData3);

	ProgressGraph progressGraph = new ProgressGraph();

	progressGraph.setGraphData(graphArray);
	progressGraph.setXAxisToday(object.getLogDateTime());
	progressGraph.setYAxisToday(assetResponse.getHealthPercentage());

	assetResponse.setProgressGraph(progressGraph);
    
    
	return assetResponse;
}
	

public AssetGrpDetailsForFracTypeResponse convertAssetGrpFracSiteToData(Site summaryDetailsObj,List<Site> highLevelDataObj,Site sitelits)
{
	
	AssetGrpDetailsForFracTypeResponse response = new AssetGrpDetailsForFracTypeResponse();
	response.setAssetGrpId(sitelits.getId());
	response.setAssetGrpName(sitelits.getSiteName());
	String sitetypes=sitelits.getSiteType();
	response.setAssetGrpType(sitetypes.toLowerCase());
	HealthData healthData = new HealthData();
	healthData.setHealthPercentage(10.595000);
	healthData.setSiteAvgHealth(46.6539076116763333);
	response.setHealthData(healthData);
	
	Map<String, AssetData> map = new HashMap<String, AssetData>();
	AssetData assetData = new AssetData();
	//assetData.setTotalAssets(summaryDetailsObj[1]==null?null:summaryDetailsObj[1]);
	//summaryDetailsObj.getNoOfAssetss()==null?null:summaryDetailsObj.getNoOfAssetss()
	assetData.setTotalAssets(summaryDetailsObj.getNoOfAssetss());
	//System.out.println(summaryDetailsObj.getNoOfAssetss());
	//assetData.setGood(summaryDetailsObj[7]==null?null:summaryDetailsObj[7]);
	assetData.setGood(summaryDetailsObj.getGood());
	//assetData.setStable(summaryDetailsObj[6]==null?null:summaryDetailsObj[6]);
	assetData.setStable(summaryDetailsObj.getStable());
	//assetData.setCritical(summaryDetailsObj[5]==null?null:summaryDetailsObj[5]);
	assetData.setCritical(summaryDetailsObj.getCritical());
	map.put("frackpumps",assetData);
	
	List<Map<String, AssetData>> list = new ArrayList<Map<String, AssetData>>();
	list.add(map);
	response.setAssetsData(list);
	
	AssetMetaData3 assetMetaData3 = new AssetMetaData3();
	AssetMetaData3 assetMData = new AssetMetaData3();
	AssetMetaData3 assetMetaData33 = new AssetMetaData3();
	
	assetMetaData33.setName(SecurityConstants.NO_OF_FRAC_PUMPS);
	assetMetaData33.setDisplayName(SecurityConstants.FRAC_PUMPS);
	//assetMetaData33.setValue((summaryDetailsObj[1]==null)?null:summaryDetailsObj[1]);
	assetMetaData33.setValue(summaryDetailsObj.getNoOfAssetss());
	AssetMetaData assetMetaData = new AssetMetaData();
	assetMetaData.setName(SecurityConstants.RUL);
	assetMetaData.setDisplayName(SecurityConstants.AVG_RUL);
	//assetMetaData.setValue((summaryDetailsObj[8]==null)?null:summaryDetailsObj[8]);
	assetMetaData.setValue(summaryDetailsObj.getAvgRulsite());
	assetMetaData3.setName(SecurityConstants.HOURS);
	assetMetaData3.setDisplayName(SecurityConstants.AVG_HOURS);
	//assetMetaData3.setValue((summaryDetailsObj[3]==null)?null:summaryDetailsObj[3]);
	assetMetaData3.setValue(summaryDetailsObj.getAvgHealthsite());
	//assetMetaData3.setUnits("");
	
	assetMData.setName(SecurityConstants.ROD);
	assetMData.setDisplayName(SecurityConstants.ROD);
	//assetMData.setValue((summaryDetailsObj[4]==null)?null:summaryDetailsObj[4]);
	//assetMData.setUnits("");
	assetMData.setValue(summaryDetailsObj.getAvgRodsite());
	
	
	ArrayList<AssetMetaData> assetGrpMetaData = new ArrayList<AssetMetaData>();
	
	assetGrpMetaData.add(assetMetaData3);
	assetGrpMetaData.add(assetMetaData);
	assetGrpMetaData.add(assetMData);
	response.setAssetGrpMetaData(assetGrpMetaData);
	
	
	
	ArrayList<AssetGrpMajorAssets> assetGrpMajorAssets = new ArrayList<AssetGrpMajorAssets>();
	
	for(Site objOfHighlevelData : highLevelDataObj) {
		AssetGrpMajorAssets assetGrpMajor = new AssetGrpMajorAssets();
		
		assetGrpMajor.setHeading(objOfHighlevelData.getCategory());//FeatureType
		assetGrpMajor.setAssetid(objOfHighlevelData.getSiteId());//appending assetid to site id
		assetGrpMajor.setAssetName("");
		assetGrpMajor.setAssetType(SecurityConstants.FRAC);
		
		AssetMetaData assetMetaData2 = new AssetMetaData();
		AssetMetaData3 assetMetaData32 = new AssetMetaData3();
		
		assetMetaData2.setName(SecurityConstants.RUL);
		assetMetaData2.setDisplayName(SecurityConstants.HOURS);
		assetMetaData2.setValue("Hours");
		
		assetMetaData32.setName(SecurityConstants.SMH);
		assetMetaData32.setDisplayName(SecurityConstants.HEALTH);
		assetMetaData32.setValue(objOfHighlevelData.getAvgHealthsite());
		assetMetaData32.setUnits(SecurityConstants.PERCENTAGE);
		
		AssetMetaData4 assetMetaData4 = new AssetMetaData4();
		
		assetMetaData4.setName(SecurityConstants.ROD);
		assetMetaData4.setDisplayName(SecurityConstants.ROD);
		assetMetaData4.setValue(objOfHighlevelData.getAvgRodsite());
		assetMetaData4.setUnits(SecurityConstants.PERCENTAGE);
		assetMetaData4.setTrend("Trend");
		
		ArrayList<AssetMetaData> arrayList = new ArrayList<AssetMetaData>();
		arrayList.add(assetMetaData2);
		arrayList.add(assetMetaData32);
		arrayList.add(assetMetaData4);
		
		assetGrpMajor.setMetaData(arrayList);
		assetGrpMajorAssets.add(assetGrpMajor);
	}
	response.setAssetgrpMajorAssets(assetGrpMajorAssets);
	return response;
}
public AssetGroupDetailsForRegTypeResponse convertAssetGrpRegTypeToData(Site object) {
	
	AssetGroupDetailsForRegTypeResponse response = new AssetGroupDetailsForRegTypeResponse();
	response.setAssetGrpId(object.getSiteId());
	response.setAssetGrpName(object.getSiteName());
	response.setAssetGrpType("frac");
	//response.setCategory((object[13]==null)?null:object[13]);
	response.setOperationalDate(object.getCategory());
	
	AssetsDataRigType assetsDataRigType = new AssetsDataRigType();
	
	assetsDataRigType.setAssetId(object.getId());
	assetsDataRigType.setAssetName(object.getAssetName());
	String stype=object.getSiteType();
	assetsDataRigType.setAssetType(stype.toLowerCase());
	assetsDataRigType.setCategory("Stable");
	
	/*BigDecimal rul = (object[14]==null)?null:(BigDecimal)object[14];
	BigDecimal durationHrs = (object[11]==null)?null:(BigDecimal)object[11];
	BigDecimal expectedLife =  rul.add(durationHrs);*/
	
	String assetType = (String) assetsDataRigType.getAssetType(); 
	
	if(assetType.equalsIgnoreCase(SecurityConstants.IRONROUGHNECK))
		assetsDataRigType.setExpectedLife(800);
	else if(assetType.equalsIgnoreCase(SecurityConstants.CATWALK))
		assetsDataRigType.setExpectedLife(250000);
	else
		assetsDataRigType.setExpectedLife(0);
		
	assetsDataRigType.setOperationalDate(object.getCategory());
	assetsDataRigType.setHealthPercentage(object.getAvgHealthsite());
	GraphDatum graphData = new GraphDatum();
	GraphDatum graphData2 = new GraphDatum();
	GraphDatum graphData3 = new GraphDatum();
	
	graphData.setxAxis(new BigDecimal(0));
	graphData.setxAxisDate(object.getCategory());
	graphData.setyAxis(new BigDecimal(100));
	
	graphData2.setxAxis(BigDecimal.valueOf(object.getLongitude()));
	graphData2.setxAxisDate(object.getAvgHealthsite());
	graphData2.setyAxis(BigDecimal.valueOf(object.getLatitude()));
	
	BigDecimal rul =BigDecimal.valueOf(object.getAvgRulsite());
	BigDecimal durationHrs = BigDecimal.valueOf(object.getLongitude());
	BigDecimal xAxis =  rul.add(durationHrs);
	
	graphData3.setxAxis(BigDecimal.valueOf(object.getLatitude()));
	graphData3.setxAxisDate(object.getSiteLocation());
	graphData3.setyAxis(new BigDecimal(0.0));
	
	ArrayList<GraphDatum> graphArray = new ArrayList<GraphDatum>();
	graphArray.add(graphData);
	graphArray.add(graphData2);
	graphArray.add(graphData3);
	
	ProgressGraph progressGraph = new ProgressGraph();
	
	progressGraph.setGraphData(graphArray);
	progressGraph.setXAxisToday(59);
	progressGraph.setYAxisToday(BigDecimal.valueOf(object.getAvgHealthsite()));
	
	assetsDataRigType.setProgressGraph(progressGraph);
	
	AssetMetaData assetMetaData2 = new AssetMetaData();
	
	assetMetaData2.setName(SecurityConstants.RUL);
	
	if(assetType.equalsIgnoreCase(SecurityConstants.IRONROUGHNECK))
		assetMetaData2.setDisplayName(SecurityConstants.CYCLE_);
	else if(assetType.equalsIgnoreCase(SecurityConstants.CATWALK))
		assetMetaData2.setDisplayName(SecurityConstants.CYCLE_);
	else
		assetMetaData2.setDisplayName(SecurityConstants.HOURS);
	
	assetMetaData2.setValue(object.getLongitude());
	
	AssetMetaData4 assetMetaData4 = new AssetMetaData4();
	
	assetMetaData4.setName(SecurityConstants.ROD);
	assetMetaData4.setDisplayName(SecurityConstants.ROD);
	assetMetaData4.setValue(object.getAvgRulsite());
	assetMetaData4.setUnits(SecurityConstants.PERCENTAGE);
	
	BigDecimal rodValue = (BigDecimal.valueOf(object.getAvgRodsite())); //rod_change_prev_day
	if(rodValue.compareTo(BigDecimal.ZERO) >0)
		assetMetaData4.setTrend(SecurityConstants.INCREASE);
	else
		assetMetaData4.setTrend(SecurityConstants.DECREASE);
	
	
	ArrayList<AssetMetaData> arrayList3 = new ArrayList<AssetMetaData>();
	arrayList3.add(assetMetaData2);
	arrayList3.add(assetMetaData4);
	assetsDataRigType.setMetaData(arrayList3);
	
	ArrayList<AssetsDataRigType> arrayList = new ArrayList<AssetsDataRigType>();
	arrayList.add(assetsDataRigType);
	
	response.setAssetsData(arrayList);
	
	return response;
	
}



public AssetDetailsFracTypeResponse ConvertToAssetFracResponseJSON(AssetJdbcEx obj,String stype)
{
	
	AssetDetailsFracTypeResponse assetDetailsFracTypeResponse = new AssetDetailsFracTypeResponse();
	
	AssetMetaData3 assetMetaData3 = new AssetMetaData3();
	AssetMetaData3 assetMetaData = new AssetMetaData3();
	AssetMetaData3 assetMetaData32 = new AssetMetaData3();
	AssetMetaData4 assetMetadata2 = new AssetMetaData4();
	AssetMetaData3 assetMetaData4 = new AssetMetaData3();
	AssetMetaData3 assetMetaData5 = new AssetMetaData3();
	AssetMetaData3 assetMetaData6 = new AssetMetaData3();
	AssetMetaData3 assetMetaData7 = new AssetMetaData3();
	AssetMetaData3 assetMetaData8 = new AssetMetaData3();
	AssetMetaData3 assetMetaData9 = new AssetMetaData3();
	AssetMetaData3 assetMetaData10 = new AssetMetaData3();
	AssetMetaData3 assetMetaData11 = new AssetMetaData3();
	
	RULLife rulLife = new RULLife();
	ArrayList<AssetMetaData> arrayList = new ArrayList<AssetMetaData>();
	if (stype.equalsIgnoreCase(SecurityConstants.FRACPUMP)) {
		assetDetailsFracTypeResponse.setAssetId(obj.getAssetid());
		assetDetailsFracTypeResponse.setAssetName(obj.getAssetName());
		String sstype=obj.getAssettype();
		assetDetailsFracTypeResponse.setAssetType(sstype.toLowerCase());
		assetDetailsFracTypeResponse.setSiteId(obj.getSiteId());
		assetDetailsFracTypeResponse.setSiteName(obj.getSiteName());
		String ssstype=obj.getSiteType();
		assetDetailsFracTypeResponse.setSiteType(ssstype.toLowerCase());
		assetDetailsFracTypeResponse.setSiteLocation(obj.getLocation());
		
		assetMetaData3.setName(SecurityConstants.HEALTHPERCENTAGE);
		assetMetaData3.setDisplayName(SecurityConstants.HEALTH);
		assetMetaData3.setValue(obj.getHealth());
		assetMetaData3.setUnits(SecurityConstants.PERCENTAGE_);
		
		assetMetaData.setName(SecurityConstants.SMH);
		assetMetaData.setDisplayName(SecurityConstants.HOURS_TILL_TODAY);
		assetMetaData.setValue(obj.getDurationshours());

		assetMetaData32.setName(SecurityConstants.USAGE_HOURS);
		assetMetaData32.setDisplayName("Hours (Day)");
		assetMetaData32.setValue(obj.getRuntimeperdayhrs());
		/* assetMetaData32.setUnits("Hours"); */

		assetMetadata2.setName(SecurityConstants.ROD);
		assetMetadata2.setDisplayName(SecurityConstants.ROD);
		assetMetadata2.setValue(obj.getRopperday());
		assetMetadata2.setUnits(SecurityConstants.PERCENTAGE_);
		BigDecimal rodValue =BigDecimal.valueOf(obj.getRopperday());
		if (rodValue.compareTo(BigDecimal.ZERO) > 0)
			assetMetadata2.setTrend(SecurityConstants.INCREASE);
		else
			assetMetadata2.setTrend(SecurityConstants.DECREASE);

		assetMetaData4.setName(SecurityConstants.TOTAL_TIME_CAVITATION);
		assetMetaData4.setDisplayName(SecurityConstants.TT_CAVITATION);
		Random rand = new Random();
		int n = rand.nextInt(2) + 1;
		BigDecimal value = BigDecimal.valueOf(obj.getTotalcaviationtime());
		assetMetaData4.setValue(value.multiply((BigDecimal.valueOf(n))));

		assetMetaData5.setName(SecurityConstants.CAVIATION_EVENTS);
		assetMetaData5.setDisplayName(SecurityConstants.C_EVENTS);
		assetMetaData5.setValue(obj.getTotalcaviationcount());

		assetMetaData6.setName(SecurityConstants.TOTAL_EVENTS);
		assetMetaData6.setDisplayName(SecurityConstants.T_EVENTS);
		BigDecimal totalEvents =BigDecimal.valueOf(obj.getTotaleventscount());
		assetMetaData6.setValue(totalEvents);

		assetMetaData7.setName(SecurityConstants.MTBF);
		assetMetaData7.setDisplayName(SecurityConstants.MTBF);
		assetMetaData7.setValue(obj.getTotalmtbamins());
		assetMetaData7.setUnits(SecurityConstants.MINUTES);
		
		arrayList.add(assetMetaData3);
		arrayList.add(assetMetaData);
		arrayList.add(assetMetaData32);
		arrayList.add(assetMetadata2);
		arrayList.add(assetMetaData4);
		arrayList.add(assetMetaData5);
		arrayList.add(assetMetaData6);
		arrayList.add(assetMetaData7);
		
		rulLife.setName(SecurityConstants.OUR_PROJECTION);
		rulLife.setDisplayName(SecurityConstants.PROJECTION_RUL);
		/*rulLife.setLife((object[13] == null) ? null : object[13]);*/
		rulLife.setRUL(obj.getProjectionrul());
		rulLife.setUnits(SecurityConstants.HOURS);
	}
	assetDetailsFracTypeResponse.setAssetHealthData(arrayList);

	ArrayList<RULLife> arrayList2 = new ArrayList<RULLife>();
	arrayList2.add(rulLife);

	assetDetailsFracTypeResponse.setAssetMetaData(arrayList2);

	OptimalValues optimalValues = new OptimalValues();

	optimalValues.setGraphDisplayName(SecurityConstants.DETERIORATION_TREND);
	if(stype.equalsIgnoreCase(SecurityConstants.FRACPUMP)) {
		optimalValues.setxLabel(SecurityConstants.HOURS);
	}else if(stype.equalsIgnoreCase(SecurityConstants.CATWALK)) {
		optimalValues.setxLabel(SecurityConstants.CYCLE_);
	}else {
		optimalValues.setxLabel(SecurityConstants.CYCLE_);
	}
	optimalValues.setyLabel(SecurityConstants.DETERIORATION_RATE);
	
	if(stype.equalsIgnoreCase(SecurityConstants.FRACPUMP)) {
		optimalValues.setxAxisToday(obj.getHealth());
		optimalValues.setyAxisToday((obj.getProjectionrul()));
		optimalValues.setMinOptimalValue(1);
		optimalValues.setMaxOptimalValue(2);
		
	}
	
	List<GraphDatum> list = new ArrayList<GraphDatum>();
	
		GraphDatum graphData = new GraphDatum();
		graphData.setxAxis(BigDecimal.valueOf(obj.getDurationshours()));
		graphData.setxAxisDate(obj.getLogdatetime());
		graphData.setyAxis(BigDecimal.valueOf(obj.getRopperday()));

		list.add(graphData);
		optimalValues.setHealthGraph(list);
	

	assetDetailsFracTypeResponse.setDeteriorationGraphs(optimalValues);

	return assetDetailsFracTypeResponse;
}
	
	
public AssetDetailsFracTypeResponse ConvertToAssetCatwalkResponseJSON(AssetDetailsCatWalk obj,String stype)
{
	
	AssetDetailsFracTypeResponse assetDetailsFracTypeResponse = new AssetDetailsFracTypeResponse();
	
	AssetMetaData3 assetMetaData3 = new AssetMetaData3();
	AssetMetaData3 assetMetaData = new AssetMetaData3();
	AssetMetaData3 assetMetaData32 = new AssetMetaData3();
	AssetMetaData4 assetMetadata2 = new AssetMetaData4();
	AssetMetaData3 assetMetaData4 = new AssetMetaData3();
	AssetMetaData3 assetMetaData5 = new AssetMetaData3();
	AssetMetaData3 assetMetaData6 = new AssetMetaData3();
	AssetMetaData3 assetMetaData7 = new AssetMetaData3();
	AssetMetaData3 assetMetaData8 = new AssetMetaData3();
	AssetMetaData3 assetMetaData9 = new AssetMetaData3();
	AssetMetaData3 assetMetaData10 = new AssetMetaData3();
	AssetMetaData3 assetMetaData11 = new AssetMetaData3();

	
	RULLife rulLife = new RULLife();

	ArrayList<AssetMetaData> arrayList = new ArrayList<AssetMetaData>();
	if(stype.equalsIgnoreCase(SecurityConstants.CATWALK)) {
	assetDetailsFracTypeResponse.setAssetId(obj.getAssetId());
	assetDetailsFracTypeResponse.setAssetName("");
	assetDetailsFracTypeResponse.setAssetType("catwalk");
	assetDetailsFracTypeResponse.setSiteId("");
	assetDetailsFracTypeResponse.setSiteName("");
	assetDetailsFracTypeResponse.setSiteType("rig");
	assetDetailsFracTypeResponse.setSiteLocation("");
	
	assetMetaData3.setName(SecurityConstants.HEALTHPERCENTAGE);
	assetMetaData3.setDisplayName(SecurityConstants.HEALTH);
	assetMetaData3.setValue(obj.getHealth());
	assetMetaData3.setUnits(SecurityConstants.PERCENTAGE_);
	
	assetMetaData.setName(SecurityConstants.CYCLE_);
	assetMetaData.setDisplayName(SecurityConstants.CYCLES_TILL_TODAY);
	assetMetaData.setValue(obj.getCycles_Till_Today());

	assetMetadata2.setName(SecurityConstants.ROD);
	assetMetadata2.setDisplayName(SecurityConstants.ROD);
	assetMetadata2.setValue(obj.getRodpersec());
	assetMetadata2.setUnits(SecurityConstants.PERCENTAGE_);
	BigDecimal rodValue =BigDecimal.valueOf(obj.getRodpersec());
	if (rodValue.compareTo(BigDecimal.ZERO) > 0)
		assetMetadata2.setTrend(SecurityConstants.INCREASE);
	else
		assetMetadata2.setTrend(SecurityConstants.DECREASE);

	assetMetaData32.setName(SecurityConstants.AVG_CYCLE_TIME);
	assetMetaData32.setDisplayName(SecurityConstants.A_C_TIME);
	assetMetaData32.setValue(obj.getCyclesperday());
	assetMetaData32.setUnits(SecurityConstants.SECONDS);

	assetMetaData4.setName(SecurityConstants.CYCLES_PER_DAY);
	assetMetaData4.setDisplayName(SecurityConstants.C_P_DAY);
	assetMetaData4.setValue(obj.getCyclesperday());
	/* assetMetaData4.setUnits("mins"); */

	assetMetaData5.setName(SecurityConstants.OVERLOAD_EVENTS);
	assetMetaData5.setDisplayName(SecurityConstants.O_EVENTS);
	assetMetaData5.setValue(obj.getOverloadevenets());

	assetMetaData6.setName(SecurityConstants.ABSUSE_EVENTS);
	assetMetaData6.setDisplayName(SecurityConstants.AB_EVENTS);
	assetMetaData6.setValue(obj.getAbuseEvents());
	/*assetMetaData5.setUnits("cycles");*/

	assetMetaData7.setName(SecurityConstants.SKATE_TRAVEL);
	assetMetaData7.setDisplayName(SecurityConstants.SK_TRAVEL);
	assetMetaData7.setValue("");
	assetMetaData7.setUnits(SecurityConstants.FT);

	assetMetaData8.setName(SecurityConstants.MTBF);
	assetMetaData8.setDisplayName(SecurityConstants.MTBF);
	assetMetaData8.setValue(obj.getMtbamins());
	assetMetaData8.setUnits(SecurityConstants.CYCLES);
	
	assetMetaData9.setName(SecurityConstants.KICERCYCLE);
	assetMetaData9.setDisplayName(SecurityConstants.K_CYCLE);
	assetMetaData9.setValue("");
	/*assetMetaData7.setUnits("mins");*/
	
	assetMetaData10.setName(SecurityConstants.INDECX_CYCLES);
	assetMetaData10.setDisplayName(SecurityConstants.I_CYCLES);
	assetMetaData10.setValue(" ");
	/*assetMetaData7.setUnits("mins");*/
	
	assetMetaData11.setName(SecurityConstants.MODEL_CONFIDENCE);
	assetMetaData11.setDisplayName(SecurityConstants.M_CONFIDENCE);
	assetMetaData11.setValue(obj.getModelconfidence());
	assetMetaData11.setUnits(SecurityConstants.PERCENTAGE_);

	arrayList.add(assetMetaData3);
	arrayList.add(assetMetaData);
	arrayList.add(assetMetadata2);
	arrayList.add(assetMetaData32);
	arrayList.add(assetMetaData4);
	arrayList.add(assetMetaData5);
	arrayList.add(assetMetaData6);
	arrayList.add(assetMetaData7);
	arrayList.add(assetMetaData8);
	arrayList.add(assetMetaData9);
	arrayList.add(assetMetaData10);
	arrayList.add(assetMetaData11);
	
	rulLife.setName(SecurityConstants.OUR_PROJECTION);
	rulLife.setDisplayName(SecurityConstants.PROJECTION_RUL);
	/*rulLife.setLife((object[13] == null) ? null : object[13]);*/
	rulLife.setRUL(obj.getProjectionrul());
	rulLife.setUnits(SecurityConstants.CYCLE_);
	
}

assetDetailsFracTypeResponse.setAssetHealthData(arrayList);

ArrayList<RULLife> arrayList2 = new ArrayList<RULLife>();
arrayList2.add(rulLife);

assetDetailsFracTypeResponse.setAssetMetaData(arrayList2);

OptimalValues optimalValues = new OptimalValues();

optimalValues.setGraphDisplayName(SecurityConstants.DETERIORATION_TREND);
if(stype.equalsIgnoreCase(SecurityConstants.FRACPUMP)) {
	optimalValues.setxLabel(SecurityConstants.HOURS);
}else if(stype.equalsIgnoreCase(SecurityConstants.CATWALK)) {
	optimalValues.setxLabel(SecurityConstants.CYCLE_);
}else {
	optimalValues.setxLabel(SecurityConstants.CYCLE_);
}
optimalValues.setyLabel(SecurityConstants.DETERIORATION_RATE);


	optimalValues.setxAxisToday(obj.getHealth());
	optimalValues.setyAxisToday(obj.getRodpersec());
	optimalValues.setMinOptimalValue(0.5);
	optimalValues.setMaxOptimalValue(1);


List<GraphDatum> list = new ArrayList<GraphDatum>();

	GraphDatum graphData = new GraphDatum();
	graphData.setxAxis(new BigDecimal(10));
	graphData.setxAxisDate(obj.getHealth());
	graphData.setyAxis(BigDecimal.valueOf(obj.getRodpersec()));

	list.add(graphData);
	optimalValues.setHealthGraph(list);


assetDetailsFracTypeResponse.setDeteriorationGraphs(optimalValues);

return assetDetailsFracTypeResponse;
}

public HealthGraph convertHealthGraphDatatoJSON(List<Site> simHealthData, List<Site> healthData,
		String assetType) throws ParseException {
			
	HealthGraph healthGraph = new HealthGraph();

	if (assetType.equalsIgnoreCase(SecurityConstants.FRACPUMP)) {
		healthGraph.setGraphDisplayName(SecurityConstants.FLUID_END);
		healthGraph.setxLabel(SecurityConstants.HOURS);
	} else if (assetType.equalsIgnoreCase(SecurityConstants.IRONROUGHNECK)) {
		healthGraph.setGraphDisplayName(SecurityConstants.OVERALL);
		healthGraph.setxLabel(SecurityConstants.CYCLE_);
	} else {
		healthGraph.setGraphDisplayName(SecurityConstants.OVERALL);
		healthGraph.setxLabel(SecurityConstants.CYCLE_);
	}

	healthGraph.setyLabel(SecurityConstants.HEALTH);

	Site objects = simHealthData.get(simHealthData.size() - 1);
	healthGraph.setxMax(objects.getAvgRodsite());
	healthGraph.setxNumIntrevals(100);
	healthGraph.setyMax(1);
	healthGraph.setyNumIntrevals(0.1);

	Site health = healthData.get(healthData.size() - 1);
	SimpleDateFormat dateFormathealth = new SimpleDateFormat("dd-MM-yyyy hh:mm");
	Date parsedDatehealth = dateFormathealth. parse(health.getSiteName());
	Timestamp timestamphealth = new Timestamp(parsedDatehealth.getTime());
	healthGraph.setxAxisToday(timestamphealth.getTime());
	healthGraph.setyAxisToday(health.getAvgRodsite());

	ArrayList<GraphDatum> arrayList = new ArrayList<GraphDatum>();

	for (Site objOfsimHealthData : simHealthData) {
		HealthGraphData healthData2 = new HealthGraphData();

		healthData2.setxAxis(BigDecimal.valueOf(objOfsimHealthData.getLatitude()));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		Date parsedDate = dateFormat. parse(objOfsimHealthData.getSiteName());
		Timestamp timestamp = new Timestamp(parsedDate.getTime());
		
		healthData2.setxAxisDate(timestamp.getTime());
		healthData2.setyAxis(BigDecimal.valueOf(objOfsimHealthData.getAvgRulsite()));
		healthData2.setyAxisMin(objOfsimHealthData.getAvgHealthsite());
		healthData2.setyAxisMax(objOfsimHealthData.getAvgRodsite());

		arrayList.add(healthData2);
		healthGraph.setHealthGraph(arrayList);
	}

	ArrayList<GraphDatum> arrayList2 = new ArrayList<GraphDatum>();

	for (Site objOfHealthData : healthData) {
		GraphDatum healthData2 = new GraphDatum();

		healthData2.setxAxis(BigDecimal.valueOf(objOfHealthData.getAvgHealthsite()));
		healthData2.setxAxisDate(objOfHealthData.getSiteName());
		healthData2.setyAxis(BigDecimal.valueOf(objOfHealthData.getAvgRodsite()));

		arrayList2.add(healthData2);
		healthGraph.setTrendGraph(arrayList2);
	}

	healthGraph.setBinOrDate(SecurityConstants.DATE);

	return healthGraph;
	
	
}
public HealthGraph convertPowerEndDatatoJSON(List<Site> simHealthData, List<Site> healthData) throws ParseException {
	

	HealthGraph healthGraph = new HealthGraph();

	healthGraph.setGraphDisplayName(SecurityConstants.POWER_END);
	healthGraph.setxLabel(SecurityConstants.HOURS);
	healthGraph.setyLabel(SecurityConstants.HEALTH);

	Site objects = simHealthData.get(simHealthData.size() - 1);
	healthGraph.setxMax(objects.getAvgRodsite());
	healthGraph.setxNumIntrevals(100);
	healthGraph.setyMax(1);
	healthGraph.setyNumIntrevals(0.1);

	Site health = healthData.get(healthData.size() - 1);
	healthGraph.setxAxisToday(health.getSiteName());
	healthGraph.setyAxisToday(health.getAvgRodsite());

	ArrayList<GraphDatum> arrayList = new ArrayList<GraphDatum>();

	for (Site objOfsimHealthData : simHealthData) {
		HealthGraphData healthData2 = new HealthGraphData();

		healthData2.setxAxis(BigDecimal.valueOf(objOfsimHealthData.getLatitude()));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		Date parsedDate = dateFormat. parse(objOfsimHealthData.getSiteName());
		Timestamp timestamp = new Timestamp(parsedDate.getTime());
		healthData2.setxAxisDate(timestamp.getTime());
		healthData2.setyAxis(BigDecimal.valueOf(objOfsimHealthData.getAvgRulsite()));
		healthData2.setyAxisMin(objOfsimHealthData.getAvgHealthsite());
		healthData2.setyAxisMax(objOfsimHealthData.getAvgRodsite());

		arrayList.add(healthData2);
		healthGraph.setHealthGraph(arrayList);
	}

	ArrayList<GraphDatum> arrayList2 = new ArrayList<GraphDatum>();

	for (Site objOfHealthData : healthData) {
		GraphDatum healthData2 = new GraphDatum();

		healthData2.setxAxis(BigDecimal.valueOf(objOfHealthData.getAvgHealthsite()));

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		Date parsedDate = dateFormat. parse(objOfHealthData.getSiteName());
		Timestamp timestamp = new Timestamp(parsedDate.getTime());
		healthData2.setxAxisDate(timestamp.getTime());
		healthData2.setyAxis(BigDecimal.valueOf(objOfHealthData.getAvgRodsite()));

		arrayList2.add(healthData2);
		healthGraph.setTrendGraph(arrayList2);
	}

	healthGraph.setBinOrDate(SecurityConstants.DATE);

	return healthGraph;
}

public ArrayList<CategoryDetailsResponse> convertDataToResponseJson(LinkedHashMap<String, List<VariableGraph>> map, CategoryDetailsRequest categoryDetails, Map<String, List<Object[]>> assetAllocationData) throws CloneNotSupportedException {
	{
CategoryDetailsResponse categoryDetailsResponse = new CategoryDetailsResponse();
		
		categoryDetailsResponse.setUserId(categoryDetails.getUserId());
		categoryDetailsResponse.setSiteId(categoryDetails.getSiteId());
		categoryDetailsResponse.setAssetId(categoryDetails.getAssetId());
		
		categoryDetailsResponse.setxLabel(SecurityConstants.TIME);
		categoryDetailsResponse.setyLabel(SecurityConstants.VALUE);
		Set<String> keySet = map.keySet();
		ArrayList<CategoryDetailsResponse> arrayList = new ArrayList<CategoryDetailsResponse>();

		for(String param : keySet) {
			CategoryDetailsResponse clone = (CategoryDetailsResponse)categoryDetailsResponse.clone();
			clone.setVariableName(param);
			clone.setVariableGraph(map.get(param));
			List<Object[]> list = assetAllocationData.get(param);
			//Object[] objects = list.get(0);
			clone.setMinOptimal("");
			clone.setMaxOptimal("");
			clone.setMinRange("");
			clone.setMaxRange("");
			clone.setUnits("");
			arrayList.add(clone);
			
		}
		
		return arrayList;
		
	}
	
	
}

}
