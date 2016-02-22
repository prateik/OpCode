package com.datastructures.string;

public class Permutation {


	
	
	public static void main(String[] args) {
		 String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String elements = alphabet.substring(0, 5);
	        perm1(elements);
	}

	public  static void perm1(String s) { perm1("", s); }
    private static void perm1(String prefix, String s) {
    	
    	//System.out.println("PREFIX: "+prefix + " STRING : "+s);
        int N = s.length();
        if (N == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < N; i++){
            	//System.out.println("ITERATION PREFIX: "+prefix + " STRING : "+s);
            	perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
               }
        }

    }
    
}
