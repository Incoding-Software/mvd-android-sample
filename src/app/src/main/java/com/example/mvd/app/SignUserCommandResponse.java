package com.example.mvd.app;

import org.json.JSONException;
import org.json.JSONObject;	


     
public class SignUserCommandResponse {
    public Object data;

    public static SignUserCommandResponse Create(JSONObject result) throws JSONException, ModelStateException {
	    IncodingHelper.Verify(result);
        SignUserCommandResponse response = new SignUserCommandResponse();
        response.data = result.isNull("data") ? null : result.get("data");
        return response;
    }
 	                                                           
}