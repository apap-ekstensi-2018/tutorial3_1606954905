/**
 * 
 */
package com.example.tutorial3.model;

/**
 * @author muhammad kamal - 1606954905
 *
 */
public class StudentModel {

	private String name;
	private String npm;
	private double gpa;
	
	/**
	 * 
	 */
	public StudentModel() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentModel(String name, String npm, double gpa)
	{
		this.name = name;
		this.npm = npm;
		this.gpa = gpa;
		
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNpm(String npm)
	{
		this.npm = npm;
	}
	
	public String getNpm() {
		return npm;
	}
	
	public void setGpa(double gpa)
	{
		this.gpa = gpa;
	}
	
	public double getGpa() {
		return gpa;
	}
}
