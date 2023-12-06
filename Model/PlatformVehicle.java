package Model;

import Model.PlatFormVehiclePlatformStates.PlatFormVehiclePlatformDownState;
import Model.PlatFormVehiclePlatformStates.PlatFormVehiclePlatformState;
import Model.PlatFormVehiclePlatformStates.PlatFormVehiclePlatformUpState;

import java.awt.*;

public abstract class PlatformVehicle extends MotorVehicle {
     public PlatFormVehiclePlatformState platFormVehiclePlatformState;
    private double platformAngle = 0.0;

    public PlatformVehicle(int nrDoors, double enginePower, Color color, String modelName, double x, double y, int size) {
        super(nrDoors,color, modelName, x, y, size, enginePower);
        this.platFormVehiclePlatformState = new PlatFormVehiclePlatformUpState(this);
    }

    public double getPlatformAngle() {
        return platformAngle;
    }

    public void setPlatformAngle(double degrees) {
        if (isStationary()){
            platformAngle = degrees;
        }
    }

    public PlatFormVehiclePlatformState platformDown(){
        return new PlatFormVehiclePlatformDownState(this);
    }

    public PlatFormVehiclePlatformState platformUp(){
        return new PlatFormVehiclePlatformUpState(this);
    }


    @Override
    public void move(){
        platFormVehiclePlatformState.onMove();
    }

    public void moveAsSuper(){
        super.move();
    }

    @Override
    public void gas(double amount) {
        platFormVehiclePlatformState.onGas(amount);
    }

    public void gasAsSuper(double amount){
        super.gas(amount);
    }
}
