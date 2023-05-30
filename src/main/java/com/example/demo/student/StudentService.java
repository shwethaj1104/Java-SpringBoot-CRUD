package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	
private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
		
	public List<Student> getStudents() {
		return  studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());
		if(studentOptional.isPresent()) {
			throw new IllegalStateException("Email already exist");
		}
		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
		Boolean exist =  studentRepository.existsById(studentId);
		if(!exist) {
			throw new IllegalStateException("Student with ID " +studentId + " does not exist");
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long studentId, Student student) {
		Student student1 = studentRepository.findById(studentId)
				.orElseThrow(()->new IllegalStateException("Student with ID " +studentId + " does not exist")
		);
		if(student.getName() != null && student.getName().length() > 0 && !Objects.equals(student1.getName(), student.getName())) {
			student1.setName(student.getName());
		}
		if(student.getEmail() != null && student.getEmail().length() > 0 && !Objects.equals(student1.getEmail(), student.getEmail())) {
			Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());
			if(studentOptional.isPresent()) {
				throw new IllegalStateException("Email already exist");
			}
			
			student1.setEmail(student.getEmail());
		}
	}
}
