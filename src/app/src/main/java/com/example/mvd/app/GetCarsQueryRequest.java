package com.example.mvd.app;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class GetCarsQueryRequest {

     
     public HttpResponse execute() throws IOException {
				String uri = "http://mvd-endpoint.incframework.com/Dispatcher/Query?incType=GetCarsQuery";
                HttpGet http = new HttpGet(uri);
        return new DefaultHttpClient().execute(http);
    }
                                                        
}