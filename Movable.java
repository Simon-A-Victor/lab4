

public interface Movable {
    void move();
    void turnLeft();
    void turnRight();

    double getXPosition();
    double getYPosition();

    void setXPosition(double amount);
    void setYPosition(double amount);

    void setDirection(Directions direction);

    Directions getDirection();

    double getCurrentSpeed();
    void setCurrentSpeed(double speed);

    boolean isStationary();
}
