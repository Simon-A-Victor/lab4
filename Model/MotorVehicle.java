package Model;

import java.awt.*;

public abstract class MotorVehicle implements Movable, Loadable {

    private final int nrDoors;
    private double currentSpeed;
    private Color color;
    private final String modelName;
    private Directions direction;
    private double x;
    private double y;
    private final int size;
    private boolean active;

    private final double enginePower; // Engine power of the car
    public MotorVehicle(int nrDoors, Color color, String modelName, double x, double y, int size, double enginePower){
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.size = size;
        this.enginePower = enginePower;
        this.setActive();
        this.setDirection(Directions.EAST);
    }

    public Color getColor(){
        return color;
    }
    public int getSize(){
        return this.size;
    }
    public int getNrDoors(){
        return nrDoors;
    }

    public String getModelName() {
        return modelName;
    }

    public double getEnginePower(){
        return enginePower;
    }
    public void stopEngine(){
        this.setCurrentSpeed(0.0);
    }
    public void startEngine(){
        this.setActive();
        this.setCurrentSpeed(0.1);

    }
    public void setColor(Color clr){
        color = clr;
    }

    abstract double speedFactor();

    public boolean isActive() {
        return active;
    }

    public void setActive() {
        this.active = true;
    }

    protected void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    protected void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
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
                    this.setYPosition(this.getYPosition() - this.getCurrentSpeed());
                    break;
                case WEST:
                    this.setXPosition(this.getXPosition() - this.getCurrentSpeed());
                    break;
                case SOUTH:
                    this.setYPosition(this.getYPosition() + this.getCurrentSpeed());
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

    public void gas(double amount){
        if (0 <= amount && amount <= 1){
            this.incrementSpeed(amount);
        }
    }
    public void brake(double amount){
        if (0 <= amount && amount <= 1){
            decrementSpeed(amount);
        }
    }
}
