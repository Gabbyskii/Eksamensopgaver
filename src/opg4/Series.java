package opg4;

import java.util.ArrayList;
import java.util.List;

public class Series extends Media {

    private List<Season> seasons;

    // Constructor der initialiserer serien med titel og skuespillere
    public Series(String title, List<String> actors) {
        super(title, actors);
        this.seasons = new ArrayList<>();
    }


    public void addSeason(Season season) {
        seasons.add(season);
    }

    // Returnerer en kopi af sæson-listen for at beskytte encapsulation
    public List<Season> getSeasons() {
        return new ArrayList<>(seasons);
    }

    // Beregner og returnerer det samlede antal episoder på tværs af alle sæsoner
    public int getTotalEpisodes() {
        int total = 0;
        // Summerer episoder fra hver sæson
        for (Season season : seasons) {
            total += season.getTotalEpisodes();
        }
        return total;
    }

    // Finder og returnerer en specifik episode baseret på sæson- og episode-nummer
    public Episode getEpisode(int seasonNumber, int episodeNumber) {
        // Gennemgår alle sæsoner for at finde den rigtige
        for (Season season : seasons) {
            if (season.getSeasonNumber() == seasonNumber) {
                return season.getEpisode(episodeNumber); // Henter episode fra sæsonen
            }
        }
        return null; // Returnerer null hvis sæsonen eller episoden ikke findes
    }

    // Returnerer en formateret string med seriens information
    @Override
    public String toString() {
        return "Series: " + title + " (" + getTotalEpisodes() + " episodes across " +
                seasons.size() + " seasons)";
    }
}