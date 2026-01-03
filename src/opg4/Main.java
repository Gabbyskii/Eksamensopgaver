package opg4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Opretter en ny streaming-tjeneste (som Netflix)
        Streaming netflix = new Streaming();

        // OPRETTER EN FILM
        // Definerer skuespillere til Inception
        List<String> inceptionActors = Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page");
        // Opretter film-objekt med titel, skuespillere, instruktør og varighed
        Movie inception = new Movie("Inception", inceptionActors, "Christopher Nolan", 148);
        // Tilføjer filmen til Netflix
        netflix.addMedia(inception);

        // OPRETTER EN SERIE
        // Definerer skuespillere til Stranger Things
        List<String> strangerThingsActors = Arrays.asList("Millie Bobby Brown", "Finn Wolfhard", "Winona Ryder");
        // Opretter serie-objekt
        Series strangerThings = new Series("Stranger Things", strangerThingsActors);

        // OPRETTER SÆSON 1
        Season season1 = new Season(1);
        // Tilføjer episoder til sæson 1
        season1.addEpisode(new Episode("The Vanishing of Will Byers",
                Arrays.asList("Millie Bobby Brown", "Finn Wolfhard"), 1, 48));
        season1.addEpisode(new Episode("The Weirdo on Maple Street",
                Arrays.asList("Millie Bobby Brown", "Finn Wolfhard"), 2, 55));

        // OPRETTER SÆSON 2
        Season season2 = new Season(2);
        // Tilføjer episoder til sæson 2
        season2.addEpisode(new Episode("MADMAX",
                Arrays.asList("Millie Bobby Brown", "Finn Wolfhard", "Noah Schnapp"), 1, 58));
        season2.addEpisode(new Episode("Trick or Treat, Freak",
                Arrays.asList("Millie Bobby Brown", "Finn Wolfhard"), 2, 56));
        season2.addEpisode(new Episode("The Pollywog",
                Arrays.asList("Millie Bobby Brown", "Finn Wolfhard", "Noah Schnapp"), 3, 51));
        season2.addEpisode(new Episode("Will the Wise",
                Arrays.asList("Millie Bobby Brown", "Finn Wolfhard"), 4, 57));
        season2.addEpisode(new Episode("The Mind Flayer",
                Arrays.asList("Millie Bobby Brown", "Finn Wolfhard"), 5, 59));

        // Tilføjer sæsonerne til serien
        strangerThings.addSeason(season1);
        strangerThings.addSeason(season2);

        // Tilføjer serien til Netflix
        netflix.addMedia(strangerThings);

        // TESTER SYSTEMET
        System.out.println("=== Testing Streaming Service ===\n");

        // Test 1: Printer hele mediebiblioteket
        netflix.printLibrary();

        System.out.println("\n=== Testing Play Functions ===\n");

        // Test 2: Afspiller en film
        System.out.println("1. Playing a movie:");
        netflix.playMovie("Inception");

        // Test 3: Afspiller en specifik episode
        System.out.println("\n2. Playing an episode:");
        netflix.playEpisode("Stranger Things", 2, 5);

        // Test 4: Finder en specifik episode
        System.out.println("\n3. Finding specific episode:");
        Episode episode = netflix.findEpisode("Stranger Things", 2, 5);
        if (episode != null) {
            System.out.println("Found: " + episode);
        }

        // Test 5: Tæller samlet antal episoder i en serie
        System.out.println("\n4. Total episodes in Stranger Things:");
        System.out.println(strangerThings.getTotalEpisodes() + " episodes");

        // Test 6: Prøver at finde indhold der ikke eksisterer
        System.out.println("\n5. Trying to find non-existent content:");
        netflix.playMovie("Fake Movie"); // Film findes ikke
        netflix.playEpisode("Stranger Things", 3, 1); // Sæson 3 findes ikke
    }
}