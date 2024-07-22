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
		
		#Stream.of(m1).flatMap(Stream::of).toArray(Long[]::new);
		Stream.of(m1).forEach(y -> LongStream.of(y).forEach(x -> System.out.println(x)));
		
	}
	
	public void optional() {
		Integer source = 6;//null;
		Integer target = null;
		
		//Optional<Integer> srcOptional = Optional.of(source);
		Optional<Integer> srcOptional = Optional.ofNullable(source);	

		srcOptional.orElse(Integer.valueOf(1));
		srcOptional.ifPresent(e  -> System.out.println(e));	
	}

	
	public static void main(String[] args) {
		ScratchPad pad = new ScratchPad();
		//pad.optional();
		pad.matrixReductionForAdding();
	}

}
