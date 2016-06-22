package com.example.cloud.Incoding;

import org.json.JSONObject;
import android.content.Context;
import android.os.AsyncTask;

import java.util.HashMap;

public class StartSessionCommandRequest extends AsyncTask<String, Integer, String> {

        public String Description;
        public java.util.Date StartDate;
       

   public java.util.HashMap<String, Object> GetParameters(Integer index) {
	java.util.HashMap<String, Object> parameters = new java.util.HashMap<String, Object>();	
	parameters.put("incTypes","Push");
		 if (this.Description != null)     parameters.put(index == -1 ? "Description" : String.format("[%s].Description", index),this.Description);
    	    parameters.put(index == -1 ? "StartDate" : String.format("[%s].StartDate", index),this.StartDate);
       
	return parameters;
   } 

    private Context context;

    private IStartSessionCommandListener listener;
    	
	public StartSessionCommandRequest(Context context) {
		this.context = context;		
	}
		
	@Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            listener.Success( StartSessionCommandResponse.Create(new JSONObject(s)) );
        } catch (Exception e) {
            e.printStackTrace();
        } catch (ModelStateException e) {
            listener.Error(e.getState());
        }
    }

	@Override
    protected String doInBackground(String... strings) {
        try {
		   
		    HashMap<String, Object> params = new HashMap<String, Object>();			
			String type = "Push";

            return IncodingHelper.Execute(context, true, type, params);
			        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void On(IStartSessionCommandListener on)
    {
        listener = on;
        execute();
    }


}