package com.oops.immutability;


 final class ImmutableClassCorrect {

    private final String[] array;

    public ImmutableClassCorrect(String[] arr){
        this.array = arr.clone(); // defensive copy
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Characters in array are: ");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i] + " ");
        }
        return sb.toString();
    }

   
}

public class ImmutableExample2 {
	 public static void main(String[] args) {
	        String[] array = {"a","b"};
	        ImmutableClassCorrect immutableClass = new ImmutableClassCorrect(array) ;
	        System.out.println("Before constructing " + immutableClass);
	        array[1] = "c"; // change (i.e. mutate) the element
	        System.out.println("After constructing " + immutableClass);
	    }
}
