package com.qadr.sms.service;


import com.qadr.sms.entity.Student;

import java.util.List;

/**
 * Controller relies on the service layer,
 * this gives the blueprint of what actions are allowed by the student controller
 * */
public interface StudentService {
	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentById(long id);
	void updateStudent (Student student);
	void deleteStudent (Student student);
}
