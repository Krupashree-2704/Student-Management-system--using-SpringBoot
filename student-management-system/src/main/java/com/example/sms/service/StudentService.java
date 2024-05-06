package com.example.sms.service;

import java.sql.Struct;
import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.entry.StructuredCacheEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.sms.dao.StudentDao;
import com.example.sms.dto.Student;
import com.example.sms.exceptionclass.copy.IdNotFoundException;
import com.example.sms.exceptionclass.copy.InvalidEmailOrPasswordException;
import com.example.sms.exceptionclass.copy.InvalidPhoneOrPasswordException;
import com.example.sms.exceptionclass.copy.NoStudentsFoundException;
import com.example.sms.responsestructure.copy.ResponseStructure;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao dao;
	
	public ResponseEntity<ResponseStructure<Student>>saveStudent(Student student)
	{
		Student dbstudent = dao.saveStudent(student);
		ResponseStructure<Student> structure=new ResponseStructure<Student>();
		if(dbstudent!=null) {
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Student Saved Successfully....");
			structure.setBody(dbstudent);
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);	
		}
		structure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		structure.setMessage("Can't save student.....");
		structure.setBody(null);
		return new ResponseEntity<>(structure,HttpStatus.NOT_ACCEPTABLE);
		
	}

	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student) {
		// TODO Auto-generated method stub
		Student dbstudent = dao.updateStudent(student);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (dbstudent!=null) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Student Updated Sucessfully....");
			structure.setBody(dbstudent);
			return new ResponseEntity<>(structure,HttpStatus.OK);
		}
		structure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		structure.setMessage("Can't update Student...");
		structure.setBody(null);
		return new ResponseEntity<>(structure,HttpStatus.NOT_ACCEPTABLE);
	}
	
	public ResponseEntity<ResponseStructure<Student>>findStudentById(int id)
	{
		Optional<Student> dbstudent = dao.findStudentById(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (!dbstudent.isPresent()) {
			throw new IdNotFoundException();
		}
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Student Found Successfully....");
		structure.setBody(dbstudent.get());
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteStudent(int id)
	{
		Optional<Student> dbstudent = dao.findStudentById(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (!dbstudent.isPresent()) {
			throw new IdNotFoundException();
		}
		dao.deleteStudent(id);
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Student Deleted Successfully");
		structure.setBody("Given Student Id Record deleted Successfully...");
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Student>> findStudentbyPhoneAndPassword(long phone,String password)
	{
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		Student dbstudent = dao.findStudentByPhoneAndPassword(phone, password);
		if (dbstudent==null) {
			throw new InvalidPhoneOrPasswordException();
		}
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Student Found Successfully....");
		structure.setBody(dbstudent);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Student>> findStudentbyEmailAndPassword(String email,String password)
	{
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		Student dbstudent = dao.findByEmailAndPassword(email, password);
		if(dbstudent==null)
			throw new InvalidEmailOrPasswordException();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Student Found Successfully");
		structure.setBody(dbstudent);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudents()
	{
		List<Student> students = dao.findAllStudents();
		if (students.isEmpty()) {
			throw new NoStudentsFoundException();
		}
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("All Students are fetched from database Successfully....");
		structure.setBody(students);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
}
