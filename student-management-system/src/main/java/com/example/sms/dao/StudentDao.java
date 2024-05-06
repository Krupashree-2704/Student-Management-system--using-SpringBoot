package com.example.sms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sms.dto.Student;
import com.example.sms.repository.StudentRepository;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public Optional<Student> findStudentById(int id)
	{
		return studentRepository.findById(id);
	}
	
	public void deleteStudent(int id)
	{
		studentRepository.deleteById(id);
	}
	public Student findStudentByPhoneAndPassword(long phone,String password)
	{
		return studentRepository.findByPhoneAndPassword(phone,password);
	}
	public Student findByEmailAndPassword(String email,String password)
	{
		return studentRepository.findByEmailAndPassword(email,password);
	}
	public List<Student> findAllStudents()
	{
		return studentRepository.findAll();
	}

}
