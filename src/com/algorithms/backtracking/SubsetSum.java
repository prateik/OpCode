package com.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

	public static void printSubSetSums(int[] set,int sum,int index){
		
		
		if(index == set.length) return;
		
		List<Integer> list = new ArrayList<Integer>();
		
		if(sum == 0)
		{
		for(int i=0;i< list.size();i++) System.out.print(list.get(i));
		System.out.println();
		}
		
		else{
			System.out.println("Sum = "+sum+ " index = "+index);
			if(sum-set[index] >=0)
			{
				System.out.println(" Adding to list "+set[index]);
				list.add(set[index]);
				sum-=set[index];
				printSubSetSums(set, sum, index+1);
				return;
			}
			else{	
				printSubSetSums(set, sum, index+1);
				return;
			}
			
		}
		
	}
	
	
	
	public static void main(String[] args) {

		int[] set = new int[] {1,2,3,4,5,6};
		
		printSubSetSums(set, 5, 0);
	}

}
