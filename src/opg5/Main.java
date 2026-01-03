package opg5;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Opretter et team
        Team t = new Team("Backend Team");

        // Opretter developers med forskellige skills
        Developer cal = new Developer("Cal");
        cal.addSkill("Java", 7);
        cal.addSkill("SQL", 5);
        cal.addSkill("Git", 6);

        Developer lester = new Developer("Lester");
        lester.addSkill("Java", 10);
        lester.addSkill("SQL", 7);
        lester.addSkill("UML", 10);

        Developer jason = new Developer("Jason");
        jason.addSkill("Java", 5);
        jason.addSkill("SQL", 8);
        jason.addSkill("Git", 7);
        jason.addSkill("UML", 6);

        Developer diana = new Developer("Diana");
        diana.addSkill("SQL", 10);
        diana.addSkill("Git", 5);

        // Tilføjer developers til teamet
        t.addDev(cal);
        t.addDev(lester);
        t.addDev(jason);
        t.addDev(diana);

        // Printer team oversigt med alle developers
        t.printTeamOverview();

        // Opdaterer skill-niveauer for eksisterende skills
        System.out.println("=== Updating Skills ===");
        diana.updateSkillLevel("Java", 8);
        lester.updateSkillLevel("SQL", 10);

        // Finder bedste developer for specifikke skills
        System.out.println("\n=== Finding Best Developers ===");
        t.findBestDevForSkill("Java");
        t.findBestDevForSkill("SQL");
        t.findBestDevForSkill("Python"); // Ingen har denne skill

        // Finder developers der opfylder specifikke krav
        System.out.println("\n=== Finding Developers Meeting Requirements ===");

        // Krav 1: Java >= 3 og SQL >= 2
        Map<String, Integer> requires1 = new HashMap<>();
        requires1.put("Java", 3);
        requires1.put("SQL", 2);
        System.out.println("Requirements: Java >= 3, SQL >= 2");
        t.findDevsMeetingRequirements(requires1);

        // Krav 2: Java >= 7 og Git >= 6
        Map<String, Integer> requires2 = new HashMap<>();
        requires2.put("Java", 7);
        requires2.put("Git", 6);
        System.out.println("\nRequirements: Java >= 7, Git >= 6");
        t.findDevsMeetingRequirements(requires2);

        // Fjerner en developer fra teamet
        System.out.println("\n=== Removing Developer ===");
        t.removeDeveloper("Diana");

        // Printer opdateret team oversigt
        t.printTeamOverview();

        // Forsøger at finde fjernet developer (for at demonstrere at den er væk)
        System.out.println("=== Finding Removed Developer ===");
        Developer found = t.findDeveloper("Diana");
        if (found == null) {
            System.out.println("Diana is no longer in the team");
        }
    }
}
