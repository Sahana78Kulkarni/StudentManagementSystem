package com.MiniProject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Student
{
	private String studentId;
	private String name,gender;
	private ArrayList<String> courses=new ArrayList<String>();
	private double balance_fee=0;
	private static double costOfCourse=0;	
	private static int id=101;
	
	Scanner scan=new Scanner(System.in); 
	public Student()
	{
		System.out.println("Enter Student Details:");	
		setStudentId();
		System.out.println("Student ID: "+this.studentId);
		System.out.println("Enter Student Name:");
		this.name=scan.nextLine();
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
		
		boolean flag=true;
		do {
				System.out.println("Enter course Id to enroll(Q to quit) :");
				String input=scan.next();	
				String enroll_course;
				
				if(!input.equalsIgnoreCase("Q"))
				{
					int courseId=Integer.parseInt(input);
					if(courseId<=Course.course_List.size())
					{
						enroll_course=Course.course_List.get(courseId-1).getName();
						courses.add(enroll_course);
						System.out.println("Total Fee: "+Course.course_List.get(courseId-1).getCost());
						costOfCourse=Course.course_List.get(courseId-1).getCost();
						balance_fee+=costOfCourse;
					}
					else
						{
							System.out.println("Enter invalid course id");
							enroll();
						}
				}
				else {
					flag=false;
					break;
				}
				
		}while(flag);
		System.out.print("Courses enrolled: ");
		for(String c:courses)
		{
			System.out.print(c+" ");
		}
		//courses.forEach(System.out::print);
	}
	public  void viewBalance()
	{
		System.out.println("\n Balance fee : "+balance_fee);
	}
	public void payTuitionFee() {
		System.out.println("Enter the amount to pay: ");
		int amount=scan.nextInt();
		if(amount>0 && amount<=balance_fee)
			balance_fee=balance_fee-amount;
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
				 + ", TuitionBalance: Rs" + balance_fee 
				 ;
	}
	
	public double getBalance_fee() {
		return balance_fee;
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
