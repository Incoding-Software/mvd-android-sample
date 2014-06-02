package com.example.mvd.app;

public interface IGetLocationsQueryListener {
	void Success(GetLocationsQueryResponse[] response);	
	void Error(JsonModelStateData[] modelState);
}