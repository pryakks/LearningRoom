package com.learning.FunctionalInterface;

import java.util.function.Function;

/*
 * Function Interface
 * Function<T,R>	Represents a function that accepts one argument and produces a result.
 * 
 * output: 
		Old way : 1
		Function Interface way : 2
		multiplyBy10: 20
		addBy1AndThenMutliplyBy10: 20
 */

public class _Function {
	public static void main(String args[]) {
		System.out.print("Old way : ");
		int increment = incrementByOne(0);
		System.out.println(increment);

		System.out.print("Function Interface way : ");
		Integer incrementByOne = incrementByOneFunction.apply(1);
		System.out.println(incrementByOne);
		
		// combine multiple function together
		int multiplyBy10 = multiplyByTenFunction.apply(incrementByOne);
		System.out.println("multiplyBy10: " +multiplyBy10);
		
		Function<Integer, Integer> addBy1AndThenMutliplyBy10 = incrementByOneFunction.andThen(multiplyByTenFunction);
		System.out.println("addBy1AndThenMutliplyBy10: "+addBy1AndThenMutliplyBy10.apply(1));
	}

	static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

	static int incrementByOne(int number) {
		return number + 1;
	}
	
	static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;
	
}
