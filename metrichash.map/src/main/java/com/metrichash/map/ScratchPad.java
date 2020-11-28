package com.metrichash.map;

import java.util.Optional;

public class ScratchPad {
	
	public void demo() {
		Integer source = null;
		Integer target = null;
		
		//Optional<Integer> srcOptional = Optional.of(source);
		Optional<Integer> srcOptional = Optional.ofNullable(source);
		

		srcOptional.orElse(Integer.valueOf(1));
		srcOptional.ifPresent(e  -> System.out.println(e));	
		
		
		
	}

	
	public static void main(String[] args) {
		ScratchPad pad = new ScratchPad();
		pad.demo();
	}

}
