package serverlogic;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 


public class Content {

	private double reputation;
	private int totalVotes;
	private int partialVotes;
	private String title;
	private String body;
	private String topic;
	private String uploadDate;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
	
	public static Content createContent(String title, String body, String topic) {
		if(title.length()<=0 || title.length()>50) {
			throw new RuntimeException("Invalid title length");
		}else if(body.length()<=0 || title.length()>1000) {
			throw new RuntimeException("Invalid body length");
		}else if(body.length()<=0 || title.length()>20) {
			throw new RuntimeException("Invalid topic length");
		}
		
		return new Content(title, body, topic);
	}
	
	private Content(String title, String body, String topic) {
		this.title=title;
		this.body=body;
		this.topic=topic;
		
		
		LocalDateTime now = LocalDateTime.now();
		uploadDate = dtf.format(now);
		
	}
	
	public String getTopic() {
		return topic;
	}
	
	public void updateReputation(double value) {
		//TODO Checking the value doesn't have error
		reputation+=value;
	}

	public void resetPartialVotes() {
		partialVotes=0;
	}
	
	public int getTotalVotes() {
		return totalVotes;
	}
	
	public int getPartialVotes() {
		return partialVotes;
	}

	public void upvote() {		
		totalVotes++;
		partialVotes++;
	}
	
	public void downvote() {
		if(totalVotes>0) {
			totalVotes--;
		}
		partialVotes--;
	}
	
}
