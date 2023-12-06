package Model.PlatFormVehiclePlatformStates;

import Model.PlatformVehicle;

public class PlatFormVehiclePlatformDownState extends PlatFormVehiclePlatformState {
    public PlatFormVehiclePlatformDownState(PlatformVehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void onMove() {}

    @Override
    public void onGas(double amount) {}
}
