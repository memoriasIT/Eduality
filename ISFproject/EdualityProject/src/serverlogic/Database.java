package serverlogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    public static void main(String[] args) {
        //
    	
    	
    	
    	/**This would be a thread
    	while(every 60 min) {
    		//create a iterator for all the content
    		 while(allContent.hasNext()){
    		 	//for every content, we have to apply the faitAlgorith(content);
    		 	fairAlgorithm(allContent.next());
    		 
    		 }
    		
    	}
    	**/ 
    	
        String sql = "SELECT first_name, last_name, email " +
                "FROM candidates";

        try (Connection conn = MySQLJDBCUtil.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("first_name") + "\t" +
                        rs.getString("last_name")  + "\t" +
                        rs.getString("email"));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
