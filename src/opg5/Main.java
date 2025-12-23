package opg5;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //TODO: Tænk over hvad der skal ske, hvis kompetencen allerede findes, ?
        // når man prøver at tilføje den igen,
        // samt hvordan du sikrer, at kompetenceniveauer altid ligger mellem 1 og 10. - laver if-statements i setLevel metode.

        // Create a team
        Team team = new Team("Backend Team");

        // Create developers with various skills
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

        // Add developers to team
        team.addDeveloper(cal);
        team.addDeveloper(lester);
        team.addDeveloper(jason);
        team.addDeveloper(diana);

        // Print team overview
        team.printTeamOverview();

        // Update a skill
        System.out.println("=== Updating Skills ===");
        diana.updateSkillLevel("Java", 8);
        lester.updateSkillLevel("SQL", 10);

        // Find best developer for specific skill
        System.out.println("\n=== Finding Best Developers ===");
        team.findBestDeveloperForSkill("Java");
        team.findBestDeveloperForSkill("SQL");
        team.findBestDeveloperForSkill("Python"); // No one has this

        // Find developers meeting specific requirements
        System.out.println("\n=== Finding Developers Meeting Requirements ===");
        Map<String, Integer> requirements1 = new HashMap<>();
        requirements1.put("Java", 3);
        requirements1.put("SQL", 2);
        System.out.println("Requirements: Java >= 3, SQL >= 2");
        team.findDevelopersMeetingRequirements(requirements1);

        Map<String, Integer> requirements2 = new HashMap<>();
        requirements2.put("Java", 7);
        requirements2.put("Git", 6);
        System.out.println("\nRequirements: Java >= 7, Git >= 6");
        team.findDevelopersMeetingRequirements(requirements2);

        // Remove a developer
        System.out.println("\n=== Removing Developer ===");
        team.removeDeveloper("Diana");

        // Print updated team overview
        team.printTeamOverview();

        // Try to find removed developer
        System.out.println("=== Finding Removed Developer ===");
        Developer found = team.findDeveloper("Diana");
        if (found == null) {
            System.out.println("Jason is no longer in the team");
        }
    }
}