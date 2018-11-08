/*package com.cyientinsights.forumenergyweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cyientinsights.forumenergyweb.model.Asset;
import com.cyientinsights.forumenergyweb.model.AssetData;
import com.cyientinsights.forumenergyweb.model.AssetGroup;
import com.cyientinsights.forumenergyweb.model.AssetGrpDetailsForFracTypeResponse;
import com.cyientinsights.forumenergyweb.model.AssetGrpMajorAssets;
import com.cyientinsights.forumenergyweb.model.AssetMetaData;
import com.cyientinsights.forumenergyweb.model.AssetMetaData3;
import com.cyientinsights.forumenergyweb.model.AssetMetaData4;
import com.cyientinsights.forumenergyweb.model.AssetMetaDatum;
import com.cyientinsights.forumenergyweb.model.Assets;
import com.cyientinsights.forumenergyweb.model.AssetsDatum;
import com.cyientinsights.forumenergyweb.model.Coordinates;
import com.cyientinsights.forumenergyweb.model.DataToShowOnHover;
import com.cyientinsights.forumenergyweb.model.Example;
import com.cyientinsights.forumenergyweb.model.Fracpump;
import com.cyientinsights.forumenergyweb.model.Fracpump_cidb_rul;
import com.cyientinsights.forumenergyweb.model.GraphDatum;
import com.cyientinsights.forumenergyweb.model.HealthData;
import com.cyientinsights.forumenergyweb.model.ProgressGraph;
import com.cyientinsights.forumenergyweb.model.Site;
import com.cyientinsights.forumenergyweb.model.User;
import com.cyientinsights.forumenergyweb.model.UserSite;

import com.cyientinsights.forumenergyweb.repository.AssetGroupsRepository;
import com.cyientinsights.forumenergyweb.service.AssetsGroupServiceImpl;
import com.cyientinsights.forumenergyweb.service.SecurityConstants;
//import com.cyientinsights.forumenergyweb.repository.AssetGroupsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RestController
@RequestMapping("/geo")
public class GeographicalController {

	
	 * @Autowired AssetGroupsRepository assetGroupRepository;
	 
	@Autowired
	AssetsGroupServiceImpl assetGroupService;
	
	@Autowired
	AssetGroupsRepository assetGroupRepository;

	

	@CrossOrigin
	@GetMapping("/geographicaldata")
	public Object responseProcessing(@RequestHeader(value = "Authorization") String data) throws Exception {

		HomeController homecontroller = new HomeController();
		String jsonObject = homecontroller.validateToken(data);

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> val = mapper.readValue(jsonObject, Map.class);

		Object validtoken = val.get("tokenValid");
		boolean vtoken = (boolean) validtoken;

		if (vtoken) {

			String userassetsJson = homecontroller.assetsProcessing(data);
			// new changes
			parseJson(userassetsJson);

			System.out.println(userassetsJson);
			Map<String, Object> userassets = mapper.readValue(userassetsJson, Map.class);

			List<Map> usersites = (List<Map>) userassets.get("userSites");
			System.out.println(usersites);

			List<Site> lsite = new ArrayList<Site>();

			for (int i = 0; i < usersites.size(); i++) {

				Map<String, Object> sitemap = usersites.get(i);

				System.out.println(sitemap);

				String siteid = (String) sitemap.get("siteId");
				System.out.println(siteid);
				Map<String, Object> sites = (Map<String, Object>) sitemap.get("site");
				System.out.println(sites);

				List<Map> assets = (List<Map>) sites.get("assets");
				System.out.println(assets.size());
				int nofassets = assets.size();

				System.out.println(nofassets);

				String sitename = (String) sites.get("siteName");
				String sitety = (String) sites.get("siteType");
				String sitetype = sitety.toLowerCase();
				String location = (String) sites.get("siteLocation");
				double longitude = (double) sites.get("longitude");
				System.out.println(longitude);
				double latitude = (double) sites.get("latitude");
				System.out.println(latitude);

				System.out.println(siteid);
				System.out.println(sitename);
				System.out.println(sitetype);
				System.out.println(location);

				Site st = new Site();
				st.setSiteId(siteid);
				st.setSiteName(sitename);

				st.setLocation(location);
				st.setCategory("Stable");
				st.setAssetName("Forum Frac Spread 1");

				Coordinates cordinates = new Coordinates();
				cordinates.setX(latitude);
				cordinates.setY(longitude);
				st.setCoordinates(cordinates);

				 if(sitety.equals("Frac")) { 
				st.setSiteType(sitetype);
				Fracpump fracpump = new Fracpump();
				fracpump.setTotalAssets(nofassets);
				fracpump.setCritical(4);
				fracpump.setGood(2);
				fracpump.setStable(4);
				AssetsDatum assetdata = new AssetsDatum();
				assetdata.setFracpump(fracpump);

				List<AssetsDatum> asd = new ArrayList<AssetsDatum>();
				asd.add(assetdata);

				st.setAssetsData(asd);

				DataToShowOnHover dtsh = new DataToShowOnHover();

				dtsh.setName("noofassets");
				dtsh.setDisplayName("noofassets");
				dtsh.setValue(6.00);

				DataToShowOnHover dtsh2 = new DataToShowOnHover();

				dtsh2.setName("noofassets");
				dtsh2.setDisplayName("noofassets");
				dtsh2.setValue(6.00);

				List<DataToShowOnHover> dtsh3 = new ArrayList<DataToShowOnHover>();
				dtsh3.add(dtsh);
				dtsh3.add(dtsh2);

				st.setDataToShowOnHover(dtsh3);
				
				 * }else if(sitety.equals("CatWalk")) { st.setSiteType(sitetype); CatWalk
				 * fracpump=new CatWalk(); fracpump.setTotalAssets(nofassets);
				 * fracpump.setCritical(4); fracpump.setGood(2); fracpump.setStable(4);
				 * AssetsDatum assetdata=new AssetsDatum(); assetdata.setCatwalk(fracpump);
				 * 
				 * List<AssetsDatum> asd=new ArrayList<AssetsDatum>(); asd.add(assetdata);
				 * 
				 * st.setAssetsData(asd);
				 * 
				 * DataToShowOnHover dtsh= new DataToShowOnHover();
				 * 
				 * dtsh.setName("noofassets"); dtsh.setDisplayName("noofassets");
				 * dtsh.setValue(6.00);
				 * 
				 * DataToShowOnHover dtsh2= new DataToShowOnHover();
				 * 
				 * dtsh2.setName("noofassets"); dtsh2.setDisplayName("noofassets");
				 * dtsh2.setValue(6.00);
				 * 
				 * 
				 * List<DataToShowOnHover> dtsh3=new ArrayList<DataToShowOnHover>();
				 * dtsh3.add(dtsh); dtsh3.add(dtsh2);
				 * 
				 * st.setDataToShowOnHover(dtsh3);
				 * 
				 * }
				 
				lsite.add(st);
			}
			// ------------------------------------------
			String json = mapper.writeValueAsString(lsite);
			// System.out.println(siteid);
			return new ResponseEntity<Object>(json, HttpStatus.OK);
		} else {

			return new ResponseEntity<Object>("InvaalidToken", HttpStatus.OK);
		}

	}

	private void parseJson(String userassetsJson) {

		Gson gson = new Gson();
		Example example = gson.fromJson(userassetsJson, Example.class);
		//String json = gson.toJson(example);
		List<UserSite> userSites = example.getUserSites();
		List<Site> rigsiteList = new ArrayList<>();
		List<Site> fracsiteList = new ArrayList<>();
		List<Site> siteList = new ArrayList<>();
		for (int i = 0; i < example.getUserSites().size(); i++) {
			Site sites = example.getUserSites().get(i).getSite();
			siteList.add(sites);

		}
		Map<String, List<Site>> result = siteList.stream().collect(Collectors.groupingBy(Site::getSiteType));

		Map<String, List<Site>> siteInfoMap = siteList.stream().collect(Collectors.groupingBy(Site::getSiteType, Collectors.toList()));

		for (Entry<String, List<Site>> ee : siteInfoMap.entrySet()) {
			String key = ee.getKey();
			if (key.contains("Rig")) {
				rigsiteList = ee.getValue();

			} else {
				fracsiteList = ee.getValue();
			}
		}
	}

	@CrossOrigin
	@GetMapping("/assetgroups")
	public ResponseEntity<Object> getAssetGroups(@RequestHeader(value = "Authorization") String data) throws Exception {

		HomeController homecontroller = new HomeController();
		String jsonObject = homecontroller.validateToken(data);

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> val = mapper.readValue(jsonObject, Map.class);

		Object validtoken = val.get("tokenValid");
		boolean vtoken = (boolean) validtoken;
		if (vtoken) {

			String userassetsJson = homecontroller.assetsProcessing(data);
			Map<String, Object> userassets = mapper.readValue(userassetsJson, Map.class);
			List<Map> usersites = (List<Map>) userassets.get("userSites");

			List<AssetGroup> lassetGroup = new ArrayList<AssetGroup>();
			int j = 3;
			for (int i = 0; i < j; i++) {
				Map<String, Object> sitemap = usersites.get(i);
				Map<String, Object> sites = (Map<String, Object>) sitemap.get("site");
				List<Map> assets = (List<Map>) sites.get("assets");

				
				 * int fraccount = 0; for(int i=0;i<assets.size();i++) { Map<String,Object>
				 * assetmap = assets.get(i); if(assetmap.get("product").equals("Frac Pump")) {
				 * fraccount++; } }
				  String Id = (String) sites.get("id");

				String location = (String) sites.get("siteLocation");
				String sitename = (String) sites.get("siteName");
				String sitety = (String) sites.get("siteType");
				String sitetype = sitety.toLowerCase();

				AssetGroup assetGroup = new AssetGroup();
				assetGroup.setAssetGrpId(Id);
				assetGroup.setAssetGrpLocation(location);
				assetGroup.setAssetGrpName(sitename);
				assetGroup.setAssetGrpType(sitetype);
				assetGroup.setCategory("Stable");
				assetGroup.setOperationalDate("2018-04-15T11:45:23.000+0000");
				assetGroup.setHealthPercentage(50.00);// At present category is static for now keep static 50

				Asset asset = new Asset();
				asset.setDisplayName("Frac Pumps");
				asset.setName("fracpump");
				asset.setValue(2);

				Asset asset2 = new Asset();
				asset2.setDisplayName("Catwalk");
				asset2.setName("catwalk");
				asset2.setValue(0);
				Asset asset3 = new Asset();
				asset3.setDisplayName("Iron Roughneck");
				asset3.setName("roughneck");
				asset3.setValue(0);
				List<Asset> lasset = new ArrayList<Asset>();
				lasset.add(asset);
				lasset.add(asset2);
				lasset.add(asset3);
				assetGroup.setAssets(lasset);
				lassetGroup.add(assetGroup);
			}

			String json = mapper.writeValueAsString(lassetGroup);

			return new ResponseEntity<Object>(json, HttpStatus.OK);
		} else {

			return new ResponseEntity<Object>("InvalidToken", HttpStatus.OK);
		}

	}

	@CrossOrigin
	@GetMapping("/assets")
	public ResponseEntity<Object> getAssets(@RequestHeader(value = "Authorization") String data) throws Exception {

		HomeController homecontroller = new HomeController();
		String jsonObject = homecontroller.validateToken(data);

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> val = mapper.readValue(jsonObject, Map.class);

		Object validtoken = val.get("tokenValid");
		boolean vtoken = (boolean) validtoken;
		if (vtoken) {

			String userassetsJson = homecontroller.assetsProcessing(data);
			Map<String, Object> userassets = mapper.readValue(userassetsJson, Map.class);
			List<Map> usersites = (List<Map>) userassets.get("userSites");

			Map<String, Object> sitemap = usersites.get(0);
			Map<String, Object> sites = (Map<String, Object>) sitemap.get("site");
			List<Map> assets = (List<Map>) sites.get("assets");

			List<Assets> lassets = new ArrayList<Assets>();
			Assets assetsindividual = new Assets();
			assetsindividual.setAssetId("dce00928-f60b-4159-bfc5-b9584b9bab6c");
			assetsindividual.setAssetName("Catwalk efg");
			assetsindividual.setAssetType("catwalk");
			assetsindividual.setSiteId("4b093302-3d76-434a-bbb4-c39e81cfa2e3");
			assetsindividual.setSiteName("Houston Site #2");
			assetsindividual.setCategory("Stable");
			assetsindividual.setSmh(256.89);
			assetsindividual.setRod(13.99);
			assetsindividual.setRul(146.20);
			assetsindividual.setExpectedLife(1000);
			assetsindividual.setPurchaseDate("2018-04-15T11:45:23.000+0000");
			assetsindividual.setLatitude(29.7);
			assetsindividual.setLogDateTime(15148007);
			assetsindividual.setHealthPercentage(23.165493770000);

			AssetMetaDatum amd = new AssetMetaDatum();
			amd.setName("RUL");
			amd.setDisplayName("RUL");
			amd.setValue(256.89);
			AssetMetaDatum amd2 = new AssetMetaDatum();
			amd2.setName("ROD");
			amd2.setDisplayName("Deterioration");
			amd2.setValue(13.99);
			amd2.setTrend("decrease");
			amd2.setUnits("percentage");

			List<AssetMetaDatum> lamd = new ArrayList<AssetMetaDatum>();

			lamd.add(amd);
			lamd.add(amd2);
			assetsindividual.setAssetMetaData(lamd);

			GraphDatum gd = new GraphDatum();
			gd.setXAxis(0.00);
			gd.setXAxisDate(152379272);
			gd.setYAxis(100);

			GraphDatum gd1 = new GraphDatum();
			gd1.setXAxis(0.00);
			gd1.setXAxisDate(1514800764);
			gd1.setYAxis(23);

			GraphDatum gd2 = new GraphDatum();
			gd2.setXAxis(403.09);
			gd2.setXAxisDate(1514800764);
			gd2.setYAxis(0);

			List<GraphDatum> lgd = new ArrayList<GraphDatum>();
			lgd.add(gd);
			lgd.add(gd1);
			lgd.add(gd2);

			ProgressGraph pg = new ProgressGraph();
			pg.setGraphData(lgd);
			pg.setXAxisToday(1514800764);
			pg.setYAxisToday(23.1654937);

			assetsindividual.setProgressGraph(pg);
			assetsindividual.setLongitude(-95.4);

			lassets.add(assetsindividual);
			// ---------------------------------

			Assets assetsindividual2 = new Assets();
			assetsindividual2.setAssetId("b8b213e6-ab3e-418b-972f-f39b6a00f022");
			assetsindividual2.setAssetName("Frac Pump 001 Power End");
			assetsindividual2.setAssetType("fracpump");
			assetsindividual2.setSiteId("6f9b3f4b-a58e-46b8-97c6-0976223cd3d3");
			assetsindividual2.setSiteName("Houston Site #1");
			assetsindividual2.setCategory("Stable");
			assetsindividual2.setSmh(144.47);
			assetsindividual2.setRod(1.96);
			assetsindividual2.setRul(362.98);
			assetsindividual2.setExpectedLife(1000);
			assetsindividual2.setPurchaseDate("2018-04-15T11:45:23.000+0000");
			assetsindividual2.setLatitude(29.7604);
			assetsindividual2.setLogDateTime(15148007);
			assetsindividual2.setHealthPercentage(59.482730924195);

			AssetMetaDatum amd3 = new AssetMetaDatum();
			amd3.setName("RUL");
			amd3.setDisplayName("RUL");
			amd3.setValue(362.98);
			AssetMetaDatum amd4 = new AssetMetaDatum();
			amd4.setName("ROD");
			amd4.setDisplayName("Deterioration");
			amd4.setValue(1.96);
			amd4.setTrend("increase");
			amd4.setUnits("percentage");

			List<AssetMetaDatum> lamd2 = new ArrayList<AssetMetaDatum>();

			lamd2.add(amd3);
			lamd2.add(amd4);
			assetsindividual2.setAssetMetaData(lamd2);

			GraphDatum gd3 = new GraphDatum();
			gd3.setXAxis(0.00);
			gd3.setXAxisDate(152379272);
			gd3.setYAxis(100);

			GraphDatum gd4 = new GraphDatum();
			gd4.setXAxis(0.00);
			gd4.setXAxisDate(1514800764);
			gd4.setYAxis(59);

			GraphDatum gd5 = new GraphDatum();
			gd5.setXAxis(403.09);
			gd5.setXAxisDate(1514800764);
			gd5.setYAxis(0);

			List<GraphDatum> lgd2 = new ArrayList<GraphDatum>();
			lgd2.add(gd3);
			lgd2.add(gd4);
			lgd2.add(gd5);

			ProgressGraph pg1 = new ProgressGraph();
			pg1.setGraphData(lgd2);
			pg1.setXAxisToday(15148007);
			pg1.setYAxisToday(23.1654937);

			assetsindividual2.setProgressGraph(pg);
			assetsindividual2.setLongitude(-95.3698);

			lassets.add(assetsindividual2);

			String json = mapper.writeValueAsString(lassets);

			return new ResponseEntity<Object>(json, HttpStatus.OK);

		} else {

			return new ResponseEntity<Object>("InvalidToken", HttpStatus.OK);

		}

	}

	@CrossOrigin
	@GetMapping("/assetGroup/{assetGroupId}")
	public ResponseEntity<Object> getAssetGrpDetailsByAssetGrpId(@PathVariable("assetGroupId") String assetGrpId,@RequestHeader(value = "Authorization") String data)
			throws Exception {
		

		
		
		HomeController homecontroller = new HomeController();
		
		String userassetsJson = homecontroller.assetsProcessing(data);
		
		Gson gson = new Gson();
		
		Example example = gson.fromJson(userassetsJson, Example.class);
		
		//String json = gson.toJson(example);
		
		List<UserSite> userSites = example.getUserSites();
		
		assetGrpId="6f9b3f4b-a58e-46b8-97c6-0976223cd3d3";
		
		Site siteListss = new Site();
		
		List<Site> siteList = new ArrayList<>();
		
		for(int i = 0; i < example.getUserSites().size(); i++) {
		
			Site sites = example.getUserSites().get(i).getSite();
			
			siteList.add(sites);

		}
		
		for (int i = 0; i < siteList.size(); i++) {
			
			if(assetGrpId.equals(siteList.get(i).getId())) {
				siteListss.setId(siteList.get(i).getId());
				siteListss.setSiteName(siteList.get(i).getSiteName());
				siteListss.setSiteType(siteList.get(i).getSiteType());
				siteListss.setAssets(siteList.get(i).getAssets());
		}
			
		}
		
		System.out.println(siteListss.getId());
		
		ArrayList<AssetGrpDetailsForFracTypeResponse> fracSiteResponse = new ArrayList<AssetGrpDetailsForFracTypeResponse>();
		
		if ((siteListss.getSiteType()).equalsIgnoreCase("frac")) {
			
			List<Object[]> summaryFracSite22=assetGroupRepository.getAssetClassTypeSummary();
			
			List<Object[]> highLowLevelFeatures22=assetGroupRepository.getListOfHighLowFeatures();
		
			if (summaryFracSite22 != null && highLowLevelFeatures22 != null &&
					 !summaryFracSite22.isEmpty() && !highLowLevelFeatures22.isEmpty()) {
				for(Object[] eachObj : summaryFracSite22) 
				{ AssetGrpDetailsForFracTypeResponse
					 results = assetGroupService .convertAssetGrpFracSiteToData(eachObj, highLowLevelFeatures22,siteListss); 
					 fracSiteResponse.add(results); 
					 }
		}
		}
		
		
		String sitetype = "frac";
		Object[] summaryFracSite = null;
		List<Object[]> highLowLevelFeatures = null;
		
		List<Object[]> summaryFracSite22=assetGroupRepository.getAssetClassTypeSummary();
		List<Object[]> highLowLevelFeatures22=assetGroupRepository.getListOfHighLowFeatures();

		ArrayList<AssetGrpDetailsForFracTypeResponse> fracSiteResponse = new ArrayList<AssetGrpDetailsForFracTypeResponse>();

		AssetGrpDetailsForFracTypeResponse results = assetGroupService.convertAssetGrpFracSiteToData(summaryFracSite,
				highLowLevelFeatures);

		////////////////////////
		AssetGrpDetailsForFracTypeResponse response = new AssetGrpDetailsForFracTypeResponse();

		response.setAssetGrpId("c204cd1a-a2cd-4836-8701-a3988015ccc8");

		response.setAssetGrpName("Florida Site #1");

		response.setAssetGrpType("frac");
		HealthData healthData = new HealthData();

		healthData.setHealthPercentage(10.595000);

		healthData.setSiteAvgHealth(46.6539076116763333);
		response.setHealthData(healthData);

		Map<String, AssetData> map = new HashMap<String, AssetData>();
		AssetData assetData = new AssetData();

		assetData.setTotalAssets(1);

		assetData.setGood(1);

		assetData.setStable(0);

		assetData.setCritical(0);
		map.put("frackpumps", assetData);

		List<Map<String, AssetData>> list = new ArrayList<Map<String, AssetData>>();
		list.add(map);
		response.setAssetsData(list);

		AssetMetaData3 assetMetaData3 = new AssetMetaData3();
		AssetMetaData3 assetMData = new AssetMetaData3();
		AssetMetaData3 assetMetaData33 = new AssetMetaData3();

		assetMetaData33.setName(SecurityConstants.NO_OF_FRAC_PUMPS);
		assetMetaData33.setDisplayName(SecurityConstants.FRAC_PUMPS);

		assetMetaData33.setValue(2);
		AssetMetaData assetMetaData = new AssetMetaData();
		assetMetaData.setName(SecurityConstants.RUL);
		assetMetaData.setDisplayName(SecurityConstants.AVG_RUL);

		assetMetaData.setValue(432.901667);
		assetMetaData3.setName(SecurityConstants.HOURS);
		assetMetaData3.setDisplayName(SecurityConstants.AVG_HOURS);

		assetMetaData3.setValue(141.633333);

		assetMData.setName(SecurityConstants.ROD);
		assetMData.setDisplayName(SecurityConstants.ROD);

		assetMData.setValue(10.595000);

		ArrayList<AssetMetaData> assetGrpMetaData = new ArrayList<AssetMetaData>();

		assetGrpMetaData.add(assetMetaData3);
		assetGrpMetaData.add(assetMetaData);
		assetGrpMetaData.add(assetMData);
		response.setAssetGrpMetaData(assetGrpMetaData);

		ArrayList<AssetGrpMajorAssets> assetGrpMajorAssets = new ArrayList<AssetGrpMajorAssets>();
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
		assetGrpMajorAssets.add(assetGrpMajor);

		response.setAssetgrpMajorAssets(assetGrpMajorAssets);

		fracSiteResponse.add(results);
		fracSiteResponse.add(response);

		
		 * if (sitetype.equalsIgnoreCase("frac")) {
		 * 
		 * List<Object[]> summaryFracSite =
		 * assetGroupRepository.getAssetClassTypeSummary(assetGrpId); List<Object[]>
		 * highLowLevelFeatures =
		 * assetGroupRepository.getListOfHighLowFeatures(assetGrpId);
		 * 
		 * if (summaryFracSite != null && highLowLevelFeatures != null &&
		 * !summaryFracSite.isEmpty() && !highLowLevelFeatures.isEmpty()) { for
		 * (Object[] eachObj : summaryFracSite) { AssetGrpDetailsForFracTypeResponse
		 * results = assetGroupService .convertAssetGrpFracSiteToData(eachObj,
		 * highLowLevelFeatures); fracSiteResponse.add(results); } }
		 

		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(fracSiteResponse);

		return new ResponseEntity<Object>(json, HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@GetMapping("/assetGroupjsondata")
	public Object diplayAssets() {

		return assetGroupService;
	}
}
*/