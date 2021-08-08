package com.learning.optionals;

import java.util.Optional;
import java.util.function.Supplier;
/*
 * be safe with null values
 * allows us to clean API know that the specific field is nullable or not.
 */

public class _Optional {

	public static void main(String[] args) {
		
		Optional<Object> empty = Optional.empty();
		System.out.println("isPresent: "+ empty.isPresent());
//		System.out.println("isPresent: "+ empty.isEmpty());
		
		Optional<Object> empty1 = Optional.of("Hello");
		System.out.println("isPresent: "+ empty1.isPresent());
	
		Optional<Object> hello1 = Optional.of("Hello");
		String orElse = (String) hello1.orElse("World");
		System.out.println("orElse: "+orElse);
		
		Object value = Optional.ofNullable(null)
				.orElseGet(()->"Default Value"); // accept supplier
		System.out.println(value);
		
		Object hello = Optional.ofNullable("Hello")
				.orElseGet(()->"Default Value"); // accept supplier
		System.out.println(hello);
		
		Supplier<IllegalStateException> exceptionSupplier = ()-> new IllegalStateException("Exception");
		Object exceptionTest = Optional.ofNullable("hello")
				.orElseThrow(exceptionSupplier);
		
		Optional.ofNullable("pryakks@gmail.com")
		.ifPresent(email-> System.out.println("Sendin email to : "+ email));
		
		// ifPresentOrElse(Consumer, Runnable) 
//		Optional.ofNullable("pryakks@gmail.com")
//		.ifPresentOrElse(email-> System.out.println("Sendin email to : "+ email),
//				()->  System.out.println("Cannot send mail"));

		
	}
	

}
