package in.todoservlet;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.jdi.connect.spi.Connection;

public class Databaseconnection {
	 private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
	    private static final String USER = "todoitems";
	    private static final String PASSWORD = "root";
	    static {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	    public static Connection getConnection() throws SQLException {
	        return (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
	    }
}
