package serverRESTinterface;
import serverRESTinterface.MySQLAccess;

public class Test_MySQLAccess {
	
	 public static void main(String[] args) throws Exception {
	        MySQLAccess dao = new MySQLAccess();
	        dao.readDataBase();
	    }

}
