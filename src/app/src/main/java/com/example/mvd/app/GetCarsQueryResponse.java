package com.example.mvd.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetCarsQueryResponse {

    public String Brand;
    public String Model;
    public int Seating;
    public String Id;

    public static GetCarsQueryResponse[] Create(JSONArray data) throws JSONException {
        int length = data.length();
        GetCarsQueryResponse[] result = new GetCarsQueryResponse[length];
        for (int i = 0; i < length; i++) {
            JSONObject item = data.getJSONObject(i);

            GetCarsQueryResponse response = new GetCarsQueryResponse();
            response.Brand = item.getString("Brand");
            response.Model = item.getString("Model");
            response.Seating = item.getInt("Seating");
            response.Id = item.getString("Id");
            result[i] = response;
        }

        return result;
    }

}