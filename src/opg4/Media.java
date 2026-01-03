package opg4;

import java.util.List;

public abstract class Media {

    protected String title;
    protected List<String> actors;

    // Constructor der initialiserer titel og skuespillere
    public Media(String title, List<String> actors) {
        this.title = title;
        this.actors = actors;
    }

    // Returnerer mediets titel
    public String getTitle() {
        return title;
    }

    // Returnerer liste over skuespillere
    public List<String> getActors() {
        return actors;
    }

    // Returnerer grundlæggende information om mediet
    public String getInfo() {
        return title + " with actors: " + String.join(", ", actors);
    }

    // ToString metode der bruger getInfo() for konsistens
    @Override
    public String toString() {
        return getInfo();
    }
}