package opg3;

import java.time.LocalDate;

public class Concert extends Event {
    private String artist;
    private String genre;


    public Concert(String title, LocalDate date, double price, int maxCapacity,
                   String artist, String genre) {
        super(title, date, price, maxCapacity);
        this.artist = artist;
        this.genre = genre;
    }


    @Override
    public String getDetails() {
        return "Concert: " + title + "\n | Artist: " + artist + "\n | Genre: " + genre +
                "\n | Date: " + date + "\n | Price: " + price +
                "\n | Available seats: " + getAvailableSeats();
    }
}
