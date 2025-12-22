package opg4;

import java.util.ArrayList;
import java.util.List;

public class Season {
    private int seasonNumber;
    private List<Episode> episodes;

    public Season(int seasonNumber) {
        this.seasonNumber = seasonNumber;
        this.episodes = new ArrayList<>();
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    public List<Episode> getEpisodes() {
        return new ArrayList<>(episodes); // Returner kopi for encapsulation
    }

    public int getTotalEpisodes() {
        return episodes.size();
    }

    public Episode getEpisode(int episodeNumber) {
        for (Episode episode : episodes) {
            if (episode.getEpisodeNumber() == episodeNumber) {
                return episode;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Season " + seasonNumber + " (" + episodes.size() + " episodes)";
    }
}