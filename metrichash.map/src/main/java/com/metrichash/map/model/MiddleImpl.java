package com.metrichash.map.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MiddleImpl implements Middle {

	private Long id;
	private String attribute;
	private CopyOnWriteArrayList<Leaf> leafs;
	
	public MiddleImpl(Long _id, String _attribute) {
		id = _id;
		attribute = _attribute;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Leaf> getLeafs() {
		return leafs;
	}
	public void setLeafs(CopyOnWriteArrayList<Leaf> leafs) {
		this.leafs = leafs;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
}
