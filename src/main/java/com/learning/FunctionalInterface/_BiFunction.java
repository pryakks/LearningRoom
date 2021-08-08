package com.learning.FunctionalInterface;

import java.util.function.BiFunction;

/*
 * BiFunction<T,U,R>	Represents a function that accepts two arguments and produces a result.
 * Output:
  		Old way : 20
		incrementByOneAndThenMultiplyBiFunction : 20
 */

public class _BiFunction {

	public static void main(String[] args) {

		System.out.print("Old way : ");
		int increment = incrementBy1AndMutliply(1, 10);
		System.out.println(increment);


		System.out.println(
				"incrementByOneAndThenMultiplyBiFunction : " + incrementByOneAndThenMultiplyBiFunction.apply(1, 10));
	}

	static BiFunction<Integer, Integer, Integer> incrementByOneAndThenMultiplyBiFunction = (numberToIncrementByOne,
			numbertoMultiplyBy) -> (numberToIncrementByOne + 1) * numbertoMultiplyBy;
			
	static int incrementBy1AndMutliply(int number, int numToMutliply) {
		return (number + 1) * numToMutliply;
	}

}
