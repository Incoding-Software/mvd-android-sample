package com.example.mvd.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.preference.PreferenceManager;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class GetCarsQueryTask extends AsyncTask<String, Integer, String> {

    private Context context;

    private IGetCarsQueryListener listener;

    private GetCarsQueryRequest request  = new GetCarsQueryRequest() ;
	
    public GetCarsQueryTask(Context context) {    
	  this.context= context;
	      }
		
	@Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            listener.Success( GetCarsQueryResponse.Create(new JSONObject(s)) );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
    protected String doInBackground(String... strings) {
        try {
            HttpResponse response = request.execute(context);            
            return EntityUtils.toString(response.getEntity());            
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