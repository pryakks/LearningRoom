package com.learning.FunctionalInterface;

import java.util.function.Consumer;

/*
 * Consumer<T> 	Represents an operation that accepts a single input argument and returns no result.
 * OutPut:
		Old Way : 
		Hello : Priya! Thanks for registering phone number : 999999
		Consumer Functional Interface: 
		Hello : Priya! Thanks for registering phone number : 999999
 */
public class _Consumer {

	public static void main(String[] args) {
		// old way
		System.out.println("Old Way : ");
		Customer priya = new Customer("Priya", "999999");
		greetCustomer(priya);

		System.out.println("Consumer Functional Interface: ");
		// Consumer Functional Interface
		greetCustomerConsumer.accept(priya);
	}

	static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println(
			"Hello : " + customer.customerName + "! Thanks for registering phone number : " + customer.CustomerNumber);

	static void greetCustomer(Customer customer) {
		System.out.println("Hello : " + customer.customerName + "! Thanks for registering phone number : "
				+ customer.CustomerNumber);
	}

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
