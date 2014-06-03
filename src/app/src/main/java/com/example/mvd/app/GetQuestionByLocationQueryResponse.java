package com.example.mvd.app;

import org.json.JSONException;
import org.json.JSONObject;	


   import org.json.JSONArray;
	  
public class GetQuestionByLocationQueryResponse {
        public String Id;
        public String Title;
        public Question_OfType Type;
            
         public static GetQuestionByLocationQueryResponse[] Create(JSONObject result) throws JSONException, ModelStateException  {     
		     IncodingHelper.Verify(result);
			 if(result.isNull("data"))
               return new  GetQuestionByLocationQueryResponse[0];

		             JSONArray data = result.getJSONArray("data");
     		 int length = data.length();
             GetQuestionByLocationQueryResponse[] res = new GetQuestionByLocationQueryResponse[length];
             for (int i = 0; i < length; i++) {
                 JSONObject item = data.getJSONObject(i);		  
                 GetQuestionByLocationQueryResponse response = new GetQuestionByLocationQueryResponse();
                                     			    response.Id = item.getString("Id");
			                                             			    response.Title = item.getString("Title");
			                                             			    response.Type = Question_OfType.valueOf(item.getInt("Type"));
			                          
                 res[i] = response;
             }	    
     		return res;   
	      
         }   

 	                                                           
}