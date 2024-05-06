package com.example.sms.exceptionclass.copy;

public class IdNotFoundException extends RuntimeException{
	@Override
	public String getMessage()
	{
		return "Invalid student ID ,student with this id is not present in database!!!";
	}
}
