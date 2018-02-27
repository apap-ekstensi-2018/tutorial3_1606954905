/**
 * 
 */
package com.example.tutorial3.service;

import java.util.List;
import com.example.tutorial3.model.StudentModel;

/**
 * @author Muhammad Kamal - 1606954905
 *
 */
public interface StudentService {
	StudentModel selectStudent(String npm);
	List<StudentModel> selectAllStudents();
	void addStudent(StudentModel student);
	
}
