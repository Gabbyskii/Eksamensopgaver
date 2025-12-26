package opg2;

import java.util.List;

public interface Sauna {
    String getName();
    void addTemperature(int degrees);
    double calculateDailyCost();
    String getType();

    // Nye metoder til udvidelser
    List<Integer> getTemperatures();
    double calculateDailyCostWithStandby();
}