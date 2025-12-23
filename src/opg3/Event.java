package opg3;

import java.time.LocalDate;
import java.util.*;

public abstract class Event {
    protected String title;
    protected LocalDate date;
    protected double price;
    protected int maxCapacity;
    protected int bookedSeats;


    public Event(String title, LocalDate date, double price, int maxCapacity) {
        this.title = title;
        this.date = date;
        this.price = price;
        this.maxCapacity = maxCapacity;
        this.bookedSeats = 0;
    }


   /* public boolean bookSeats(int amount) {
        if (bookedSeats + amount <= maxCapacity) {
            bookedSeats += amount;
            return true;
        }
        return false;
    }*/
   // I Event.java
   public boolean bookSeats(int amount) {
       if (amount <= 0) {
           return false; // eller kast IllegalArgumentException
       }
       if (bookedSeats + amount <= maxCapacity) {
           bookedSeats += amount;
           return true;
       }
       return false;
   }

    public boolean isSoldOut() {
        return bookedSeats == maxCapacity;  // Kun udsolgt når præcis fyldt
    }


    public int getAvailableSeats() {
        return maxCapacity - bookedSeats;
    }


    public double getRevenue() {
        return bookedSeats * price;
    }


    public abstract String getDetails();

}
