package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;


public class CaptchaValidationService  {
  
  private boolean enabled;
  private String apiRequestURL;
  private String siteKey;
  private String secret="6LcJeRgUAAAAAPzTybgpHmL2G703wRBvVWvSRas7";
  private static final String CHARSET = "UTF-8";
  private String captchaError;
  private String captchaSuccess;
  private String captchaOrderReviewError;
  
  
  private static CaptchaValidationService instance;
  
  public synchronized static CaptchaValidationService getInstance() {
    if (null == instance) {
      instance = new CaptchaValidationService();
    }
    return instance;
  }
  
  /**
   * @return the enabled
   */
  public boolean isEnabled() {
    return enabled;
  }

  /**
   * @param enabled the enabled to set
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }  
  
  /**
   * @return the apiRequestURL
   */
  public String getApiRequestURL() {
	  apiRequestURL="https://www.google.com/recaptcha/api/siteverify";
    return apiRequestURL;
  }

  /**
   * @param apiRequestURL the apiRequestURL to set
   */
  public void setApiRequestURL(String apiRequestURL) {
    this.apiRequestURL = apiRequestURL;
  }
  
  /**
   * @return the SiteKey
   */
  public String getSiteKey() {
    return siteKey;
  }

  /**
   * @param siteKey the siteKey to set
   */
  public void setSiteKey(String siteKey) {
    this.siteKey = siteKey;
  }
  
  /**
   * @return the secret
   */
  public String getSecret() {
    return secret;
  }

  /**
   * @param secret the secret to set
   */
  public void setSecret(String secret) {
    this.secret = secret;
  }

  public boolean isValidResponse(String recaptchaResponse){
    boolean validResponse = false;
    String remoteIP="192.168.0.6";
    HttpsURLConnection urlConnection = null;
    InputStream responseStream = null;
    InputStreamReader inputStreamReader = null;
    BufferedReader reader = null;
    try {
      
    	System.out.println("recaptcharesponse:" + recaptchaResponse);
      String queryString = String.format("secret=%s&response=%s&remoteip=%s", URLEncoder.encode(secret, CHARSET), 
              URLEncoder.encode(recaptchaResponse, CHARSET), URLEncoder.encode(remoteIP, CHARSET));
      
      String url = getApiRequestURL() + "?" + queryString;
      

        System.out.println("CaptchaValidationService opening URL connection to: " + url);
      

      urlConnection = (HttpsURLConnection)(new URL(url)).openConnection();
      
      urlConnection.setDoOutput(false);
      urlConnection.setDoInput(true);
      
      responseStream = urlConnection.getInputStream();
      inputStreamReader = new InputStreamReader(responseStream);
      reader = new BufferedReader(inputStreamReader);
      
      String inputLine;
      
      StringBuilder resp = new StringBuilder();
      while ((inputLine = reader.readLine()) != null) {
        resp.append(inputLine);
      }
      
  
    	  System.out.println("CaptchaValidationService reCaptcha API JSON response: " + resp);
      
      
      if (resp != null) {
    	  
    	  System.out.println(resp.toString());
    	  
      
      }
    
    } catch(Exception e){
        e.printStackTrace();
     }
    finally {
      if(reader!=null){
        try {
          reader.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }
      }
      if(inputStreamReader!=null){
        try {
          inputStreamReader.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }
      }
      if(responseStream!=null){
        try {
          responseStream.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }
      }
    }
    
    return validResponse;
  }

public String getCaptchaError() {
	return captchaError;
}

public void setCaptchaError(String captchaError) {
	this.captchaError = captchaError;
}

public String getCaptchaSuccess() {
  return captchaSuccess;
}

public void setCaptchaSuccess(String captchaSuccess) {
  this.captchaSuccess = captchaSuccess;
}

public String getCaptchaOrderReviewError() {
  return captchaOrderReviewError;
}

public void setCaptchaOrderReviewError(String captchaOrderReviewError) {
  this.captchaOrderReviewError = captchaOrderReviewError;
}



}
