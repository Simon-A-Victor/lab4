package Model.ActivationStates;

import Model.MotorVehicle;

public abstract class ActivationState {
    MotorVehicle vehicle;
    public ActivationState(MotorVehicle vehicle){
        this.vehicle = vehicle;
    }

    public abstract void onMove();
    public abstract void onTurnLeft();
    public abstract void onTurnRight();
    public abstract void onGas(double amount);

    public ActivationState setActive(){
        return new ActiveState(vehicle);
    }
    public ActivationState setInactive(){
        return new ActiveState(vehicle);
    }

}
