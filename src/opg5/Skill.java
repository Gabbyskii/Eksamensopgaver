package opg5;

public class Skill {

    private String name;
    private int level;


    public Skill(String name, int level) {
        this.name = name;
        // setLevel() istedet for this.level = level (sikrer 1-10 range)
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

    // Setter med validering - sikrer at level altid er mellem 1 og 10
    public void setLevel(int level) {
        if (level < 1) {
            this.level = 1;  // Værdier under 1 sættes til 1
        } else if (level > 10) {
            this.level = 10;  // Værdier over 10 sættes til 10
        } else {
            this.level = level;  // Gyldige værdier bruges direkte
        }
    }

    // Returnerer tekstrepræsentation: "Navn: Niveau"
    @Override
    public String toString() {
        return name + ": " + level;
    }
}
