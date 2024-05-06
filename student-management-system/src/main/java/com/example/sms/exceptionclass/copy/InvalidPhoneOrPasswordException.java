package com.example.sms.exceptionclass.copy;

public class InvalidPhoneOrPasswordException extends RuntimeException{
	@Override
	public String getMessage()
	{
		return "Invalid Credentials, i.e.. Invalid Phone Number or Passeord exception";
	}

}
