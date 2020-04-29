package serverlogic;
import java.util.*;

public class TimeReputationUpdater extends Thread {
	
	//I could pass allContent as a parameter and also the iterator
	public TimeReputationUpdater() {
		
	}
	
	public void run() {
		Timer timer = new Timer ();
		
		TimerTask reputationUpdate= new TimerTask(){
		    @Override
		    public void run () {
		        
		    	//create objects for every content in the database, this actually shouldn't be done in this class
		    	
		    	//create a iterator for all the content
		    	
		    	
		    	
				 while(allContent.hasNext()){
				 	//for every content, we have to apply the faitAlgorith(content);
				 	fairAlgorithm(allContent.next());
				 
				 }
				 
				 
				 //Update the database, this actually shouldn't be done in this class
		    	
		    }
		};
		
		
		timer.schedule (reputationUpdate, 60, 1000*60);
	}
	
	
}
