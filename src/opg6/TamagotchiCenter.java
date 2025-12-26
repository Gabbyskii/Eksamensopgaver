package opg6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TamagotchiCenter {
    // Liste over alle tamagotchis
    private List<Tamagotchi> pets = new ArrayList<>();

    // Tilføj et nyt kæledyr til centret
    public void addPet(Tamagotchi pet) {
        pets.add(pet);
    }

    // Fjern et kæledyr baseret på navn
    public void removePet(String name) {
        pets.removeIf(p -> p.getName().equalsIgnoreCase(name));
    }

    // Find et specifikt kæledyr ved navn
    public Tamagotchi getPet(String name) {
        for (Tamagotchi pet : pets) {
            if (pet.getName().equalsIgnoreCase(name)) {
                return pet;
            }
        }
        return null; // Returnerer null hvis ikke fundet
    }

    // Udfør en aktivitet på et specifikt kæledyr
    public void performActivityOnPet(String name, ActivityType activity, int amount) {
        Tamagotchi pet = getPet(name);
        if (pet != null) {
            pet.performActivity(activity, amount);
        }
    }

    // Udskriv status for alle kæledyr
    public void printStatusReport() {
        for (Tamagotchi pet : pets) {
            System.out.println(pet);
        }
    }

    // Find det gladeste kæledyr
    public Tamagotchi getHappiestPet() {
        if (pets.isEmpty()) {
            return null;
        }

        Tamagotchi happiest = pets.get(0);
        for (Tamagotchi pet : pets) {
            if (pet.getHappiness() > happiest.getHappiness()) {
                happiest = pet;
            }
        }
        return happiest;
    }

    // Find det mest sultne kæledyr
    public Tamagotchi getMostHungryPet() {
        if (pets.isEmpty()) {
            return null;
        }

        Tamagotchi mostHungry = pets.get(0);
        for (Tamagotchi pet : pets) {
            if (pet.getHunger() > mostHungry.getHunger()) {
                mostHungry = pet;
            }
        }
        return mostHungry;
    }

    // Beregn gennemsnitlig glæde for alle kæledyr
    public double getAverageHappiness() {
        if (pets.isEmpty()) {
            return 0;
        }

        int totalHappiness = 0;
        for (Tamagotchi pet : pets) {
            totalHappiness += pet.getHappiness();
        }
        return (double) totalHappiness / pets.size();
    }
}