package in.todoservletproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

	public class Tododao {
	private static final String URL = "jdbc:mysql://localhost:3306/todo_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static int insertTodo(Tododto todo) throws Exception {
        String sql = "INSERT INTO todo_items (currentDate, todoDesc, targetDate, todoStatus, credited_by) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, todo.getCurrentDate());
            ps.setString(2, todo.getTodoDesc());
            ps.setString(3, todo.getTargetDate());
            ps.setString(4, todo.getTodoStatus());
            ps.setString(5, "admin"); 
            return ps.executeUpdate();
        }
    }
    
    
}
