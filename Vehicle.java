import java.awt.*;

public class Vehicle implements Movable, Loadable {
    private double currentSpeed;
    private Color color;
    private String modelName;
    private Directions direction;
    private double x;
    private double y;
    private int size;
    private boolean active;

    public Vehicle(Color color, String modelName, double x, double y, int size){
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.size = size;
        this.setActive();
    }
    public Color getColor(){
        return color;
    }
    public int getSize(){
        return this.size;
    };
    public void setColor(Color clr){
        color = clr;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive() {
        this.active = true;
    }

    public boolean isStationary(){
        double speed = getCurrentSpeed();
        return speed == 0;
    }

    public void setInactive(){
        if (isStationary()){
            this.setCurrentSpeed(0.0);
            this.active = false;
        }
    }
    @Override
    public void move() {
        if (this.isActive()){
            switch (this.getDirection()){
                case NORTH:
                    this.setYPosition(this.getYPosition() + this.getCurrentSpeed());
                    break;
                case WEST:
                    this.setXPosition(this.getXPosition() - this.getCurrentSpeed());
                    break;
                case SOUTH:
                    this.setYPosition(this.getYPosition() - this.getCurrentSpeed());
                    break;
                case EAST:
                    this.setXPosition(this.getXPosition() + this.getCurrentSpeed());
                    break;
            }
        }
    }
    @Override
    public void turnLeft() {
        if (this.isActive()) {
            this.setDirection(Directions.values()[(direction.ordinal()+3)%4]);
        }
    }

    @Override
    public void turnRight() {
        if (this.isActive()) {
            this.setDirection(Directions.values()[(direction.ordinal()+1)%4]);
        }
    }

    @Override
    public double getXPosition() {
        return this.x;
    }

    @Override
    public double getYPosition() {
        return this.y;
    }

    @Override
    public void setXPosition(double amount) {
        this.x = amount;
    }

    @Override
    public void setYPosition(double amount) {
        this.y = amount;
    }

    @Override
    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    @Override
    public Directions getDirection() {
        return this.direction;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    @Override
    public void setCurrentSpeed(double speed){
        currentSpeed = speed;
    }
}
