package com.example.mvd.app;

import org.json.JSONException;
import org.json.JSONObject;	
     
public class GetCarByIdQueryResponse {
        public String Brand;
        public String Model;
        public int Seating;
        public String Id;
            
    	     public static GetCarByIdQueryResponse Create(JSONObject result) throws JSONException { 
		     if(result.isNull("data"))
			  return  new GetCarByIdQueryResponse();

		     JSONObject data = new JSONObject(result.getString("data"));    
	         GetCarByIdQueryResponse res = new GetCarByIdQueryResponse();
                          res.Brand = data.getString("Brand");
                          res.Model = data.getString("Model");
                          res.Seating = data.getInt("Seating");
                          res.Id = data.getString("Id");
              
		     return res;       
		  }     
	   	                                                           
}