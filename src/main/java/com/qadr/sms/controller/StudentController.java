package com.qadr.sms.controller;


import com.qadr.sms.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.qadr.sms.service.StudentService;

/**
 * This is the student controller class that handles request from clients
 * It is annotated with @Controller, @RestController can also be used if we're building a restful service
 * @RequestMapping("/students") is also used to tell the spring boot framework that this class will handle
 * the request send to the "/students" path
 * */
@Controller
@RequestMapping("/students")
public class StudentController {
	private StudentService studentService;

	/**
	 * Because this spring bean has only one constructor, we don't need @Autowired
	 * annotation
	 */
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// handler method for updating student
	@PostMapping("/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student){
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setEmail(student.getEmail());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		studentService.updateStudent(existingStudent);

		return "redirect:/students";
	}

	//handler method to delete student
	@GetMapping("/delete/{id}")
	public String deleteStudent (@PathVariable Long id){
		Student student = studentService.getStudentById(id);
		studentService.deleteStudent(student);
		return "redirect:/students";
	}

	// handler method for getting all students
	@GetMapping
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	// handler method for post all students
	@PostMapping
	public String createStudent(@ModelAttribute("student")
											/** annotation used to tell that the data is coming from the
											 * model view with the name "student" */
											Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	// handler method for navigating to the new student form page
	@GetMapping("/new")
	public String createStudentForm(Model model) {
		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	// handler method for navigating to update user
	@GetMapping("update/{id}")
	public String updateStudentForm(@PathVariable("id")
												/** annotation used to get the path var from the url*/ Long id,
									Model model){
		// find student
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		return "update_student";
	}
}
