package com.algorithms.backtracking;

public class MazeProblem {
	
	static int[][] sol = { {0, 0, 0, 0},
	        {0, 0, 0, 0},
	        {0, 0, 0, 0},
	        {0, 0, 0, 0}
	    };

	public static boolean solveMaze(int[][] maze,int x,int y,int N){
		System.out.println(" Solving ..."+x+":"+y);
	if(x == N-1 && y == N-1){
		sol[x][y] = 1;
		return true;
	    }
	if(isSafe(maze, x, y, N)){
		sol[x][y] = 1;
		
		if(solveMaze(maze, x+1, y, N))
			return true;
		
		if(solveMaze(maze, x, y+1, N))
             return true;
		
		sol[x][y]=0;
		return false;
	}	
		
	return false;
	}
	
	
	
	//to check if the co-ordinates are valid and on track
	public static boolean isSafe(int[][] maze,int x,int y,int N){
		if(x >= 0 && x < N && y >=0 && y < N && maze[x][y]==1)
			return true;
		else return false;
	}
	
	
	public static void printSolution(int N){
	
		for(int i=0;i<N;i++){
			for (int j=0;j< N;j++){
				System.out.print(sol[i][j]+",");}
		
		System.out.println();
		}
		
	}
	
	public static void printMATRIX(int[][] maze,int N){
		
		for(int i=0;i<N;i++){
			for (int j=0;j< N;j++){
				System.out.print(maze[i][j]+",");}
		
		System.out.println();
		}
		
	}
	public static void main(String[] args) {
	
	int[][] maze =  new int [][]{
		{1, 0, 0, 0},
		{1, 1, 0, 1},
		{0, 1, 0, 0},
		{1, 1, 1, 1}};
	System.out.println("Solving...");
	printMATRIX(maze, 4);
	solveMaze(maze, 0, 0, 4);
	printSolution(4);

	}

}
