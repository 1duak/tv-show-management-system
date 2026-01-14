import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public enum UserDAO {
	instance;
	public Connection getConnection() throws Exception{
		Class.forName("org.hsqldb.jdbcDriver");
		Connection con;
		con = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");
		return con;
	}
	
	public void save(User u) throws Exception{
		Connection connection = getConnection();
		PreparedStatement psmt = connection.prepareStatement
				("INSERT INTO USER (name, email, password) VALUES (?, ?)");
		psmt.setString(1, u.getName());
		psmt.setString(1, u.getEmail());
		psmt.setString(1, u.getPassword());
		psmt.executeUpdate();
		
		psmt.close();
		connection.close();
	}
	
	public List<User> list() throws Exception{
		List<User> listOfUsers = new ArrayList();
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT name, address FROM USER");
		while (rs.next()) {
			String name = rs.getString("name");
			String email = rs.getString("email");
			String password = rs.getString("password");
			User u = new User(name, email, password);
			listOfUsers.add(u);
		}return listOfUsers;
	}
}
