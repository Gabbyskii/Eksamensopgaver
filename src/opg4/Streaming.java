package opg4;

// Streaming.java - Main system class
import java.util.ArrayList;
import java.util.List;

public class Streaming {
    private List<Media> mediaLibrary;

    public Streaming() {
        this.mediaLibrary = new ArrayList<>();
    }

    public void addMedia(Media media) {
        mediaLibrary.add(media);
    }

    public Movie findMovie(String title) {
        for (Media media : mediaLibrary) {
            if (media instanceof Movie && media.getTitle().equalsIgnoreCase(title)) {
                return (Movie) media;
            }
        }
        return null;
    }

    public Episode findEpisode(String seriesTitle, int seasonNumber, int episodeNumber) {
        for (Media media : mediaLibrary) {
            if (media instanceof Series) {
                Series series = (Series) media;
                if (series.getTitle().equalsIgnoreCase(seriesTitle)) {
                    return series.getEpisode(seasonNumber, episodeNumber);
                }
            }
        }
        return null;
    }

    public void playMovie(String title) {
        Movie movie = findMovie(title);
        if (movie != null) {
            movie.play();
        } else {
            System.out.println("Movie not found: " + title);
        }
    }

    public void playEpisode(String seriesTitle, int seasonNumber, int episodeNumber) {
        Episode episode = findEpisode(seriesTitle, seasonNumber, episodeNumber);
        if (episode != null) {
            episode.play();
        } else {
            System.out.println("Episode not found: " + seriesTitle + " S" +
                    seasonNumber + "E" + episodeNumber);
        }
    }

    public void printLibrary() {
        System.out.println("=== Media Library ===");
        for (Media media : mediaLibrary) {
            System.out.println(media);
            if (media instanceof Series) {
                Series series = (Series) media;
                for (Season ss : series.getSeasons()) {
                    System.out.println("  " + ss);
                    for (Episode ep  : ss.getEpisodes()) {
                        System.out.println("    " + ep);
                    }
                }
            }
        }
    }
}