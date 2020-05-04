package serverlogic;
import java.util.*;

public class TimeReputationUpdater extends Thread {
	ContentIterator allContent;
	EdualityLogic eduality;
	//I could pass allContent as a parameter and also the iterator
	
	public TimeReputationUpdater(ContentIterator allContent) {
		this.allContent = allContent;
		eduality = new EdualityLogic();
	}
	
	public void run() {
		Timer timer = new Timer ();
		
		TimerTask reputationUpdate= new TimerTask(){
		    @Override
		    public void run () {
		        
		    	//create objects for every content in the database, this actually shouldn't be done in this class
		    	
		    	//create a iterator for all the content
		    	
		    	
		    	
				 while(allContent.hasNextItem()){
				 	//for every content, we have to apply the faitAlgorith(content);
				 	eduality.fairAlgorithm(allContent.nextItem());
				 	
				 }
				 
				 
				 //Update the database, this actually shouldn't be done in this class
		    	
		    }
		};
		
		
		timer.schedule (reputationUpdate, 60, 1000*60);
	}
	
	
}
