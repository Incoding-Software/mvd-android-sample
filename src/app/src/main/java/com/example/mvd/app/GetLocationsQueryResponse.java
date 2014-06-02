package com.example.mvd.app;

import org.json.JSONException;
import org.json.JSONObject;	


   import org.json.JSONArray;
	  
public class GetLocationsQueryResponse {
        public String Id;
        public String Name;
            
         public static GetLocationsQueryResponse[] Create(JSONObject result) throws JSONException, ModelStateException  {     
		     IncodingHelper.Verify(result);
			 if(result.isNull("data"))
               return new  GetLocationsQueryResponse[0];

		             JSONArray data = result.getJSONArray("data");
     		 int length = data.length();
             GetLocationsQueryResponse[] res = new GetLocationsQueryResponse[length];
             for (int i = 0; i < length; i++) {
                 JSONObject item = data.getJSONObject(i);		  
                 GetLocationsQueryResponse response = new GetLocationsQueryResponse();
                             response.Id = item.getString("Id");
                             response.Name = item.getString("Name");
                  
                 res[i] = response;
             }	    
     		return res;   
	      
         }   

 	                                                           
}