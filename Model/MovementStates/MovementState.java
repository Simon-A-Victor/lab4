package Model.MovementStates;

import Model.MotorVehicle;

public abstract class MovementState {
    public MotorVehicle vehicle;

    public MovementState(MotorVehicle vehicle){
        this.vehicle = vehicle;
    }

    public void setTrue(){
        vehicle.movementState = new MovementTrueState(vehicle);
    }

    public void setFalse(){
        vehicle.movementState = new MovementFalseState(vehicle);
    }

}