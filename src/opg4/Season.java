package opg4;

import java.util.ArrayList;
import java.util.List;

public class Season {
    private int seasonNumber;
    private List<Episode> episodes; // Liste over episoder i denne sæson

    // Constructor der initialiserer sæsonen med et sæson-nummer
    public Season(int seasonNumber) {
        this.seasonNumber = seasonNumber;
        this.episodes = new ArrayList<>(); // Opretter tom liste til episoder
    }

    // Returnerer sæson-nummeret
    public int getSeasonNumber() {
        return seasonNumber;
    }

    // Tilføjer en episode til sæsonen
    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    // Returnerer en kopi af episode-listen for at beskytte encapsulation
    public List<Episode> getEpisodes() {
        return new ArrayList<>(episodes);
    }

    // Returnerer det samlede antal episoder i sæsonen
    public int getTotalEpisodes() {
        return episodes.size();
    }

    // Finder og returnerer en specifik episode baseret på episode-nummer
    public Episode getEpisode(int episodeNumber) {
        // Gennemgår alle episoder for at finde den med det rigtige nummer
        for (Episode episode : episodes) {
            if (episode.getEpisodeNumber() == episodeNumber) {
                return episode;
            }
        }
        return null; // Returnerer null hvis episoden ikke findes
    }

    // Returnerer en formateret string med sæsonens information
    @Override
    public String toString() {
        return "Season " + seasonNumber + " (" + episodes.size() + " episodes)";
    }
}