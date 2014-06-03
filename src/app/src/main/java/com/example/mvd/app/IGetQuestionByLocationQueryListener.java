package com.example.mvd.app;

public interface IGetQuestionByLocationQueryListener {
	void Success(GetQuestionByLocationQueryResponse[] response);	
	void Error(JsonModelStateData[] modelState);
}