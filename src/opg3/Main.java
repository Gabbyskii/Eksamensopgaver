package opg3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Opretter en EventManager til at håndtere vores events
        EventManager manager = new EventManager();

        // Opretter et koncert-event
        Event concert = new Concert(
                "Rolling Loud",
                LocalDate.of(2025, 6, 7),
                899.0,
                10000,
                "Drake",
                "Rap"
        );

        // Opretter et workshop-event
        Event workshop = new Workshop(
                "Coding Camp",
                LocalDate.of(2025, 12, 12),
                1999.0,
                30,
                "Tess",
                "Java Programming",
                true
        );

        // Tilføjer begge events til manageren
        manager.addEvent(concert);
        manager.addEvent(workshop);

        // Forsøger at booke sæder til begge events
        manager.bookEvent(concert, 10000);  // Booker alle koncert-sæder
        manager.bookEvent(workshop, 35);     // Forsøger at booke flere end kapaciteten (vil fejle)

        // Udskriver oversigt over alle events
        manager.printOverview();

        // Finder og udskriver det mest populære event
        Event mostPopular = manager.findMostPopularEvent();
        System.out.println("\nMost popular event is the " + mostPopular.getDetails().split("\n")[0]);

    }
}