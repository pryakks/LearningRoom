package com.learning.FunctionalInterface;

import java.util.function.Predicate;

/*
 * Predicate<T>	 Represents a predicate (boolean-valued function) of one argument.
 * OutPut
		Old Way : 
		+91-1234567891: true
		+91-1234591: false
		1234567891: false
		Predicate Functional Interface: 
		+91-1234567891: true
		+91-1234591: false
		1234567891: false
		Predicate isNumberValid and contains 3 using and: 
		+91-1234567891: true
		+91-124591: false
		Predicate isNumberValid and contains 3 using or: 
		+91-1234567891: true
		+91-1244567891: true
 */
public class _Predicate {
	public static void main(String[] args) {
		// old way
		System.out.println("Old Way : ");
		System.out.println("+91-1234567891: " + isPhoneNumberValid("+91-1234567891"));
		System.out.println("+91-1234591: " + isPhoneNumberValid("+91-1234591"));
		System.out.println("1234567891: " + isPhoneNumberValid("1234567891"));
		
		System.out.println("Predicate Functional Interface: ");
		System.out.println("+91-1234567891: " + isPhoneNumberValidByPredicate.test("+91-1234567891"));
		System.out.println("+91-1234591: " + isPhoneNumberValidByPredicate.test("+91-1234591"));
		System.out.println("1234567891: " + isPhoneNumberValidByPredicate.test("1234567891"));
		
		System.out.print("Predicate isNumberValid and contains 3 using and: ");
		System.out.println("+91-1234567891: " + isPhoneNumberValidByPredicate.and(containsNumber3).test("+91-1234567891"));
		System.out.println("+91-124591: " + isPhoneNumberValidByPredicate.and(containsNumber3).test("+91-124591"));
		
		System.out.print("Predicate isNumberValid and contains 3 using or: ");
		System.out.println("+91-1234567891: " + isPhoneNumberValidByPredicate.or(containsNumber3).test("+91-1234567891"));
		System.out.println("+91-1244567891: " + isPhoneNumberValidByPredicate.or(containsNumber3).test("+91-1244567891"));
		
	}

	static Boolean isPhoneNumberValid(String phoneNumer) {
		return phoneNumer.startsWith("+91-") && phoneNumer.length() == 14;
	}

	static Predicate<String> isPhoneNumberValidByPredicate = phoneNumer -> phoneNumer.startsWith("+91-")
			&& phoneNumer.length() == 14;
	
	static Predicate<String> containsNumber3 = phoneNumer -> phoneNumer.contains("3");
}
