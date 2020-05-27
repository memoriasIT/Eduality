package com.test.edualitytest.logic;

public abstract class AggregateBase {

	public abstract IteratorBase createIterator();
	public abstract void addItem(Object item);
	public abstract int count();
	public abstract Object obtain(int position);
}
