package Model;

import java.awt.*;

abstract class PlatformVehicle extends MotorVehicle {
    PlatformState platformState;
    private double platformAngle = 0.0;

    public PlatformVehicle(int nrDoors, double enginePower, Color color, String modelName, double x, double y, int size) {
        super(nrDoors,color, modelName, x, y, size, enginePower);
        this.platformState = new PlatformUpState(this);
    }

    protected double getPlatformAngle() {
        return platformAngle;
    }

    protected void setPlatformAngle(double degrees) {
        if (isStationary()){
            platformAngle = degrees;
        }
    }

    protected PlatformState platformDown(){
        return new PlatformDownState(this);
    }

    protected PlatformState platformUp(){
        return new PlatformUpState(this);
    }


    @Override
    public void move(){
        platformState.onMove();
    }

    public void moveAsSuper(){
        super.move();
    }

    @Override
    public void gas(double amount) {
        platformState.onGas(amount);
    }

    public void gasAsSuper(double amount){
        super.gas(amount);
    }
}
