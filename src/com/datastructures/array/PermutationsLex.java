package com.datastructures.array;


/*Suppose that P[1..n] is a permutation of 1 through n. We can construct the next permutation in lexicographic order by following these simple steps:
Find the largest x such that P[x]<P[x+1].
(If there is no such x, P is the last permutation.)
Find the largest y such that P[x]<P[y].
Swap P[x] and P[y].
Reverse P[x+1 .. n].*/

public class PermutationsLex {

    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++)
        	System.out.print(a[i]);
            
        System.out.println();
    } 

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean hasNext(int[] a) {
        int N = a.length;

        // find rightmost element a[k] that is smaller than element to its right
        int k; 
        for (k = N-2; k >= 0; k--)
            if (a[k] < a[k+1]) break;
        if (k == -1) return false;

        // find rightmost element a[j] that is larger than a[k]
        int j = N-1;
        while (a[k] > a[j])
            j--;
        swap(a, j, k);

        for (int r = N-1, s = k+1; r > s; r--, s++)
            swap(a, r, s);

        return true;
    }

    public static void perm(int N) {

        // initialize permutation
        int[] a  = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = i;

        // print permutations
        show(a);
        while (hasNext(a))
           show(a);
    }


    public static void main(String[] args) {
        int N = 5;
        perm(N);
    }
}