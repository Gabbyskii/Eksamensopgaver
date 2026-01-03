package opg4;

import java.util.List;

public class Movie extends Media implements Playable {

    private String director;
    private int duration;

    // Constructor der initialiserer film med titel, skuespillere, instruktør og varighed
    public Movie(String title, List<String> actors, String director, int duration) {
        super(title, actors); // Kalder parent class constructor
        this.director = director;
        this.duration = duration;
    }


    public String getDirector() {
        return director;
    }

    // Implementerer play() fra Playable - afspiller filmen
    @Override
    public void play() {
        System.out.println("Now playing movie: " + title);
        System.out.println("Directed by: " + director);
        System.out.println("Duration: " + duration + " minutes");
    }

    // Implementerer getDuration() fra Playable - returnerer filmens varighed
    @Override
    public int getDuration() {
        return duration;
    }

    // Returnerer en formateret string med filmens information
    @Override
    public String toString() {
        return "Movie: " + title + " (Director: " + director + ", Duration: " + duration + " min)";
    }
}
