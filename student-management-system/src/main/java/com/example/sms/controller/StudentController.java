package com.example.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.dto.Student;
import com.example.sms.responsestructure.copy.ResponseStructure;
import com.example.sms.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value="/welcome")
	public String home()
	{
		return "welcome from homes";
	}

	@PostMapping(value="/student")
	public ResponseEntity<ResponseStructure<Student>>saveStudent(@RequestBody Student student)
	{
		return studentService.saveStudent(student);
	}
	
	@PutMapping(value="/student")
	public ResponseEntity<ResponseStructure<Student>>updateStudent(@RequestBody Student student)
	{
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping(value="/student/{id}")
	public ResponseEntity<ResponseStructure<String>>deleteStudent(@PathVariable int id)
	{
		return studentService.deleteStudent(id);
	}
	
	@GetMapping(value = "/student/{id}")
	public ResponseEntity<ResponseStructure<Student>> findStudent(@PathVariable int id) {
		return studentService.findStudentById(id);
	}
	
	@GetMapping(value = "/student/{phone}/{password}")
	public ResponseEntity<ResponseStructure<Student>> findStudentByPhoneAndPassword(@PathVariable long phone,
			@PathVariable String password) {
		return studentService.findStudentbyPhoneAndPassword(phone, password);
	}
	
	@GetMapping(value = "/student")
	public ResponseEntity<ResponseStructure<Student>> findStuidentByEmailAndPassword(@RequestParam String email,
			String password) {
		return studentService.findStudentbyEmailAndPassword(email, password);
	}

	@GetMapping(value = "/student/all")
	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudent() {
		return studentService.findAllStudents();
	}
}
