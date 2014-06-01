package com.example.mvd.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class GetCarByIdQueryTask extends AsyncTask<String, Integer, String> {

    private Context context;

    private IGetCarByIdQueryListener listener;

    private GetCarByIdQueryRequest request  = new GetCarByIdQueryRequest() ;
	
    public GetCarByIdQueryTask(Context context, GetCarByIdQueryRequest request ) {    
	  this.context= context;
	  	  this.request = request;    
	      }
	
	
	@Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONObject data = jsonObject.isNull("data")
                    ? new JSONObject()
                    : new JSONObject(jsonObject.getString("data"));            
			listener.Success( GetCarByIdQueryResponse.Create(data) );									
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

    public void On(IGetCarByIdQueryListener on)
    {
        listener = on;
        execute();
    }
}