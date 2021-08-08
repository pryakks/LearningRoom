package com.learning.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
/*
 * streams takes us to Abstract mode
 */

public class _Stream {

	private static final Gender FEMALE = Gender.FEMALE;
	private static final Gender PREFER_NOT_TO_SAY = Gender.PREFER_NOT_TO_SAY;

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Priya", FEMALE), 
				new Person("Deepak", Gender.MALE),
				new Person("Ashish", Gender.MALE), 
				new Person("Sandy", FEMALE), 
				new Person("Aniket", Gender.MALE)
		);
		
		persons.stream()
				.map(person -> person.gender) //takes function
				.collect(Collectors.toSet())
				.forEach(System.out::println); // takes consumer
		
		persons.stream()
			.map(person -> person.name) //takes function
//			.mapToInt(name -> name.length()) //ToIntfunction
			.mapToInt(String::length) // method reference
			.forEach(System.out::println); // takes consumer
		
		Function<Person, String> personStringFunction = person -> person.name;
		ToIntFunction<String> length = String::length;
		IntConsumer println = System.out::println;//x -> System.out.println(x);

		persons.stream()
			.map(personStringFunction) //takes function
			.mapToInt(length) // method reference
			.forEach(println); // takes consumer
		
		Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
		boolean containsOnlyFemale = 
				persons.stream()
						.allMatch(personPredicate); //checks on one existance
		System.out.println("allMatch : "+ containsOnlyFemale);
		
		System.out.println("nonematch: "+persons.stream()
		.noneMatch(person->PREFER_NOT_TO_SAY.equals(person.gender)));
		
		
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
		MALE, FEMALE, PREFER_NOT_TO_SAY
	}

}
