package com.oops.immutability;


 final class ImmutableClassWrong {

    private final String[] array;

    public ImmutableClassWrong(String[] arr){
        this.array = arr; // wrong
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Characters in array are: ");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i] + " ");
        }
        return sb.toString();
    }

   
}

public class ImmutableExampleWrong {

	
		 public static void main(String[] args) {
		        String[] array = {"a","b"};
		        ImmutableClassWrong immutableClass = new ImmutableClassWrong(array) ;
		        System.out.println("Before constructing " + immutableClass);
		        array[1] = "c"; // change (i.e. mutate) the element
		        System.out.println("After constructing " + immutableClass);
		    }
	

}
