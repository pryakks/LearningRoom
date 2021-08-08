package com.learning.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _StreamFunction {
	public static void main(String args[]) {
		List<Person> persons = Arrays.asList(
				new Person("Priya", 12, Gender.FEMALE),
				new Person("Deepak", 60, Gender.MALE), 
				new Person("Pooja", 36, Gender.FEMALE),
				new Person("Abhishek", 33, Gender.MALE));
		
		// filter
		System.out.println("filter : ");
		List<Person> femalePersonList = 
				persons.stream()
						.filter(person -> Gender.FEMALE.equals(person.gender))
						.collect(Collectors.toList());

		femalePersonList.forEach(System.out::println);

		// sorted
		System.out.println("Sorted : ");
		List<Person> sortedPersonList = 
				persons.stream()
						.sorted(Comparator.comparing(Person::getAge))
						.collect(Collectors.toList());

		// sorted reversed
		sortedPersonList.forEach(System.out::println);
		System.out.println("sortedReversed : ");
		List<Person> sortedReversedPersonList = 
				persons.stream()
						.sorted(Comparator.comparing(Person::getAge).reversed())
						.collect(Collectors.toList());

		sortedReversedPersonList.forEach(System.out::println);
		
		// All Match -true
		System.out.println("All Match : ");
		boolean allMatchPerson = 
					persons.stream()
							.allMatch(person -> person.getAge() >5 );
		System.out.println("allMatchPerson : "+allMatchPerson);
	
		// All Match - false
		System.out.println("All Match : ");
		boolean allMatch = 
				persons.stream()
						.allMatch(person -> person.getAge() > 14 );
		System.out.println("allMatchPerson : "+allMatch);
		
		//AnyMAtch - true
		boolean anyatch = 
				persons.stream()
						.anyMatch(person -> person.getAge() > 14 );
		System.out.println("anyatch : "+anyatch);
		
		//AnyMAtch - false
		boolean anyatchFalse = 
				persons.stream()
						.anyMatch(person -> person.getAge() <5 );
		System.out.println("anyatch : "+anyatchFalse);
				
		//nonMatch
		boolean nonMatch = 
				persons.stream()
						.noneMatch(person -> person.getName().endsWith("Rachel"));
		System.out.println("nonMatch : "+nonMatch);
		
		//nonMatch
		boolean nonMatchFalse = 
				persons.stream()
						.noneMatch(person -> person.getName().endsWith("Priya"));
		System.out.println("nonMatch : "+nonMatchFalse);
		
		//Max
		System.out.print("Max : ");
		persons.stream()
				.max(Comparator.comparing(Person::getAge))
				.ifPresent(System.out::println);
		
		System.out.print("Min : ");
		//Min
		persons.stream()
				.min(Comparator.comparing(Person::getAge))
				.ifPresent(System.out::println);
		
		//Group
		Map<Gender, List<Person>> groupByGender = persons.stream()
				.collect(Collectors.groupingBy(Person::getGender));
		
		groupByGender.forEach((gender, people) ->{
			System.out.println(gender);
			people.forEach(System.out::println);
		});
		
		persons.stream()
			.filter(person -> Gender.FEMALE.equals(person.getGender()))
			.max(Comparator.comparing(Person::getAge))
			.map(person -> person.getName())
			.ifPresent(System.out::println);
	}

	static class Person {
		private final String name;
		private final int age;
		private final Gender gender;

		public Person(String name, int age, Gender gender) {
			this.name = name;
			this.age = age;
			this.gender = gender;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		public Gender getGender() {
			return gender;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
		}
	}

	enum Gender {
		MALE, FEMALE, PREFER_NOT_TO_SAY
	}
}