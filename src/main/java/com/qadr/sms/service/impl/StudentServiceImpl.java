package com.qadr.sms.service.impl;

import java.util.List;

import com.qadr.sms.entity.Student;
import org.springframework.stereotype.Service;
import com.qadr.sms.repository.StudentRepository;
import com.qadr.sms.service.StudentService;

/**
 *  This is the real service layer, and it is annotated with @Service
 * Because our StudentService is an interface, we've to implement it
 * */
@Service
public class StudentServiceImpl implements StudentService {
	private StudentRepository studentRepository;

	/**
	 * Because this spring bean has only one constructor, we don't need @Autowired annotation
	 * */
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
		
	}

	@Override
	public Student getStudentById(long id) {
		return studentRepository.findById(id).orElseThrow();
	}

	@Override
	public void updateStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Student student){
		studentRepository.delete(student);
	}
}
