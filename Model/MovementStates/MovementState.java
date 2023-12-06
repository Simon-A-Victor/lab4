package Model.MovementStates;

import Model.MotorVehicle;

public abstract class MovementState {
    public MotorVehicle vehicle;

    public MovementState(MotorVehicle vehicle){
        this.vehicle = vehicle;
    }

}