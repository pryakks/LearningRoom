package com.learning.FunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ImperativeDeclarativeApproach {
	public static void main(String args[]) {
		List<Person> persons = Arrays.asList(
				new Person("Priya", Gender.FEMALE), 
				new Person("Deepak", Gender.MALE),
				new Person("Ashish", Gender.MALE), 
				new Person("Sandy", Gender.FEMALE),
				new Person("Aniket", Gender.MALE));

		// Imperative approach i.e. old
		List<Person> females = new ArrayList<Person>();
		for (Person person : persons) {
			if (Gender.FEMALE.equals(person.gender)) {
				females.add(person);
			}
		}
		
		System.out.println("Imperative approach");
		for (Person female : females) {
			System.out.println(female);
		}
		
		System.out.println("Declarative Approach");
		// Declarative Approach i.e. functional programming
		persons.stream()
				.filter(person -> Gender.FEMALE.equals(person.gender))
				.forEach(System.out::println);
		
		System.out.println("Declarative Approach with list");
		
		Predicate<? super Person> predicate = person -> Gender.FEMALE.equals(person.gender);
		
		List<Person> femalesDeclarativeArrpoach = 
		persons.stream()
				.filter(predicate)
				.collect(Collectors.toList());
		
		femalesDeclarativeArrpoach.forEach(System.out::println);
	}

	static class Person {
		private final String name;
		private final Gender gender;

		public Person(String name, Gender gender) {
			this.name = name;
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + "]";
		}
	}

	enum Gender {
		MALE, FEMALE
	}
	
	/*
	 * output: 
	 	Imperative approach
			Person [name=Priya, gender=FEMALE]
			Person [name=Sandy, gender=FEMALE]
		Declarative Approach
			Person [name=Priya, gender=FEMALE]
			Person [name=Sandy, gender=FEMALE]
		Declarative Approach with list
			Person [name=Priya, gender=FEMALE]
			Person [name=Sandy, gender=FEMALE]
	 
	 */
	 
}
