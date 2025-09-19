package in.spring.wmvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

	public class Assignment1dao {
	private static final String URL = "jdbc:mysql://localhost:3306/todo_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static int insertUsers(Userdto dao) throws Exception {
        String query = "INSERT INTO users (name,email,password) VALUES (?,?,?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, dao.getName());
            ps.setString(2, dao.getEmail());
            ps.setString(3, dao.getPassword()); 
            return ps.executeUpdate();
        }
    }
    
    
}
