package opg1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BikeCommute {
    // Array med alle månedsnavne - bruges til at validere input og finde månedsindex
    private String[] months = {"januar", "februar", "marts", "april", "maj", "juni",
            "juli", "august", "september", "oktober", "november", "december"};

    // Array til at gemme antal ture for hver måned (index 0-11 = januar-december)
    private int[] rides = new int[12];

    // Variabel til at holde styr på det samlede klimarabat-beløb
    private int totalAmount = 0;

    // Variabel til at tælle det totale antal cykelture
    private int totalRides = 0;

    // Scanner objekt til at læse brugerinput fra konsollen
    private Scanner scanner;

    // Constructor - initialiserer scanner objektet
    public BikeCommute() {
        scanner = new Scanner(System.in);
    }

    // Hovedmetode der håndterer registrering af cykelture
    public void registerRides() {
        // Variabel til at styre om loopet skal fortsætte (j = ja, n = nej)
        String continueReg = "j";

        // Loop der kører så længe brugeren svarer "j" (ja)
        while (continueReg.equalsIgnoreCase("j")) {
            try {
                // Bed brugeren om at indtaste månedens navn
                System.out.print("Indtast måned: ");
                String monthName = scanner.nextLine().toLowerCase().trim();

                // Find månedens index (0-11) baseret på navnet
                int monthIndex = getMonthIndex(monthName);

                // Tjek om måneden er gyldig
                if (monthIndex == -1) {
                    System.out.println("Ugyldig måned. Prøv igen med et gyldigt månedsnavn (fx januar, februar, osv.)");
                    continue; // Spring til næste iteration af loopet
                }

                // Bed brugeren om at indtaste antal cykelture
                System.out.print("Antal cykelture: ");
                int numRides = scanner.nextInt();
                scanner.nextLine(); // Ryd buffer efter nextInt() for at undgå problemer

                // Valider at antal ture er et positivt tal
                if (numRides < 0) {
                    System.out.println("Antal cykelture kan ikke være negativt. Prøv igen.");
                    continue;
                }

                // Gem antal ture for denne måned i arrayet
                rides[monthIndex] = numRides;

                // Læg til det totale antal ture
                totalRides += numRides;

                // Beregn klimarabat for denne måned (inkl. bonus hvis relevant)
                int monthAmount = calculateMonthAmount(monthIndex, numRides);

                // Læg månedbeløbet til det totale beløb
                totalAmount += monthAmount;

                // Vis klimarabat for den registrerede måned
                System.out.println("Klimarabat for " + monthName + ": " + monthAmount + "kr");
                System.out.println();

            } catch (InputMismatchException e) {
                // Håndter fejl hvis brugeren indtaster bogstaver i stedet for tal
                System.out.println("Fejl: Du skal indtaste et tal for antal cykelture. Prøv igen.");
                scanner.nextLine(); // Ryd den ugyldige input fra buffer
                continue; // Spring til næste iteration for at prøve igen
            }

            // Spørg om brugeren vil fortsætte med at registrere flere måneder
            System.out.print("Fortsæt registrering? (j/n): ");
            continueReg = scanner.nextLine();
        }

        // Når loopet er færdigt, vis den samlede oversigt
        displaySummary();
    }

    // Hjælpemetode der finder index (0-11) for et månedsnavn
    private int getMonthIndex(String monthName) {
        // Loop gennem alle måneder i arrayet
        for (int i = 0; i < months.length; i++) {
            // Sammenlign månedsnavn (case-insensitive)
            if (months[i].equalsIgnoreCase(monthName)) {
                return i; // Returner index hvis der er match
            }
        }
        return -1; // Returner -1 hvis måneden ikke blev fundet (ugyldig)
    }

    // Beregner klimarabat for en måned baseret på sæson og antal ture
    private int calculateMonthAmount(int monthIndex, int numRides) {
        int amount;

        // Bestem om det er vinter eller sommer baseret på månedsindex
        // Vinter: november(10), december(11), januar(0), februar(1), marts(2)
        if (monthIndex == 10 || monthIndex == 11 || monthIndex <= 2) {
            amount = numRides * 15; // Vintersats: 15kr per tur
        } else {
            // Sommer: april(3) til oktober(9)
            amount = numRides * 10; // Sommersats: 10kr per tur
        }

        // Tilføj bonus hvis brugeren har cyklet 20 eller flere gange
        if (numRides >= 20) {
            amount += 50; // Bonus: 50kr ekstra
        }

        return amount; // Returner det samlede beløb for måneden
    }

    // Viser den endelige oversigt med CO₂-besparelse og samlet klimarabat
    private void displaySummary() {
        // Beregn total CO₂ besparelse: hver tur sparer 2,6kg CO₂
        double co2Saved = totalRides * 2.6;

        // Beregn træ-ækvivalent: et træ absorberer ca. 20kg CO₂ per år
        double treesEquivalent = co2Saved / 20.0;

        // Vis den flotte besked med CO₂-besparelse og træ-sammenligning
        System.out.println("\nFlot arbejde! Du har sparet klimaet for " +
                String.format("%.0f", co2Saved) + "kg CO₂ (svarende til " +
                String.format("%.0f", treesEquivalent) + " træers årlige absorption)");

        // Vis det samlede klimarabat-beløb
        System.out.println("Din klimarabat: " + totalAmount + "kr overføres til din NemKonto");
    }
}
