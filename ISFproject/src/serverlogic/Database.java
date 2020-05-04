package serverlogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	//I create the objects for every content in the database
	AggregateBase myAggregateContent = new ContentAggregate();
	
	
	//Then I have to create the iterator
	
	IteratorBase myIteratorContent = myAggregateContent.createIterator();
	
    public static void main(String[] args) {
        //
    	
    	
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
                
                //myAggregateContent.add(   content objects with the values obtain from the database    );
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
