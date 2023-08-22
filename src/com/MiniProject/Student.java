package com.MiniProject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Student
{
	private String studentId;
	private String name,gender;
	private ArrayList<String> courses;
	private int tuitionBalance=0;
	private static int costOfCourse=6000;	
	private static int id=101;
	Scanner scan=new Scanner(System.in); 
	public Student()
	{
		System.out.println("Enter Student Details:");	
		setStudentId();
		System.out.println("Student ID: "+this.studentId);
		System.out.println("Enter Student Name:");
		this.name=scan.next();
		System.out.println("Enter Student Gender:");
		this.gender=scan.next();	
	}
	
	public void setStudentId()
	{
		int year = Calendar.getInstance().get(Calendar.YEAR);
		this.studentId=year-2000+""+id;
		id++;		
	}
	public  void enroll()
	{
		this.courses=new ArrayList<String>();
		boolean flag=true;
		do {
				System.out.println("Enter course to enroll(Q to quit)");
				String course=scan.next();				
				if(!course.equals("Q"))
				{
					courses.add(course);
					tuitionBalance+=costOfCourse;
				}
				else {
					flag=false;
					break;
				}
				
		}while(flag);
		System.out.println("Courses enrolled: ");
		courses.forEach(System.out::println);
	}
	public  void viewBalance()
	{
		System.out.println("Tuition Balance : "+tuitionBalance);
	}
	public void payTuitionFee() {
		System.out.println("Enter the amount to pay: ");
		int amount=scan.nextInt();
		if(amount>0 && amount<=tuitionBalance)
			tuitionBalance=tuitionBalance-amount;
		else
		{
			System.out.println("Entered Amount should be less than or equal to Balance");
			payTuitionFee();
		}
		viewBalance();
	}
	@Override
	public String toString() {
		return "Student_id: " + studentId + ", name:" + name +", gender: " + gender + ", courses: " + courses
				 + ", TuitionBalance: " + tuitionBalance 
				 ;
	}
	public int getTuitionBalance() {
		return tuitionBalance;
	}
	public String getStudentId() {
		return studentId;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public ArrayList<String> getCourses() {
		return courses;
	}
	
}
