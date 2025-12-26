package opg2;

import java.util.ArrayList;
import java.util.List;

public class WoodSauna implements Sauna {
    private String name;
    private ArrayList<Integer> temperatures;

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

    @Override
    public void addTemperature(int degrees) {
        temperatures.add(degrees);
    }

    @Override
    public List<Integer> getTemperatures() {
        return new ArrayList<>(temperatures);
    }

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

    @Override
    public double calculateDailyCostWithStandby() {
        double cost = 0;
        for (int temp : temperatures) {
            if (temp > 50) {
                cost += 12;
            } else {
                // Standby omkostning: 2kr/time under 50°C
                cost += 2;
            }
        }
        return cost;
    }
}