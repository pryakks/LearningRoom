package com.learning.combinatorPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator
		extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {
	public static final ValidationResult SUCCESS = CustomerRegistrationValidator.ValidationResult.SUCCESS;
	public static final ValidationResult PHONE_NUMBER_NOT_VALID = CustomerRegistrationValidator.ValidationResult.PHONE_NUMBER_NOT_VALID;
	public static final ValidationResult IS_NOT_AN_ADULT = CustomerRegistrationValidator.ValidationResult.IS_NOT_AN_ADULT;
	public static final ValidationResult EMAIL_NOT_VALID = CustomerRegistrationValidator.ValidationResult.EMAIL_NOT_VALID;

	static CustomerRegistrationValidator isEmailValid() {
		return customer -> {
			return customer.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
		};
	}

	static CustomerRegistrationValidator isPhoneNumberValid() {
		return customer -> customer.getPhoneNumber().length() == 10 ? SUCCESS : PHONE_NUMBER_NOT_VALID;
	}

	static CustomerRegistrationValidator isAnAdultValid() {
		return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ? SUCCESS
				: IS_NOT_AN_ADULT;
	}

	enum ValidationResult {
		SUCCESS, PHONE_NUMBER_NOT_VALID, EMAIL_NOT_VALID, IS_NOT_AN_ADULT
	}

	default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
		return customer -> {
			ValidationResult result = this.apply(customer);
			return result.equals(SUCCESS) ? other.apply(customer) : result;
		};
	}
}
