package serverlogic;
import serverRESTinterface.MySQLAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class TimeReputationUpdater extends Thread {
	IteratorBase allContent; 
	EdualityLogic eduality;
	MySQLAccess dao = new MySQLAccess();
	private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
	
	
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
		        
		    		
		    		
					try {
						
						 // This will load the MySQL driver, each DB has its own driver
			            Class.forName("com.mysql.cj.jdbc.Driver");
			            // Setup the connection with the DB
			            connect = DriverManager
			                    .getConnection("jdbc:mysql://localhost:3306/eduality?"
			                            + "user=root&password=12345");

			            // Statements allow to issue SQL queries to the database
			            statement = connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			            // Result set get the result of the SQL query
			            resultSet = statement
			                    .executeQuery("select * from eduality.content");
						
						
						
						while (resultSet.next()) {
		                	
							 String title = resultSet.getString("title");
				        	 String body = resultSet.getString("body");
				        	 String topic = resultSet.getString("topic");
				        	 long uploadDate = resultSet.getLong("uploadDate");
				        	 int idUser = resultSet.getInt("idUser");
				        	 boolean hasAward = resultSet.getBoolean("hasAward");
				        	 int votes = resultSet.getInt("votes");
				        	 int idContent = resultSet.getInt("idContent");
				        	 int partialVotes = resultSet.getInt("partialVotes");
				        	 int totalVotes = resultSet.getInt("totalVotes");
				        	 
				        	 
				        	 //Content objects with the values obtain from the database
				        	Content content1 = new Content(idContent, title, body, topic, idContent, uploadDate, idUser, hasAward, totalVotes, partialVotes);
				        	
				        	eduality.fairAlgorithm(content1); //Applying the fairAlgorithm to every content we just fetched from the database
				        	 
			
				        	//Update the database 
				        	resultSet.updateDouble("reputation", content1.getReputation());
				        	resultSet.updateRow();
				        	
				        	 
		                   
		                    
		                }
		            
						
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					finally {
						 try {
					            if (resultSet != null) {
					                resultSet.close();
					            }

					            if (statement != null) {
					                statement.close();
					            }

					            if (connect != null) {
					                connect.close();
					            }
					        } catch (Exception e) {

					        }
					}
		    		
		                
		           
		    	 //---------------------------------------------------------------------
		    	
					
		
		
		    }
					
					
		
			};
					timer.schedule (reputationUpdate, 60, 1000*60);
		}
	}
	
		

