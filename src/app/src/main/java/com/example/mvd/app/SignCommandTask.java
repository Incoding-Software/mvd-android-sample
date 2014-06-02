package com.example.mvd.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class SignCommandTask extends AsyncTask<String, Integer, String> {

    private Context context;

    private ISignCommandListener listener;

    private SignCommandRequest request ;
	
    public SignCommandTask(Context context, SignCommandRequest request ) {    
	  this.context= context;
	  	  this.request = request;    
	      }
		
	@Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            listener.Success( Object.Create(new JSONObject(s)) );
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

    public void On(ISignCommandListener on)
    {
        listener = on;
        execute();
    }
}