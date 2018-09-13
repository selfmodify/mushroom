package com.rajesh.study;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//problem of validating that a string has well-formed brackets (what if it is different types of bracket) 

public class WellFormedBrackets {

	public static boolean isWellFormed(String str) {
		
//		Set<Character> openBraces = new HashSet<Character>();
//		openBraces.add('{');
//		openBraces.add('[');
//		openBraces.add('(');
		
		Set<Character> closingBraces = new HashSet<Character>();
		closingBraces.add('}');
		closingBraces.add(']');
		closingBraces.add(')');
		
		Map<Character, Character> bracesMap = new HashMap<Character, Character>();
		bracesMap.put('{', '}');
		bracesMap.put('[', ']');
		bracesMap.put('(', ')');
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if(bracesMap.containsKey(c)) {
				stack.push(c);
				continue;
			}
			
			if (closingBraces.contains(c)){
				// check if there is a matching open brace pushed already onto the stack
				if (stack.empty()) return false;
				Character openBrace = stack.pop();
				if(bracesMap.get(openBrace) != c) {
					return false;
				}
			}
		}
		
		// By this time, stack must be empty
		if (!stack.empty()) return false;
		
		return true;
	}
	
	public static void main(String [] args) {
		System.out.println("{123} well formed = " + isWellFormed("{123}"));
		System.out.println("{123 well formed = " + isWellFormed("{123"));
		System.out.println("123{546[]6758()} well formed = " + isWellFormed("123{546[]6758()}"));
		System.out.println("{[(])} well formed = " + isWellFormed("{[(])}"));
	}
}