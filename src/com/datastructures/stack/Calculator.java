package com.datastructures.stack;

import java.util.Stack;

public class Calculator {

	
	
	public static  int evaluate(String expression,int start){
		
		Stack<Character> s = new Stack<Character>();
	
		while(start <= expression.length()-1){

			switch (expression.charAt(start)){
			case '(':
				evaluate(expression, start+1);
				
			case ')':
				return getResult(s);
			
			case '+':
				s.push(expression.charAt(start));
				start++;
				break;
				
			case '-':
				s.push(expression.charAt(start));
				start++;
				break;
				
			case '*':
				s.push(expression.charAt(start));
				start++;
				break;
				
			case '/':
				s.push(expression.charAt(start));
				start++;
				break;
				
			case ' ':
				start++;
				break;
				
			default:
				s.push(expression.charAt(start));
				start++;
				
			}
			
			if(start == expression.length())
			break;
		}
      
		return getResult(s);
	}
	
	
	public static int getResult(Stack<Character> s)
	{
		if(s.size() != 3) return 0;
		
		
		int num1 = Character.getNumericValue((s.pop().charValue()));
		int num2 = Character.getNumericValue((s.pop().charValue()));
		
		if(s.pop().charValue()=='+')
			return num1+num2;
		
		if(s.pop().charValue()=='-')
			return num1-num2;
		
		
		if(s.pop().charValue()=='*')
			return num1*num2;
		
		
		if(s.pop().charValue()=='/')
			return num1/num2;
	
		
		return 0;
	}
	
	public static void main(String[] args) {
        System.out.println(evaluate("+ 2 4",0));
        System.out.println(evaluate("* 8 ( + 7 12 )",0));
        
	}

}
