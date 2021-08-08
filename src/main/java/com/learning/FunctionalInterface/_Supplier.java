package com.learning.FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/*
 * Supplier<T>	Represents a supplier of results. Return any kind of value that you want
 * Output:
		Old Way : jdbc://localhost:8080/users
		Supplier Functional Interface Way : jdbc://localhost:8080/users
		Supplier list Functional Interface Way : [jdbc://localhost:8080/users, jdbc://localhost:8081/users]

 */
public class _Supplier {

	public static void main(String[] args) {
		System.out.println("Old Way : "+ getDBConnectionURL());
		System.out.println("Supplier Functional Interface Way : "+getDBConnectionURLSupplier.get());
		System.out.println("Supplier list Functional Interface Way : "+getDBConnectionURLsSupplier.get());
	}

	static String getDBConnectionURL() {
		return "jdbc://localhost:8080/users";
	}

	static Supplier<String> getDBConnectionURLSupplier = () -> "jdbc://localhost:8080/users";

	static Supplier<List<String>> getDBConnectionURLsSupplier = () -> Arrays.asList("jdbc://localhost:8080/users",
			"jdbc://localhost:8081/users");
}
