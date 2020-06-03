package testeduality;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import serverlogic.Award;
import serverlogic.Content;
import serverlogic.User;

public class TestUser {

	User user;
	
	@Before
	public void setUp() throws Exception {
		user = new User("pepe@uma.es","Pepe","myCoolPassword",true, 1, 1, 1);
	}

	@After
	public void tearDown() throws Exception {
		user=null;
	}

	@Test(expected = RuntimeException.class)
	public void testAwardsAvaliableExpertCannotHaveNegativeAwards() {
		String mail="juan@uma.es";
		String name="Juan";
		String password="myCoolPasssword";
		boolean expert=true;
		int gold=0;
		int silver=-1;
		int copper=-2;
		
		User user = new User(mail,name,password,expert, gold, silver, copper);
		user.awardsAvaliable();
	}
	
	@Test(expected = RuntimeException.class)
	public void testAwardsAvaliableUserShouldNotHaveAwards() {
		String mail="juan@uma.es";
		String name="Juan";
		String password="myCoolPasssword";
		boolean expert=false;
		int gold=0;
		int silver=1;
		int copper=3;
		
		User user = new User(mail,name,password,expert, gold, silver, copper);
		user.awardsAvaliable();
		
	}

	@Test
	public void testGiveAwardContentSeeThatHasAwardChangesToTrueAndNumberOfAwardsIsIncremented() {
		Content content = Content.createContent(1, "test", "bodytest", "topictest", 0, 20200518, 1, false);
		boolean initialHasAward = content.getHasAward();
		int initialNumberOfAwards = content.getNumberOfAwards();
		
		Award award= new Award(3);
		
		user.giveAwardContent(content,award);
		
		assertEquals("hasAward hasn't changed as it should ",!initialHasAward,content.getHasAward());
		assertEquals("NumberOfAwards hasn't changed as it should ",initialNumberOfAwards+1,content.getNumberOfAwards());
		
	}

}
