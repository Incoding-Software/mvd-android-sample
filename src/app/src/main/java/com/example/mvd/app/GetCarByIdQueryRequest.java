package com.example.mvd.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.IOException;

public class GetCarByIdQueryRequest {

    public String Id;
     

   public HttpResponse execute(Context context) throws IOException {   
     SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
	    	        
		        String uri = String.format("http://mvd-endpoint.incframework.com/Dispatcher/Query?incType=GetCarByIdQuery&Id=%s" ,this.Id ); 
                
	    HttpGet http = new HttpGet(uri);		            
                 
        http.setHeader("Set-Cookie", preferences.getString("Set-Cookie", "Set-Cookie"));
        HttpResponse response = new DefaultHttpClient().execute(http);
		Header cookieAsHeader = response.getFirstHeader("Set-Cookie");
        if (cookieAsHeader != null) {
		    SharedPreferences.Editor edit = preferences.edit();
            edit.putString(cookieAsHeader.getName(), cookieAsHeader.getValue());
            edit.commit();
        }

        return response;
   } 
                                         
}