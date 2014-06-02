package com.example.mvd.app;

import org.json.JSONException;
import org.json.JSONObject;	


     
public class SignCommandResponse {
    public JSONObject data;

    public static SignCommandResponse Create(JSONObject result) throws JSONException {
        SignCommandResponse response = new SignCommandResponse();
        response.data = result.isNull("data") ? new JSONObject() : new JSONObject(result.getString("data"));
        return response;
    }
 	                                                           
}