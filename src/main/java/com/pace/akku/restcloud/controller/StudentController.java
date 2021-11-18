package com.pace.akku.restcloud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class StudentController {

	@Autowired
	StudentRepo student;

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required = false) String title) {
		try {
			List<Student> information = new ArrayList<Student>();

			if (title == null)
				student.findAll().forEach(information::add);
			else

			if (information.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(information, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
		Optional<Student> data = student.findById(id);

		if (data == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(data.get(), HttpStatus.OK);
		}
	}

	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody Student std) {
		try {
			Student _info = student
					.saveAndFlush((new Student(std.getStudentid(), std.getDob(), std.getEmailId(), std.getFirstName(),
							std.getLastName(), std.getPhoneNumber(), std.getSpecialization(), std.getSubject())));
			return new ResponseEntity<>(_info, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/deleteStudents/{id}")
	public String deleteStudent(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.student.deleteById(id);
		return "redirect:/";
	}
}
