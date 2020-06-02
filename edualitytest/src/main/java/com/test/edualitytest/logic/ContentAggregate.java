package com.test.edualitytest.logic;

import java.util.ArrayList;

public class ContentAggregate extends AggregateBase {

	
	//I create the structure for my content
	private ArrayList<ContentLogic> myListOfContent = new ArrayList<>();
	
	
	public ContentIterator createIterator() {
		
		return new ContentIterator(this);	
	}
		
	public int count() {
		return myListOfContent.size();
	}
	
	public ContentLogic obtain(int position) {
		return myListOfContent.get(position);
	}

	@Override
//	public void addItem(Object content) {
		//CAUTION I'm not doing addItem() I am using 
		// the add() from the structure that I've chosen
		
//		myListOfContent.add((Content) content);
//	}
	
	public void addItem(Object item) {
		
		
	}
	
}
