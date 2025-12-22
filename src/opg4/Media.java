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

    @Override
    public String toString() {
        return title + " with actors: " + actors;
    }
}