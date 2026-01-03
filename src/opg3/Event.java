package opg3;

import java.time.LocalDate;
import java.util.*;

// Abstrakt superklasse for alle typer events
public abstract class Event {
    // Fælles attributter for alle events
    protected String title;
    protected LocalDate date;
    protected double price;
    protected int maxCapacity;
    protected int bookedSeats;

    // Constructor til at initialisere et event
    public Event(String title, LocalDate date, double price, int maxCapacity) {
        this.title = title;
        this.date = date;
        this.price = price;
        this.maxCapacity = maxCapacity;
        this.bookedSeats = 0; // Starter med 0 bookede sæder
    }

    // Booker et antal sæder hvis der er plads
    public boolean bookSeats(int amount) {
        // Tjekker at amount er positivt
        if (amount <= 0) {
            return false;
        }
        // Tjekker om der er plads nok
        if (bookedSeats + amount <= maxCapacity) {
            bookedSeats += amount;
            return true;
        }
        return false;
    }

    // Returnerer true hvis eventet er fuldstændig udsolgt
    public boolean isSoldOut() {
        return bookedSeats == maxCapacity;
    }

    // Beregner hvor mange ledige sæder der er tilbage
    public int getAvailableSeats() {
        return maxCapacity - bookedSeats;
    }

    // Beregner den samlede indtægt fra bookede sæder
    public double getRevenue() {
        return bookedSeats * price;
    }

    // Abstrakt metode - hver subklasse skal implementere sin egen version
    public abstract String getDetails();

}
