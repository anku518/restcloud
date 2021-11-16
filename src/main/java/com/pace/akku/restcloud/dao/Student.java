package com.pace.akku.restcloud.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long studentid;
	@Column(name = "firstName")
	String firstName;
	@Column(name = "lastName")
	String lastName;
	@Column(name = "emailId")
	String emailId;
	String dob;
	@Column(name = "subject")
	String subject;
	@Column(name = "specialization")
	String specialization;
	@Column(name = "phoneNumber")
	String phoneNumber;
	public long getStudentid() {
		return studentid;
	}
	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Student(long studentid, String firstName, String lastName, String emailId, String dob, String subject,
			String specialization, String phoneNumber) {
		super();
		this.studentid = studentid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.dob = dob;
		this.subject = subject;
		this.specialization = specialization;
		this.phoneNumber = phoneNumber;
	}
	public Student() {
		
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", dob=" + dob + ", subject=" + subject + ", specialization=" + specialization
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	

	
	
	

}
