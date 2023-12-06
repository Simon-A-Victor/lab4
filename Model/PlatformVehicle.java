package Model;

import java.awt.*;

abstract class PlatformVehicle extends MotorVehicle {
    private double platformAngle = 0.0;

    public PlatformVehicle(int nrDoors, double enginePower, Color color, String modelName, double x, double y, int size) {
        super(nrDoors,color, modelName, x, y, size, enginePower);
    }

    protected double getPlatformAngle() {
        return platformAngle;
    }

    protected void setPlatformAngle(double degrees) {
        if (isStationary()){
            platformAngle = degrees;
        }
    }

    protected boolean platformIsUp() {
        return getPlatformAngle() == 0.0;
    }

    @Override
    public void move(){
        if (platformIsUp()){
            super.move();
        }
    }

    @Override
    public void gas(double amount){
        if (platformIsUp()){
            super.gas(amount);
        }
    }
}
