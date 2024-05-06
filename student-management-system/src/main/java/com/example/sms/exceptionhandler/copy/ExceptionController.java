package com.example.sms.exceptionhandler.copy;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.sms.exceptionclass.copy.IdNotFoundException;
import com.example.sms.exceptionclass.copy.InvalidEmailOrPasswordException;
import com.example.sms.exceptionclass.copy.InvalidPhoneOrPasswordException;
import com.example.sms.exceptionclass.copy.NoStudentsFoundException;
import com.example.sms.responsestructure.copy.ResponseStructure;

@RestControllerAdvice
public class ExceptionController {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException idNotFoundException)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.NO_CONTENT.value());
		structure.setMessage("Invalid Student ID");
		structure.setBody(idNotFoundException.getMessage());
		return new ResponseEntity<>(structure,HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(InvalidEmailOrPasswordException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidEmailOrPasswordException(InvalidEmailOrPasswordException invalidEmailOrPasswordException)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.NO_CONTENT.value());
		structure.setMessage("Invalid Student Emil Or Password....");
		structure.setBody(invalidEmailOrPasswordException.getMessage());
		return new ResponseEntity<>(structure,HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(InvalidPhoneOrPasswordException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidPhoneOrPasswordException(InvalidPhoneOrPasswordException invalidPhoneOrPasswordException)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.NO_CONTENT.value());
		structure.setMessage("Invalid Student Phone Or Password....");
		structure.setBody(invalidPhoneOrPasswordException.getMessage());
		return new ResponseEntity<>(structure,HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(NoStudentsFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handlerNoStudentsFoundException(NoStudentsFoundException noStudentsFoundException)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.NO_CONTENT.value());
		structure.setMessage("Invalid Student Phone Or Password....");
		structure.setBody(noStudentsFoundException.getMessage());
		return new ResponseEntity<>(structure,HttpStatus.NO_CONTENT);
	}

}
