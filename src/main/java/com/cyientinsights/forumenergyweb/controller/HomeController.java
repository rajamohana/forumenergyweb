package com.cyientinsights.forumenergyweb.controller;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;






@RestController
@RequestMapping("/api")
public class HomeController {
	

	public ResponseEntity<Object> responseProcessing(String data) throws Exception 
	{
		
		
		
		 String url = "https://fetidentitydev.azurewebsites.net/api/Identity/Permissions";
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	     //con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)");
	     //con.setRequestProperty("useerid", "101");
	     con.setRequestProperty("Origin", "http://localhost");
	     con.setRequestProperty("Referer", "http://localhost/FET_Identity_Usage_Example/index.html");
	     //con.setRequestProperty("useerid", "101");
	     con.setRequestProperty("Authorization",data);
	     int responseCode = con.getResponseCode();
	     System.out.println("\nSending 'GET' request to URL : " + url);
	     System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer  response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     //print in String
	   /*JSONObject myResponse = new JSONObject(response.toString());
	     System.out.println("result after Reading JSON Response");
	     System.out.println("Id- "+myResponse.getString("id"));
	     System.out.println("Component- "+myResponse.getString("component"));
	      System.out.println("availability- "+myResponse.getString("availability"));
	     JSONObject outputJson = new JSONObject(response.toString());
	outputJson.put("Id-", outputJson.getString("id"));
	outputJson.put("Component-", outputJson.getString("component"));
	outputJson.put("avaliability-", outputJson.getString("availablity"));*/
		
		return new ResponseEntity<Object>(response.toString(), HttpStatus.OK);
	}
	
	
	public String validateToken(String data) throws Exception 
	{
		
		
		
		 String url = "https://fetidentitydev.azurewebsites.net/api/ValidateToken";
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	     //con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)");
	     //con.setRequestProperty("useerid", "101");
	     con.setRequestProperty("Origin", "http://localhost");
	     con.setRequestProperty("Referer", "http://localhost/FET_Identity_Usage_Example/index.html");
	     //con.setRequestProperty("useerid", "101");
	     con.setRequestProperty("Authorization",data);
	     int responseCode = con.getResponseCode();
	     System.out.println("\nSending 'GET' request to URL : " + url);
	     System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer  response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     //print in String
	   /*JSONObject myResponse = new JSONObject(response.toString());
	     System.out.println("result after Reading JSON Response");
	     System.out.println("Id- "+myResponse.getString("id"));
	     System.out.println("Component- "+myResponse.getString("component"));
	      System.out.println("availability- "+myResponse.getString("availability"));
	     JSONObject outputJson = new JSONObject(response.toString());
	outputJson.put("Id-", outputJson.getString("id"));
	outputJson.put("Component-", outputJson.getString("component"));
	outputJson.put("avaliability-", outputJson.getString("availablity"));*/
		
		return response.toString();
	}
	
	public String assetsProcessing(String data) throws Exception 
	{
		
		
		
		 String url = "https://fetidentitydev.azurewebsites.net/api/UserSitesAssets";
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	     //con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)");
	     //con.setRequestProperty("useerid", "101");
	     con.setRequestProperty("Origin", "http://localhost");
	     con.setRequestProperty("Referer", "http://localhost/FET_Identity_Usage_Example/index.html");
	     //con.setRequestProperty("useerid", "101");
	     con.setRequestProperty("Authorization",data);
	     int responseCode = con.getResponseCode();
	     System.out.println("\nSending 'GET' request to URL : " + url);
	     System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer  response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     //print in String
	   /*JSONObject myResponse = new JSONObject(response.toString());
	     System.out.println("result after Reading JSON Response");
	     System.out.println("Id- "+myResponse.getString("id"));
	     System.out.println("Component- "+myResponse.getString("component"));
	      System.out.println("availability- "+myResponse.getString("availability"));
	     JSONObject outputJson = new JSONObject(response.toString());
	outputJson.put("Id-", outputJson.getString("id"));
	outputJson.put("Component-", outputJson.getString("component"));
	outputJson.put("avaliability-", outputJson.getString("availablity"));*/
		
		return response.toString();
	}
	
	public String geodataProcessing(String data) throws Exception 
	{
		
		
		
		 String url = "http://104.210.222.134:8080/forumenergy/assetGroups/geographicData";
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	     //con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)");
	     con.setRequestProperty("userId", "101");
	     con.setRequestProperty("", "");
	     con.setRequestProperty("Origin", "http://localhost");
	     con.setRequestProperty("Referer", "http://localhost/FET_Identity_Usage_Example/index.html");
	     
	     con.setRequestProperty("Authorization",data);
	     int responseCode = con.getResponseCode();
	     System.out.println("\nSending 'GET' request to URL : " + url);
	     System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer  response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     //print in String
	   /*JSONObject myResponse = new JSONObject(response.toString());
	     System.out.println("result after Reading JSON Response");
	     System.out.println("Id- "+myResponse.getString("id"));
	     System.out.println("Component- "+myResponse.getString("component"));
	      System.out.println("availability- "+myResponse.getString("availability"));
	     JSONObject outputJson = new JSONObject(response.toString());
	outputJson.put("Id-", outputJson.getString("id"));
	outputJson.put("Component-", outputJson.getString("component"));
	outputJson.put("avaliability-", outputJson.getString("availablity"));*/
		
		return response.toString();
	}
	
	
	

}
