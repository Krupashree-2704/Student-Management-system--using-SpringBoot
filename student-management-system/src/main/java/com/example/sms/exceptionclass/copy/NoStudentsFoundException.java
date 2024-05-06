package com.example.sms.exceptionclass.copy;

public class NoStudentsFoundException extends RuntimeException{

	@Override
	public String getMessage()
	{
		return "No student are Present In Database, Database is Empty";
	}
}
