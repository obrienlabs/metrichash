package com.metrichash.map.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public interface Middle {

	Long getId();

	void setId(Long id);

	List<Leaf> getLeafs(); 

	void setLeafs(CopyOnWriteArrayList<Leaf> leafs);

	String getAttribute();

	void setAttribute(String attribute);

}
