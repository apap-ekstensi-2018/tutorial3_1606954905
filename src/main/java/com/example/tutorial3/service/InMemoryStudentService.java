/**
 * 
 */
package com.example.tutorial3.service;


/**
 * @author muhammad Kamal - 1606954905
 *
 */

import java.util.List;
import java.util.ArrayList;
import com.example.tutorial3.model.StudentModel;

public class InMemoryStudentService implements StudentService {

	private static List<StudentModel> studentList = new ArrayList<StudentModel>();
	/**
	 * 
	 */
	public InMemoryStudentService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public StudentModel selectStudent(String npm) {
		//implemet
		 
		for(StudentModel itemStudent : studentList)
		{
			if (itemStudent.getNpm().equals(npm))
			{
				return itemStudent;
			}
		}
		return null;
	}
	
	@Override
	public List<StudentModel> selectAllStudents(){
		return studentList;
	}
	
	@Override
	public void addStudent(StudentModel student) {
		studentList.add(student);
	}

	@Override
	public void deleteStudent(String npm)
	{
		StudentModel entityStudent = selectStudent(npm);
		
		if	(entityStudent != null) {
			//execute delete student
			studentList.remove(entityStudent);	
		}
		
	}
}
