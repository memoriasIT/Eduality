package serverlogic;

import java.util.ArrayList;

public class ContentAggregate extends AggregateBase {

	
	//I create the structure for my content
	private ArrayList<Content> myListOfContent = new ArrayList<>();
	
	
	public ContentIterator createIterator() {
		
		return new ContentIterator(this);	
	}
		
	public int count() {
		return myListOfContent.size();
	}
	
	public Content obtain(int position) {
		return myListOfContent.get(position);
	}

	@Override
	public void addItem(Object content) {
		//CAUTION I'm not doing addItem() I am using 
		// the add() from the structure that I've choosen
		
		myListOfContent.add((Content) content);
	}
	
	public void addItem(Object item) {
		
		
	}
	
}
