package Model.ActivationStates;

import Model.MotorVehicle;

public class InactiveState extends ActivationState{
    public InactiveState(MotorVehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void onMove() {

    }

    @Override
    public void onTurnLeft() {

    }

    @Override
    public void onTurnRight() {

    }

    @Override
    public void onGas(double amount) {

    }

}
