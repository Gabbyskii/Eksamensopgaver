package opg5;

import java.util.ArrayList;
import java.util.List;

public class Developer {
    private String name;
    private List<Skill> skills = new ArrayList<>();

    // Konstruktør der opretter udvikler med tomt skill-sæt
    public Developer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    // Tilføjer en ny skill hvis den ikke allerede eksisterer
    public void addSkill(String skillName, int level) {
        // Tjekker om skill allerede findes (case-insensitive)
        for (Skill skill : skills) {
            if (skill.getName().equalsIgnoreCase(skillName)) {
                System.out.println("Skill '" + skillName + "' already exists. Use updateSkillLevel() to modify it.");
                return;  // Afbryder hvis skill findes
            }
        }
        // Tilføjer ny skill til listen
        skills.add(new Skill(skillName, level));
    }

    // Opdaterer niveau for eksisterende skill
    public void updateSkillLevel(String skillName, int newLevel) {
        // Finder den rigtige skill og opdaterer den
        for (Skill skill : skills) {
            if (skill.getName().equalsIgnoreCase(skillName)) {
                skill.setLevel(newLevel);
                System.out.println("Updated " + name + "'s " + skillName + " to level " + newLevel);
                return;
            }
        }
        // Hvis skill ikke findes, vis fejlbesked
        System.out.println("Skill '" + skillName + "' not found for " + name);
    }

    // Returnerer niveau for en specifik skill (0 hvis den ikke findes)
    public int getSkillLevel(String skillName) {
        for (Skill skill : skills) {
            if (skill.getName().equalsIgnoreCase(skillName)) {
                return skill.getLevel();
            }
        }
        return 0;  // Returnerer 0 hvis skill ikke findes
    }

    // Tjekker om udvikler har en skill på mindst et bestemt niveau
    public boolean hasSkillAtLevel(String skillName, int minLevel) {
        return getSkillLevel(skillName) >= minLevel;
    }

    // Laver en tekstrepræsentation af udvikler med alle skills
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" - Skills: ");

        if (skills.isEmpty()) {
            sb.append("None");
        } else {
            // Bygger komma-separeret liste af skills
            for (int i = 0; i < skills.size(); i++) {
                sb.append(skills.get(i));
                if (i < skills.size() - 1) {
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }
}