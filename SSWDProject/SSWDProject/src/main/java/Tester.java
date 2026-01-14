public class Tester {
    public static void main(String[] args) {
        try {
            TVShowDAO.instance.save(new TVShows("New Show", "Genre", "3", "someone@email.com"));
            System.out.println("TV Show saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
