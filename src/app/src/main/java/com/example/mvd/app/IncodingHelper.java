package com.example.mvd.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IncodingHelper
{
    public static void Verify(JSONObject result) throws JSONException, ModelStateException {
        if (!result.getBoolean("success")) {
            JSONArray errors = result.isNull("data") ? new JSONArray() : result.getJSONArray("data");
            JsonModelStateData[] state = new JsonModelStateData[errors.length()];
            for (int i = 0; i < errors.length(); i++) {
                JSONObject itemError = errors.getJSONObject(i);
                JsonModelStateData jsonModelStateData = new JsonModelStateData();
                jsonModelStateData.errorMessage = itemError.getString("errorMessage");
                jsonModelStateData.isValid = itemError.getBoolean("isValid");
                jsonModelStateData.name = itemError.getString("name");
                state[i] = jsonModelStateData;
            }
            throw new ModelStateException(state);
        }
    }
}