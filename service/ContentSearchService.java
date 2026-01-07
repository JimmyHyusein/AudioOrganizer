package NEW.service;
import NEW.model.AudioContent;
import java.util.ArrayList;

public class ContentSearchService {

    public ArrayList<AudioContent> searchByTitle(String title, ArrayList<AudioContent> library) {
        ArrayList<AudioContent> result = new ArrayList<>();
        for (AudioContent a : library) {
            if (a.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(a);
            }
        }
        return result;
    }

    public ArrayList<AudioContent> searchByAuthor(String author, ArrayList<AudioContent> library) {
        ArrayList<AudioContent> result = new ArrayList<>();
        for (AudioContent a : library) {
            if (a.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(a);
            }
        }
        return result;
    }

    public ArrayList<AudioContent> searchByGenre(String genre, ArrayList<AudioContent> library) {
        ArrayList<AudioContent> result = new ArrayList<>();
        for (AudioContent a : library) {
            if (a.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                result.add(a);
            }
        }
        return result;
    }
}