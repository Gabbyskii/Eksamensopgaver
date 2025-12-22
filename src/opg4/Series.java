package opg4;

// Series.java
import java.util.ArrayList;
import java.util.List;

public class Series extends Media {
    private List<Season> seasons;

    public Series(String title, List<String> actors) {
        super(title, actors);
        this.seasons = new ArrayList<>();
    }

    public void addSeason(Season season) {
        seasons.add(season);
    }

    public List<Season> getSeasons() {
        return new ArrayList<>(seasons);
    }

    public int getTotalEpisodes() {
        int total = 0;
        for (Season season : seasons) {
            total += season.getTotalEpisodes();
        }
        return total;
    }

    public Episode getEpisode(int seasonNumber, int episodeNumber) {
        for (Season season : seasons) {
            if (season.getSeasonNumber() == seasonNumber) {
                return season.getEpisode(episodeNumber);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Series: " + title + " (" + getTotalEpisodes() + " episodes across " +
                seasons.size() + " seasons)";
    }
}