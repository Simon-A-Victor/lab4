package Model.PlatFormVehiclePlatformStates;

import Model.PlatformVehicle;

public abstract class PlatFormVehiclePlatformState {
    PlatformVehicle vehicle;
    public PlatFormVehiclePlatformState(PlatformVehicle vehicle){
        this.vehicle = vehicle;
    }

    public abstract void onMove();

    public abstract void onGas(double amount);
}