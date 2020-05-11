package serverlogic;

public class ContentIterator extends IteratorBase {
	private ContentAggregate contentAggregate;
	int position;
	
	public ContentIterator(ContentAggregate contentAggregate ) {
		this.contentAggregate=contentAggregate;
		position=0;
	}
	
	public Content firstItem() {
		position=0;
		return currentItem();
	}
	 
    public Content nextItem() {
    	
    	if(this.hasNextItem()) {
    		position++;
    		return currentItem();
    	}else {
    		throw new RuntimeException("There is no next item");
    	}
    	
    	//I have to control that when I increment it I dont get the same item
    	
    }
 
    public Content currentItem() {
    	if(position < contentAggregate.count()) {
    		return contentAggregate.obtain(position);
    	}else {
    		return null;
    	}
 
    }
 
    public boolean hasNextItem() {
    	
    	return position+1 < contentAggregate.count();
    }
    //1 item then it should be false, 
    //Im in 6 and the list have 7 it returns true
    
	
	
}
