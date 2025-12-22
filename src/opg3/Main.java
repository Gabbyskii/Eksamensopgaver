package opg3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //TODO: Tænk over:
        // • Hvordan holder du styr på antal bookede billetter for hvert event? - shows available seats.
        // • Hvordan tjekker du om et event er sold out? - return når bookedSeats == maxCapacity;
        // • Hvordan validerer du at der er ledige pladser før en booking?
        // • Hvordan håndterer du fejlsituationer? (Hint: exceptions eller returværdier?) - returnværdier (if + return)


        EventManager manager = new EventManager();

        Event concert = new Concert(
                "Rolling Loud",
                LocalDate.of(2025, 6, 7),
                899.0,
                10000,
                "Drake",
                "Rap"
        );


        Event workshop = new Workshop(
                "Coding Camp",
                LocalDate.of(2025, 12, 12),
                1999.0,
                30,
                "Tess",
                "Java Programming",
                true
        );


        manager.addEvent(concert);
        manager.addEvent(workshop);


        manager.bookEvent(concert, 10000);
        manager.bookEvent(workshop, 35);


        manager.printOverview();


        Event mostPopular = manager.findMostPopularEvent();
        System.out.println("\nMost popular event is the " + mostPopular.getDetails().split("\n")[0]);

    }
}
