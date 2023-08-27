package game;

public class Player {
    private String name;
    private int score;
    private int choice;

    private int health;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.health = 10;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void resetScore() {
        this.score = 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void resetHealth() {
        this.health = 10;
    }


}
