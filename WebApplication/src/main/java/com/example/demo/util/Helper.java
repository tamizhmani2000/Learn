package com.example.demo.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.springframework.boot.json.*;
import com.fasterxml.jackson.*;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Helper {
	
	
	private static void ReadFileContent(String file) {
		
		BufferedReader br = null;
		try 
			{
			//br = new BufferedReader(new FileReader(file));
		br = new BufferedReader(
		              new InputStreamReader(
		                         new FileInputStream(file), "UTF8"));
		    String line;
		    int length = 0;
		    String lasttwo;
		    while ((line = br.readLine()) != null) {
		    	if (null!=line && line.length()>4) {
		    		 // System.out.println(line);
		    		lasttwo = line.substring(line.length()-3,line.length()-1);
		    		if (lasttwo.indexOf("$$")>-1) 
		    			length = line.length()-3;
		    		else if(lasttwo.indexOf("$")>-1)
		    			length = line.length()-2;
		    		else
		    			length = line.length()-1;
		    	
		    		//System.out.println(lasttwo);
		    		line = line.substring(6, length);
			    	  //System.out.println(line);
			    	  String UTF8 = new String((Base64.getDecoder().decode(line.getBytes("UTF-8"))),"UTF-8");
			    	  //System.out.println(UTF8);
			    	  
			    	
			    	JsonFactory jFactory = new JsonFactory();
			    	com.fasterxml.jackson.core.JsonParser  jp = (com.fasterxml.jackson.core.JsonParser) jFactory.createJsonParser(UTF8);
			   
			    	ObjectMapper mapper = new ObjectMapper();
			    	JsonNode jsonObject = mapper.readTree(jp);
			    	String cardNumber;
			    	String cardCin;
			    	int numberOfGiftCards = 0;
			    	if (null!=jsonObject) {
				    	 numberOfGiftCards = jsonObject.path("PaymentEditGiftCardValueReq").get("giftCards").get("GiftCard").size();
			    	}
			    	for (int i=0;i<numberOfGiftCards;i++){
			    		cardNumber=jsonObject.path("PaymentEditGiftCardValueReq").get("giftCards").get("GiftCard").get(0).get("cardNumber").asText();
			    		cardCin = jsonObject.path("PaymentEditGiftCardValueReq").get("giftCards").get("GiftCard").get(0).get("cardCIN").asText();
			    		System.out.println(cardNumber +"    "+ cardCin);
			    	}
			    	
			    
			    	  
		    	}
		    }
		    
	
		    br.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			br=null;

		}
	}
	
	public static void main(String[] args ) {
		
		ReadFileContent("/Users/ctsuser1/Downloads/splunk2.csv");	

		
	}
	
}