package com.learning.FunctionalInterface;

import java.util.function.BiPredicate;

/*
 * BiPredicate<T,U>	Represents a predicate (boolean-valued function) of two arguments.
 * Output
		Old Way : 
		+91-1234567891: true
		BiPredicate Functional Interface: 
		+91-1234567891: true
 * 
 */
public class _BiPredicate {

	public static void main(String[] args) {
		System.out.println("Old Way : ");
		System.out.println("+91-1234567891: " + isPhoneNumberValid("+91-1234567891", "+91"));
		
		System.out.println("BiPredicate Functional Interface: ");
		System.out.println("+91-1234567891: " + isPhoneNumberValidBiPrecicate.test("+91-1234567891", "+91"));
	}

	static BiPredicate<String, String> isPhoneNumberValidBiPrecicate = (phoneNumer, containsVal) 
			-> phoneNumer.contains(containsVal) && phoneNumer.length() == 14;

	static Boolean isPhoneNumberValid(String phoneNumer, String containsVal) {
		return phoneNumer.contains(containsVal) && phoneNumer.length() == 14;
	}

}
