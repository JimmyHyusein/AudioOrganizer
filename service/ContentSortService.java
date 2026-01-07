package NEW.service;
import NEW.model.AudioContent;
import java.util.ArrayList;

public class ContentSortService {

    public void sortByTitle(ArrayList<AudioContent> library) {
        library.sort((a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));
    }
}