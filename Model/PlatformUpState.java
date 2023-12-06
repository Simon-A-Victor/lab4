package Model;

import java.security.KeyStore;

public class PlatformUpState extends PlatformState{

    public PlatformUpState(MotorVehicle vehicle) {
        super(vehicle);
    }

    @Override
    public boolean allowMove() {
        return true;
    }
}
