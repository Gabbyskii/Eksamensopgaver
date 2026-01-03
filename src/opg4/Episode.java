package opg4;

// Klasse der repræsenterer en episode i en serie - arver fra Media og implementerer Playable
import java.util.List;

public class Episode extends Media implements Playable {

    private int episodeNumber;
    private int duration;

    // Constructor der initialiserer episode med titel, skuespillere, episode-nummer og varighed
    public Episode(String title, List<String> actors, int episodeNumber, int duration) {
        super(title, actors); // Kalder parent class constructor
        this.episodeNumber = episodeNumber;
        this.duration = duration;
    }

    // Returnerer episode-nummeret
    public int getEpisodeNumber() {
        return episodeNumber;
    }

    // Implementerer play() fra Playable - afspiller episoden
    @Override
    public void play() {
        System.out.println("Now playing episode " + episodeNumber + ": " + title);
        System.out.println("Duration: " + duration + " minutes");
    }

    // Implementerer getDuration() fra Playable - returnerer episodens varighed
    @Override
    public int getDuration() {
        return duration;
    }

    // Returnerer en formateret string med episodens information
    @Override
    public String toString() {
        return "Episode " + episodeNumber + ": " + title + " (" + duration + " min)";
    }
}