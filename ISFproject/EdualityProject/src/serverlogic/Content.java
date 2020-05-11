package serverlogic;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList; 


public class Content {

	private double reputation;
	private int totalVotes;
	private int partialVotes;
	private String title;
	private String body;
	private String topic;
	private long uploadDate;
	private int idContent;
	private int idUser;
	private boolean hasAward;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
	private ArrayList<Award>listAwards;
	
	public static Content createContent(int idContent, String title, String body, String topic,int votes,long uploadDate,int idUser,boolean hasAward) {
		if(title.length()<=0 || title.length()>50) {
			throw new RuntimeException("Invalid title length");
		}else if(body.length()<=0 || title.length()>1000) {
			throw new RuntimeException("Invalid body length");
		}else if(body.length()<=0 || title.length()>20) {
			throw new RuntimeException("Invalid topic length");
		}
		
		return new Content(idContent, title, body, topic, votes, uploadDate,idUser,hasAward);
	}
	
	private Content(int idContent,String title, String body, String topic,int votes,long uploadDate,int idUser,boolean hasAward) {
		this.idContent=idContent;
		this.title=title;
		this.body=body;
		this.topic=topic;
		this.totalVotes=votes;
		
		///What it should be done when creating a new content for the first time
		//LocalDateTime now = LocalDateTime.now();
		/// uploadTime = now.getTime();
		
		this.uploadDate = uploadDate;  //dtf.format(now);
		this.idUser = idUser; 
		this.hasAward=hasAward;
		listAwards=new ArrayList<Award>();
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

	public boolean getHasAward() {
		return hasAward;
	}
	
	public void addAward(Award award) {
		listAwards.add(award);
	}
	
}
