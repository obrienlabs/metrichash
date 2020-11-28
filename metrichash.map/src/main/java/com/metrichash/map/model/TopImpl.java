package com.metrichash.map.model;

import java.util.concurrent.CopyOnWriteArrayList;

public class TopImpl implements Top {

	private Long id;
	private String attribute;
	private CopyOnWriteArrayList<Middle> middles;
	
	public TopImpl(Long _id, String _attribute) {
		id = _id;
		attribute = _attribute;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CopyOnWriteArrayList<Middle> getMiddles() {
		return middles;
	}
	public void setMiddles(CopyOnWriteArrayList<Middle> middles) {
		this.middles = middles;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	
	
}
