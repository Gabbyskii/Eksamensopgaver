package opg2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SaunaVillage {
    private ArrayList<Sauna> saunas;

    public SaunaVillage() {
        saunas = new ArrayList<>();
    }

    // Læs filen, spring header over, opret saunaer og tilføj temperaturer
    void loadFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                // Spring header over
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Split linjen: hour,degrees,sauna_name,sauna_type
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    // Kolonner: 0=hour, 1=degrees, 2=sauna_name, 3=sauna_type
                    int temperature = Integer.parseInt(parts[1].trim());
                    String name = parts[2].trim();
                    String type = parts[3].trim();

                    // Tjek om sauna med navnet findes
                    Sauna sauna = findSaunaByName(name);

                    // Hvis ikke findes, opret ny sauna og tilføj til listen
                    if (sauna == null) {
                        if (type.equalsIgnoreCase("Wood")) {
                            sauna = new WoodSauna(name);
                        } else if (type.equalsIgnoreCase("Electric")) {
                            sauna = new ElectricSauna(name);
                        }
                        saunas.add(sauna);
                    }

                    // Tilføj temperatur til saunaen
                    if (sauna != null) {
                        sauna.addTemperature(temperature);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Fejl ved læsning af fil: " + e.getMessage());
        }
    }

    // Hjælpemetode til at finde sauna ved navn
    private Sauna findSaunaByName(String name) {
        for (Sauna sauna : saunas) {
            if (sauna.getName().equals(name)) {
                return sauna;
            }
        }
        return null;
    }

    // Udskriv alle saunaer med deres omkostning
    void printReport() {
        System.out.println("=== Sauna Rapport ===");
        for (Sauna sauna : saunas) {
            System.out.printf("%s (%s): %.2f kr%n",
                    sauna.getName(),
                    sauna.getType(),
                    sauna.calculateDailyCost());
        }
        System.out.println();
    }

    // Filtrer efter type, beregn gennemsnit af omkostninger
    double getAverageCost(String type) {
        double totalCost = 0;
        int count = 0;

        for (Sauna sauna : saunas) {
            if (sauna.getType().equalsIgnoreCase(type)) {
                totalCost += sauna.calculateDailyCost();
                count++;
            }
        }

        return count > 0 ? totalCost / count : 0;
    }

    // Find sauna med højest omkostning
    Sauna getMostExpensive() {
        if (saunas.isEmpty()) {
            return null;
        }

        Sauna mostExpensive = saunas.get(0);
        for (Sauna sauna : saunas) {
            if (sauna.calculateDailyCost() > mostExpensive.calculateDailyCost()) {
                mostExpensive = sauna;
            }
        }
        return mostExpensive;
    }

    // Find sauna med lavest omkostning
    Sauna getCheapest() {
        if (saunas.isEmpty()) {
            return null;
        }

        Sauna cheapest = saunas.get(0);
        for (Sauna sauna : saunas) {
            if (sauna.calculateDailyCost() < cheapest.calculateDailyCost()) {
                cheapest = sauna;
            }
        }
        return cheapest;
    }
}