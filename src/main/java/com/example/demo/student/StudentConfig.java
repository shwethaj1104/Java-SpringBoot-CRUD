package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args->{
			Student Shwetha = new Student(
					"Shwetha",
					"Shwetha@gmail.com",
					LocalDate.of(2000, Month.APRIL, 2)
					);
			Student Jayaram = new Student(
					"Jayaram",
					"Jayaram@gmail.com",
					LocalDate.of(1960, Month.JANUARY, 25)
					);
			studentRepository.saveAll(
					List.of(Shwetha,Jayaram));
		};
	}
	
}
