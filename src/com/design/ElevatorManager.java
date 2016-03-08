package com.design;

import java.util.ArrayList;
import java.util.List;


class Elevator{
	int currentFloor;
	boolean isGoingup = false;
	
	public void moveUpToFloor(int floor)
	{
		isGoingup = true;
		while(currentFloor != floor)
		{
			currentFloor++;
		}
	}
	
	public void moveDownToFloor(int floor){
		isGoingup = false;
		
		while(currentFloor != floor)
		{
			currentFloor--;
		}
		
	}
	
	
}


public class ElevatorManager {

	int FLOORS;
    Elevator elevator = new Elevator();
    
    List<Integer> upRequests = new ArrayList<Integer>();
    List<Integer> downRequests = new ArrayList<Integer>();
    
    
	public ElevatorManager(int FLOORS) {
		this.FLOORS = FLOORS;
	}
	
	
	public void request(int floor,boolean isUpRequest){
		
		if(isUpRequest) upRequests.add(floor);
		else downRequests.add(floor);
       
	}

	
	public void serviceRequests(){
		if(elevator.isGoingup){
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
