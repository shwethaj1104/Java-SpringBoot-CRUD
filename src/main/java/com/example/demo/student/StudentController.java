package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService=studentService;
		/*
		 * // creating new instance of StudentService manually, but in spring boot we
		 * have annotations and // dependency injection for that so that we are doing
		 * inversion of control to spring boot // this.studentService= new
		 * StudentService();
		 */	}
	
	@GetMapping
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		 studentService.addNewStudent(student);
	}
	
	@DeleteMapping("{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		 studentService.deleteStudent(studentId);
	}
	
	@PutMapping("{studentId}")
	public void updateStudent(@PathVariable("studentId") Long studentId,
			@RequestBody Student student) {
		 studentService.updateStudent(studentId,student);
	}
}
