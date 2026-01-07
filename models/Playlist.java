package NEW.model;

import java.util.ArrayList;

public class Playlist extends AudioContent {
    private int count;
    private ArrayList<AudioContent> items;

    public int getCount() {
        return this.items.size();
    }

    public Playlist(String title) {
        super(title, "User", "Mix", 2025, 0);
        this.items = new ArrayList<>();

    }

    public void addContent (AudioContent content){

        items.add(content);

    }
    public void removeContent (AudioContent content){

        items.remove(content);

    }

    public ArrayList<AudioContent> getItems (){
        return items;
    }
    @Override
    public String toString() {
        return "Плейлиста: " + getTitle() + ", Брой песни: " + getCount();
    }
}
