package opg5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Team {
    private String name;
    private List<Developer> developers = new ArrayList<>();

    // Konstruktør der opretter team med navn
    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    // Tilføjer en udvikler til teamet med validering
    public void addDev(Developer developer) {
        // Tjekker om developer er null
        if (developer == null) {
            System.out.println("Cannot add *** developer");
            return;
        }

        // Tjekker om developer allerede er i teamet
        if (developers.contains(developer)) {
            System.out.println(developer.getName() + " is already in the team");
            return;
        }

        // Tilføjer developer til teamet
        developers.add(developer);
        System.out.println(developer.getName() + " added to team " + name);
    }

    // Fjerner en udvikler fra teamet baseret på navn
    public void removeDeveloper(String developerName) {
        Developer toRemove = null;

        // Finder developer med matchende navn (case-insensitive)
        for (Developer dev : developers) {
            if (dev.getName().equalsIgnoreCase(developerName)) {
                toRemove = dev;
                break;
            }
        }

        // Fjerner developer hvis fundet
        if (toRemove != null) {
            developers.remove(toRemove);
            System.out.println(developerName + " removed from team " + name);
        } else {
            System.out.println("Developer '" + developerName + "' not found in team");
        }
    }

    // Finder og returnerer en specifik developer (null hvis ikke fundet)
    public Developer findDeveloper(String developerName) {
        for (Developer dev : developers) {
            if (dev.getName().equalsIgnoreCase(developerName)) {
                return dev;
            }
        }
        return null;
    }

    // Printer oversigt over teamet og alle udviklere
    public void printTeamOverview() {
        System.out.println("\n=== Team: " + name + " ===");
        System.out.println("Number of developers: " + developers.size());
        System.out.println("\nDevelopers:");

        if (developers.isEmpty()) {
            System.out.println("  No developers in team");
        } else {
            // Printer hver developer med deres skills
            for (Developer dev : developers) {
                System.out.println("  " + dev);
            }
        }
        System.out.println();
    }

    // Finder den bedste developer til en specifik skill
    public Developer findBestDevForSkill(String skillName) {
        Developer bestDev = null;
        int highestLevel = 0;

        // Gennemgår alle developers og finder højeste niveau
        for (Developer dev : developers) {
            int level = dev.getSkillLevel(skillName);
            if (level > highestLevel) {
                highestLevel = level;
                bestDev = dev;
            }
        }

        // Printer resultat
        if (bestDev != null) {
            System.out.println("Best developer for " + skillName + ": " +
                    bestDev.getName() + " (level " + highestLevel + ")");
        } else {
            System.out.println("No developer in the team has the skill: " + skillName);
        }

        return bestDev;
    }

    // Finder alle developers der opfylder mindstekrav for skills
    public List<Developer> findDevsMeetingRequirements(Map<String, Integer> requirements) {
        List<Developer> qualifiedDevs = new ArrayList<>();

        // Tjekker hver developer mod kravene
        for (Developer dev : developers) {
            boolean meetsAllRequirements = true;

            // Tjekker om developer opfylder alle skill-krav
            for (Map.Entry<String, Integer> requirement : requirements.entrySet()) {
                String skillName = requirement.getKey();
                int minLevel = requirement.getValue();

                if (!dev.hasSkillAtLevel(skillName, minLevel)) {
                    meetsAllRequirements = false;
                    break;  // Stop hvis et krav ikke opfyldes
                }
            }

            // Tilføj developer til listen hvis alle krav opfyldes
            if (meetsAllRequirements) {
                qualifiedDevs.add(dev);
            }
        }

        // Printer resultat
        System.out.println("\nDevelopers meeting requirements:");
        if (qualifiedDevs.isEmpty()) {
            System.out.println("  No developers meet all requirements");
        } else {
            for (Developer dev : qualifiedDevs) {
                System.out.println("  " + dev.getName());
            }
        }

        return qualifiedDevs;
    }
}
