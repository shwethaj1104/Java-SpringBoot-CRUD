package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
//	below is same as 
//	@Query("SELECT s FROM Student s WHERE s.email=?1")
	
	Optional<Student> findByEmail(String email);
}
