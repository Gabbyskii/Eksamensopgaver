package opg6;

public class Tamagotchi {
    // Attributter
    private String name;
    private int hunger;     // 0 = ikke sulten, 100 = meget sulten
    private int energy;     // 0 = udmattet, 100 = fuld energi
    private int happiness;  // 0 = trist, 100 = meget glad
    private int coins;      // Mønter optjent ved arbejde

    // Constructor - opretter en ny Tamagotchi
    public Tamagotchi(String name, int hunger, int energy, int happiness) {
        this.name = name;
        this.hunger = clamp(hunger);
        this.energy = clamp(energy);
        this.happiness = clamp(happiness);
        this.coins = 0;
    }

    // Getters - returnerer værdier
    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getCoins() {
        return coins;
    }

    // Udfør en aktivitet med tamagotchien
    public void performActivity(ActivityType activity, int amount) {
        switch (activity) {
            case SLEEP -> {
                energy += amount * 5;      // Søvn giver energi
                hunger += amount * 3;      // Men gør også sulten
            }
            case FEED -> {
                hunger -= amount * 10;     // Fodring reducerer sult
            }
            case PLAY -> {
                happiness += amount * 7;   // Leg gør glad
                energy -= amount * 4;      // Men bruger energi
                hunger += amount * 3;      // Og gør sulten
            }
            case WORK -> {
                coins += amount * 10;      // Arbejde giver mønter
                happiness -= amount * 3;   // Men gør mindre glad
                energy -= amount * 5;      // Bruger meget energi
                hunger += amount * 4;      // Og gør sulten
            }
        }

        // Sørg for at alle værdier forbliver mellem 0 og 100
        hunger = clamp(hunger);
        energy = clamp(energy);
        happiness = clamp(happiness);
    }

    // Holder værdier mellem 0 og 100
    private int clamp(int value) {
        return Math.max(0, Math.min(100, value));
    }

    @Override
    public String toString() {
        return name +
                " | Hunger: " + hunger +
                " | Energy: " + energy +
                " | Happiness: " + happiness +
                " | Coins: " + coins;
    }
}
