package Model;

import Model.PlatformStates.PlatformDownState;
import Model.PlatformStates.PlatformState;
import Model.PlatformStates.PlatformUpState;

import java.awt.*;

public abstract class PlatformVehicle extends MotorVehicle {
     public PlatformState platformState;
    private double platformAngle = 0.0;

    public PlatformVehicle(int nrDoors, double enginePower, Color color, String modelName, double x, double y, int size) {
        super(nrDoors,color, modelName, x, y, size, enginePower);
        this.platformState = new PlatformUpState(this);
    }

    public double getPlatformAngle() {
        return platformAngle;
    }

    public void setPlatformAngle(double degrees) {
        if (isStationary()){
            platformAngle = degrees;
        }
    }

    public PlatformState platformDown(){
        return new PlatformDownState(this);
    }

    public PlatformState platformUp(){
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
