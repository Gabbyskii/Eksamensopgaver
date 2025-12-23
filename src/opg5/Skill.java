package opg5;

public class Skill {
    private String name;
    private int level;

    public Skill(String name, int level) {
        this.name = name;
        //this.level = level;
        setLevel(level);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        // Ensure level is between 1 and 10
        if (level < 1) {
            this.level = 1;
        } else if (level > 10) {
            this.level = 10;
        } else {
            this.level = level;
        }
    }

    @Override
    public String toString() {
        return name + ": " + level;
    }
}