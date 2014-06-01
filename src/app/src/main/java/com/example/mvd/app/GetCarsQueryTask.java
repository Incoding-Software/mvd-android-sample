package com.example.mvd.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetCarsQueryTask extends AsyncTask<String, Integer, String> {

    private Context context;

    private IGetCarsQueryListener listener;

    private GetCarsQueryRequest request = new GetCarsQueryRequest();
	
    public GetCarsQueryTask(Context context) {    
	  this.context= context;
	      }
	
	
	@Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray data = jsonObject.isNull("data")
                    ? new JSONArray()
                    : jsonObject.getJSONArray("data");
			listener.Success( GetCarsQueryResponse.Create(data) );									
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
    protected String doInBackground(String... strings) {
        try {
            HttpResponse response = request.execute();
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            for (Header header : response.getHeaders("Set-Cookie")) {
                preferences.edit().putString(header.getName(), header.getValue());
            }
            String json = EntityUtils.toString(response.getEntity());
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void On(IGetCarsQueryListener on)
    {
        listener = on;
        execute();
    }
}