package com.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Point {
	int x;
	int y;

	Point(int x, int y) {

		this.x = x;
		this.y = y;
	}

}

public class FindPathInMaze {

	 int X;
	 int Y;

	 List<Point> maze = new ArrayList<Point>();
	 List<Point> path = new ArrayList<Point>();

	public void generateMaze() {

		for (int i = 0; i < 5; i++) {
			Random rn = new Random();
			int randomX = rn.nextInt(X);
			int randomY = rn.nextInt(Y);
			if (randomX != 0 && randomY != 0 && randomX!= X && randomY != Y) {
				Point randomPoint = new Point(randomX, randomY);
				maze.add(randomPoint);
			}
		}
	}

	public boolean isFree(int x, int y) {
		for (Point p : maze) {
			if (p.x == x && p.y == y)
				return false;
		}
		return true;
	}

	public void printMaze() {
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				if (isFree(i, j)) {
					System.out.print("0 | ");
				}

				else {
					System.out.print("1 | ");
				}
			}
			System.out.println();
		}

	}
	
	
	public boolean getPath(int x,int y,List<Point> path)
	{
		
		System.out.println(" Determining "+x+":"+y);
		if(x < 0 || y < 0 || !isFree(x, y)) return false;
		
		
		
		if( (x == 0 && y == 0) ||  getPath(x, y-1, path) || getPath(x - 1, y,path) )
		{
			System.out.println("Adding Point "+x+":"+y);
			Point p = new Point(x,y);
			path.add(p);
			return true;
		}
		
		return false;
		
	}
	
	
	public  void printPath(List<Point> path){
		for(Point p:path)
		{
			System.out.println(" Point "+p.x+":"+p.y);
		}
	}

	public static void main(String[] args) {
		
		FindPathInMaze f = new FindPathInMaze();
		f.X = 5;
		f.Y =5;
		
		f.generateMaze();
		
		f.printMaze();
		
		f.getPath(5, 5, f.path);
		
		f.printPath(f.path);

	}

}
