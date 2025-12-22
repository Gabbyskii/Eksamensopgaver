package opg3;

import java.time.LocalDate;

public class Workshop extends Event {
    private String instructor;
    private String subject;
    private boolean materials;


    public Workshop(String title, LocalDate date, double price, int maxCapacity,
                    String instructor, String subject, boolean materials) {
        super(title, date, price, maxCapacity);
        this.instructor = instructor;
        this.subject = subject;
        this.materials= materials;
    }


    @Override
    public String getDetails() {
        return "\nWorkshop: " + title + "\n | Instructor: " + instructor +
                "\n | Subject: " + subject + "\n | Materials: " + materials +
                "\n | Date: " + date + "\n | Price: " + price +
                "\n | Available seats: " + getAvailableSeats();
    }
}