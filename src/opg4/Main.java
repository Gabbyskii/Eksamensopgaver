package opg4;

import java.util.Arrays;
import java.util.List;

    public class Main {
        public static void main(String[] args) {
            // Create Streaming Service
            Streaming netflix = new Streaming();

            // Create a Movie
            List<String> inceptionActors = Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page");
            Movie inception = new Movie("Inception", inceptionActors, "Christopher Nolan", 148);
            netflix.addMedia(inception);

            // Create a Series
            List<String> strangerThingsActors = Arrays.asList("Millie Bobby Brown", "Finn Wolfhard", "Winona Ryder");
            Series strangerThings = new Series("Stranger Things", strangerThingsActors);

            // Create Season 1
            Season season1 = new Season(1);
            season1.addEpisode(new Episode("The Vanishing of Will Byers",
                    Arrays.asList("Millie Bobby Brown", "Finn Wolfhard"), 1, 48));
            season1.addEpisode(new Episode("The Weirdo on Maple Street",
                    Arrays.asList("Millie Bobby Brown", "Finn Wolfhard"), 2, 55));

            // Create Season 2
            Season season2 = new Season(2);
            season2.addEpisode(new Episode("MADMAX",
                    Arrays.asList("Millie Bobby Brown", "Finn Wolfhard", "Noah Schnapp"), 1, 58));
            season2.addEpisode(new Episode("Trick or Treat, Freak",
                    Arrays.asList("Millie Bobby Brown", "Finn Wolfhard"), 2, 56));
            season2.addEpisode(new Episode("The Pollywog",
                    Arrays.asList("Millie Bobby Brown", "Finn Wolfhard", "Noah Schnapp"), 3, 51));
            season2.addEpisode(new Episode("The Mind Flayer",
                    Arrays.asList("Millie Bobby Brown", "Finn Wolfhard"), 5, 59));

            // Add seasons to series
            strangerThings.addSeason(season1);
            strangerThings.addSeason(season2);

            // Add series to streaming service
            netflix.addMedia(strangerThings);

            // Test the system
            System.out.println("=== Testing Streaming Service ===\n");

            // Print library
            netflix.printLibrary();

            System.out.println("\n=== Testing Play Functionality ===\n");

            // Play a movie
            System.out.println("1. Playing a movie:");
            netflix.playMovie("Inception");

            // Play an episode
            System.out.println("\n2. Playing an episode:");
            netflix.playEpisode("Stranger Things", 2, 5);

            // Find specific episode
            System.out.println("\n3. Finding specific episode:");
            Episode episode = netflix.findEpisode("Stranger Things", 2, 5);
            if (episode != null) {
                System.out.println("Found: " + episode);
            }

            // Get total episodes in series
            System.out.println("\n4. Total episodes in Stranger Things:");
            System.out.println(strangerThings.getTotalEpisodes() + " episodes");

            // Try to find non-existent content
            System.out.println("\n5. Trying to find non-existent content:");
            netflix.playMovie("Non-existent Movie");
            netflix.playEpisode("Stranger Things", 3, 1); // Season 3 doesn't exist
        }
    }

