package com.metrichash.map;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import com.metrichash.map.model.Leaf;
import com.metrichash.map.model.LeafImpl;
import com.metrichash.map.model.Middle;
import com.metrichash.map.model.MiddleImpl;
import com.metrichash.map.model.Top;
import com.metrichash.map.model.TopImpl;

public class LamdaStreamsWorkspace {

	
	private List<Top> getModel() {
		CopyOnWriteArrayList<Top> roots = new CopyOnWriteArrayList<>();
		Top top1 = new TopImpl(1L, "orig");
		Middle middle11 = new MiddleImpl(11L, "orig");
		Middle middle12 = new MiddleImpl(12L, "orig");
		Leaf leaf111 = new LeafImpl(111L, "orig");
		Leaf leaf112 = new LeafImpl(112L, "orig");
		Leaf leaf121 = new LeafImpl(121L, "orig");
		Leaf leaf122 = new LeafImpl(121L, "orig");
		
		CopyOnWriteArrayList<Leaf> leafs11 = new CopyOnWriteArrayList<>();
		CopyOnWriteArrayList<Leaf> leafs12 = new CopyOnWriteArrayList<>();
		CopyOnWriteArrayList<Middle> middles1 = new CopyOnWriteArrayList<>();
		leafs11.add(leaf111);
		leafs11.add(leaf112);
		leafs12.add(leaf121);
		leafs12.add(leaf122);
		middle11.setLeafs(leafs11);
		middle12.setLeafs(leafs12);
		middles1.add(middle11);
		middles1.add(middle12);
		top1.setMiddles(middles1);
		
		Top top2 = new TopImpl(2L, "orig");
		Middle middle21 = new MiddleImpl(21L, "orig");
		Middle middle22 = new MiddleImpl(22L, "orig");
		Leaf leaf211 = new LeafImpl(211L, "orig");
		Leaf leaf212 = new LeafImpl(212L, "orig");
		Leaf leaf221 = new LeafImpl(221L, "orig");
		Leaf leaf222 = new LeafImpl(222L, "orig");
		
		CopyOnWriteArrayList<Leaf> leafs21 = new CopyOnWriteArrayList<>();
		CopyOnWriteArrayList<Leaf> leafs22 = new CopyOnWriteArrayList<>();
		CopyOnWriteArrayList<Middle> middles2 = new CopyOnWriteArrayList<>();
		leafs21.add(leaf211);
		leafs21.add(leaf212);
		leafs22.add(leaf221);
		leafs22.add(leaf222);
		middle21.setLeafs(leafs21);
		middle22.setLeafs(leafs22);
		middles2.add(middle21);
		middles2.add(middle22);
		top2.setMiddles(middles2);
		
		roots.add(top1);
		roots.add(top2);
		
		return roots;
	}
	
	private void modifyLeafNodes(List<Top> roots) {
		// change an attribute on the leaf nodes
		roots
			.forEach(y -> y.getMiddles()
			.stream()
			.forEach(z -> z.getLeafs()
			.stream()
			.forEach(x -> x.setAttribute(x.getAttribute().toUpperCase()))));
		roots
			.forEach(x -> x.getMiddles()
			.stream()
			.forEach(y -> y.getLeafs()
			.forEach(i -> System.out.println(i.getId() + "," + i.getAttribute()))));
	}
	
	public void test() {
		List<Top> roots = getModel();
		modifyLeafNodes(roots);
		
	}
	
	
	public static void main(String[] args) {
		LamdaStreamsWorkspace client = new LamdaStreamsWorkspace();
		client.test();
	}
}
