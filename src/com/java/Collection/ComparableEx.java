package com.java.Collection;


class Employee implements Comparable<Employee>
{
	int age;
	int id;
	String name;
	String position;

	public Employee(int age) {
        this.age = age;
	}
	
	@Override
	public int compareTo(Employee o) {	
	  if(this.age == o.age) return 0;
	  if(this.age < o.age) return -1;
	  return 1;
	}
	
}


public class ComparableEx {

	public static void main(String[] args) {

		
		Employee e1 = new Employee(14);
		Employee e2 = new Employee(12);
		
		System.out.println(e1.compareTo(e2));
	}

}
