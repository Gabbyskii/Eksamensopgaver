package opg5;

import java.util.ArrayList;
import java.util.List;

public class Developer {
    private String name;
    private List<Skill> skills = new ArrayList<>();

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

    /**
     * Add a new skill to the developer
     * @param skillName name of the skill
     * @param level skill level (1-10)
     */
    public void addSkill(String skillName, int level) {
        // Check if skill already exists
        for (Skill skill : skills) {
            if (skill.getName().equalsIgnoreCase(skillName)) {
                System.out.println("Skill '" + skillName + "' already exists. Use updateSkillLevel() to modify it.");
                return;
            }
        }
        skills.add(new Skill(skillName, level));
    }

    /**
     * Update the level of an existing skill
     * @param skillName name of the skill to update
     * @param newLevel new level (1-10)
     */
    public void updateSkillLevel(String skillName, int newLevel) {
        for (Skill skill : skills) {
            if (skill.getName().equalsIgnoreCase(skillName)) {
                skill.setLevel(newLevel);
                System.out.println("Updated " + name + "'s " + skillName + " to level " + newLevel);
                return;
            }
        }
        System.out.println("Skill '" + skillName + "' not found for " + name);
    }

    /**
     * Get the level of a specific skill
     * @param skillName name of the skill
     * @return skill level, or 0 if skill not found
     */
    public int getSkillLevel(String skillName) {
        for (Skill skill : skills) {
            if (skill.getName().equalsIgnoreCase(skillName)) {
                return skill.getLevel();
            }
        }
        return 0;
    }

    /**
     * Check if developer has a skill at or above a certain level
     * @param skillName name of the skill
     * @param minLevel minimum required level
     * @return true if developer has the skill at required level
     */
    public boolean hasSkillAtLevel(String skillName, int minLevel) {
        return getSkillLevel(skillName) >= minLevel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" - Skills: ");
        if (skills.isEmpty()) {
            sb.append("None");
        } else {
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