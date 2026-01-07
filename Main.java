package NEW.app;

import NEW.model.*;
import NEW.service.AudioManager;
import NEW.utils.InputValidator;

public class Main {
    private static final AudioManager manager = new AudioManager();
    private static final InputValidator validator = new InputValidator();

    public static void main(String[] args) {
        boolean running = true;


        while (running) {
            printMainMenu();
            int choice = validator.readInt("Изберете опция: ", 0, 8);

            switch (choice) {
                case 1:
                    addNewContent();
                    break;
                case 2:
                    manager.showCatalog();
                    break;
                case 3:
                    searchMenu();
                    break;
                case 4:
                    manager.sortByTitle();
                    break;
                case 5:
                    createAndManagePlaylist();
                    break;
                case 6:
                    deleteContent();
                    break;
                case 7:
                    manager.save();
                    break;
                case 8:
                    manager.load();
                    break;
                case 0:
                    running = false;
                    System.out.println("Изход...");
                    break;
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n--- ГЛАВНО МЕНЮ ---");
        System.out.println("1. Добави съдържание");
        System.out.println("2. Покажи всичко");
        System.out.println("3. Търсене");
        System.out.println("4. Сортиране по заглавие");
        System.out.println("5. Управление на Плейлист");
        System.out.println("6. Изтриване на обект");
        System.out.println("7. Запис във файл");
        System.out.println("8. Зареждане от файл");
        System.out.println("0. Изход");
    }

    private static void addNewContent() {
        System.out.println("\n--- Изберете тип ---");
        System.out.println("1. Песен");
        System.out.println("2. Подкаст");
        System.out.println("3. Аудиокнига");

        int type = validator.readInt("Вашият избор: ", 1, 3);

        String title = validator.readString("Заглавие: ");
        String author = validator.readTextOnly("Автор/Изпълнител: ");
        String genre = validator.readTextOnly("Жанр: ");
        int year = validator.readInt("Година (1800-2030): ", 1800, 2030);
        int duration = validator.readInt("Продължителност (мин): ", 1, 1000);

        AudioContent content = null;

        switch (type) {
            case 1:
                content = new Song(title, author, genre, year, duration);
                break;
            case 2:
                content = new Podcast(title, author, genre, year, duration);
                break;
            case 3:
                content = new AudioBook(title, author, genre, year, duration);
                break;
        }

        manager.add(content);
        System.out.println("Успешно добавено!");
    }

    private static void createAndManagePlaylist() {
        String plTitle = validator.readString("Име на новия плейлист: ");
        Playlist myPlaylist = new Playlist(plTitle);
        manager.add(myPlaylist);
        System.out.println("Плейлист '" + plTitle + "' е създаден!");

        boolean managing = true;
        while (managing) {
            System.out.println("\n--- Меню Плейлист: " + myPlaylist.getTitle() + " ---");
            System.out.println("1. Добави песен от каталога");
            System.out.println("2. Виж съдържанието");
            System.out.println("3. Премахни песен");
            System.out.println("0. Назад");

            int choice = validator.readInt("Избор: ", 0, 3);

            switch (choice) {
                case 1:
                    addToPlaylist(myPlaylist);
                    break;
                case 2:
                    System.out.println(myPlaylist);
                    if (myPlaylist.getItems().isEmpty()) System.out.println("(Празен)");
                    for (AudioContent ac : myPlaylist.getItems()) {
                        System.out.println("   -> " + ac.getTitle() + " (" + ac.getAuthor() + ")");
                    }
                    break;
                case 3:
                    removeFromPlaylist(myPlaylist);
                    break;
                case 0:
                    managing = false;
                    break;
            }
        }
    }

    private static void addToPlaylist(Playlist pl) {
        String searchTitle = validator.readString("Въведи точно заглавие от каталога: ");
        AudioContent found = manager.findContent(searchTitle);

        if (found != null) {
            pl.addContent(found);
            System.out.println("Успешно добавено: " + found.getTitle());
        } else {
            System.out.println("Няма такъв запис в каталога.");
        }
    }

    private static void deleteContent() {
        String t = validator.readString("Въведи заглавие за триене: ");
        manager.removeByTitle(t);
    }

    private static void searchMenu() {
        System.out.println("\n--- ТЪРСЕНЕ ---");
        System.out.println("1. Търсене по Заглавие");
        System.out.println("2. Търсене по Жанр");

        int c = validator.readInt("Избор: ", 1, 2);

        if (c == 1) {
            String t = validator.readString("Търси заглавие: ");
            manager.searchTitle(t);
        } else {
            String g = validator.readTextOnly("Търси жанр: ");
            manager.searchGenre(g);
        }
    }

    private static void removeFromPlaylist(Playlist pl) {
        String t = validator.readString("Заглавие за махане от плейлиста: ");
        AudioContent toRemove = null;
        for(AudioContent ac : pl.getItems()) {
            if(ac.getTitle().equalsIgnoreCase(t)) {
                toRemove = ac;
                break;
            }
        }

        if(toRemove != null) {
            pl.removeContent(toRemove);
            System.out.println("Премахнато.");
        } else {
            System.out.println("Не е намерено в този плейлист.");
        }
    }
}