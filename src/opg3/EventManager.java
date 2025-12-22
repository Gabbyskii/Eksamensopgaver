package opg3;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Event> events = new ArrayList<>();


    public void addEvent(Event event) {
        events.add(event);
    }


    /*public boolean bookEvent(Event event, int seats) {
        return event.bookSeats(seats);
    }*/
    //implementering af udvidelse
    public boolean bookEvent(Event event, int seats) {
        boolean success = event.bookSeats(seats);
        if (!success) {
            System.out.println("\nFailed to book " + seats + " seats for " +
                    event.getDetails().split("\n")[1]);
        }
        return success;
    }


    public void printOverview() {
        System.out.println("\n--- EVENT OVERVIEW ---\n");
        for (Event e : events) {
            System.out.println(e.getDetails());
            if (e.isSoldOut()) {
                System.out.println("Status: SOLD OUT!!!");
            }
        }
    }

    public Event findMostPopularEvent() {
        Event mostPopular = null;

        for (Event e : events) {
            if (mostPopular == null || e.bookedSeats > mostPopular.bookedSeats) {
                mostPopular = e;
            }
        }
        return mostPopular;
    }

}
