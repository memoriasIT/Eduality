package serverlogic;


public class EdualityLogic {
	
	private final double partialMultiplier = 0.7;
	private final double totalMultiplier = 0.3;
	private final double subtopicMultiplier = 1.25; 
	
	
	 public void fairAlgorithm(Content content){
		 
		double value=0;
	
		//Calculate value
		value= content.getPartialVotes()*0.7 + content.getTotalVotes()*0.3;
		
		if(!content.getTopic().equalsIgnoreCase("all")) {
			value=value*subtopicMultiplier;
		}
		
		content.updateReputation(value);
		
	}
	
	
}
