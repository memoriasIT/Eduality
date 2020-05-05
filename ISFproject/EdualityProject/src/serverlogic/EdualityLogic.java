package serverlogic;


public class EdualityLogic {
	
	private final double partialMultiplier = 0.7;
	private final double totalMultiplier = 0.3;
	private final double subtopicMultiplier = 1.25; 
	private final double awardMultiplier = 1.75; 
	
	
	 public void fairAlgorithm(Content content){
		 
		double value=0;
	
		//We take into account different things:
		
		//We value more 
		value= content.getPartialVotes()*0.7 + content.getTotalVotes()*0.3;
		
		if(!content.getTopic().equalsIgnoreCase("all")) {
			value=value*subtopicMultiplier;
		}
			
		if(content.getHasAward()) {
			value=value*awardMultiplier;
		}
	
		content.updateReputation(value);
		
	}
	
	
}
