package opg4;

import java.util.List;

public class Movie extends Media implements Playable {
    private String director;
    private int duration; // i minutter

    public Movie(String title, List<String> actors, String director, int duration) {
        super(title, actors);
        this.director = director;
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public void play() {
        System.out.println("Now playing movie: " + title);
        System.out.println("Directed by: " + director);
        System.out.println("Duration: " + duration + " minutes");
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Movie: " + title + " (Director: " + director + ", Duration: " + duration + " min)";
    }
}