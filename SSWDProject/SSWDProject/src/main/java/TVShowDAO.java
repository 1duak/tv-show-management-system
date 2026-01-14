import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public enum TVShowDAO {
    instance;

    public Connection getConnection() throws Exception {
        Class.forName("org.hsqldb.jdbcDriver");
        Connection con = DriverManager.getConnection(
                "jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");
        return con;
    }

    public void save(TVShows show) throws Exception {
        Connection connection = getConnection();
        PreparedStatement psmt = connection.prepareStatement(
                "INSERT INTO TVSHOW (title, genre, seasons, userEmail) VALUES (?, ?, ?, ?)");
        psmt.setString(1, show.getTitle());
        psmt.setString(2, show.getGenre());
        psmt.setString(3, show.getSeasons());
        psmt.setString(4, show.getUserEmail());
        psmt.executeUpdate();

        psmt.close();
        connection.close();
    }

    public List<TVShows> list() throws Exception {
        List<TVShows> shows = new ArrayList<>();
        Connection connection = getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM TVSHOW");

        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String genre = rs.getString("genre");
            String seasons = rs.getString("seasons");
            String userEmail = rs.getString("userEmail");

            TVShows show = new TVShows(id, title, genre, seasons, userEmail);
            shows.add(show);
        }

        rs.close();
        stmt.close();
        connection.close();
        return shows;
    }
}
