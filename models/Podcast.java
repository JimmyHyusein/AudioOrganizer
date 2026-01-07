package NEW.model;

public class Podcast extends AudioContent {

    public Podcast(String title, String author, String genre, int year, int duration) {
        super(title, author, genre, year, duration);

    }



    @Override
    public String toString() {
        return "Водещ: " + getAuthor() + " (Podcast)";
    }
}
