package com.cyientinsights.forumenergyweb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cyientinsights.forumenergyweb.model.Asset;
import com.cyientinsights.forumenergyweb.model.AssetDetailsCatWalk;
import com.cyientinsights.forumenergyweb.model.AssetDetailsFracTypeResponse;
import com.cyientinsights.forumenergyweb.model.AssetJdbcEx;
import com.cyientinsights.forumenergyweb.model.Assets;
import com.cyientinsights.forumenergyweb.model.AssetsResponse;
import com.cyientinsights.forumenergyweb.model.Example;
import com.cyientinsights.forumenergyweb.model.HealthGraph;
import com.cyientinsights.forumenergyweb.model.SensorsData;
import com.cyientinsights.forumenergyweb.model.Site;
import com.cyientinsights.forumenergyweb.model.UserSite;
import com.cyientinsights.forumenergyweb.repository.BranchDao;

//import com.cyientinsights.forumenergyweb.repository.UserRepository;
import com.cyientinsights.forumenergyweb.service.AssetsGroupServiceImpl;
import com.cyientinsights.forumenergyweb.service.SecurityConstants;
import com.google.gson.Gson;


@RestController
@RequestMapping("/assets")
public class AssetsController {

	
	@Autowired
	BranchDao geographyRespository;
	@Autowired
	AssetsGroupServiceImpl assetGroupService;
    
    @CrossOrigin   
	@GetMapping("/assetsuser")
	public List<AssetsResponse> getAllAssets(@RequestHeader("userId") String userId,@RequestHeader(value = "Authorization") String data) throws Exception
	{

            
		HomeController homecontroller = new HomeController();

		String userassetsJson = homecontroller.assetsProcessing(data);

		Gson gson = new Gson();

		Example example = gson.fromJson(userassetsJson, Example.class);

		//String json = gson.toJson(example);

		List<UserSite> userSites = example.getUserSites();
		System.out.println(userSites);

		//Site siteListss = new Site();
		//List of site ids for logeed in user

		List<String> siteList = new ArrayList<>();

		for(int i = 0; i < userSites.size(); i++) {

			if(userId.equals(userSites.get(i).getUserId()))
			{


				String ss=userSites.get(i).getSiteId();
				System.out.println(ss);
				siteList.add(ss);
			}

		}
		System.out.println(siteList);
		
	List<Assets> assetsAll=geographyRespository.getAllAssets(siteList);
	
	ArrayList<AssetsResponse> results = new ArrayList<AssetsResponse>();

	if (assetsAll != null && !assetsAll.isEmpty()) {

		for (Assets obj : assetsAll) {

			AssetsResponse convertToAsestsResponse = assetGroupService.ConvertToAsestGroupResponse(obj);

			results.add(convertToAsestsResponse);

		}

	}
		//String results="[{\"assetId\":\"UL5P6BR7T7\",\"assetName\":\"Nano Box 1\",\"assetType\":\"fracpump\",\"siteName\":\"Houston\",\"siteId\":1,\"category\":\"Stable\",\"rul\":256.89,\"rod\":13.99,\"smh\":146.20,\"expectedLife\":1000,\"purchaseDate\":\"2018-04-15T11:45:23.000+0000\",\"latitude\":29.76199300,\"logDateTime\":1514800764000,\"healthPercentage\":23.165493770000,\"assetMetaData\":[{\"name\":\"RUL\",\"displayName\":\"RUL (Hours)\",\"value\":256.89},{\"name\":\"ROD\",\"displayName\":\"Deterioration\",\"value\":13.99,\"trend\":\"decrease\",\"units\":\"percentage\"}],\"progressGraph\":{\"graphData\":[{\"xAxis\":0,\"xAxisDate\":1523792723000,\"yAxis\":100},{\"xAxis\":0,\"xAxisDate\":1514800764000,\"yAxis\":23.165493770000},{\"xAxis\":403.09,\"xAxisDate\":1514800764000,\"yAxis\":0}],\"xAxisToday\":1514800764000,\"yAxisToday\":23.165493770000},\"longitude\":-95.36630200},{\"assetId\":\"VGPA9HIM1V\",\"assetName\":\"Nano Box 2\",\"assetType\":\"fracpump\",\"siteName\":\"Houston\",\"siteId\":1,\"category\":\"Stable\",\"rul\":362.98,\"rod\":1.96,\"smh\":144.67,\"expectedLife\":1000,\"purchaseDate\":\"2018-04-15T11:45:23.000+0000\",\"latitude\":29.76199300,\"logDateTime\":1514800764000,\"healthPercentage\":59.482730924195,\"assetMetaData\":[{\"name\":\"RUL\",\"displayName\":\"RUL (Hours)\",\"value\":362.98},{\"name\":\"ROD\",\"displayName\":\"Deterioration\",\"value\":1.96,\"trend\":\"increase\",\"units\":\"percentage\"}],\"progressGraph\":{\"graphData\":[{\"xAxis\":0,\"xAxisDate\":1523792723000,\"yAxis\":100},{\"xAxis\":0,\"xAxisDate\":1514800764000,\"yAxis\":59.482730924195},{\"xAxis\":507.65,\"xAxisDate\":1514800764000,\"yAxis\":0}],\"xAxisToday\":1514800764000,\"yAxisToday\":59.482730924195},\"longitude\":-95.36630200},{\"assetId\":\"XDGCTR8N03\",\"assetName\":\"Nano Box 3\",\"assetType\":\"fracpump\",\"siteName\":\"Houston\",\"siteId\":1,\"category\":\"Good\",\"rul\":842.61,\"rod\":1.66,\"smh\":136.38,\"expectedLife\":1000,\"purchaseDate\":\"2018-04-15T11:45:23.000+0000\",\"latitude\":29.76199300,\"logDateTime\":1514800764000,\"healthPercentage\":81.187426636739,\"assetMetaData\":[{\"name\":\"RUL\",\"displayName\":\"RUL (Hours)\",\"value\":842.61},{\"name\":\"ROD\",\"displayName\":\"Deterioration\",\"value\":1.66,\"trend\":\"increase\",\"units\":\"percentage\"}],\"progressGraph\":{\"graphData\":[{\"xAxis\":0,\"xAxisDate\":1523792723000,\"yAxis\":100},{\"xAxis\":0,\"xAxisDate\":1514800764000,\"yAxis\":81.187426636739},{\"xAxis\":978.99,\"xAxisDate\":1514800764000,\"yAxis\":0}],\"xAxisToday\":1514800764000,\"yAxisToday\":81.187426636739},\"longitude\":-95.36630200},{\"assetId\":\"GCG0EBDIY7\",\"assetName\":\"FRAC636\",\"assetType\":\"fracpump\",\"siteName\":\"Houston\",\"siteId\":1,\"category\":\"Stable\",\"rul\":540.82,\"rod\":19.12,\"smh\":138.65,\"expectedLife\":1000,\"purchaseDate\":\"2018-04-15T11:45:23.000+0000\",\"latitude\":29.76199300,\"logDateTime\":1514800764000,\"healthPercentage\":37.381562329668,\"assetMetaData\":[{\"name\":\"RUL\",\"displayName\":\"RUL (Hours)\",\"value\":540.82},{\"name\":\"ROD\",\"displayName\":\"Deterioration\",\"value\":19.12,\"trend\":\"increase\",\"units\":\"percentage\"}],\"progressGraph\":{\"graphData\":[{\"xAxis\":0,\"xAxisDate\":1523792723000,\"yAxis\":100},{\"xAxis\":0,\"xAxisDate\":1514800764000,\"yAxis\":37.381562329668},{\"xAxis\":679.47,\"xAxisDate\":1514800764000,\"yAxis\":0}],\"xAxisToday\":1514800764000,\"yAxisToday\":37.381562329668},\"longitude\":-95.36630200},{\"assetId\":\"13TSE3LN7W\",\"assetName\":\"FRAC076\",\"assetType\":\"fracpump\",\"siteName\":\"Houston\",\"siteId\":1,\"category\":\"Stable\",\"rul\":362.98,\"rod\":1.96,\"smh\":144.67,\"expectedLife\":1000,\"purchaseDate\":\"2018-04-15T11:45:23.000+0000\",\"latitude\":29.76199300,\"logDateTime\":1514800764000,\"healthPercentage\":59.482730924195,\"assetMetaData\":[{\"name\":\"RUL\",\"displayName\":\"RUL (Hours)\",\"value\":362.98},{\"name\":\"ROD\",\"displayName\":\"Deterioration\",\"value\":1.96,\"trend\":\"increase\",\"units\":\"percentage\"}],\"progressGraph\":{\"graphData\":[{\"xAxis\":0,\"xAxisDate\":1523792723000,\"yAxis\":100},{\"xAxis\":0,\"xAxisDate\":1514800764000,\"yAxis\":59.482730924195},{\"xAxis\":507.65,\"xAxisDate\":1514800764000,\"yAxis\":0}],\"xAxisToday\":1514800764000,\"yAxisToday\":59.482730924195},\"longitude\":-95.36630200},{\"assetId\":\"MUUXC8S50F\",\"assetName\":\"FRAC176\",\"assetType\":\"fracpump\",\"siteName\":\"Houston\",\"siteId\":1,\"category\":\"Critical\",\"rul\":231.13,\"rod\":24.88,\"smh\":139.23,\"expectedLife\":1000,\"purchaseDate\":\"2018-04-15T11:45:23.000+0000\",\"latitude\":29.76199300,\"logDateTime\":1514800764000,\"healthPercentage\":19.223501085261,\"assetMetaData\":[{\"name\":\"RUL\",\"displayName\":\"RUL (Hours)\",\"value\":231.13},{\"name\":\"ROD\",\"displayName\":\"Deterioration\",\"value\":24.88,\"trend\":\"increase\",\"units\":\"percentage\"}],\"progressGraph\":{\"graphData\":[{\"xAxis\":0,\"xAxisDate\":1523792723000,\"yAxis\":100},{\"xAxis\":0,\"xAxisDate\":1514800764000,\"yAxis\":19.223501085261},{\"xAxis\":370.36,\"xAxisDate\":1514800764000,\"yAxis\":0}],\"xAxisToday\":1514800764000,\"yAxisToday\":19.223501085261},\"longitude\":-95.36630200}]";	
		return results;

	}
	
    @CrossOrigin
	@GetMapping("/assetDetails/{assetId}")
	public Object getAllAssetsByAssetId(@PathVariable(value = "assetId") String assetId,@RequestHeader(value = "Authorization") String data) throws Exception 
	{
		
		HomeController homecontroller = new HomeController();

		String userassetsJson = homecontroller.assetsProcessing(data);

		Gson gson = new Gson();

		Example example = gson.fromJson(userassetsJson, Example.class);

		//String json = gson.toJson(example);

		List<UserSite> userSites = example.getUserSites();
		System.out.println(userSites);
      int usize=userSites.size();		
      System.out.println(usize);

		//Site siteListss = new Site();
		//List of site ids for logeed in user
         List<Asset> lasset= new ArrayList<Asset>();
         List<List<Asset>> llasset= new ArrayList<List<Asset>>(); 
		Asset asst= new Asset();
		asst.setId(assetId);
		String ss=null;

         Site siteListss = new Site();
		
		List<Site> siteList = new ArrayList<>();
		
		for(int i = 0; i < example.getUserSites().size(); i++) {
		
			Site sites = example.getUserSites().get(i).getSite();
			
			siteList.add(sites);

		}
		
		for (int i = 0; i < siteList.size(); i++) {
			
			lasset=siteList.get(i).getAssets();
			llasset.add(lasset);
		
		}
		
		List<Asset> assets3=new ArrayList<Asset>();
		for(int i=0;i<llasset.size();i++)
		{
			
			
			assets3=llasset.get(i);
			for(Asset ass:assets3)
			{
				if(assetId.equals(ass.getId()))
				{
					
					ss=ass.getProduct();
					
					
				}
				
			}
		}
		
		
		
		
		System.out.println(lasset.size());
		
		
		
		/*for(int i=0; i<usize; i++) {

			System.out.println(userSites.get(i).getSite().getAssets().get);
			if(assetId.equals(userSites.get(i).getSite().getAssets().get(i).getId()))
			{


				ss=userSites.get(i).getSite().getAssets().get(i).getProduct();
				System.out.println(ss);

			}

		}*/
		
		
		
		
		asst.setProduct(ss);
		System.out.println(asst.getId());
		System.out.println(ss);
		String atype=ss.replaceAll("\\s+","");
		System.out.println(atype);
		
		ArrayList<AssetDetailsFracTypeResponse> fracSiteResponse = new ArrayList<AssetDetailsFracTypeResponse>();
		if (atype.equalsIgnoreCase(SecurityConstants.FRACPUMP)) {
			//List<Object[]> sideData = geographyRespository.getAssetDeteriotationData(assetId);
			List<AssetJdbcEx> topEndData = geographyRespository.getAssetDetailsForFracType(assetId);
			
			if (topEndData != null && !topEndData.isEmpty()) {
				for (AssetJdbcEx obj : topEndData) {
					AssetDetailsFracTypeResponse convertToAsestsResponse = assetGroupService.ConvertToAssetFracResponseJSON(obj, atype);
					//AssetDetailsFracTypeResponse convertToAsestsResponse = assetsService.ConvertToResponseJSON(obj);
					fracSiteResponse.add(convertToAsestsResponse);
				}
			}
		}else {
			//List<Object[]> sideData = rulRepository.getAssetDeteriotationData(assetId);
			List<AssetDetailsCatWalk> topEndData = geographyRespository.getAssetDetailsForCatwalk(assetId);
			if (topEndData != null && !topEndData.isEmpty()) {
				for (AssetDetailsCatWalk obj : topEndData) {
					AssetDetailsFracTypeResponse convertToAsestsResponse = assetGroupService.ConvertToAssetCatwalkResponseJSON(obj,ss);
					fracSiteResponse.add(convertToAsestsResponse);
				}
			}
		}
		return fracSiteResponse;
	}
    @CrossOrigin	
	@GetMapping("/assetDetails/chartData/{assetId}")
	public Object getAssetDetailsChartData(@PathVariable(value = "assetId") String assetId,@RequestHeader(value = "Authorization") String data) throws Exception{
		

		HomeController homecontroller = new HomeController();

		String userassetsJson = homecontroller.assetsProcessing(data);

		Gson gson = new Gson();

		Example example = gson.fromJson(userassetsJson, Example.class);

		//String json = gson.toJson(example);

		List<UserSite> userSites = example.getUserSites();
		System.out.println(userSites);

		 int usize=userSites.size();		
	      System.out.println(usize);

			//Site siteListss = new Site();
			//List of site ids for logeed in user
	         List<Asset> lasset= new ArrayList<Asset>();
	         List<List<Asset>> llasset= new ArrayList<List<Asset>>(); 
			Asset asst= new Asset();
			asst.setId(assetId);
			String ss=null;

	         Site siteListss = new Site();
			
			List<Site> siteList = new ArrayList<>();
			
			for(int i = 0; i < example.getUserSites().size(); i++) {
			
				Site sites = example.getUserSites().get(i).getSite();
				
				siteList.add(sites);

			}
			
			for (int i = 0; i < siteList.size(); i++) {
				
				lasset=siteList.get(i).getAssets();
				llasset.add(lasset);
			
			}
			
			List<Asset> assets3=new ArrayList<Asset>();
			for(int i=0;i<llasset.size();i++)
			{
				assets3=llasset.get(i);
				for(Asset ass:assets3)
				{
					if(assetId.equals(ass.getId()))
					{
						ss=ass.getProduct();	
					}
					
				}
			}
			System.out.println(lasset.size());
			
			/*for(int i=0; i<usize; i++) {

				System.out.println(userSites.get(i).getSite().getAssets().get);
				if(assetId.equals(userSites.get(i).getSite().getAssets().get(i).getId()))
				{


					ss=userSites.get(i).getSite().getAssets().get(i).getProduct();
					System.out.println(ss);

				}

			}*/
			
			asst.setProduct(ss);
			System.out.println(asst.getId());
			System.out.println(ss);
			String atype=ss.replaceAll("\\s+","");
			System.out.println(atype);
		
		List<Site> simHealthData = geographyRespository.getSimHealthChartData(assetId);
		List<Site> healthData = geographyRespository.getHealthChartData(assetId);
		ArrayList<HealthGraph> arrayList = new ArrayList<HealthGraph>();

		if (atype.equalsIgnoreCase(SecurityConstants.FRACPUMP)) {
			String assetIdForFrac = "KF03ZI63NP";
			List<Site> simHealthDataForFrac = geographyRespository.getSimHealthChartData(assetId);
			List<Site> healthDataForFrac = geographyRespository.getHealthChartData(assetId);
			if (simHealthData != null && !simHealthData.isEmpty() && healthData != null && !healthData.isEmpty()) {
				HealthGraph healthGraph = assetGroupService.convertHealthGraphDatatoJSON(simHealthData, healthData, atype);
				HealthGraph healthGraph2 = assetGroupService.convertPowerEndDatatoJSON(simHealthDataForFrac,
						healthDataForFrac);
				arrayList.add(healthGraph);
				arrayList.add(healthGraph2);
			}

		} else{
			List<Site> healthData2=geographyRespository.getHealthChartDataCatWalk(assetId);
			List<Site> simHealthDataForCatwalk = geographyRespository.getSimHealthChartDataCatWalk(assetId);
			if (simHealthDataForCatwalk != null && !simHealthDataForCatwalk.isEmpty() && healthData2 != null && !healthData2.isEmpty()) {
				HealthGraph healthGraph = assetGroupService.convertHealthGraphDatatoJSON(simHealthDataForCatwalk, healthData2, atype);
				arrayList.add(healthGraph);
			}
		} 

		return arrayList;
		
	}
    
   /* @CrossOrigin
	@GetMapping("/cosmodb")
	 private void getStartedDemo() throws DocumentClientException, IOException {
		 
		 this.client = new DocumentClient("https://cyientcosmos.documents.azure.com:443/",
	                "aYKTlOp0rlEhhVvj7x7GMohKGh4WOgFPOdqLFuitN0GLmHSvpJqE39DJ5syF765RA7QfxgHkXDyW9wZfIAAVMQ==", 
	                new ConnectionPolicy(),
	                ConsistencyLevel.Session);
		 this.executeSimpleQuery("iotdata2", "fracdata");
	 }
	 
	
	
	 private List<SensorsData> executeSimpleQuery(String Startdate, String endDate) {
		 
		 this.client = new DocumentClient("https://cyientcosmos.documents.azure.com:443/",
	                "aYKTlOp0rlEhhVvj7x7GMohKGh4WOgFPOdqLFuitN0GLmHSvpJqE39DJ5syF765RA7QfxgHkXDyW9wZfIAAVMQ==", 
	                new ConnectionPolicy(),
	                ConsistencyLevel.Session);
		 String databaseName="iotdata2";
		 String collectionName="fracdata";
		 
	        // Set some common query options
	        FeedOptions queryOptions = new FeedOptions();
	        queryOptions.setPageSize(-1);
	        queryOptions.setEnableCrossPartitionQuery(true);

	        String collectionLink = String.format("/dbs/%s/colls/%s", databaseName, collectionName);
	        FeedResponse<Document> queryResults = this.client.queryDocuments(collectionLink,
	                "SELECT f._ts,f.inletTemp FROM fracdata f where f._ts > 1540453820 AND f._ts < 1540471820 ", queryOptions);

	        System.out.println("Running SQL query...");
	        
	        List<Document> family=queryResults.getQueryIterable().toList();
	        
	        List<SensorsData> listsensorData=new ArrayList<SensorsData>();
	        
	        for(int i=0;i<family.size();i++)
	        {
	        SensorsData sensedata=gson.fromJson(family.get(i).toString(), SensorsData.class);
	        
	        listsensorData.add(sensedata);
	        
	        }
	       
	        // System.out.println(sensedata.getInletTemp()+" "+sensedata.get_ts());
	        
	        for (Document family : queryResults.getQueryIterable()) {
	            System.out.println(String.format("\tRead %s", family));
	        }
	    
	      return listsensorData;
	 }
	
	*/
	
	
}

