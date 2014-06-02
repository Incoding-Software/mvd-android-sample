package com.example.mvd.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class GetLocationsQueryTask extends AsyncTask<String, Integer, String> {

    private Context context;

    private IGetLocationsQueryListener listener;

    private GetLocationsQueryRequest request  = new GetLocationsQueryRequest() ;
	
    public GetLocationsQueryTask(Context context) {    
	  this.context= context;
	      }
		
	@Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            listener.Success( GetLocationsQueryResponse.Create(new JSONObject(s)) );
        } catch (Exception e) {
            e.printStackTrace();
        } catch (ModelStateException e) {
            listener.Error(e.getState());
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

    public void On(IGetLocationsQueryListener on)
    {
        listener = on;
        execute();
    }
}