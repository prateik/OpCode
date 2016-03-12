package com.datastructures.stack;

import java.util.Stack;

public class PostFixExpression {

	
	public static boolean isHigherPrecedence(char source,char target)
	{
		
		
		
		switch(source){
		
		
		case '-':
	     return target == '-';
		
		case '+' :
		return target == '-' || target=='+';
		
		case '*':
		return target == '-' || target == '+' || target=='*';
		
		case '/':
		return target == '-' || target == '+' || target=='*' || target == '/';
		
		
		}
		
		return false;
	}
	
	public static String getPostFixExpression(String infixExpression)
	{
		
		StringBuilder postFixExpression  = new StringBuilder();
		
		Stack<Character> operationStack = new Stack<Character>();
		for(int i=0;i < infixExpression.length();i++)
		{
			
			switch (infixExpression.charAt(i)){
			
			case '+':
			case '-':
			case '*':
			case '/':
					
			if(operationStack.isEmpty() || isHigherPrecedence(infixExpression.charAt(i),operationStack.peek()))
					operationStack.push(infixExpression.charAt(i));
			
			else{
			      while(!isHigherPrecedence(infixExpression.charAt(i),operationStack.peek())){
					postFixExpression.append(operationStack.pop());
				  }
				operationStack.push(infixExpression.charAt(i));
				
			  }
			break;
			
			case '(':
				operationStack.push(infixExpression.charAt(i));
				break;
				
			case ')':
			    while(!operationStack.isEmpty()  && operationStack.peek()!= '('){
			    	postFixExpression.append(operationStack.pop());
			 
			    }	
			    
			    
			    if(!operationStack.isEmpty() && operationStack.peek()!='(')
			    	return null;
				//postFixExpression.append(infixExpression).charAt(i);
			    else if(!operationStack.isEmpty() && operationStack.peek()=='(')
			    	operationStack.pop();
			    break;
				
			default:	
				postFixExpression.append(infixExpression.charAt(i));
			
			}
		}
		
		while(!operationStack.isEmpty()){
			postFixExpression.append(operationStack.pop());
		}
		
	return postFixExpression.toString();	
	}
	
	
	public static void main(String[] args) {

		
		System.out.println(getPostFixExpression("c+(d+a)"));
	
		
	}

}
