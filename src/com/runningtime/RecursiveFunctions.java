package com.runningtime;

public class RecursiveFunctions {

	
	
	int recursiveFun1(int n)
    {
        if (n <= 0)
        return 1;
       else
        return 1 + recursiveFun1(n-1);
     }

int recursiveFun2(int n)
{
    if (n <= 0)
        return 1;
    else
        return 1 + recursiveFun2(n-5);
}

int recursiveFun3(int n)
{
    if (n <= 0)
        return 1;
    else
        return 1 + recursiveFun3(n/5);
}

void recursiveFun4(int n, int m, int o)
{
    if (n <= 0)
    {
        /*System.out.println("%d, %d\n",m, o);*/
    }
    else
    {
        recursiveFun4(n-1, m+1, o);
        recursiveFun4(n-1, m, o+1);
    }
}

int recursiveFun5(int n)
{
  /*  for(i=0;i<n;i+=2)
        do something;
*/
    if (n <= 0)
        return 1;
    else
        return 1 + recursiveFun5(n-5);
}



public static void main(String args[]){
	
	
	
	
	
	
	
}
	
	
}
