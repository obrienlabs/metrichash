package com.metrichash.map;

import java.util.Optional;

public class ScratchPad {
	
	/**
	 * 20240707
	 * Multiply 2 matrixes efficiently
	 */
	public void matrixReductionForAdding() {
		long m1[][] = {{1,2,3},{4,5,6}};
		long red0[][];
		
		// initialize reduction matrix
		for(long[] row : m1) {
			for(long col : row) {
				System.out.println(col);
			}
		}
		
		
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
		pad.optional();
		pad.matrixReductionForAdding();
	}

}
