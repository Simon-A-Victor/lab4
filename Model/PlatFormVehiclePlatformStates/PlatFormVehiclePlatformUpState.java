package Model.PlatFormVehiclePlatformStates;

import Model.PlatformVehicle;

public class PlatFormVehiclePlatformUpState extends PlatFormVehiclePlatformState {

    public PlatFormVehiclePlatformUpState(PlatformVehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void onMove() {
        vehicle.moveAsSuper();
    }

    @Override
    public void onGas(double amount) {
        vehicle.gasAsSuper(amount);
    }
}
