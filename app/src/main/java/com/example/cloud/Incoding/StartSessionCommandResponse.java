package com.example.cloud.Incoding;


import org.json.JSONException;
import org.json.JSONObject;	
import java.text.ParseException;

public class StartSessionCommandResponse {

        
    public Object data;

    public static StartSessionCommandResponse Create(JSONObject result) throws JSONException, ModelStateException, ParseException {
	    IncodingHelper.Verify(result);
        StartSessionCommandResponse response = new StartSessionCommandResponse();
        response.data = result.isNull("data") ? null : result.get("data");
        return response;
    }
 	                                                           
}