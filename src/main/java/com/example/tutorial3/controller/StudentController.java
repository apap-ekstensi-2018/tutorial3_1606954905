package com.example.tutorial3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		//System.out.println("add data");
		studentService.addStudent(student);
		return "add";
	}
	
	// @RequestMapping("/student/view") --> remark since ambigouse error countered after create path variable method with same "view" action method
	@RequestMapping("/student/viewold")
	public String view(Model model, @RequestParam(value="npm", required=true) String npm) {
		StudentModel student = studentService.selectStudent(npm);
		//System.out.println(student);
		model.addAttribute("student", student);
		return "view";
	}
	
	@RequestMapping(value = {"/student/view", "student/view/{npm}"})
	public String view(@PathVariable Optional<String> npm, Model model) {
		
		if (npm.isPresent())
		{
			StudentModel student = studentService.selectStudent(npm.get());
			System.out.println(student);
			if (student != null)
			{
				System.out.println("cari view view");
				model.addAttribute("student", student);
				return "view";
			}
			else
			{
				System.out.println("cari view not found");
				return "viewnotfound";
			}
		}
		else {
			System.out.println("cari view not found");
			return "viewnotfound";
		}
		
		
	
	}
	
	
	
	@RequestMapping("/student/viewall")
	public String viewAll(Model model) {
		List<StudentModel> students = studentService.selectAllStudents();
		model.addAttribute("students", students);
		System.out.println(students);
		return "viewall";
	}

	
	/***
	 * method to delete student from collections student list
	 */
	@RequestMapping(value = {"/student/delete", "student/delete/{npm}"})
	public String delete(@PathVariable Optional<String> npm, Model model) {
		
		if (npm.isPresent())
		{
			StudentModel student = studentService.selectStudent(npm.get());
			if (student != null)
			{
				// if student exist, execute service delete 
				studentService.deleteStudent(npm.get());
				return "delete";
			}
			else
			{
				return "viewnotfound";
			}
		}
		else {
			return "viewnotfound";
		}
		
		
	
	}
}
