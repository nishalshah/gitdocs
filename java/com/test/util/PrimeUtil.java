package com.test.util;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PrimeUtil {
	
	public static boolean isPrime(int number) {
	    IntPredicate isDivisible = index -> number % index == 0;
	    return number > 1 && IntStream.range(2, number - 1).noneMatch(isDivisible);
	}

}
