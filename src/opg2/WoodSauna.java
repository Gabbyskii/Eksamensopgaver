package opg2;

import java.util.ArrayList;

public class WoodSauna implements Sauna {
    private String name;
    private ArrayList<Integer> temperatures;

    // Konstruktør: Gem navnet og initialiser tom ArrayList
    public WoodSauna(String name) {
        this.name = name;
        this.temperatures = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Wood";
    }

    // Tilføj temperatur til ArrayListen
    @Override
    public void addTemperature(int degrees) {
        temperatures.add(degrees);
    }

    // WoodSauna: For hver temperatur over 50°C, tilføj 12kr
    @Override
    public double calculateDailyCost() {
        double cost = 0;
        for (int temp : temperatures) {
            if (temp > 50) {
                cost += 12;
            }
        }
        return cost;
    }
}