package com.oops.immutability;

/*
 * Class must be declared final
 * Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
Make all fields final and private.
Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final. A more sophisticated approach is to make the constructor private and construct instances in factory methods.
If the instance fields include references to mutable objects, don't allow those objects to be changed:
Don't provide methods that modify the mutable objects.
Don't share references to the mutable objects. Never store references to external, mutable objects passed to the constructor; if necessary, create copies, and store references to the copies. Similarly, create copies of your internal mutable objects when necessary to avoid returning the originals in your methods.
*/


final class ImmutableClass{
	
	final private int id;
	final private String name;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	 	public ImmutableClass(int id,String name){
	 		this.id = id;
	 		this.name = name;
	 	}
	
}


public class ImmutableClassExample {

	public static void main(String[] args) {
      ImmutableClassWrong IMC  = new ImmutableClassWrong(1,"Test1");
      IMC = new ImmutableClassWrong(2, "Test2");
      
	}

}
