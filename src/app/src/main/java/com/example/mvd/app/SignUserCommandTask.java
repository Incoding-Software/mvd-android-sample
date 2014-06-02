package com.example.mvd.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class SignUserCommandTask extends AsyncTask<String, Integer, String> {

    private Context context;

    private ISignUserCommandListener listener;

    private SignUserCommandRequest request ;
	
    public SignUserCommandTask(Context context, SignUserCommandRequest request ) {    
	  this.context= context;
	  	  this.request = request;    
	      }
		
	@Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            listener.Success( SignUserCommandResponse.Create(new JSONObject(s)) );
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

    public void On(ISignUserCommandListener on)
    {
        listener = on;
        execute();
    }
}