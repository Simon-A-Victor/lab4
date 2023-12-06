package Model;

public abstract class PlatformState {
    PlatformVehicle vehicle;
    public PlatformState(PlatformVehicle vehicle){
        this.vehicle = vehicle;
    }

    public abstract void onMove();

    public abstract void onGas(double amount);
}