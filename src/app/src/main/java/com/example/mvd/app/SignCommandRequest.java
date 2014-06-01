package com.example.mvd.app;

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

public class SignCommandRequest {

    public String Id;
     
      public HttpResponse execute() throws IOException {        	        
        HttpPost http = new HttpPost("http://mvd-endpoint.incframework.com/Dispatcher/Push?incType=SignCommand");		        
        http.setHeader("Content-Type", "application/x-www-form-urlencoded");
		        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        		parameters.add(new BasicNameValuePair("Id", String.valueOf(this.Id)));
		        http.setEntity(new UrlEncodedFormEntity(parameters, HTTP.UTF_8));
		        return new DefaultHttpClient().execute(http);
   } 
                                                        
}