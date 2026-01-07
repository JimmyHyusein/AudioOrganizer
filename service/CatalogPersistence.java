package NEW.service;
import NEW.model.AudioContent;
import java.io.*;
import java.util.ArrayList;

public class CatalogPersistence {

    public void save(ArrayList<AudioContent> library) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("catalog.ser"))) {
            out.writeObject(library);
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<AudioContent> load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("catalog.ser"))) {
            return (ArrayList<AudioContent>) in.readObject();
        }
    }
}