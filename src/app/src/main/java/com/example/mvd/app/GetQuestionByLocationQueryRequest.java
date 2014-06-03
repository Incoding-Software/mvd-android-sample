package com.example.mvd.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.IOException;

public class GetQuestionByLocationQueryRequest {

    public String LocationId;
     

   public HttpResponse execute(Context context) throws IOException {   
     SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
	    	        
		        String uri = String.format("http://bmapp.incoding.biz/Dispatcher/Query?incType=GetQuestionByLocationQuery&LocationId=%s" ,this.LocationId ); 
                
	    HttpGet http = new HttpGet(uri);		            
                 
        http.setHeader("Cookie", preferences.getString("Set-Cookie", "Set-Cookie"));
		http.setHeader("X-Requested-With" , "XMLHttpRequest");
        HttpResponse response = new DefaultHttpClient().execute(http);
		Header[] cookies = response.getHeaders("Set-Cookie");
        if (cookies != null) {
		    SharedPreferences.Editor edit = preferences.edit();
            String combineCookie = "";
            for (Header header : cookies)
                combineCookie += header.getValue() + ";";
            edit.putString("Set-Cookie", combineCookie);
            edit.commit();
        }

        return response;
   } 
                                         
}