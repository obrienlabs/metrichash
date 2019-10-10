package com.metrichash.map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author michaelobrien
 *
 */
public class MapClient {
	/** parallelStreams need thread safe HashMaps */
	private Map<Long, String> concurrentHashMap = new ConcurrentHashMap<>();
    /** parallelStreams need thread safe ArrayLists */
	private List<String> splitCopyOnWriteArrayList = new CopyOnWriteArrayList<>();
	
	private List<String> split(String line) {
	    List<String> aList = new CopyOnWriteArrayList<>();
		if(null != line && line.length() > 4) {
			// strip out header and footer
			String replaced = line.substring(line.indexOf("(") + 1).replaceAll("\\),\\(", "|");
			String replaced2 = replaced.substring(0, replaced.length() - 2);
			//System.out.println(replaced2.substring(replaced2.length()-20, replaced2.length()));
			aList = Stream.of(replaced2.split("\\|"))
					.map(elem -> new String(elem))
					.collect(Collectors.toList());
		}
		return aList;
	}
	
	Consumer<String> splitConsumer = new Consumer<String>() {
		public void accept(String line) {
			List<String> aList = split(line);
			//System.out.println("split: " + splitList.size() + " this: " + aList.size());
			splitCopyOnWriteArrayList.addAll(aList);
		}
	};
	
	Consumer<String> mapConsumer = new Consumer<String>() {
		public void accept(String line) {
			tokenize(line);
		}
	};
	
	public void streamFromDump(String path) {
		List<String> localCOWAlist = new CopyOnWriteArrayList<>();
		try {
			Stream<String> lines = Files.lines(Paths.get(path));
			// lines are 1Mb long
			localCOWAlist = lines.collect(Collectors.toList());
			System.out.println("Lines: " + localCOWAlist.size());
			lines.close();
			lines = null;
			
			// split large lines into individual records into a CopyOnWriteArrayList
			localCOWAlist.parallelStream().forEach(splitConsumer);
			localCOWAlist = null;
			
			System.out.println("records: " + splitCopyOnWriteArrayList.size());
			splitCopyOnWriteArrayList.parallelStream().forEach(mapConsumer);
			// parallel will cause random TreeMapNode concurrency issues without a ConcurrentHashMap
			//splitList.stream().forEach(mapConsumer);
			splitCopyOnWriteArrayList = null;
			System.out.println("Map: " + getConcurrentHashMap().keySet().size());
			report();
			filter(10_880_000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean isNumeric(String key) {
		try {
			Long.parseLong(key);
			return true;
		} catch (NumberFormatException nfe) {
			return false; // expected
		}
	}
	
	private void tokenize(String line) {
		if(null != line) {
		  StringTokenizer tokenizer = new StringTokenizer(line, ",");
		  String key = tokenizer.nextToken();
		  
		  if(isNumeric(key)) {
			  long key_l = Long.parseUnsignedLong(key);
			  if(getConcurrentHashMap().containsKey(key_l)) {
				  System.out.println("Dup: " + key_l);
			  }
			  //System.out.println("Key: " + key_l + " val: " + line);
			  getConcurrentHashMap().put(key_l, line);
		  } else {
			  //System.out.println("skipping:" + line);
		  }
		}
		//System.out.println(mapSize);
	}

	private void report() {
		System.out.println("Mem: " + 
				((Runtime.getRuntime().totalMemory() 
						- Runtime.getRuntime().freeMemory()) / (1 << 30)) + "Gb" );
	}

	private void filter(long criteria) {
	    Map<Long, String> aMap = getConcurrentHashMap().entrySet().parallelStream()
	            .filter(x -> x.getKey().longValue() > criteria)
	            .collect(Collectors
	                .toMap(x -> x.getKey(), x -> x.getValue()));
	    System.out.println("Filtered: " + aMap.size());
	}

	public Map<Long, String> getConcurrentHashMap() {
		return concurrentHashMap;
	}

	public void setConcurrentHashMap(Map<Long, String> concurrentHashMap) {
		this.concurrentHashMap = concurrentHashMap;
	}
	
	public static void main(String[] args) {
		MapClient client = new MapClient();
		client.streamFromDump("../Dump20190225.sql");
	}
}
