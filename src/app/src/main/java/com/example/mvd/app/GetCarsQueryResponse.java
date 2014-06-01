package com.example.mvd.app;

import org.json.JSONException;
import org.json.JSONObject;	
   import org.json.JSONArray;
	  
public class GetCarsQueryResponse {
        public String Brand;
        public String Model;
        public int Seating;
        public String Id;
            
             public static GetCarsQueryResponse[] Create(JSONObject result) throws JSONException {     
		     if(result.isNull("data"))
               return new  GetCarsQueryResponse[0];

             JSONArray data = result.getJSONArray("data");
     		 int length = data.length();
             GetCarsQueryResponse[] res = new GetCarsQueryResponse[length];
             for (int i = 0; i < length; i++) {
                 JSONObject item = data.getJSONObject(i);		  
                 GetCarsQueryResponse response = new GetCarsQueryResponse();
                             response.Brand = item.getString("Brand");
                             response.Model = item.getString("Model");
                             response.Seating = item.getInt("Seating");
                             response.Id = item.getString("Id");
                  
                 res[i] = response;
             }	    
     		return res;     
         } 
       	                                                           
}