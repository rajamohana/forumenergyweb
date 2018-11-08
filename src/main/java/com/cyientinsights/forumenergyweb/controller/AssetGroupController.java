package com.cyientinsights.forumenergyweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cyientinsights.forumenergyweb.model.AssetGroup;
import com.cyientinsights.forumenergyweb.model.AssetGroupDetailsForRegTypeResponse;
import com.cyientinsights.forumenergyweb.model.AssetGrpDetailsForFracTypeResponse;
import com.cyientinsights.forumenergyweb.model.Example;
import com.cyientinsights.forumenergyweb.model.Site;
import com.cyientinsights.forumenergyweb.model.UserSite;
import com.cyientinsights.forumenergyweb.repository.BranchDao;
import com.cyientinsights.forumenergyweb.service.AssetsGroupServiceImpl;
import com.google.gson.Gson;

@RestController
@RequestMapping("/assetGroups")
public class AssetGroupController {


	@Autowired
	BranchDao geographyRespository;
	@Autowired
	AssetsGroupServiceImpl assetGroupService;

	@CrossOrigin
	@GetMapping("/geographicData")
	public List<Site> getGeographicData(@RequestHeader("userId") String userId,@RequestHeader(value = "Authorization") String data) throws Exception
	{

		HomeController homecontroller = new HomeController();

		String userassetsJson = homecontroller.assetsProcessing(data);

		Gson gson = new Gson();

		Example example = gson.fromJson(userassetsJson, Example.class);

		//String json = gson.toJson(example);

		List<UserSite> userSites = example.getUserSites();
		System.out.println(userSites);

		//Site siteListss = new Site();

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

		List<Site> geographicDataResponse = geographyRespository.getGeographicData(siteList);     

		ArrayList<Site> results = new ArrayList<Site>();

		if (geographicDataResponse != null && !geographicDataResponse.isEmpty()) {

			for (Site obj : geographicDataResponse) {

				Site convertToAsestsResponse = assetGroupService.convertToResponseGeographicData(obj);

				results.add(convertToAsestsResponse);

			}

		}

		//String resultss="[{\"siteId\":09a598e1-8e81-4d6c-af4b-eb3bea5238c4,\"siteName\":\"Forum Frac Spread 1\",\"siteType\":\"frac\",\"assetName\":\"Forum Frac Spread 1\",\"location\":\"Houston\",\"category\":\"Stable\",\"coordinates\":{\"x\":29.76199300,\"y\":-95.36630200},\"assetsData\":[{\"fracpump\":{\"totalAssets\":0,\"good\":0,\"stable\":0,\"critical\":0}}],\"dataToShowOnHover\":[{\"name\":\"noofassets\",\"displayName\":\"No.of Assets\",\"value\":0},{\"name\":\"operationaldate\",\"displayName\":\"Operational Date\",\"value\":\"2018-04-15T11:45:23.000+0000\"},{\"name\":\"health\",\"displayName\":\"Health\",\"value\":0},{\"name\":\"ROD\",\"displayName\":\"ROD\",\"value\":0},{\"name\":\"RUL\",\"displayName\":\"RUL\",\"value\":0}]},{\"siteId\":0f2dee9d-e635-4733-98d3-6f9074099fdf,\"siteName\":\"Forum Frac Spread 2\",\"siteType\":\"frac\",\"assetName\":\"Forum Frac Spread 2\",\"location\":\"Tampa\",\"category\":\"Stable\",\"coordinates\":{\"x\":27.96415700,\"y\":-82.45260600},\"assetsData\":[{\"fracpump\":{\"totalAssets\":4,\"good\":1,\"stable\":2,\"critical\":1}}],\"dataToShowOnHover\":[{\"name\":\"noofassets\",\"displayName\":\"No.of Assets\",\"value\":4},{\"name\":\"operationaldate\",\"displayName\":\"Operational Date\",\"value\":\"2018-04-15T11:45:32.000+0000\"},{\"name\":\"health\",\"displayName\":\"Health\",\"value\":40.2394959554170000},{\"name\":\"ROD\",\"displayName\":\"ROD\",\"value\":14.912500},{\"name\":\"RUL\",\"displayName\":\"RUL\",\"value\":467.862500}]},{\"siteId\":18158ab2-e15c-41c7-a982-dfb95dd52807,\"siteName\":\"Forum Frac Spread 3\",\"siteType\":\"frac\",\"assetName\":\"Forum Frac Spread 3\",\"location\":\"Fort Worth\",\"category\":\"Stable\",\"coordinates\":{\"x\":32.76879900,\"y\":-97.30934100},\"assetsData\":[{\"fracpump\":{\"totalAssets\":5,\"good\":1,\"stable\":3,\"critical\":1}}],\"dataToShowOnHover\":[{\"name\":\"noofassets\",\"displayName\":\"No.of Assets\",\"value\":5},{\"name\":\"operationaldate\",\"displayName\":\"Operational Date\",\"value\":\"2018-04-15T11:45:39.000+0000\"},{\"name\":\"health\",\"displayName\":\"Health\",\"value\":44.0881429491726000},{\"name\":\"ROD\",\"displayName\":\"ROD\",\"value\":12.322000},{\"name\":\"RUL\",\"displayName\":\"RUL\",\"value\":446.886000}]},{\"siteId\":24b673d8-e47b-48ff-991b-913d2cbaba38,\"siteName\":\"Forum Frac Spread 4\",\"siteType\":\"frac\",\"assetName\":\"Forum Frac Spread 4\",\"location\":\"Santa Clara\",\"category\":\"Stable\",\"coordinates\":{\"x\":37.35239000,\"y\":-121.95308000},\"assetsData\":[{\"fracpump\":{\"totalAssets\":4,\"good\":1,\"stable\":2,\"critical\":1}}],\"dataToShowOnHover\":[{\"name\":\"noofassets\",\"displayName\":\"No.of Assets\",\"value\":4},{\"name\":\"operationaldate\",\"displayName\":\"Operational Date\",\"value\":\"2018-08-28T11:34:21.000+0000\"},{\"name\":\"health\",\"displayName\":\"Health\",\"value\":49.3188052439657500},{\"name\":\"ROD\",\"displayName\":\"ROD\",\"value\":11.905000},{\"name\":\"RUL\",\"displayName\":\"RUL\",\"value\":494.385000}]},{\"siteId\":4b093302-3d76-434a-bbb4-c39e81cfa2e3,\"siteName\":\"Forum Frac Spread 5\",\"siteType\":\"frac\",\"assetName\":\"Forum Frac Spread 5\",\"location\":\"Pittsburgh\",\"category\":\"Stable\",\"coordinates\":{\"x\":38.02797700,\"y\":-121.88468200},\"assetsData\":[{\"fracpump\":{\"totalAssets\":5,\"good\":1,\"stable\":3,\"critical\":1}}],\"dataToShowOnHover\":[{\"name\":\"noofassets\",\"displayName\":\"No.of Assets\",\"value\":5},{\"name\":\"operationaldate\",\"displayName\":\"Operational Date\",\"value\":\"2018-08-28T11:35:53.000+0000\"},{\"name\":\"health\",\"displayName\":\"Health\",\"value\":44.0881429491726000},{\"name\":\"ROD\",\"displayName\":\"ROD\",\"value\":12.322000},{\"name\":\"RUL\",\"displayName\":\"RUL\",\"value\":446.886000}]},{\"siteId\":6f9b3f4b-a58e-46b8-97c6-0976223cd3d3,\"siteName\":\"Forum Drilling Rig 200\",\"siteType\":\"rig\",\"assetName\":\"Forum Drilling Rig 200\",\"location\":\"Salt Lake City\",\"category\":\"Stable\",\"coordinates\":{\"x\":40.76078000,\"y\":-111.89104500},\"assetsData\":[{\"catwalk\":{\"totalAssets\":1,\"good\":1,\"stable\":0,\"critical\":0},\"ironroughneck\":{\"totalAssets\":1,\"good\":0,\"stable\":1,\"critical\":0}}],\"dataToShowOnHover\":[{\"name\":\"noofassets\",\"displayName\":\"No.of Assets\",\"value\":2},{\"name\":\"operationaldate\",\"displayName\":\"Operational Date\",\"value\":\"2018-08-28T11:38:34.000+0000\"},{\"name\":\"health\",\"displayName\":\"Health\",\"value\":65.4306024748340000},{\"name\":\"ROD\",\"displayName\":\"ROD\",\"value\":10.400000},{\"name\":\"RUL\",\"displayName\":\"RUL\",\"value\":143608.910000}]},{\"siteId\":8b3ca0c9-c4bd-4b90-9fbe-f0dc2e064069,\"siteName\":\"Forum Drilling Rig 201\",\"siteType\":\"rig\",\"assetName\":\"Forum Drilling Rig 201\",\"location\":\"Dallas\",\"category\":\"Stable\",\"coordinates\":{\"x\":32.77666500,\"y\":-96.79698900},\"assetsData\":[{\"catwalk\":{\"totalAssets\":1,\"good\":1,\"stable\":0,\"critical\":0},\"ironroughneck\":{\"totalAssets\":1,\"good\":0,\"stable\":1,\"critical\":0}}],\"dataToShowOnHover\":[{\"name\":\"noofassets\",\"displayName\":\"No.of Assets\",\"value\":2},{\"name\":\"operationaldate\",\"displayName\":\"Operational Date\",\"value\":\"2018-08-28T11:38:38.000+0000\"},{\"name\":\"health\",\"displayName\":\"Health\",\"value\":76.8444973943000000},{\"name\":\"ROD\",\"displayName\":\"ROD\",\"value\":1.065000},{\"name\":\"RUL\",\"displayName\":\"RUL\",\"value\":143540.490000}]},{\"siteId\":97ab021c-d956-4b64-8d4d-2e9853796e32,\"siteName\":\"Forum Drilling Rig 202\",\"siteType\":\"rig\",\"assetName\":\"Forum Drilling Rig 202\",\"location\":\"Albuquerque\",\"category\":\"Good\",\"coordinates\":{\"x\":35.08438500,\"y\":-106.65042100},\"assetsData\":[{\"catwalk\":{\"totalAssets\":1,\"good\":1,\"stable\":0,\"critical\":0},\"ironroughneck\":{\"totalAssets\":1,\"good\":1,\"stable\":0,\"critical\":0}}],\"dataToShowOnHover\":[{\"name\":\"noofassets\",\"displayName\":\"No.of Assets\",\"value\":2},{\"name\":\"operationaldate\",\"displayName\":\"Operational Date\",\"value\":\"2018-08-28T11:41:52.000+0000\"},{\"name\":\"health\",\"displayName\":\"Health\",\"value\":87.6968452505720000},{\"name\":\"ROD\",\"displayName\":\"ROD\",\"value\":0.915000},{\"name\":\"RUL\",\"displayName\":\"RUL\",\"value\":143780.305000}]},{\"siteId\":9f2f276e-a876-417a-96dc-9139edc386e7,\"siteName\":\"Forum Drilling Rig 203\",\"siteType\":\"rig\",\"assetName\":\"Forum Drilling Rig 203\",\"location\":\"Juneau\",\"category\":\"Stable\",\"coordinates\":{\"x\":58.30194500,\"y\":-134.41972400},\"assetsData\":[{\"catwalk\":{\"totalAssets\":1,\"good\":1,\"stable\":0,\"critical\":0},\"ironroughneck\":{\"totalAssets\":1,\"good\":0,\"stable\":1,\"critical\":0}}],\"dataToShowOnHover\":[{\"name\":\"noofassets\",\"displayName\":\"No.of Assets\",\"value\":2},{\"name\":\"operationaldate\",\"displayName\":\"Operational Date\",\"value\":\"2018-08-28T11:41:54.000+0000\"},{\"name\":\"health\",\"displayName\":\"Health\",\"value\":58.6858788172025000},{\"name\":\"ROD\",\"displayName\":\"ROD\",\"value\":7.080000},{\"name\":\"RUL\",\"displayName\":\"RUL\",\"value\":143487.445000}]},{\"siteId\":9fc1022f-08e4-4bab-a621-5302f0153eab,\"siteName\":\"Forum Drilling Rig 204\",\"siteType\":\"rig\",\"assetName\":\"Forum Drilling Rig 204\",\"location\":\"Fargo\",\"category\":\"Stable\",\"coordinates\":{\"x\":46.87778600,\"y\":-96.78980300},\"assetsData\":[{\"catwalk\":{\"totalAssets\":1,\"good\":1,\"stable\":0,\"critical\":0},\"ironroughneck\":{\"totalAssets\":1,\"good\":0,\"stable\":0,\"critical\":1}}],\"dataToShowOnHover\":[{\"name\":\"noofassets\",\"displayName\":\"No.of Assets\",\"value\":2},{\"name\":\"operationaldate\",\"displayName\":\"Operational Date\",\"value\":\"2018-08-28T11:41:54.000+0000\"},{\"name\":\"health\",\"displayName\":\"Health\",\"value\":56.3515718526305000},{\"name\":\"ROD\",\"displayName\":\"ROD\",\"value\":13.280000},{\"name\":\"RUL\",\"displayName\":\"RUL\",\"value\":143454.065000}]},{\"siteId\":b4c56573-9c42-48ea-a4c0-31b7114c4da0,\"siteName\":\"Forum Drilling Rig 205\",\"siteType\":\"rig\",\"assetName\":\"Forum Drilling Rig 205\",\"location\":\"Atlantic City\",\"category\":\"Stable\",\"coordinates\":{\"x\":42.49649000,\"y\":-108.73181900},\"assetsData\":[{\"catwalk\":{\"totalAssets\":1,\"good\":1,\"stable\":0,\"critical\":0},\"ironroughneck\":{\"totalAssets\":1,\"good\":0,\"stable\":1,\"critical\":0}}],\"dataToShowOnHover\":[{\"name\":\"noofassets\",\"displayName\":\"No.of Assets\",\"value\":2},{\"name\":\"operationaldate\",\"displayName\":\"Operational Date\",\"value\":\"2018-08-28T11:43:25.000+0000\"},{\"name\":\"health\",\"displayName\":\"Health\",\"value\":58.3225681950000000},{\"name\":\"ROD\",\"displayName\":\"ROD\",\"value\":7.835000},{\"name\":\"RUL\",\"displayName\":\"RUL\",\"value\":143466.945000}]}]";
		return results;
	}


	@CrossOrigin
	@GetMapping("/assetGroup")
	public List<AssetGroup> getAssetGroupData(@RequestHeader("userId") String userId,@RequestHeader(value = "Authorization") String data) throws Exception
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

		List<AssetGroup> geographicDataResponse = geographyRespository.getAssetGroups(siteList);     

		ArrayList<AssetGroup> results = new ArrayList<AssetGroup>();

		if (geographicDataResponse != null && !geographicDataResponse.isEmpty()) {

			for (AssetGroup obj : geographicDataResponse) {

				AssetGroup convertToAsestsResponse = assetGroupService.ConvertToAsestGroupResponse(obj);

				results.add(convertToAsestsResponse);

			}

		}

		//String results="[{\"assetGrpId\":0f2dee9d-e635-4733-98d3-6f9074099fdf,\"assetGrpName\":\"Forum Frac Spread 1\",\"assetGrpLocation\":\"Houston\",\"assetGrpType\":\"frac\",\"category\":\"Stable\",\"operationalDate\":\"2018-04-15T11:45:23.000+0000\",\"healthPercentage\":46.6539076116763333,\"assets\":[{\"name\":\"fracpump\",\"value\":6,\"displayName\":\"Frac Pumps\"},{\"name\":\"catwalk\",\"value\":0,\"displayName\":\"Catwalk\"},{\"name\":\"roughneck\",\"value\":0,\"displayName\":\"Iron Roughneck\"}]},{\"assetGrpId\":18158ab2-e15c-41c7-a982-dfb95dd52807,\"assetGrpName\":\"Forum Frac Spread 2\",\"assetGrpLocation\":\"Tampa\",\"assetGrpType\":\"frac\",\"category\":\"Stable\",\"operationalDate\":\"2018-04-15T11:45:32.000+0000\",\"healthPercentage\":40.2394959554170000,\"assets\":[{\"name\":\"fracpump\",\"value\":4,\"displayName\":\"Frac Pumps\"},{\"name\":\"catwalk\",\"value\":0,\"displayName\":\"Catwalk\"},{\"name\":\"roughneck\",\"value\":0,\"displayName\":\"Iron Roughneck\"}]},{\"assetGrpId\":24b673d8-e47b-48ff-991b-913d2cbaba38,\"assetGrpName\":\"Forum Frac Spread 3\",\"assetGrpLocation\":\"Fort Worth\",\"assetGrpType\":\"frac\",\"category\":\"Stable\",\"operationalDate\":\"2018-04-15T11:45:39.000+0000\",\"healthPercentage\":44.0881429491726000,\"assets\":[{\"name\":\"fracpump\",\"value\":5,\"displayName\":\"Frac Pumps\"},{\"name\":\"catwalk\",\"value\":0,\"displayName\":\"Catwalk\"},{\"name\":\"roughneck\",\"value\":0,\"displayName\":\"Iron Roughneck\"}]},{\"assetGrpId\":4b093302-3d76-434a-bbb4-c39e81cfa2e34,\"assetGrpName\":\"Forum Frac Spread 4\",\"assetGrpLocation\":\"Santa Clara\",\"assetGrpType\":\"frac\",\"category\":\"Stable\",\"operationalDate\":\"2018-08-28T11:34:21.000+0000\",\"healthPercentage\":49.3188052439657500,\"assets\":[{\"name\":\"fracpump\",\"value\":4,\"displayName\":\"Frac Pumps\"},{\"name\":\"catwalk\",\"value\":0,\"displayName\":\"Catwalk\"},{\"name\":\"roughneck\",\"value\":0,\"displayName\":\"Iron Roughneck\"}]},{\"assetGrpId\":6f9b3f4b-a58e-46b8-97c6-0976223cd3d3,\"assetGrpName\":\"Forum Frac Spread 5\",\"assetGrpLocation\":\"Pittsburgh\",\"assetGrpType\":\"frac\",\"category\":\"Stable\",\"operationalDate\":\"2018-08-28T11:35:53.000+0000\",\"healthPercentage\":44.0881429491726000,\"assets\":[{\"name\":\"fracpump\",\"value\":5,\"displayName\":\"Frac Pumps\"},{\"name\":\"catwalk\",\"value\":0,\"displayName\":\"Catwalk\"},{\"name\":\"roughneck\",\"value\":0,\"displayName\":\"Iron Roughneck\"}]},{\"assetGrpId\":97ab021c-d956-4b64-8d4d-2e9853796e32,\"assetGrpName\":\"Forum Drilling Rig 200\",\"assetGrpLocation\":\"Salt Lake City\",\"assetGrpType\":\"rig\",\"category\":\"Stable\",\"operationalDate\":\"2018-08-28T11:38:34.000+0000\",\"healthPercentage\":65.4306024748340000,\"assets\":[{\"name\":\"fracpump\",\"value\":0,\"displayName\":\"Frac Pumps\"},{\"name\":\"catwalk\",\"value\":1,\"displayName\":\"Catwalk\"},{\"name\":\"roughneck\",\"value\":1,\"displayName\":\"Iron Roughneck\"}]},{\"assetGrpId\":9f2f276e-a876-417a-96dc-9139edc386e7,\"assetGrpName\":\"Forum Drilling Rig 201\",\"assetGrpLocation\":\"Dallas\",\"assetGrpType\":\"rig\",\"category\":\"Stable\",\"operationalDate\":\"2018-08-28T11:38:38.000+0000\",\"healthPercentage\":76.8444973943000000,\"assets\":[{\"name\":\"fracpump\",\"value\":0,\"displayName\":\"Frac Pumps\"},{\"name\":\"catwalk\",\"value\":1,\"displayName\":\"Catwalk\"},{\"name\":\"roughneck\",\"value\":1,\"displayName\":\"Iron Roughneck\"}]},{\"assetGrpId\":9fc1022f-08e4-4bab-a621-5302f0153eab,\"assetGrpName\":\"Forum Drilling Rig 202\",\"assetGrpLocation\":\"Albuquerque\",\"assetGrpType\":\"rig\",\"category\":\"Good\",\"operationalDate\":\"2018-08-28T11:41:52.000+0000\",\"healthPercentage\":87.6968452505720000,\"assets\":[{\"name\":\"fracpump\",\"value\":0,\"displayName\":\"Frac Pumps\"},{\"name\":\"catwalk\",\"value\":1,\"displayName\":\"Catwalk\"},{\"name\":\"roughneck\",\"value\":1,\"displayName\":\"Iron Roughneck\"}]},{\"assetGrpId\":c204cd1a-a2cd-4836-8701-a3988015ccc8,\"assetGrpName\":\"Forum Drilling Rig 203\",\"assetGrpLocation\":\"Juneau\",\"assetGrpType\":\"rig\",\"category\":\"Stable\",\"operationalDate\":\"2018-08-28T11:41:54.000+0000\",\"healthPercentage\":58.6858788172025000,\"assets\":[{\"name\":\"fracpump\",\"value\":0,\"displayName\":\"Frac Pumps\"},{\"name\":\"catwalk\",\"value\":1,\"displayName\":\"Catwalk\"},{\"name\":\"roughneck\",\"value\":1,\"displayName\":\"Iron Roughneck\"}]},{\"assetGrpId\":c97f1116-3217-4111-8ed9-1024a2891794,\"assetGrpName\":\"Forum Drilling Rig 204\",\"assetGrpLocation\":\"Fargo\",\"assetGrpType\":\"rig\",\"category\":\"Stable\",\"operationalDate\":\"2018-08-28T11:41:54.000+0000\",\"healthPercentage\":56.3515718526305000,\"assets\":[{\"name\":\"fracpump\",\"value\":0,\"displayName\":\"Frac Pumps\"},{\"name\":\"catwalk\",\"value\":1,\"displayName\":\"Catwalk\"},{\"name\":\"roughneck\",\"value\":1,\"displayName\":\"Iron Roughneck\"}]},{\"assetGrpId\":b4c56573-9c42-48ea-a4c0-31b7114c4da0,\"assetGrpName\":\"Forum Drilling Rig 205\",\"assetGrpLocation\":\"Atlantic City\",\"assetGrpType\":\"rig\",\"category\":\"Stable\",\"operationalDate\":\"2018-08-28T11:43:25.000+0000\",\"healthPercentage\":58.3225681950000000,\"assets\":[{\"name\":\"fracpump\",\"value\":0,\"displayName\":\"Frac Pumps\"},{\"name\":\"catwalk\",\"value\":1,\"displayName\":\"Catwalk\"},{\"name\":\"roughneck\",\"value\":1,\"displayName\":\"Iron Roughneck\"}]}]";
		return results;
	}


	

	@CrossOrigin
	@GetMapping("/assetGroupdetailsUser/{assetGroupId}")
	public Object getAssetGroupdetailsUserData(@PathVariable("assetGroupId") String assetGrpId,@RequestHeader(value = "Authorization") String data) throws Exception
	{

        HomeController homecontroller = new HomeController();
		
		String userassetsJson = homecontroller.assetsProcessing(data);
		
		Gson gson = new Gson();
		
		Example example = gson.fromJson(userassetsJson, Example.class);
		
		//String json = gson.toJson(example);
		
		List<UserSite> userSites = example.getUserSites();
		
		//assetGrpId="6f9b3f4b-a58e-46b8-97c6-0976223cd3d3";
		
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

		if ((siteListss.getSiteType()).equalsIgnoreCase("frac")) {
			
			List<Site> summaryFracSite=geographyRespository.getSummaryAssetGroupDetails(siteListss.getId());
			System.out.println(summaryFracSite);
			List<Site> highLowLevelFeatures=geographyRespository.getHealthAssetGroupDetails(siteListss.getId());
			ArrayList<AssetGrpDetailsForFracTypeResponse> fracSiteResponse = new ArrayList<AssetGrpDetailsForFracTypeResponse>();
			if (summaryFracSite != null && highLowLevelFeatures != null && !summaryFracSite.isEmpty()
					&& !highLowLevelFeatures.isEmpty()) {
				for (Site eachObj : summaryFracSite) {
					AssetGrpDetailsForFracTypeResponse results = assetGroupService.convertAssetGrpFracSiteToData(eachObj, highLowLevelFeatures,siteListss);
					fracSiteResponse.add(results);
				}
			}
		
			return fracSiteResponse;
		}else
		{
			List<Site> regTypeData = geographyRespository.getSummaryAssetGroupCatwalkDetails(siteListss.getId());
			System.out.println("before enterinto response");
			ArrayList<AssetGroupDetailsForRegTypeResponse> rigTypeResponse = new ArrayList<AssetGroupDetailsForRegTypeResponse>();
			if (regTypeData != null && !regTypeData.isEmpty()) {
				for (Site obj : regTypeData) {
					System.out.println("befoure response1");
					AssetGroupDetailsForRegTypeResponse convertToresponseJson = assetGroupService
							.convertAssetGrpRegTypeToData(obj);
					System.out.println("befoure response2");
					rigTypeResponse.add(convertToresponseJson);
				}
			}
			return rigTypeResponse;
		}
		
		//String results="[{\"assetGrpId\":0f2dee9d-e635-4733-98d3-6f9074099fdf,\"assetGrpName\":\"Forum Frac Spread 1\",\"assetGrpType\":\"frac\",\"healthData\":{\"healthPercentage\":10.595000,\"siteAvgHealth\":46.6539076116763333},\"assetsData\":[{\"frackpumps\":{\"totalAssets\":6,\"good\":1,\"stable\":4,\"critical\":1}}],\"assetGrpMetaData\":[{\"name\":\"Hours\",\"displayName\":\"Avg. Hours\",\"value\":141.633333,\"units\":\"\"},{\"name\":\"RUL\",\"displayName\":\"Avg. RUL\",\"value\":432.901667},{\"name\":\"ROD\",\"displayName\":\"ROD\",\"value\":10.595000,\"units\":\"\"}],\"assetgrpMajorAssets\":[{\"heading\":\"Least Health\",\"assetid\":\"MUUXC8S50F\",\"assetName\":\"MUUXC8S50F\",\"assetType\":\"frac\",\"metaData\":[{\"name\":\"RUL\",\"displayName\":\"Hours\",\"value\":139.23},{\"name\":\"SMH\",\"displayName\":\"Health\",\"value\":19.223501085261,\"units\":\"percentage\"},{\"name\":\"ROD\",\"displayName\":\"ROD\",\"value\":24.88,\"units\":\"percentage\",\"trend\":21.60}]},{\"heading\":\"Highest Runtime\",\"assetid\":\"UL5P6BR7T7\",\"assetName\":\"UL5P6BR7T7\",\"assetType\":\"frac\",\"metaData\":[{\"name\":\"RUL\",\"displayName\":\"Hours\",\"value\":146.20},{\"name\":\"SMH\",\"displayName\":\"Health\",\"value\":23.165493770000,\"units\":\"percentage\"},{\"name\":\"ROD\",\"displayName\":\"ROD\",\"value\":13.99,\"units\":\"percentage\",\"trend\":-14.16}]},{\"heading\":\"Highest Deterioation\",\"assetid\":\"MUUXC8S50F\",\"assetName\":\"MUUXC8S50F\",\"assetType\":\"frac\",\"metaData\":[{\"name\":\"RUL\",\"displayName\":\"Hours\",\"value\":139.23},{\"name\":\"SMH\",\"displayName\":\"Health\",\"value\":19.223501085261,\"units\":\"percentage\"},{\"name\":\"ROD\",\"displayName\":\"ROD\",\"value\":24.88,\"units\":\"percentage\",\"trend\":21.60}]}]}]";
	}

}
