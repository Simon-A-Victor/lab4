package Model;

public class PlatformDownState extends PlatformState{
    public PlatformDownState(PlatformVehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void onMove() {}

    @Override
    public void onGas(double amount) {}
}