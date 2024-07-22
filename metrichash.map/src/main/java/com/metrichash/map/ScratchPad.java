package com.metrichash.map;

import java.util.Optional;
import java.util.stream.LongStream;
import java.util.stream.Stream;
public class ScratchPad {
	
	/**
	 * 20240707
	 * Multiply 2 matrixes efficiently
	 */
	public void matrixReductionForAdding() {
		long m1[][] = {{1,2,3},{4,5,6}};
		long red0[] = {7,8,9};
		
		//LongStream.of(red0).forEach(System.out::println);
		//Stream.of(red0).forEach(x -> System.out.println(x));
		
		// initialize reduction matrix
		
		//Stream.of(m1).flatMap(Stream::of).toArray(Long[]::new);
		System.out.println("stream using forEach - not flatmMap()");

		//Stream.of(m1).forEach(y -> LongStream.of(y).forEach(x -> System.out.println(x)));
		
	}
	
	public void optional() {
		Integer source = 6;//null;
		Integer target = null;
		
		//Optional<Integer> srcOptional = Optional.of(source);
		// in case the source is null
		Optional<Integer> srcOptional = Optional.ofNullable(source);	

		System.out.println("Optional");
		srcOptional.orElse(Integer.valueOf(1));
		srcOptional.ifPresent(e  -> System.out.println(e));	
	}


	public boolean isPalindromeViaStringBuilder(String input) {
		boolean criteria = false;

		/*
		 * abba
		 * Algorithm:
		 * convert string to IntStream
		 * Brute force: iterate from both sides - once a match is not found - stop:false
		 * Optimized: compare a reversed string - if not equal - not a palindrome (abaa != aaba)
		 * Simplest: StringBuilder.reverse
		 */
		if(input != null && input.length() > 1) {
			StringBuilder builder = new StringBuilder(input);
			criteria = input.compareTo(builder.reverse().toString()) == 0; 
		}
		return criteria;
	}

	public boolean isPalindrome(String input) {
		boolean criteria = false;

		/*
		 * abba
		 * Algorithm:
		 * convert string to IntStream
		 * Brute force: iterate from both sides - once a match is not found - stop:false
		 * Optimized: compare a reversed string - if not equal - not a palindrome (abaa != aaba)
		 * Simplest: StringBuilder.reverse
		 */
		if(null != input && input.length() > 1) {
			StringBuilder reversed = new StringBuilder(); 
			// reverse
			input.chars().forEach(x -> reversed.insert(0,(char) x));
			// compare
			System.out.println(input + " : " + reversed.toString());
			criteria = input.compareTo(reversed.toString()) == 0; 
		}

		String result = criteria ? "true" : "false";
		System.out.println("Result: " + result);
		return criteria;

	}

	public static void main(String[] args) {
		ScratchPad pad = new ScratchPad();
		System.out.println(pad.isPalindromeViaStringBuilder("abcddcba") ? "True" : "False");
		System.out.println(pad.isPalindrome("abcddddcba") ? "True" : "False");
		System.out.println(pad.isPalindrome("abcddddcbdddda") ? "True" : "False");

		//pad.optional();
		//pad.matrixReductionForAdding();
	}

}
