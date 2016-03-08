package com.datastructures.matrix;

public class RotateMatrix {

	public static int[][] rotateMatrix(int[][] matrix)
	
	{
		int N = matrix.length;
		

		for (int layer = 0; layer < N / 2; layer++) {
            int farthest = N - layer - 1;
          System.out.println(" Start Layer : "+layer);
          System.out.println(" farthest : "+farthest);
            for (int i = layer; i < farthest; i++) {
                
                System.out.println("Co-ordinates: "+layer+":"+i);
                System.out.println("Co-ordinates: "+(farthest - i + layer)+":"+layer);
                System.out.println("Co-ordinates: "+farthest+":"+(farthest - i + layer));
                System.out.println("Co-ordinates: "+i+":"+farthest);
                
                
                int temp = matrix[layer][i];
                matrix[layer][i] = matrix[farthest - i + layer][layer];
                matrix[farthest - i + layer][layer] = matrix[farthest][farthest - i + layer];
                matrix[farthest][farthest - i + layer] = matrix[i][farthest];
                matrix[i][farthest] = temp;
            }
            
            System.out.println(" Done Layer : "+layer);
        }
		
		return matrix;
	
		
		
	}
	
	
	public static void print(int[][] matrix)
	{
		
		for(int i=0;i < matrix.length; i++)
		{
			
			for(int j=0;j < matrix.length;j++)
			{ 
				
				
				System.out.print(matrix[i][j]+",");
			}
			
			System.out.println();
		}
		
	}
	
	
	public static void main(String[] args) {
		int[][] matrix =  new int [][]{
			{1, 3, 5, 9},
			{2, 4, 6, 11},
			{6, 7, 8, 13},
			{8, 9, 10, 15}};
			print(matrix);
    matrix = rotateMatrix(matrix);
    print(matrix);
	}

}
