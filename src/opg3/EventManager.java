package opg3;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    // Liste til at gemme alle events
    private List<Event> events = new ArrayList<>();

    // Metode til at tilføje et event til listen
    public void addEvent(Event event) {
        events.add(event);
    }

    // Implementering af udvidelse - booker sæder og viser fejlbesked hvis det ikke lykkes
    public boolean bookEvent(Event event, int seats) {
        boolean success = event.bookSeats(seats);
        if (!success) {
            // Udskriver fejlbesked hvis booking mislykkes
            System.out.println("\nFailed to book " + seats + " seats for " +
                    event.getDetails().split("\n")[1]);
        }
        return success;
    }

    // Udskriver oversigt over alle events med deres detaljer
    public void printOverview() {
        System.out.println("\n--- EVENT OVERVIEW ---\n");
        for (Event e : events) {
            System.out.println(e.getDetails());
            // Viser SOLD OUT status hvis eventet er udsolgt
            if (e.isSoldOut()) {
                System.out.println("Status: SOLD OUT!!!");
            }
        }
    }

    // Finder det mest populære event baseret på antal bookede sæder
    public Event findMostPopularEvent() {
        Event mostPopular = null;

        // Gennemgår alle events og finder det med flest bookede sæder
        for (Event e : events) {
            if (mostPopular == null || e.bookedSeats > mostPopular.bookedSeats) {
                mostPopular = e;
            }
        }
        return mostPopular;
    }

}
