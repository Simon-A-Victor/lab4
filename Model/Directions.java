package Model;

import java.util.Random;

public enum Directions {
    NORTH,
    EAST,
    SOUTH,
    WEST;
    private static final Random random = new Random();

    public static Directions randomDirection()  {
        Directions[] directions = values();
        return directions[random.nextInt(directions.length)];
    }

}
