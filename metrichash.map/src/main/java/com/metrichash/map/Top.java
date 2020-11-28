package com.metrichash.map;

import java.util.concurrent.CopyOnWriteArrayList;

public interface Top {

	Long getId();
	void setId(Long id);

	CopyOnWriteArrayList<Middle> getMiddles();

	void setMiddles(CopyOnWriteArrayList<Middle> middles);

	String getAttribute();

	void setAttribute(String attribute);

}
