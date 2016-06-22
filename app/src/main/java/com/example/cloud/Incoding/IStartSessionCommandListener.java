package com.example.cloud.Incoding;


public interface IStartSessionCommandListener {
	void Success(StartSessionCommandResponse response);	
	void Error(JsonModelStateData[] modelState);
}