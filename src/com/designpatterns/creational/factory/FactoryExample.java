package com.designpatterns.creational.factory;


interface Shape{
	void draw();
}

class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println(" Drawing A Rectangle!");
		
	}
	
}

class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println(" Drawing A cIRCLE!");
		
	}
	
}


class Triangle implements Shape{

	@Override
	public void draw() {
		System.out.println(" Drawing A Triangle!");
		
	}
	
}


class ShapeFactory{
	
	
	public static Shape getShape(String shapeType)
	{
		Shape shape = null;
		switch(shapeType.toUpperCase()){
		
		case "CIRCLE":
		shape = new Circle();
		break;
		
		case "RECTANGLE":
			shape = new Rectangle();
			break;
		
		 case "TRIANGLE":
			shape = new Triangle();
			break;
		}
	
			return shape;
	}
	
	
}

public class FactoryExample {

	public static void main(String[] args) {
		Shape s = ShapeFactory.getShape("rectangle");
		 s.draw();
		 s = ShapeFactory.getShape("triangle");
		s.draw();
	}

}
