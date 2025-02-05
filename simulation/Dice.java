package simulation;

import java.util.Random;

public class Dice {
    private Random random = new Random();

    public Dice() {}

    public int roll() {
        int roll1 = random.nextInt(6) + 1;
        int roll2 = random.nextInt(6) + 1;
        return roll1 + roll2;
    }
}
