package NEW.service;
import NEW.model.AudioContent;
import java.util.ArrayList;

public class LibraryRepository {

    private ArrayList<AudioContent> library = new ArrayList<>();

    public void add(AudioContent content) {
        library.add(content);
    }

    public void remove(AudioContent content) {
        library.remove(content);
    }


    public ArrayList<AudioContent> getLibrary() {
        return library;
    }


    public void setLibrary(ArrayList<AudioContent> newLibrary) {
        this.library = newLibrary;
    }
}