package opg4;

import java.util.List;

public class Episode extends Media implements Playable {
    private int episodeNumber;
    private int duration; //

    public Episode(String title, List<String> actors, int episodeNumber, int duration) {
        super(title, actors);
        this.episodeNumber = episodeNumber;
        this.duration = duration;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    @Override
    public void play() {
        System.out.println("Now playing episode " + episodeNumber + ": " + title);
        System.out.println("Duration: " + duration + " minutes");
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Episode " + episodeNumber + ": " + title + " (" + duration + " min)";
    }
}