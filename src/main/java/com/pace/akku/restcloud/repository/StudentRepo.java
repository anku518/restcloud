package com.pace.akku.restcloud.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pace.akku.restcloud.dao.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	
	
	Student  findByid(long id);
	
	List<String> findbyname(String name);
	
	Student  addNewStudent(long studentid, String firstName, String lastName, String emailId, Date dob, List<String> subject,
			String specialization, String phoneNumber );
	
	
	Student deleteStudentByid(long id);
	
	
	void deleteListStudent(List<Student> student);
	
	Student updateStudent(Student student);
	

}
