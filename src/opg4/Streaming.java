package opg4;

import java.util.ArrayList;
import java.util.List;

public class Streaming {

    private List<Media> mediaLibrary;

    public Streaming() {
        this.mediaLibrary = new ArrayList<>();
    }

    // Tilføjer medie (film eller serie) til biblioteket
    public void addMedia(Media media) {
        mediaLibrary.add(media);
    }

    // Finder og returnerer en film baseret på titel (ignorerer store/små bogstaver)
    public Movie findMovie(String title) {

        for (Media media : mediaLibrary) {
            // Tjekker om mediet er en film og om titlen matcher
            if (media instanceof Movie && media.getTitle().equalsIgnoreCase(title)) {
                return (Movie) media; // Caster til Movie og returnerer
            }
        }
        return null;
    }

    // Finder og returnerer en episode baseret på serie-titel, sæson- og episode-nummer
    public Episode findEpisode(String seriesTitle, int seasonNumber, int episodeNumber) {
        // Gennemgår alle medier i biblioteket
        for (Media media : mediaLibrary) {
            // Tjekker om mediet er en serie
            if (media instanceof Series) {
                Series series = (Series) media;

                if (series.getTitle().equalsIgnoreCase(seriesTitle)) { // Tjekker om serie-titlen matcher
                    return series.getEpisode(seasonNumber, episodeNumber);
                }
            }
        }
        return null;
    }

    // Afspiller en film baseret på titel
    public void playMovie(String title) {
        Movie movie = findMovie(title);
        if (movie != null) {
            movie.play();
        } else {
            System.out.println("Movie not found: " + title);
        }
    }

    // Afspiller en episode baseret på serie-titel, sæson- og episode-nummer
    public void playEpisode(String seriesTitle, int seasonNumber, int episodeNumber) {
        Episode episode = findEpisode(seriesTitle, seasonNumber, episodeNumber);
        if (episode != null) {
            episode.play();
        } else {
            System.out.println("Episode not found: " + seriesTitle + " S" +
                    seasonNumber + "E" + episodeNumber);
        }
    }

    // Printer hele mediebiblioteket med alle detaljer
    public void printLibrary() {
        System.out.println("=== Media Library ===");

        for (Media media : mediaLibrary) {
            System.out.println(media); // Printer medie-information

            if (media instanceof Series) {  // Hvis mediet er serie, print alle sæsoner og episoder
                Series series = (Series) media;

                for (Season ss : series.getSeasons()) { // Gennemgår alle sæsoner i serien
                    System.out.println("  " + ss); // Printer sæson med indrykning

                    for (Episode ep  : ss.getEpisodes()) { // Gennemgår alle episoder i sæsonen
                        System.out.println("    " + ep); // Printer episode med større indrykning
                    }
                }
            }
        }
    }
}