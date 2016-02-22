package com.oops;



interface Flyable{

	public void fly();
	
}


abstract class Aircraft implements Flyable
{
	float speed;
	
	@Override
	public void fly() {
		System.out.println(" Flying High!");
		
	}
	
	abstract void getMaxSpeed();
	
}


class Jet extends Aircraft{

	public Jet(){
		this.speed = 1000;
	}

	@Override
	void getMaxSpeed() {
		
		System.out.println(" Speed of a Jet is "+speed);
	}
	
}


class Helicopter extends Aircraft{

	
	public  Helicopter() {
      this.speed = 200;
	}
	@Override
	void getMaxSpeed() {
		System.out.println(" Speed of an Helicopter is "+speed);
			
	}
	
}
public class AbstractClassAndInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
