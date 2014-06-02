package com.example.mvd.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignUserCommandRequest {

    public String UserName;
    public String Password;
     

   public HttpResponse execute(Context context) throws IOException {   
     SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
	     	        	    
        HttpPost http = new HttpPost("http://bmapp.incoding.biz/Dispatcher/Push?incType=SignUserCommand");		        
        http.setHeader("Content-Type", "application/x-www-form-urlencoded");				
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        		parameters.add(new BasicNameValuePair("UserName", String.valueOf(this.UserName)));
				parameters.add(new BasicNameValuePair("Password", String.valueOf(this.Password)));
		        http.setEntity(new UrlEncodedFormEntity(parameters, HTTP.UTF_8));		
                 
        http.setHeader("Set-Cookie", preferences.getString("Set-Cookie", "Set-Cookie"));
		http.setHeader("X-Requested-With" , "XMLHttpRequest");
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