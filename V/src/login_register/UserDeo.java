package login_register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class UserDeo {
	
	 public int registerUser(User user) throws ClassNotFoundException {	
	        String INSERT_USERS_SQL = "INSERT INTO User" +	
	            "  ( id,first_name, last_name, username, password, address, contact) VALUES " +	
	            " (?,?, ?, ?, ?,?,?);";	
		
	        int result = 0;	
		
	        Class.forName("com.mysql.jdbc.Driver");	
		
	        try (Connection connection = DriverManager	
	            .getConnection("jdbc:mysql://localhost:3306/ADMdatabase?useSSL=false", "root", "3735672With");	
		
	            // Step 2:Create a statement using connection object	
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {	
	            preparedStatement.setInt(1,0);	
	            preparedStatement.setString(2, user.getFirstname());	
	            preparedStatement.setString(3, user.getLastname());	
	            preparedStatement.setString(4, user.getUsername());	
	            preparedStatement.setString(5, user.getPassword());	
	            preparedStatement.setString(6, user.getAddress());	
	            preparedStatement.setString(7, user.getContact());	
		
	            System.out.println(preparedStatement);	
	            // Step 3: Execute the query or update query	
	            result = preparedStatement.executeUpdate();	
		
	        } catch (SQLException e) {	
	            // process sql exception	
	            printSQLException(e);	
	        }	
	        return result;	
	    }	
		
	    private void printSQLException(SQLException ex) {	
	        for (Throwable e: ex) {	
	            if (e instanceof SQLException) {	
	                e.printStackTrace(System.err);	
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());	
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());	
	                System.err.println("Message: " + e.getMessage());	
	                Throwable t = ex.getCause();	
	                while (t != null) {	
	                    System.out.println("Cause: " + t);	
	                    t = t.getCause();	
	                }	
	            }	
	        }	
	    }	


}
