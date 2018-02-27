package com.example.tutorial3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.tutorial3.service.InMemoryStudentService;
import com.example.tutorial3.service.StudentService;
import com.example.tutorial3.model.StudentModel;

@Controller
public class StudentController {

	private final StudentService studentService;
	
	public StudentController() {
		// TODO Auto-generated constructor stub
		studentService = new InMemoryStudentService();
	}
 
	@RequestMapping("/student/add")
	public String add(@RequestParam(value = "npm", required=true) String npm,
			@RequestParam(value = "name", required=true) String name,
			@RequestParam(value = "gpa", required=true) double gpa) {
		StudentModel student = new StudentModel(name, npm, gpa);
		System.out.println("add data");
		studentService.addStudent(student);
		return "add";
	}
	
	@RequestMapping("/student/view")
	public String view(Model model, @RequestParam(value="npm", required=true) String npm) {
		StudentModel student = studentService.selectStudent(npm);
		System.out.println(student);
		model.addAttribute("student", student);
		return "view";
	}

}