package opg2;

import java.util.ArrayList;

public class ElectricSauna implements Sauna {
    private String name;
    private ArrayList<Integer> temperatures;

    // Konstruktør: Gem navnet og initialiser tom ArrayList
    public ElectricSauna(String name) {
        this.name = name;
        this.temperatures = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Electric";
    }

    // Tilføj temperatur til ArrayListen
    @Override
    public void addTemperature(int degrees) {
        temperatures.add(degrees);
    }

    // ElectricSauna: For hver over 50°C, tilføj 8kr.
    // Hvis over 70°C, tilføj også 2kr × (degrees - 70)
    @Override
    public double calculateDailyCost() {
        double cost = 0;
        for (int temp : temperatures) {
            if (temp > 50) {
                cost += 8;
                if (temp > 70) {
                    cost += 2 * (temp - 70);
                }
            }
        }
        return cost;
    }
}