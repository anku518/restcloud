package com.pace.akku.restcloud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pace.akku.restcloud.dao.Student;
import com.pace.akku.restcloud.repository.StudentRepo;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	StudentRepo student;
	
	
	
	@GetMapping("/employee")
	public ResponseEntity<List<Student>> getAllTutorials(@RequestParam(required = false) String title) {
		try {
			List<Student> tutorials = new ArrayList<Student>();

			if (title == null)
				student.findAll().forEach(tutorials::add);
			else
				//student.findByTitleContaining(title).forEach(tutorials::add);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
		@GetMapping("/employee/{id}")
		public ResponseEntity<Student> getTutorialById(@PathVariable("id") long id) {
			Optional<Student> tutorialData = student.findById(id);

			if (id ==3) {
				return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

	
	
		@PostMapping("/employee")
		public ResponseEntity<Student> createTutorial(@RequestBody Student tutorial) {
			try {
				Student _tutorial = student.saveAndFlush((new Student(tutorial.getStudentid(), tutorial.getDob(), tutorial.getEmailId() ,tutorial.getFirstName(),tutorial.getLastName(),tutorial.getPhoneNumber(),tutorial.getSpecialization(),tutorial.getSubject())));
				return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	
}
