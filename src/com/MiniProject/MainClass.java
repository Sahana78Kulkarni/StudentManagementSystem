package com.MiniProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) 
	{	
		Scanner scan=new Scanner(System.in); 
		System.out.println("Enter number of new students to enroll in below Courses :");
		int noOfStudents=scan.nextInt();	
		Course.setCourseMenu();	
			
		List<Student> students=new ArrayList<Student>();
		
		for(int i=0;i<noOfStudents;i++)
		{
			Student student=new Student();			
			student.enroll();
			student.viewBalance();
			student.payTuitionFee();
			students.add(student);
		}
		showStatus(students);
		
		System.out.println("Exit");
		scan.close();
	}
	public static  void showStatus(List<Student> students)
	{
		System.out.println("Student details: ");
		for(Student std:students)
		{
			System.out.println(std.getStudentId()+" "+std.getName()+" "+std.getGender()
			+" "+std.getCourses()+" "+std.getBalance_fee());
			System.out.println();			
		}	
	}
}
		

