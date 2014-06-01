package com.example.mvd.app;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.IOException;

public class GetCarByIdQueryRequest {

    public String Id;
     
     public HttpResponse execute() throws IOException {
		String uri = String.format("http://mvd-endpoint.incframework.com/Dispatcher/Query?incType=GetCarByIdQuery&Id=%s" ,this.Id ); 
        		        HttpGet http = new HttpGet(uri);
        return new DefaultHttpClient().execute(http);
    }
                                                        
}