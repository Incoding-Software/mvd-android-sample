package com.example.mvd.app;

public interface ISignUserCommandListener {
	void Success(SignUserCommandResponse response);	
	void Error(JsonModelStateData[] modelState);
}