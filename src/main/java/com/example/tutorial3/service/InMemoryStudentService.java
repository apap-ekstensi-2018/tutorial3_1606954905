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
			if (itemStudent.getNpm() == npm)
			{
				System.out.println(itemStudent.getNpm());
				System.out.println("npm : " + npm);
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

}
