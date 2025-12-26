package opg2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SaunaVillage {
    private ArrayList<Sauna> saunas;
    private ArrayList<HourlyReading> hourlyReadings;

    public SaunaVillage() {
        saunas = new ArrayList<>();
        hourlyReadings = new ArrayList<>();
    }

    // Hjælpeklasse til at gemme time-data
    private static class HourlyReading {
        int hour;
        int temperature;
        String saunaName;
        String saunaType;

        HourlyReading(int hour, int temperature, String saunaName, String saunaType) {
            this.hour = hour;
            this.temperature = temperature;
            this.saunaName = saunaName;
            this.saunaType = saunaType;
        }

        double calculateCost() {
            if (saunaType.equalsIgnoreCase("Wood")) {
                return temperature > 50 ? 12 : 0;
            } else { // Electric
                double cost = 0;
                if (temperature > 50) {
                    cost += 8;
                    if (temperature > 70) {
                        cost += 2 * (temperature - 70);
                    }
                }
                return cost;
            }
        }
    }

    void loadFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int hour = Integer.parseInt(parts[0].trim());
                    int temperature = Integer.parseInt(parts[1].trim());
                    String name = parts[2].trim();
                    String type = parts[3].trim();

                    // Gem hourly reading til analyse
                    hourlyReadings.add(new HourlyReading(hour, temperature, name, type));

                    Sauna sauna = findSaunaByName(name);

                    if (sauna == null) {
                        if (type.equalsIgnoreCase("Wood")) {
                            sauna = new WoodSauna(name);
                        } else if (type.equalsIgnoreCase("Electric")) {
                            sauna = new ElectricSauna(name);
                        }
                        saunas.add(sauna);
                    }

                    if (sauna != null) {
                        sauna.addTemperature(temperature);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Fejl ved læsning af fil: " + e.getMessage());
        }
    }

    private Sauna findSaunaByName(String name) {
        for (Sauna sauna : saunas) {
            if (sauna.getName().equals(name)) {
                return sauna;
            }
        }
        return null;
    }

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

    // UDVIDELSE 1: Find dyreste og billigste time
    public void findMostAndLeastExpensiveHour() {
        if (hourlyReadings.isEmpty()) {
            System.out.println("Ingen data tilgængelig");
            return;
        }

        // Gruppér efter time og beregn total omkostning for hver time
        double[] hourlyCosts = new double[24];
        int[] hourCounts = new int[24];

        for (HourlyReading reading : hourlyReadings) {
            hourlyCosts[reading.hour] += reading.calculateCost();
            hourCounts[reading.hour]++;
        }

        // Find dyreste og billigste time
        int mostExpensiveHour = -1;
        int cheapestHour = -1;
        double maxCost = -1;
        double minCost = Double.MAX_VALUE;

        for (int i = 0; i < 24; i++) {
            if (hourCounts[i] > 0) {
                if (hourlyCosts[i] > maxCost) {
                    maxCost = hourlyCosts[i];
                    mostExpensiveHour = i;
                }
                if (hourlyCosts[i] < minCost) {
                    minCost = hourlyCosts[i];
                    cheapestHour = i;
                }
            }
        }

        System.out.println("=== Time Analyse ===");
        System.out.printf("Dyreste time: kl. %d:00 (%.2f kr)%n", mostExpensiveHour, maxCost);
        System.out.printf("Billigste time: kl. %d:00 (%.2f kr)%n%n", cheapestHour, minCost);
    }

    // UDVIDELSE 2: Beregn besparelse hvis alle var elektriske
    public void calculateElectricSavings() {
        double currentTotalCost = 0;
        double electricTotalCost = 0;

        for (HourlyReading reading : hourlyReadings) {
            // Nuværende omkostning
            currentTotalCost += reading.calculateCost();

            // Omkostning hvis det var elektrisk
            double electricCost = 0;
            if (reading.temperature > 50) {
                electricCost += 8;
                if (reading.temperature > 70) {
                    electricCost += 2 * (reading.temperature - 70);
                }
            }
            electricTotalCost += electricCost;
        }

        double savings = currentTotalCost - electricTotalCost;

        System.out.println("=== Elektrisk Besparelse ===");
        System.out.printf("Nuværende total omkostning: %.2f kr%n", currentTotalCost);
        System.out.printf("Hvis alle var elektriske: %.2f kr%n", electricTotalCost);
        System.out.printf("Besparelse: %.2f kr (%.1f%%)%n%n",
                savings,
                (savings / currentTotalCost) * 100);
    }

    // UDVIDELSE 3: Standby omkostning (2kr/time under 50°C)
    public void calculateStandbyCosts() {
        System.out.println("=== Standby Omkostninger ===");

        double totalStandbyCost = 0;

        for (Sauna sauna : saunas) {
            double regularCost = sauna.calculateDailyCost();
            double costWithStandby = sauna.calculateDailyCostWithStandby();
            double standbyCost = costWithStandby - regularCost;

            System.out.printf("%s: %.2f kr (total med standby: %.2f kr)%n",
                    sauna.getName(),
                    standbyCost,
                    costWithStandby);

            totalStandbyCost += standbyCost;
        }

        System.out.printf("Total standby omkostning for alle saunaer: %.2f kr%n%n", totalStandbyCost);
    }
}