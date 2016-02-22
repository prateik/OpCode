package com.java.Collection;

public class Strings {

	public static String processString(String text){           
	    text = text.concat("defString");
	    return text;
	}
	
	public static StringBuilder processStringBuilder(StringBuilder text){           
	    text = text.append("defbuilder");
	    return text;
	}
	
	
	public static void main(String[] args) {
		String text = "abc";
		System.out.println(processString(text));
		System.out.println(text);
		StringBuilder textBuilder = new StringBuilder("abc");
		System.out.println(processStringBuilder(textBuilder));
		System.out.println(textBuilder);
	}

}
