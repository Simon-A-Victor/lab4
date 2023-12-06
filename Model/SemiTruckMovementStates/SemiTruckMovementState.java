package Model.SemiTruckMovementStates;

import Model.MotorVehicle;
import Model.MovementStates.MovementState;
import Model.SemiTruck;

public abstract class SemiTruckMovementState extends MovementState{
    SemiTruck truck;
    public SemiTruckMovementState(SemiTruck truck) {
        super(truck);
        this.truck = truck;
    }

    @Override
    public void setTrue(){truck.movementState = new SemiTruckMovementTrueState(truck);}

    @Override
    public void setFalse(){truck.movementState = new SemiTruckMovementFalseState(truck);}

    public abstract void onSetPlatformDown();

    public abstract void onSetPlatformUp();
}
