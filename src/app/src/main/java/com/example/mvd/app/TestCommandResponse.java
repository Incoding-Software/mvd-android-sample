package com.example.mvd.app;

import org.json.JSONException;
import org.json.JSONObject;	


     
public class TestCommandResponse {
    public Object data;

    public static TestCommandResponse Create(JSONObject result) throws JSONException {
        TestCommandResponse response = new TestCommandResponse();
        response.data = result.isNull("data") ? null : result.get("data");
        return response;
    }
 	                                                           
}