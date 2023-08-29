package com.MiniProject;

import java.util.ArrayList;

public class Course {
	int id;
	String name;
	double cost;
	int duration ;
	static ArrayList<Course> course_List=new ArrayList<Course>();
	public Course(int id,String name, double cost, int duration) {
		super();
		this.id=id;
		this.name = name;
		this.cost = cost;
		this.duration = duration;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getCost() {
		return cost;
	}
	public int getDuration() {
		return duration;
	}
	public static void setCourseMenu()
	{
		
		Course c1=new Course(1,"Java",20000,5);
		Course c2=new Course(2,"Python",18000,4);
		Course c3=new Course(3,"Angular",4500,2);
		Course c4=new Course(4,"React",4000,1);
		Course c5=new Course(5,"Aptitude Skills",3000,1);
		Course c6=new Course(6,"Soft Skills",3000,1);
		course_List.add(c1);
		course_List.add(c2);
		course_List.add(c3);
		course_List.add(c4);
		course_List.add(c5);
		course_List.add(c6);
		for(Course c:course_List)
		{
			System.out.print(c.getId()+". "+c.getName()+"  "+c.getCost()+" | "+c.getDuration()+" months \n");
		}
		
	}
	@Override
	public String toString() {
		return "courseId "+ id +" name=" + name + ", cost= Rs" + cost + ", duration=" + duration + " months";
	}
	
}
