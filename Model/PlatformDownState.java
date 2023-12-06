package Model;

public class PlatformDownState extends PlatformState{
    public PlatformDownState(MotorVehicle vehicle) {
        super(vehicle);
    }

    @Override
    public boolean allowMove() {
        return false;
    }
}
