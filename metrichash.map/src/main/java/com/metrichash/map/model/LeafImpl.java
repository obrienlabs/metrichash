package com.metrichash.map.model;

public class LeafImpl implements Leaf {

	private Long id;
	private String attribute;
	
	public LeafImpl(Long _id, String _attribute) {
		id = _id;
		attribute = _attribute;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
}
