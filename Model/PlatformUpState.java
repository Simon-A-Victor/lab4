package Model;

import java.security.KeyStore;

public class PlatformUpState extends PlatformState{

    public PlatformUpState(PlatformVehicle vehicle) {
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
