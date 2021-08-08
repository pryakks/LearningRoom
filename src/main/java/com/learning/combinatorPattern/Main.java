package com.learning.combinatorPattern;

import java.time.LocalDate;

import com.learning.combinatorPattern.CustomerRegistrationValidator.ValidationResult;

/*
 * chaining and customer implementation inside interface
 */
public class Main {
	public static void main(String[] args) {
		CustomerValidatorService validatorService = new CustomerValidatorService();

		Customer customer = new Customer("Priya", "pryakks@gmail.com", "1234567890", LocalDate.of(1990, 3, 22));
		System.out.println("Customer Valid : " + validatorService.isValid(customer));

		Customer invalidCustomer = new Customer("Priya", "pryakks@gmail.com", "12567890", LocalDate.of(1990, 3, 22));
		System.out.println("Customer Valid : " + validatorService.isValid(invalidCustomer));

		// using combinator pattern
		ValidationResult result = 
				CustomerRegistrationValidator.isEmailValid()
											 .and(CustomerRegistrationValidator.isPhoneNumberValid())
											 .and(CustomerRegistrationValidator.isAnAdultValid())
											 .apply(customer);

		if (result != ValidationResult.SUCCESS) {
			throw new IllegalStateException(result.name());
		}
		
		ValidationResult result2 = 
				CustomerRegistrationValidator.isEmailValid()
											 .and(CustomerRegistrationValidator.isPhoneNumberValid())
											 .and(CustomerRegistrationValidator.isAnAdultValid())
											 .apply(invalidCustomer);

		if (result2 != ValidationResult.SUCCESS) {
			throw new IllegalStateException(result2.name());
		}
	}
}
