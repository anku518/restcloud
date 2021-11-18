package com.pace.akku.restcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pace.akku.restcloud.dao.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	
	

}
