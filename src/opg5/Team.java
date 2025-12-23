package opg5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Team {
    private String name;
    private List<Developer> developers = new ArrayList<>();

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

    /**
     * Add a developer to the team
     * @param developer the developer to add
     */
    public void addDeveloper(Developer developer) {
        if (developer == null) {
            System.out.println("Cannot add null developer");
            return;
        }
        if (developers.contains(developer)) {
            System.out.println(developer.getName() + " is already in the team");
            return;
        }
        developers.add(developer);
        System.out.println(developer.getName() + " added to team " + name);
    }

    /**
     * Remove a developer from the team by name
     * @param developerName name of the developer to remove
     */
    public void removeDeveloper(String developerName) {
        Developer toRemove = null;
        for (Developer dev : developers) {
            if (dev.getName().equalsIgnoreCase(developerName)) {
                toRemove = dev;
                break;
            }
        }
        if (toRemove != null) {
            developers.remove(toRemove);
            System.out.println(developerName + " removed from team " + name);
        } else {
            System.out.println("Developer '" + developerName + "' not found in team");
        }
    }

    /**
     * Find a developer by name
     * @param developerName name of the developer to find
     * @return the developer, or null if not found
     */
    public Developer findDeveloper(String developerName) {
        for (Developer dev : developers) {
            if (dev.getName().equalsIgnoreCase(developerName)) {
                return dev;
            }
        }
        return null;
    }

    /**
     * Print an overview of the team and all developers with their skills
     */
    public void printTeamOverview() {
        System.out.println("\n=== Team: " + name + " ===");
        System.out.println("Number of developers: " + developers.size());
        System.out.println("\nDevelopers:");
        if (developers.isEmpty()) {
            System.out.println("  No developers in team");
        } else {
            for (Developer dev : developers) {
                System.out.println("  " + dev);
            }
        }
        System.out.println();
    }

    /**
     * Find the developer with the highest level in a specific skill
     * @param skillName the skill to search for
     * @return the best developer for that skill, or null if no one has it
     */
    public Developer findBestDeveloperForSkill(String skillName) {
        Developer bestDev = null;
        int highestLevel = 0;

        for (Developer dev : developers) {
            int level = dev.getSkillLevel(skillName);
            if (level > highestLevel) {
                highestLevel = level;
                bestDev = dev;
            }
        }

        if (bestDev != null) {
            System.out.println("Best developer for " + skillName + ": " +
                    bestDev.getName() + " (level " + highestLevel + ")");
        } else {
            System.out.println("No developer in the team has the skill: " + skillName);
        }

        return bestDev;
    }

    /**
     * Find all developers who meet minimum requirements for specified skills
     * @param requirements Map of skill names to minimum required levels
     * @return List of developers who meet all requirements
     */
    public List<Developer> findDevelopersMeetingRequirements(Map<String, Integer> requirements) {
        List<Developer> qualifiedDevs = new ArrayList<>();

        for (Developer dev : developers) {
            boolean meetsAllRequirements = true;

            for (Map.Entry<String, Integer> requirement : requirements.entrySet()) {
                String skillName = requirement.getKey();
                int minLevel = requirement.getValue();

                if (!dev.hasSkillAtLevel(skillName, minLevel)) {
                    meetsAllRequirements = false;
                    break;
                }
            }

            if (meetsAllRequirements) {
                qualifiedDevs.add(dev);
            }
        }

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