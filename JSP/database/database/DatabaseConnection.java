package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class can be used initialize the database connection
public class DatabaseConnection {
	
	public static Connection initializeDatabase() 
		throws SQLException, ClassNotFoundException{
		// Initialize all the information regarding
		// Databse Connection
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/";
		
		String dbName = "fnd_schema";
		String dbUsername = "root";
		String dbPassword = "root";
		
		Class.forName(dbDriver);
		Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
		
		return con;
	}

}
