package com.example.sms.exceptionclass.copy;

public class InvalidEmailOrPasswordException extends RuntimeException{
	
	@Override
	public String getMessage()
	{
		return "Invalid credentials, i.e.Invalid Email Or Password";
	}

}
