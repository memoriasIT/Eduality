package serverlogic;
import serverRESTinterface.MySQLAccess;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class TimeReputationUpdater extends Thread {
	IteratorBase allContent; 
	EdualityLogic eduality;
	MySQLAccess dao = new MySQLAccess();
	
	
	public TimeReputationUpdater() {
		eduality = new EdualityLogic();
	}
	
	public void run() {
		//I create the objects for every content in the database
    	AggregateBase myAggregateContent = new ContentAggregate();
    	
    	//Then I have to create the iterator
    	allContent = myAggregateContent.createIterator();
    
    	 
		Timer timer = new Timer ();
		
		TimerTask reputationUpdate= new TimerTask(){
		    @Override
		    public void run () {
		        
		    		
		    		ResultSet content;
					try {
						
						
						content = dao.getContent();
						
						while (content.next()) {
		                	
							 String title = content.getString("title");
				        	 String body = content.getString("body");
				        	 String topic = content.getString("topic");
				        	 long uploadDate = content.getLong("uploadDate");
				        	 int idUser = content.getInt("idUser");
				        	 boolean hasAward = content.getBoolean("hasAward");
				        	 int votes = content.getInt("votes");
				        	 int idContent = content.getInt("idContent");
				        	 int partialVotes = content.getInt("partialVotes");
				        	 int totalVotes = content.getInt("totalVotes");
				        	 
				        	 
				        	 //Content objects with the values obtain from the database
				        	Content content1 = new Content(idContent, title, body, topic, idContent, uploadDate, idUser, hasAward, totalVotes, partialVotes);
				        	
				        	eduality.fairAlgorithm(content1); //Applying the fairAlgorithm to every content we just fetched from the database
				        	 
				        	dao.updateReputation(content1.getReputation());  //Update the database 
				        	 
		                   
		                    
		                }
		            
						
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		    		
		                
		           
		    	 //---------------------------------------------------------------------
		    	
					
		
		
		    }
					
					
		
			};
					timer.schedule (reputationUpdate, 60, 1000*60);
		}
	}
	
		

