package opg3;

import java.time.LocalDate;

// Subklasse der repræsenterer et koncert-event
public class Concert extends Event {
    // Ekstra attributter specifikt for koncerter
    private String artist;
    private String genre;

    // Constructor kalder superklassens constructor og sætter koncert-specifikke felter
    public Concert(String title, LocalDate date, double price, int maxCapacity,
                   String artist, String genre) {
        super(title, date, price, maxCapacity);
        this.artist = artist;
        this.genre = genre;
    }

    // Implementation af abstrakt metode - returnerer koncertens detaljer som String
    @Override
    public String getDetails() {
        return "Concert: " + title + "\n | Artist: " + artist + "\n | Genre: " + genre +
                "\n | Date: " + date + "\n | Price: " + price +
                "\n | Available seats: " + getAvailableSeats();
    }
}
