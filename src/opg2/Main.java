package opg2;

public class Main {
    public static void main(String[] args) {
        // Instantier SaunaVillage
        SaunaVillage village = new SaunaVillage();

        // Load CSV fil (sørg for at filen eksisterer i dit projekt)
        village.loadFromCSV("src/opg2/sauna.txt");

        // Udskriv rapport
        village.printReport();

        // Gennemsnitlig omkostning for Wood saunaer
        double avgWood = village.getAverageCost("Wood");
        System.out.printf("Gennemsnitlig pris for Wood saunaer: %.2f kr%n", avgWood);

        // Gennemsnitlig omkostning for Electric saunaer
        double avgElectric = village.getAverageCost("Electric");
        System.out.printf("Gennemsnitlig pris for Electric saunaer: %.2f kr%n%n", avgElectric);

        // Find mest dyre sauna
        Sauna mostExpensive = village.getMostExpensive();
        if (mostExpensive != null) {
            System.out.printf("Mest dyre sauna: %s (%.2f kr)%n",
                    mostExpensive.getName(),
                    mostExpensive.calculateDailyCost());
        }

        // Find billigste sauna
        Sauna cheapest = village.getCheapest();
        if (cheapest != null) {
            System.out.printf("Billigste sauna: %s (%.2f kr)%n",
                    cheapest.getName(),
                    cheapest.calculateDailyCost());
        }
    }
}