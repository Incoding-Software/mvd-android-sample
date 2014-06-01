package com.example.mvd.app;

import org.json.JSONException;
import org.json.JSONObject;	

public class GetCarByIdQueryResponse {

      public String Brand;
    public String Model;
    public int Seating;
    public String Id;
      
    public static GetCarByIdQueryResponse Create(JSONObject data) throws JSONException { 
    	GetCarByIdQueryResponse result = new GetCarByIdQueryResponse();
    result.Brand = data.getString("Brand");
    result.Model = data.getString("Model");
    result.Seating = data.getInt("Seating");
    result.Id = data.getString("Id");
   
    return result;  
	  }              
                                                     
}