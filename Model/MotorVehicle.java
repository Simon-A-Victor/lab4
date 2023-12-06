package Model;

import Model.ActivationStates.*;
import Model.MovementStates.*;


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
    ActivationState activationState;
    public MovementState movementState;

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
        this.movementState = new MovementFalseState(this);
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
        setMovementStateFalse();
    }
    public void startEngine(){
        setActive();
        setCurrentSpeed(0.1);
        setMovementStateTrue();
    }
    public void setColor(Color clr){
        color = clr;
    }

    abstract double speedFactor();


    public void setActive() {
        activationState = new ActiveState(this);
    }
    public void setInactive(){
        activationState =  new InactiveState(this);
    }

    public void setMovementStateTrue(){movementState.setTrue();}
    public void setMovementStateFalse(){movementState.setFalse();}

    public void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    protected void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    public boolean isStationary(){
        double speed = getCurrentSpeed();
        return speed == 0;
    }



    @Override
    public void move() {
       activationState.onMove();
    }
    @Override
    public void turnLeft() {
        activationState.onTurnLeft();
    }
    @Override
    public void turnRight() {
        activationState.onTurnRight();
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
        if (currentSpeed > 0){
            setMovementStateTrue();
        }
        else {
            setMovementStateFalse();
        }
    }

    public void gas(double amount){
        activationState.onGas(amount);
    }
    public void brake(double amount){
        if (0 <= amount && amount <= 1){
            decrementSpeed(amount);
        }
    }
}
