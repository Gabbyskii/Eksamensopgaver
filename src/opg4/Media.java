package opg4;

// Media.java - Abstract base class
import java.util.List;

public abstract class Media {
    protected String title;
    protected List<String> actors;

    public Media(String title, List<String> actors) {
        this.title = title;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getActors() {
        return actors;
    }

    // TILFØJET: getInfo() metode som krævet i klassediagrammet
    // Denne metode returnerer grundlæggende information om mediet
    public String getInfo() {
        return title + " with actors: " + String.join(", ", actors);
    }

    @Override
    public String toString() {
        return getInfo(); // Bruger getInfo() for konsistens
    }
}