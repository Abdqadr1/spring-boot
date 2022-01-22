package com.qadr.sms.service;


import com.qadr.sms.entity.Student;

import java.util.List;

public interface StudentService {
	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentById(long id);
	void updateStudent (Student student);
	void deleteStudent (Student student);
}
