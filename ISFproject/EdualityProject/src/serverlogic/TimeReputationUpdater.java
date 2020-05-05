package serverlogic;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class TimeReputationUpdater extends Thread {
	IteratorBase allContent;
	EdualityLogic eduality;
	
	
	public TimeReputationUpdater() {
		eduality = new EdualityLogic();
	}
	
	public void run() {
		//I create the objects for every content in the database
    	AggregateBase myAggregateContent = new ContentAggregate();
    	
    	//Then I have to create the iterator
    	IteratorBase myIteratorContent = myAggregateContent.createIterator();
    
    	 
		Timer timer = new Timer ();
		
		TimerTask reputationUpdate= new TimerTask(){
		    @Override
		    public void run () {
		        //GET THE CONTENT FROM THE DATABASE AND CREATE THE OBJECTS
		    	//---------------------------------------------------------------------
		    	// sql sentences are not well defined yet is only the idea
		    	String sqlContent = "SELECT title, body " +
		                "FROM Content";
		        
		    	
		    	try (Connection conn = MySQLJDBCUtil.getConnection();
		                 Statement stmt  = conn.createStatement();
		                 ResultSet rs    = stmt.executeQuery(sql)) {

		                // loop through the result set
		                while (rs.next()) {
		                	/**
		                	 String sqlTopic = "SELECT name " +
		     		                "FROM Topic";
		     		        // SELECT name FROM Topic
		     		        // WHERE IDTopic=currentTopic; should be inside the while
		                	**/
		                	
		                    System.out.println(rs.getString("first_name") + "\t" +
		                            rs.getString("last_name")  + "\t" +
		                            rs.getString("email"));
		                    
		                    //Content objects with the values obtain from the database
		                    //myAggregateContent.add(  createContent(idContent,title,body,topic,votes,uploadDate,idUser,hasAward) );
		                }
		            
		            } catch (SQLException ex) {
		                System.out.println(ex.getMessage());
		            }
		    	 //---------------------------------------------------------------------
		    	
		    	//Applying the fairAlgorithm to every content we just fetched from the database
				 while(allContent.hasNextItem()){
				 	//for every content, we have to apply the fairAlgorithm(content);
	 				 
				 	eduality.fairAlgorithm((Content) allContent.nextItem());
				 }
				 
				 
				 //Update the database 
				 
				 while(allContent.hasNextItem()) {
					 ((Content)allContent.currentItem()).resetPartialVotes();
					
					
					//Update the database here!
					//
					 
				 }
				 //Only the reputation field should be updated
				 //IMPORTANT!!! reputation is NOT the same that upvotes it must be a different field
		    	
		    }
		};
		
		
		timer.schedule (reputationUpdate, 60, 1000*60);
	}
	
}
