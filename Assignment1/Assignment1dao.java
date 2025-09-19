package in.spring.wmvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Assignment1dao {
    private static final String url = "jdbc:mysql://localhost:3306/users";
    private static final String user = "root";
    private static final String password = "root";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,user,password);
    }
    
    public static int insertUsers(Userdto dao) throws Exception {
        if (isEmailExists(dao.getEmail())) {
            throw new Exception("Email already exists");
        }
        if (isNameExists(dao.getName())) {
            throw new Exception("Username already exists");
        }
        
        String query = "insert into users(name, email, password) values(?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, dao.getName());
            ps.setString(2, dao.getEmail());
            ps.setString(3, Passwordinfo.hashPassword(dao.getPassword()));
            int Rows = ps.executeUpdate();
            
            if (Rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1); 
                    }
                }
            }
            return 0;
        }
    }
    
    public static Userdto getUserByEmail(String email) throws Exception {
        String query = "select userid, name, email, password from users where email = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Userdto user = new Userdto();
                    user.setUserid(String.valueOf(rs.getInt("userid")));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    return user;
                }
            }
        }
        return null;
    }
    
    public static boolean isEmailExists(String email) throws Exception {
        String query = "select count(*) from users where email = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
    
    public static boolean isNameExists(String name) throws Exception {
        String query = "select count(*) from users where name = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
}
