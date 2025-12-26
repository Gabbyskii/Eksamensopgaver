package opg6;

public class Main {
    public static void main(String[] args) {
        // Opret et TamagotchiCenter til at håndtere alle kæledyr
        TamagotchiCenter center = new TamagotchiCenter();

        // Opret to tamagotchis med startværdier
        Tamagotchi t1 = new Tamagotchi("Lola", 30, 70, 70);
        Tamagotchi t2 = new Tamagotchi("Milo", 50, 60, 40);

        // Tilføj kæledyrene til centret
        center.addPet(t1);
        center.addPet(t2);

        // Udfør aktiviteter på kæledyrene
        // OBS: "Luna" findes ikke, så denne aktivitet gør ingenting
        center.performActivityOnPet("Lola", ActivityType.SLEEP, 5);

        // Lad Milo lege 3 gange
        center.performActivityOnPet("Milo", ActivityType.PLAY, 3);

        // Lad Milo arbejde 2 gange
        center.performActivityOnPet("Milo", ActivityType.WORK, 2);

        // Udskriv status for alle kæledyr
        System.out.println("Status rapport:");
        center.printStatusReport();

        System.out.println(); // Tom linje for læsbarhed

        // Udskriv analyser
        System.out.println("Gladeste kæledyr: " + center.getHappiestPet().getName());
        System.out.println("Mest sultne kæledyr: " + center.getMostHungryPet().getName());
        System.out.println("Gennemsnitlig glæde: " + center.getAverageHappiness());
    }
}