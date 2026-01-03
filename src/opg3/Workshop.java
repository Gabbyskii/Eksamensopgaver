package opg3;

import java.time.LocalDate;

// Subklasse der repræsenterer et workshop-event
public class Workshop extends Event {
    // Ekstra attributter specifikt for workshops
    private String instructor;
    private String subject;
    private boolean materials; // Om der er inkluderet materialer

    // Constructor der kalder superklassens constructor og sætter workshop-specifikke felter
    public Workshop(String title, LocalDate date, double price, int maxCapacity,
                    String instructor, String subject, boolean materials) {
        super(title, date, price, maxCapacity);
        this.instructor = instructor;
        this.subject = subject;
        this.materials= materials;
    }

    // Implementation af abstrakt metode - returnerer workshoppens detaljer som String
    @Override
    public String getDetails() {
        return "\nWorkshop: " + title + "\n | Instructor: " + instructor +
                "\n | Subject: " + subject + "\n | Materials: " + materials +
                "\n | Date: " + date + "\n | Price: " + price +
                "\n | Available seats: " + getAvailableSeats();
    }
}
