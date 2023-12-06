package Model.ScaniaMovementStates;

import Model.MotorVehicle;
import Model.MovementStates.MovementState;
import Model.Scania;

public abstract class ScaniaMovementState extends MovementState{
    Scania vehicle;
    public ScaniaMovementState(Scania vehicle) {
        super(vehicle);
        this.vehicle = vehicle;
    }

    public abstract void onTiltPlatform(double degrees);
}
