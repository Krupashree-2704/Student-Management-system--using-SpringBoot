package com.example.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByPhoneAndPassword(long phone, String password);

	Student findByEmailAndPassword(String email, String password);

}
