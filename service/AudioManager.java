package NEW.service;
import NEW.model.AudioContent;
import java.util.ArrayList;

public class AudioManager {

    private final LibraryRepository repo = new LibraryRepository();
    private final ContentSearchService search = new ContentSearchService();
    private final ContentSortService sorter = new ContentSortService();
    private final CatalogPersistence persistence = new CatalogPersistence();



    public void add(AudioContent c) { repo.add(c); }

    public void remove(AudioContent c) { repo.remove(c); }

    public void showCatalog() {
        if (repo.getLibrary().isEmpty()) {
            System.out.println("Каталогът е празен.");
        } else {
            repo.getLibrary().forEach(System.out::println);
        }
    }

    public void searchTitle(String t) {
        var result = search.searchByTitle(t, repo.getLibrary());
        if (result.isEmpty()) {
            System.out.println("Няма намерени резултати.");
        } else {
            result.forEach(System.out::println);
        }
    }
    public void searchGenre(String g) {
        var result = search.searchByGenre(g, repo.getLibrary());
        if (result.isEmpty()) {
            System.out.println("Няма намерени резултати за жанр: " + g);
        } else {
            System.out.println("--- Намерени резултати (" + result.size() + ") ---");
            result.forEach(System.out::println);
        }
    }

    public void sortByTitle() {
        sorter.sortByTitle(repo.getLibrary());
        System.out.println("Каталогът е сортиран.");
        showCatalog();
    }

    public void save() {
        try {
            persistence.save(repo.getLibrary());
            System.out.println("Данните са записани успешно.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            ArrayList<AudioContent> loadedData = persistence.load();
            repo.setLibrary(loadedData);
            System.out.println("Данните са заредени успешно.");
        } catch (Exception e) {
            System.out.println("Проблем при зареждане (файлът може да липсва).");
        }
    }


    public void removeByTitle(String title) {
        boolean removed = repo.getLibrary().removeIf(content -> content.getTitle().equalsIgnoreCase(title));
        if (removed) {
            System.out.println("Записът '" + title + "' беше изтрит.");
        } else {
            System.out.println("Не е намерен запис с това име.");
        }
    }


    public AudioContent findContent(String title) {
        for (AudioContent ac : repo.getLibrary()) {
            if (ac.getTitle().equalsIgnoreCase(title)) {
                return ac;
            }
        }
        return null;
    }
}