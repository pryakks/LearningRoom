package com.learning.FunctionalInterface;

import java.util.function.BiConsumer;

/*
 * BiConsumer<T,U>	 Represents an operation that accepts two input arguments and returns no result.
 * OutPut:
		Old Way : 
		Hello : Priya! Thanks for registering phone number : *****
		Hello : Priya! Thanks for registering phone number : 999999
		BiConsumer Functional Interface: 
		Hello : Priya! Thanks for registering phone number : 999999
		Hello : Priya! Thanks for registering phone number : *****
 */
public class _BiConsumer {
	public static void main(String[] args) {
		// old way
		System.out.println("Old Way : ");
		Customer priya = new Customer("Priya", "999999");
		greetCustomer(priya, false);
		greetCustomer(priya, true);

		System.out.println("BiConsumer Functional Interface: ");
		greetCustomer.accept(priya, true);
		greetCustomer.accept(priya, false);
	}

	static void greetCustomer(Customer customer, Boolean showPhoneNumber) {
		System.out.println("Hello : " + customer.customerName + "! Thanks for registering phone number : "
				+ (showPhoneNumber ? customer.CustomerNumber : "*****"));
	}

	static BiConsumer<Customer, Boolean> greetCustomer = (customer, showPhoneNumber) -> System.out
			.println("Hello : " + customer.customerName + "! Thanks for registering phone number : "
					+ (showPhoneNumber ? customer.CustomerNumber : "*****"));

	static class Customer {
		private String customerName;
		private String CustomerNumber;

		public Customer(String customerName, String customerNumber) {
			super();
			this.customerName = customerName;
			CustomerNumber = customerNumber;
		}
	}
}
