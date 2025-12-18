package opg1;

public class Main {
    public static void main(String[] args) {
        // Opret et nyt BikeCommute objekt
        BikeCommute bikeCommute = new BikeCommute();

        // Velkomstbesked
        System.out.println("=== Klimarabat på cyklependling ===\n");

        // Start registreringsprocessen
        bikeCommute.registerRides();
    }
}