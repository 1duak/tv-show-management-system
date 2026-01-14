public class TVShows {

    private int id;
    private String title;
    private String genre;
    private String seasons;
    private String userEmail;

    public TVShows() {
    }

    public TVShows(String title, String genre, String seasons, String userEmail) {
        this.title = title;
        this.genre = genre;
        this.seasons = seasons;
        this.userEmail = userEmail;
    }

    public TVShows(int id, String title, String genre, String seasons, String userEmail) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.seasons = seasons;
        this.userEmail = userEmail;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSeasons() {
        return seasons;
    }
    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
