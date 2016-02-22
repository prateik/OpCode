package com.algorithms.greedy;


// weight : weights of the items
// value : value of the items
// x; fractional ratio to be picked for items

public class Knapsack  {

    double[] value;
    double[] weight;
    double[] x;
  
    // n: no of items
    public Knapsack(int noOfItems) {

        value = new double[noOfItems];
        weight = new double[noOfItems];
        x = new double[noOfItems];
        
        // generate random values for weights and values
        for (int i = 0; i < noOfItems; i++) {
            value[i] = (int) Math.round(Math.random() * 9 + 4);
            weight[i] = (int) Math.round(Math.random() * 8 + 5);
        }
    }

    public void sortByMaxUnitValue() {
    	
        for (int i = 0; i < value.length; i++) {
            for (int j = 1; j < (value.length - i); j++) {
            	
            	// compute unit values and sort in descending order
                double x=value[j - 1] / weight[j - 1];
                double y=value[j] / weight[j];
                if (x <=y) {
                    double temp = value[j - 1];
                    value[j - 1] = value[j];
                    value[j] = temp;

                    double temp1 = weight[j - 1];
                    weight[j - 1] = weight[j];
                    weight[j] = temp1;
                }
            }
        }
    }

    
    // m: the max capacity
    
    public void computeKnapsack(int capacity) {
        
    	// both weights and values are sorted(greedy!) 
    	sortByMaxUnitValue();
        
    	int item;
        
        // set all fractions as zero
        for (item = 0; item < value.length; item++) {
            x[item] = 0;
        }
        double total = capacity;
        
        
        for (item = 0; item < value.length; item++) {
            if (weight[item] <= total) {
            	// take the whole item
                x[item] = 1.00;
                //remove weight from total weight
                total = total - weight[item];
            } else {
            	// weight of item is larger than total so exit
                break;// to exit the for-loop
            }
        }
  
      // for the last item take a fractional value remaining total/weight  
        
        if (item < value.length) {
        	
            x[item] = (double)(total / weight[item]);
        
        System.out.println(x[item]);
        }       
    }

    public void print() {

      for(int i=0;i< weight.length;i++)
      {
    	  System.out.print(weight[i]+" | ");
      }
      
      System.out.println();
      
      for(int i=0;i< weight.length;i++)
      {
    	  System.out.print(value[i]+" | ");
      }
      System.out.println();
      
      for(int i=0;i< weight.length;i++)
      {
    	  System.out.printf("%.3f | ",x[i]);
      }
    }

    public static void main(String args[]) {
    	
    	int capacity = 10;
    	int noOfItems = 5;
        Knapsack knapsack = new Knapsack(noOfItems);
        knapsack.computeKnapsack(capacity);
        knapsack.print();
       
    }
}
