package NEW.model;
import java.io.Serializable;

public abstract class AudioContent implements Serializable{
    private String title;
    private String author;
    private String genre;
    private int year;
    private int duration;

    public AudioContent (String title, String author, String genre, int year, int duration){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
    }
    public String getTitle() {
        return title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Заглавие: " + getTitle() + " | Автор: " + getAuthor() + " | Жанр: " + getGenre()
                + " | Година: " + getYear() +
                " | Продължителност: " + getDuration();
    }
}
